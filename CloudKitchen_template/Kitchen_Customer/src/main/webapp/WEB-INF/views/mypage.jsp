<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My page</title>
</head>
<body>
	<!-- 위쪽 헤더바  -->
	<jsp:include page="include/header.jsp" />
	<jsp:include page="include/background.jsp" flush="false" />
	<!-- 헤드 끝 -->
<br><br><br><br><br><br>
<div style="margin-left:300px;">	
	
				
	<div class="row">
		<div class="col-md-4 col-sm-4 wow zoomIn" data-wow-delay="0.1s">
			<a class="strip_list grid" href="http://localhost:3001/customer/member/${uid}/change">

				<div class="desc">
					<h3>회원정보 수정</h3>
		
				</div>
			</a>
			<!-- End strip_list-->
		</div>
		<!-- End col-md-6-->
		<div class="col-md-4 col-sm-4 wow zoomIn" data-wow-delay="0.2s">
				<a class="strip_list grid" href="http://localhost:3001/customer/member/${uid}/mypage/orderinfo">

				<div class="desc">
					
					<h3>주문 내역 보기 </h3>
					
				</div>
			</a>
			<!-- End strip_list-->
		</div>
		<!-- End col-md-6-->
	</div>
	<!-- End row-->
<div class="row">
		<div class="col-md-4 col-sm-4 wow zoomIn" data-wow-delay="0.1s">
				<a class="strip_list grid" href="http://localhost:3001/customer/member/fav/${uid}/mypage">
				<div class="desc">
					
				
					<h3>찜 내역 보기  </h3>
		
				</div>
			</a>
			<!-- End strip_list-->
		</div>
		<!-- End col-md-6-->
		<div class="col-md-4 col-sm-4 wow zoomIn" data-wow-delay="0.2s">
		
			<a class="strip_list grid" href="http://localhost:3001/customer/member/card">

				<div class="desc">
					
					<h3>사용자 카드 관리 </h3>
					
				</div>
			</a>
			
			<!-- End strip_list-->
		</div>
		<!-- End col-md-6-->
	</div>
	<!-- End row-->
	
	
	<!-- End row-->
	</div>
		<!-- 위쪽 헤더바  -->
	<jsp:include page="include/footer.jsp" />
	<!-- 헤드 끝 -->

</body>
</html>