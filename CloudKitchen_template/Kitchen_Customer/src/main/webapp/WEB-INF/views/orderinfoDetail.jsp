<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 리스트</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js"></script>

</head>
<body>
	<!-- 위쪽 헤더바  -->
	<jsp:include page="include/header.jsp" />
	<jsp:include page="include/background.jsp" flush="false" />
	<!-- 헤드 끝 -->
	<br><br>
			<div class="sidebar col-md-2" style="margin: auto;">
				<div class="theiaStickySidebar">
					<p>
						<a href="javascript:history.back()" class="btn_side">Back to page</a>
					</p>
					<div class="box_style_1">
						<ul id="cat_nav">
						
								<li><a href="${pageContext.request.contextPath}/member/${uid}/change">
								회원정보 수정
								</a></li>
								<li><a href="${pageContext.request.contextPath}/member/${uid}/mypage/orderinfo">
								주문 내역보기
								</a></li>
								<li><a 	href="${pageContext.request.contextPath}/member/fav/${uid}/mypage">
								찜 내역
								</a></li>
							
						</ul>
					</div> <!-- End box_style_1 -->
					<div class="box_style_2 hidden-xs" id="help">
						<i class="icon_lifesaver"></i>
						<h4>도움이</h4>
						<h4>필요하세요?</h4>
						<a href="tel://01012349876" class="phone"><span style="font-size:15px;">010-1234-9876</span></a> <small>1년 365일 오전 9시부터 오후 6시까지!</small>
					</div>
				</div>
			</div> <!-- End col-md-2 -->

<h1>상세내역</h1>
	<table  class="type11" style="margin:auto;" >
		<thead>
			<tr>
				<th>주문 번호</th>
				<th>주소</th>
				<th>날짜</th>
				<th>가게</th>
				<th>결제방법</th>
				<th>메뉴</th>
				<th>가격</th>
				<th>수량</th>
				<th>옵션</th>
				<th>옵션 가격</th>
				<th>총 금액</th>
				<th>남긴말</th>
				
				
			</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		
	
	


		
		<script>
		 var tbody = $('tbody');
		 
		$(document).ready(function(){
		
			
			$.getJSON( 'http://localhost/rest/customer/${id}/mypage/orderinfo', function(list){
			
				for(var i = 0, len = list.length || 0 ; i < len; i++){
					var tr = $('<tr></tr>');
					var id = $('<td id="'+ list[i].id +'">' + list[i].id + '</td>');
					var address = $('<td>' + list[i].address + '</td>');
					var time = $('<td>' + list[i].time + '</td>');
					var bizName = $('<td>' + list[i].bizName + '</td>');
					var method = $('<td>' + list[i].method + '</td>');
					var menuName = $('<td>' + list[i].menuName + '</td>');
					var menuPrice = $('<td>' + list[i].menuPrice + '</td>');
					var quantity = $('<td>' + list[i].quantity + '</td>');
					var optName = $('<td>' + list[i].optName + '</td>');
					var optPrice = $('<td>' + list[i].optPrice + '</td>');
					var payAmt = $('<td>' + list[i].payAmt + '</td>');
					var msg = $('<td>' + list[i].msg + '</td>');
					
					if(list[i].optName == null){
						optName = '<td>'+"옵션 없음"+'</td>';
					
					
					tr.append(id).append(address).append(time).append(bizName).append(method).append(menuName).append(menuPrice)
					.append(quantity).append(optName).append(optPrice).append(payAmt).append(msg);
					tbody.append(tr);
					}else{
						tr.append(id).append(address).append(time).append(bizName).append(method).append(menuName).append(menuPrice)
						.append(quantity).append(optName).append(optPrice).append(payAmt).append(msg);
						tbody.append(tr);
					}
					
				}
					console.log(list[i]);
			});
		 
		
		});
		
		</script>
		
		
		
		
		
		<!-- 위쪽 헤더바  -->
	<jsp:include page="include/footer.jsp" />
	<!-- 헤드 끝 -->
		
		
</body>
</html>