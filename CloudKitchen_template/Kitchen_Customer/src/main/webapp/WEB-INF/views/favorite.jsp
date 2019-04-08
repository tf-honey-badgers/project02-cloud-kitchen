<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜목록 보기</title>
</head>
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

var custId = '${custId}';

</script>




<body>

<!-- 위쪽 헤더바  -->
	<jsp:include page="include/header.jsp" />
	<jsp:include page="include/background.jsp" flush="false" />
	<!-- 헤드 끝 -->
<br><br><br>
	

		<div class="sidebar col-md-2">
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





<h1>찜 리스트</h1>


<table  class="type11" style="margin-left:33%;">
		<thead>
			<tr>
				<th>회원 아이디</th>
				<th>가게 이름</th>
				<th>키친 이름</th>
			</tr>
			</thead>
			<tbody>
			</tbody>
		</table>


		<script>
		 var tbody = $('tbody');
		
		$(document).ready(function(){
			$.getJSON( 'http://localhost/rest/favorite/${custId}/mypage', function(list){
				
				for(var i = 0, len = list.length || 0 ; i < len; i++){
					var tr = $('<tr></tr>');
					var custId = $('<td id="'+ list[i].custId +'">' + list[i].custId + '</td>');
					var bizName =  $('<td>' + list[i].bizName + '</td>');
					var kitchenName = $('<td>' + list[i].kitchenName + '</td>');
					tr.append(custId).append(bizName).append(kitchenName);
					tbody.append(tr);
					console.log(list[i]);
				}
			});
		 
		
		});
			</script>
<div style="margin-bottom: 50%"></div>
	<!-- 아래 풋터바  -->
	<jsp:include page="include/footer.jsp" />
	<!-- 풋터 끝 -->

</body>
</html>