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
	
/* "Add to cart" 버튼을 클릭하면 선택한 메뉴와 옵션을 DB에 입력하고 이후 DB에서 카트 정보를 읽어와 표시하기 */
	$('.add_to_basket').on('click', function(event) {
		event.preventDefault();
		
	/* 필수선택 옵션을 선택했는지 확인한다 */
		const divs = $(this).siblings('div');
		for(let i = 0; i < divs.length; i++) {
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
	/* 비동기 요청하면 CartVOExtended에 매핑되도록 JavaScript 객체 생성 */
		var inputData = {
				custId : 'tjtjtj'
				, quantity : 1
				, unitPrice : menuPrice
				, totalAmt : totalPrice
				, kitchenName : '스톡홀름 1호점'
				, bizId : 'biz_2'
				, menuId : menuId
				, options : inputOptions
			};
		
	/* 카트에 추가하면 기존에 선택한 체크박스 해제하기 */
		$(this).siblings('div').children().children('input:checked').prop('checked', false);
		
 		$.ajax({
			type : 'POST'
			, url : 'http://localhost:3001/customer/cart/add'
			, dataType : 'json'
			, contentType : 'application/json'
			, data : JSON.stringify(inputData)
	   		, success : function(data) {
	   			$('.cartTable').empty();
	   			cartTotal = 0;
				for(let i = 0; i < data.length; i++) {
	    			$('.cartTable').append('<tr><td style="width: 10%;"><input class="check-order" type="checkbox"></td>' +
	    					'<td class="menuData" data-cart-id="' + data[i].id + '"><strong>' + data[i].quantity + 'x</strong> ' +
	    					data[i].menuName + '<strong class="pull-right">' + data[i].totalAmt + '원</strong></td>' +
	    					'<td style="text-align: right; width: 10%;"><input class="check-delete" type="checkbox"></td></tr>');
	    			if(data[i].options != null) {
		    			for(let j = 0; j < data[i].options.length; j++) {
			    			$('.cartTable').append('<tr><td style="width: 10%;"></td>' +
			    					'<td style="font-size: 11px">' + data[i].options[j].menuOptName + '</td>' +
			    					'<td style="width: 10%;"></td></tr>');			    				
		    			}
	    			}
	    			cartTotal += data[i].totalAmt;
				}
				$('.total span').text(cartTotal + '원');
			}
			, error : function(data) {
				console.log('ERRoR oCCURRED');
				console.log(data);
			}
		});
	});
	
/* 주문할 메뉴 전체선택하기 */
	$('body').on('click', '.table_summary th:eq(0) input', function() {
		$('.cartTable .check-order').prop('checked', $('.table_summary th:eq(0) input').prop('checked'));
	});
/* 체크박스 하나 클릭시 전체선택 체크박스 1개 해제하기 */
	$('body').on('click', '.cartTable .check-order', function() {
		if($('.table_summary th:eq(0) input').prop('checked') == true) {
			$('.table_summary th:eq(0) input').prop('checked', false);
		}
	});
/* 삭제할 메뉴 전체선택하기 */
	$('body').on('click', '.table_summary th:eq(2) input', function() {
		$('.cartTable .check-delete').prop('checked', $('.table_summary th:eq(2) input').prop('checked'));
	});
/* 체크박스 하나 클릭시 전체선택 체크박스 1개 해제하기 */
	$('body').on('click', '.cartTable .check-delete', function() {
		if($('.table_summary th:eq(2) input').prop('checked') == true) {
			$('.table_summary th:eq(2) input').prop('checked', false);
		}
	});
	
/* 카트의 id="deleteCart" 클릭하면 선택된 항목 삭제하기 */
	$('#deleteCart').on('click', function() {
		const checked = $('.cartTable .check-delete:checked');
		let cartId = [];
		for(let i = 0; i < checked.length; i++) {
			cartId[i] = checked.eq(i).parent().siblings('.menuData').attr('data-cart-id');
		}
		/* 카트의 모든 체크박스 해제 */
		$('.table_summary th:eq(0) input').prop('checked', false);
		$('.cartTable .check-order').prop('checked', false);
		$('.table_summary th:eq(2) input').prop('checked', false);
		$('.cartTable .check-delete').prop('checked', false);
		
 		$.ajax({
			type : 'DELETE'
			, url : 'http://localhost:3001/customer/cart/delete'
			, dataType : 'json'
			, contentType : 'application/json'
			, data : JSON.stringify({
					custId : 'tjtjtj'
					, cartIds : cartId
				})
	   		, success : function(data) {
	   			$('.cartTable').empty();
	   			cartTotal = 0;
				for(let i = 0; i < data.length; i++) {
	    			$('.cartTable').append('<tr><td style="width: 10%;"><input class="check-order" type="checkbox"></td>' +
	    					'<td class="menuData" data-cart-id="' + data[i].id + '"><strong>' + data[i].quantity + 'x</strong> ' +
	    					data[i].menuName + '<strong class="pull-right">' + data[i].totalAmt + '원</strong></td>' +
	    					'<td style="text-align: right; width: 10%;"><input class="check-delete" type="checkbox"></td></tr>');
	    			if(data[i].options != null) {
		    			for(let j = 0; j < data[i].options.length; j++) {
			    			$('.cartTable').append('<tr><td style="width: 10%;"></td>' +
			    					'<td style="font-size: 11px">' + data[i].options[j].menuOptName + '</td>' +
			    					'<td style="width: 10%;"></td></tr>');			    				
		    			}
	    			}
	    			cartTotal += data[i].totalAmt;
				}
				$('.total span').text(cartTotal + '원');
			}
			, error : function(data) {
				console.log('ERRoR oCCURRED');
				console.log(data);
			}
		});
	});
	
/* 카트의 id="orderNow" 클릭하면 선택된 항목 주문하기 */
	$('#orderNow').on('click', function() {
		const checked = $('.cartTable .check-order:checked');
		let cartId = [];
		for(let i = 0; i < checked.length; i++) {
			cartId[i] = checked.eq(i).parent().siblings('.menuData').attr('data-cart-id');
		}
		/* 카트의 모든 체크박스 해제 */
		$('.table_summary th:eq(0) input').prop('checked', false);
		$('.cartTable .check-order').prop('checked', false);
		$('.table_summary th:eq(2) input').prop('checked', false);
		$('.cartTable .check-delete').prop('checked', false);
		
 		$.ajax({
			type : 'POST'
			, url : 'http://localhost:3001/customer/cart/order'
			, dataType : 'json'
			, contentType : 'application/json'
			, data : JSON.stringify({
					cartIds : cartId
				})
	   		, success : function(data) {
	   			console.log(data);
			}
			, error : function(data) {
				console.log('ERRoR oCCURRED');
				console.log(data);
			}
		});
	});
});