<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
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
		<c:forEach var="i" begin="1" end="5">
			<li>옵션 ${i}번 추가하기</li>
			<li>menuOptId : <input type="text" id="menuOptId" placeholder="String을 입력해주세요."></li>
			<li>menuId : <input type="text" id="menuId" placeholder="String을 입력해주세요."></li>
			<li>menuOptName : <input type="text" id="menuOptName" placeholder="String을 입력해주세요."></li>
			<li>menuOptPrice : <input type="text" id="menuOptPrice" placeholder="int를 입력해주세요."></li>
			<br>
		</c:forEach>
	</ul>
	
	<ul>
		<li>custId : <input type="text" id="custId" placeholder="String을 입력해주세요."></li>
		<li>quantity : <input type="text" id="quantity" placeholder="int를 입력해주세요."></li>
		<li>unitPrice : <input type="text" id="unitPrice" placeholder="int를 입력해주세요."></li>
		<li>amount : <input type="text" id="amount" placeholder="int를 입력해주세요."></li>
		<li>kitchenName : <input type="text" id="kitchenName" placeholder="String을 입력해주세요."></li>
		<li>bizName : <input type="text" id="bizName" placeholder="String을 입력해주세요."></li>
		<li>menuId : <input type="text" id="menuId" placeholder="String을 입력해주세요."></li>
		<li>menuName : <input type="text" id="menuName" placeholder="String을 입력해주세요."></li>
	</ul>
		
	<ul>
		<li><input type="button" id="addCart" value="장바구니에 추가하기"></li>
		<li><input type="button" id="readCart" value="장바구니 읽기하기"></li>
		<li><input type="button" id="updateCart" value="장바구니 수정하기"></li>
		<li><input type="button" id="deleteAllCart" value="장바구니 전체 삭제하기"></li>
	</ul>
</body>
<script>
	$(document).ready(function(e){
		var inputData = { custId : $('#custId').val(), quantity : $('#quantity').val(), unitPrice : $('#unitPrice').val(),
				amount : $('#amount').val(), kitchenName : $('#kitchenName').val(), bizName : $('#bizName').val(),
				menuId : $('#menuId').val(), menuName : $('menuName').val() };

		// 장바구니에 메뉴 추가하기
		$('#addCart').on('click', () => {
			$.ajax({
				type : 'POST',
				url : '/cart',
        		headers : {
        			'Accept' : 'application/json',
        			'Content-Type' : 'application/json'
        		},
				data : JSON.stringify(inputData),
	    		success : data => {
					console.log(data);
				},
				error : data => {
					console.log('ERRoR oCCURRED');
					console.log(data);
				},
			});
		});
		
		// 장바구니 읽기
		
		// 장바구니 수정하기
		
		// 장바구니에서 메뉴 삭제하기
		
		// 해당 가게에 정보 및 메뉴 불러오기
		$('#bizinfo').on('click',function(e){
			$.ajax({
        		type : "POST",
        		url : "./kitchenbranch/bizinfo",
/*         		data : {
        			bizid : $('#"biz_id"').val()
        		}, */
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
	
		// 해당 지점에 가게 불러오기
		$('#biz').on('click',function(e){
			$.ajax({
        		type : "POST", 
        		url : "./kitchenbranch/bizlist",
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
		// 키친 지점불러오기
		$('#kitchenbranch').on('click',function(e){
			$.ajax({
        		type : "POST", 
        		url : "./kitchenbranch/kitchenlist",
        		error : function(data){
        			console.log(data);
        		},
        		
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
		// 리뷰관련
		$('#recommendation').on('click',function(e){
			console.log($('#cust_Idx').val());
			$.ajax({
        		type : "POST", 
        		url : "./review/recommendation",
        		data : {
        			idx : $('#cust_Idx').val()
        		},
        		error : function(data){
        			console.log(data);
        		},
        		
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// btn clic 끝
		
		
		$('#review').on('click',function(e){

			$.ajax({
        		type : "POST", 
        		url : "./review/list",
        		error : function(data){
        			console.log(data);
        		},
        		
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// btn clic 끝

	});
	// 리뷰관련 끝
</script>
</html>
