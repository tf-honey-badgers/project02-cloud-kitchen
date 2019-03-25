$(document).ready(function() {
	/* 페이지 로딩 후 카트에 총 금액 표시하기 */
	var cartTotal = 0;
	for(var i = 0; i < $('.menuData').size(); i++) {
		var price = $('.menuData').eq(i).children('strong:eq(1)').text();
		cartTotal += parseInt(price.substring(0, price.length - 1));
	}
	$('.total span').text(cartTotal + '원');
	
	/* 옵션 없는 메뉴는 "+" 클릭하면 장바구니에 추가하도록 */
	for(var i = 0; i < $('.dropdown-menu').size(); i++) {
		if($('.dropdown-menu').eq(i).children('div').length == 0) {
			// 옵션이 없으니까 옵션용 팝업을 보여주는 대신 곧바로 카트에 추가할 수 있다 (옵션용 팝업 속 "Add to cart" 버튼과 똑같다)
			$('.dropdown-menu').eq(i).siblings('a').removeClass('dropdown-toggle').addClass('add_to_basket').removeAttr('data-toggle');
		}
	}
	
	/* "Add to cart" 버튼을 클릭하면 선택한 메뉴와 옵션 정보를 DB에 입력하고 이후 DB에서 카트 정보를 읽어와 카트에 표시하기 */
	$('.add_to_basket').on('click', function(event) {
		event.preventDefault();
	/* 필수선택 옵션을 선택했는지 확인한다 */
		const divs = $(this).siblings('div');
		for(let i = 0; i < divs.length; i++) {
			console.log("what");
			if(divs.eq(i).children().children('input').attr('data-required') == "yes") {
				if(divs.eq(i).children().children('input:checked').length == 0) {
					alert("필수 선택 옵션을 선택하셔야 합니다.");
					return;
				}
			}
		}
		
	/* 선택한 메뉴의 ID */
		const menuId = $(this).parents('td').siblings('td:eq(0)').children('h5').attr('data-id');
	/* 선택한 메뉴의 가격 (옵션 제외) */
		const menuPrice = $(this).parents('td').siblings('td:eq(1)').attr('data-price');
	/* 선택한 옵션들 (input tag) */
		const checkedOptions = $(this).siblings('div').children().children('input:checked');
	/* 선택한 옵션을 담을 배열 */
		let optArr = [];
	/* 메뉴와 옵션의 가격 총 합 */
		let totalPrice = 0;		
	/* 선택한 각 옵션의 가격을 optArr 배열에 담는다 */
		$.each(checkedOptions, function(index, item) { optArr.push(checkedOptions.eq(index).siblings('span').attr('data-price')); })
	/* 메뉴 가격과 각 옵션의 가격을 더해서 가격 총 합을 구한다 */
		totalPrice += parseInt(menuPrice);
		$.each(optArr, function(index, item) { totalPrice += parseInt(item); })
/* 		console.log(totalPrice); -> 총 금액 확인하기
		console.log($(this).siblings('div').children().children('input:checked').length); -> 체크한 옵션 개수 확인하기
*/
	/* 선택한 옵션의 개수를 cur변수의 값으로 삼는다. */
		let cur = $(this).siblings('div').children().children('input:checked').length; // 브라우저 콘솔에서 작업용 : $('.add_to_basket').eq(0).siblings('div').children().children('input:checked')
	/* 옵션 정보를 담을 배열 (List<CartDetailVO>에 매핑) */
		let inputOptions = [];
		for(let i = 0; i < cur; i++) {
			id = menuId;
			optName = $(this).siblings('div').children().children('input:checked').eq(i).attr('data-name');
			optId = $(this).siblings('div').children().children('input:checked').eq(i).attr('data-id');
			optPrice = $(this).siblings('div').children().children('input:checked').eq(i).siblings('span').attr('data-price');
			
			inputOptions.push({ menuOptId : optId, menuId : id, menuOptName : optName, menuOptPrice : optPrice });
		}
		// 비동기 요청하면 CartVOExtended에 매핑되도록
		var inputData = {
				custId : 'tjtjtj'
				, quantity : 1
				, unitPrice : menuPrice
				, totalAmt : totalPrice
				, kitchenName : '스톡홀름 1호점'
				, bizName : 'biz_2'
				, menuId : menuId
				, options : inputOptions
			};
		
		// CartController로 비동기 요청하기
 		$.ajax({
			type : 'POST'
			, url : 'http://localhost:12004/customer/kitchen/cart/add'
			, dataType : 'json'
			, contentType : 'application/json'
			, data : JSON.stringify(inputData)
	   		, success : function(data) {
	   			$('.cartTable').empty();
	   			cartTotal = 0;
				for(let i = 0; i < data.length; i++) {
	    			$('.cartTable').append('<tr><td style="width: 10%;"><input class="check-order" type="checkbox"></td>' +
	    					'<td class="menuData" data-cart-id="' + data[i].id + '"><strong>' + data[i].quantity + 'x</strong> ' +
	    					data[i].name + '<strong class="pull-right">' + data[i].totalAmt + '원</strong></td>' +
	    					'<td style="width: 10%;"><input type="checkbox" class="pull-right"></td></tr>');
	    			if(data[i].options != null) {
		    			for(let j = 0; j < data[i].options.length; j++) {
			    			$('.cartTable').append('<tr><td style="width: 10%;"></td>' +
			    					'<td style="font-size: 11px">' + data[i].options[j].menuOptName + '</td>' +
			    					'<td style="width: 10%;"></td></tr>');			    				
		    			}
	    			}
	    			cartTotal += data[i].totalAmt;
				}
				console.log(cartTotal);
				$('.total span').text(cartTotal + '원');
			}
			, error : function(data) {
				console.log('ERRoR oCCURRED');
				console.log(data);
			}
		});
	});
	
	/* 주문할 메뉴 전체선택하기 */
	$('.table_summary th:eq(0) input').on('click', function() {
		console.log("mrow");
		$('.cartTable .check-order').prop('checked', $('.table_summary th:eq(0) input').prop('checked'));
	});
	
	/* 삭제할 메뉴 전체선택하기 */
	$('.table_summary th:eq(2) input').on('click', function() {
		console.log("mrow");
		$('.cartTable .check-delete').prop('checked', $('.table_summary th:eq(2) input').prop('checked'));
	});
});