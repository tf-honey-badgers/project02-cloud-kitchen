<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>rest-cart-test</title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<style type="text/css">
		.options { float: right; top: -100px;}
		ul { list-style: none; }
	</style>
</head>
<body>
	<h1>
		Rest Cart Test페이지 입니다.
	</h1>

	<ul class="options">
		<c:forEach var="i" begin="1" end="3">
			<li>옵션 ${i}번 추가하기</li>
			<li>menuOptId : <input type="text" class="menuOptId" value=5></li>
			<li>menuId : <input type="text" class="menuId" value=20></li>
			<li>menuOptName : <input type="text" class="menuOptName" value=라지></li>
			<li>menuOptPrice : <input type="text" class="menuOptPrice" value=3000></li>
			<br>
		</c:forEach>
	</ul>
	
	<ul>
		<li>custId : <input type="text" id="custId" value="tjtjtj"></li>
		<li>quantity : <input type="text" id="quantity" value=10></li>
		<li>unitPrice : <input type="text" id="unitPrice" value=10000></li>
		<li>totalAmt : <input type="text" id="amount" value=100000></li>
		<li>kitchenName : <input type="text" id="kitchenName" value="St. Petersburg"></li>
		<li>bizName : <input type="text" id="bizName" value="Original Vodka"></li>
		<li>menuId : <input type="text" id="menuId" value=20></li>
	</ul>
		
	<ul>
		<li><input type="button" id="addCart" value="장바구니에 추가하기"></li>
		<li><input type="button" id="readCart" value="장바구니 읽기하기"></li>
		<li><input type="button" id="updateCart" value="장바구니 수정하기"></li>
		<li><input type="button" id="deleteCart" value="장바구니 항목 1개 삭제하기"></li>
		<li><input type="button" id="deleteAllCart" value="장바구니 전체 삭제하기"></li>
	</ul>
	
	<div class="printArea"></div>
</body>
<script>
	$(document).ready(function(e){
		var inputOptions = []; // 비동기 요청하면 List로 매핑되도록
		var flag = true; // 옵션 정보 처리 시 사용할 무한루프 제어용
		var cur = 0; // 옵션 정보 처리 시 현재 몇 번째 옵션 출력인지 표시용
		
		// 장바구니에 메뉴 추가하기 -> id="addCart" 버튼을 클릭했을 때 작동!
		$('#addCart').on('click', () => {
			while(flag) { // 3개의 옵션 정보를 생성하여 inputOptions 배열에 추가
				optId = $('.menuOptId').eq(cur).val();
				id = $('.menuId').eq(cur).val();
				optName = $('.menuOptName').eq(cur).val();
				optPrice = $('.menuOptPrice').eq(cur).val();
				cur++;
				
				inputOptions.push({ menuOptId : optId, menuId : id, menuOptName : optName, menuOptPrice : optPrice });
				if(cur == 3) { flag = false; }
			}

			// 비동기 요청하면 CartVOExtended에 매핑되도록
			var inputData = {
					custId : $('#custId').val()
					, quantity : $('#quantity').val()
					, unitPrice : $('#unitPrice').val()
					, totalAmt : $('#totalAmt').val()
					, kitchenName : $('#kitchenName').val()
					, bizName : $('#bizName').val()
					, menuId : $('#menuId').val()
					, options : inputOptions
				};
			console.log("INPUTDATA = 제대로 입력되었는지 확인하기 : ", inputData)
			
			// CartController로 비동기 요청하기
			$.ajax({
				type : 'POST'
				, url : '/cart/'
				, dataType : 'json'
				, contentType : 'application/json'
				, data : JSON.stringify(inputData)
	    		, success : data => {
					console.log(data);
				}
				, error : data => {
					console.log('ERRoR oCCURRED');
					console.log(data);
				}
			});

			// 초기화 (다시 id="addCart" 버튼 누를 때를 대비)
			inputOptions = [];
			flag = true;
			cur = 0;
		});
		
		// 장바구니 읽기
		$('#readCart').on('click', () => {
			$.get({
				url : '/cart/tjtjtj'
				, dataType : "json"
				, success : data => {
					console.log(data);
					$('.printArea').text(data);
				}
			})
			
		});
		
		// 장바구니 수정하기
		$('#updateCart').on('click', () => {			
			var updateData = {
					id : '20'
					, quantity : $("#quantity").val()
					, unitPrice : $('#unitPrice').val()
					, amount : $('#amount').val()
				}
			console.log("UPDATEDATA = 제대로 입력되었는지 확인하기 : ", updateData)
			
			if(updateData.quantity == 0) { // 수량을 0으로 지정하고 클릭했을 경우 지정된 메뉴와 옵션을 삭제한다
				deleteOne();
			} else {
				$.ajax({
					type : 'PUT'
					, url : '/cart/'
					, dataType : 'json'
					, contentType : 'application/json'
					, data : JSON.stringify(updateData)
				    , success : data => {
						console.log(data);
					}
					, error : data => {
						console.log('ERRoR oCCURRED');
						console.log(data);
					}
				});				
			}
		});
		
		// 장바구니에서 메뉴 삭제하기
		$('#deleteCart').on('click', () => {
			deleteOne();
		});
		
		// 장바구니에서 메뉴 전체 삭제하기
		$('#deleteAllCart').on('click', () => {
			$.ajax({
				type : 'DELETE'
				, url : '/cart' + '/tjtjtj'
		    	, success : data => {
					console.log(data);
				}
				, error : data => {
					console.log('ERRoR oCCURRED');
					console.log(data);
				}
			});
		});
		
		const custId = 'tjtjtj';
		const cartId = '20';
		
		function deleteOne() {
			$.ajax({
				type : 'DELETE'
				, url : '/cart/' + custId + '/' + cartId
		    	, success : data => {
					console.log(data);
				}
				, error : data => {
					console.log('ERRoR oCCURRED');
					console.log(data);
				}
			});
		}
	});
</script>
</html>
