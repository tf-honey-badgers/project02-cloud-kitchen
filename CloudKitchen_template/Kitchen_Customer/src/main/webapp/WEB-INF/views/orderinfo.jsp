<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 리스트</title>
<script src="/customer/resources/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

var custId = '${custId}';

</script>

</head>
<body>
<!--나중에 뺼 js  -->
<!-- <script type="text/javascript" src="/customer/resources/js/member.js"></script> -->
<br><br>
	<!-- 위쪽 헤더바  -->
	<jsp:include page="include/background.jsp" flush="false" />
	<jsp:include page="include/header.jsp" />
	<!-- 헤드 끝 -->
	<br><br><br><br><br><br><br><br><br><br><br>
	<h2>주문 리스트</h2>
	<br><br>
		<table  class="type11">
		<thead>
			<tr>
				<th>주문 아이디</th>
				<th>회원 아이디</th>
				<th>핸드폰    번호</th>
				<th>주소</th>
				<th>주문 시간</th>
				<th>키친 주소</th>
				<th>주문 가게</th>
				<th>결제 방법</th>
				<th>메인 메뉴</th>
				<th>메인 메뉴 가격</th>
				<th>옵션</th>
				<th>옵션 가격</th>
				<th>수량</th>
				<th>옵션 총 가격</th>
				<th>토탈 가격</th>
				<th>하고싶은말</th>
				
			</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		
		
		<script>
		 var tbody = $('tbody');
		 
		$(document).ready(function(){
		
			
			$.getJSON( 'http://localhost/rest/customer/${custId}/mypage/orderinfo', function(list){
				
				for(var i = 0, len = list.length || 0 ; i < len; i++){
					var tr = $('<tr></tr>');
					var id = $('<td id="'+ list[i].id +'">' + list[i].id + '</td>');
					var custId =  $('<td>' + list[i].custId + '</td>');
					var phone = $('<td>' + list[i].phone + '</td>');
					var address = $('<td>' + list[i].address + '</td>');
					var time = $('<td>' + list[i].time + '</td>');
					var kitchenName = $('<td>' + list[i].kitchenName + '</td>');
					var bizName = $('<td>' + list[i].bizName + '</td>');
					var method = $('<td>' + list[i].method + '</td>');
					var menuName = $('<td>' + list[i].menuName + '</td>');
					var menuPrice = $('<td>' + list[i].menuPrice + '</td>');
					var optName = $('<td>' + list[i].optName + '</td>');
					var optPrice = $('<td>' + list[i].optPrice + '</td>');
					var quantity = $('<td>' + list[i].quantity + '</td>');
					var totalAmt = $('<td>' + list[i].totalAmt + '</td>');
					var payAmt = $('<td>' + list[i].payAmt + '</td>');
					var msg = $('<td>' + list[i].msg + '</td>');
					
					tr.append(id).append(custId).append(phone).append(address).append(time).append(kitchenName).append(bizName).append(method).append(menuName).append(menuPrice)
					.append(optName).append(optPrice).append(quantity).append(totalAmt).append(payAmt).append(msg);
					tbody.append(tr);
					console.log(list[i]);
				}
			});
		 
		
		});
		
		</script>
		
		
		
		
		
		<!-- 위쪽 헤더바  -->
	<jsp:include page="include/footer.jsp" />
	<!-- 헤드 끝 -->
		
		
</body>
</html>