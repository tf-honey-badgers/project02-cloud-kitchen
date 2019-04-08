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
	<div class="container margin_60_35">
		<div class="row">
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
	
				
	
		<!-- End col-md-6-->
		<div class="col-md-4 col-sm-4 wow zoomIn" data-wow-delay="0.2s">
		
			<a class="strip_list grid" href="${pageContext.request.contextPath}/member/card">

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