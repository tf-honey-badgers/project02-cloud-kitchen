<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 리스트</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

var custId = '${custId}';

</script>
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

${list }
		<table  class="type11" id="list" style="margin: auto;" >
		<thead>
			<tr>
				<th>주문 아이디</th>
				<th>키친 위치</th>
				<th>주소</th>
				<th>가게 이름</th>
				<th>메인 메뉴</th>
				<th>수량</th>
				<th>옵션</th>
				<th>주문 가격</th>
				
				
			</tr>
			</thead>
			<tbody id="t1">
			</tbody>
		</table>
		
	<br><br>
<h3>옵션</h3>
<table class="type11" id="list2" style="margin: auto; ">
<thead>
<tr>
<th>옵션</th>
<th>가격</th>
</tr>
</thead>
<tbody id="t2">
</tbody>

</table>
<br><br>

<h3>결제 내역</h3>
<table class="type11" id="list3" style="margin: auto; ">
<thead>
<tr>
<th>결제 방법</th>
<th>총 금액</th>
<th>남긴말 </th>
</tr>
</thead>
<tbody id="t3">
</tbody>
</table>
		
		<script>
	
		 var tbody = $('#t1');
		$(document).ready(function(){
	
			$.getJSON( 'http://localhost/rest/customer/${custId}/mypage/orderinfo', function(list){
				for(var i = 0, len =5  || 0 ; i < len; i++){
					var tr = $('<tr></tr>');
					var id = $('<td id="'+ list[1].id +'">' + list[i].id + '</td>');
					var kitchenName = $('<td>' + list[i].kitchenName + '</td>');
					var address = $('<td>' + list[i].address + '</td>');
					var bizName = $('<td>' + list[i].bizName + '</td>');
					var menuName = $('<td>' + list[i].menuName + '</td>');
					var quantity = $('<td>' + list[i].quantity + '</td>');
					var menuPrice = $('<td>' + list[i].menuPrice + '</td>');
					var totalAmt = $('<td>' + list[i].totalAmt + '</td>');

			
					
					tr.append(id).append(kitchenName).append(address).append(bizName).append(menuName).append(quantity).append(menuPrice).append(totalAmt);
					tbody.append(tr);
					console.log(list[i]);
				}
			});
		 
		
		});
		
		 var tbody2 = $('#t2');
			$(document).ready(function(){
		
				$.getJSON( 'http://localhost/rest/customer/${custId}/mypage/orderinfo', function(list2){
					
					for(var i = 0, len = 5 || 0 ; i < len; i++){
						var tr = $('<tr></tr>');
					
						var optName =  $('<td id="'+ list2[i].optName +'">' + list2[i].optName + '</td>');
						var optPrice = $('<td>' + list2[i].optPrice + '</td>');
						var id = $('<td>' + list2[2].id + '</td>');
				
						
						tr.append(optName).append(optPrice).append(id);
						tbody2.append(tr);
						console.log(list2[i]);
					}
				});
			 
			
			});
			 var tbody3 = $('#t3');
				$(document).ready(function(){
			
					$.getJSON( 'http://localhost/rest/customer/${custId}/mypage/orderinfo', function(list3){
						
						for(var i = 0, len = 5 || 0 ; i < len; i++){
							var tr = $('<tr></tr>');
							var method = $('<td id="'+ list3[i].method +'">' + list3[i].method + '</td>');
							var payAmt = $('<td>' + list3[i].payAmt + '</td>');
							var msg = $('<td>' + list3[i].msg + '</td>');

					
							
							tr.append(method).append(payAmt).append(msg);
							tbody3.append(tr);
							console.log(list3[i]);
						}
					});
				 
				
				});
	
		
		$('#price').on('click', function() {
		    var cons = document.getElementById("list");
		    if(cons.style.display=='none'){
		        cons.style.display = 'block';
		    }else{
		        cons.style.display = 'none';
		    }
		});
		
		$('#price2').on('click', function() {
		    var con = document.getElementById("list2");
		    if(con.style.display=='none'){
		        con.style.display = 'block';
		    }else{
		        con.style.display = 'none';
		    }
		});
		</script>
		
		
		
		
		
		<!-- 위쪽 헤더바  -->
	<jsp:include page="include/footer.jsp" />
	<!-- 헤드 끝 -->
		
		
</body>
</html>