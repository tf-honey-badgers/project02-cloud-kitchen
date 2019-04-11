<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역 확인</title>
</head>
<body>
	<!--헤더 -->
	<!-- 위쪽 헤더바  -->
	<jsp:include page="../include/header.jsp" flush="false" />
	<!-- 주문 헤더 -->
	<jsp:include page="../include/header_order.jsp" flush="false" />
	
	<div id="position">
		<div class="container">
			<ul>
				<li><a href="#0">Home</a></li>
				<li><a href="#0">Category</a></li>
				<li>Page active</li>
			</ul>
			<a href="#0" class="search-overlay-menu-btn"><i
				class="icon-search-6"></i> Search</a>
		</div>
	</div>
	<!-- Position -->

	<!-- Content ================================================== -->
<div class="container margin_60_35">
	<div class="row">
		<div class="col-md-offset-3 col-md-6">
			<div class="box_style_2">
				<h2 class="inner">Order confirmed!</h2>
				<div id="confirm">
					<i class="icon_check_alt2"></i>
					<h3>주문 완료!</h3>
					<p>
						고객님이 주문하신 음식의 조리가 시작되면 실시간으로 주방의 모습을 확인하실 수 있습니다. 고객님의 핸드폰으로 발송된 링크를 통해 청결한 주방과 요리 과정을 확인하세요!
					</p>
				</div>
				<h4>주문 확인</h4>
				<div id="orderBox">
                </div>
                <a href="/customer/member/" class="btn btn-success" style="display:block; text-align: center; margin-bottom:5px;">나의 주문내역으로 가기</a>
                <a href="${pageContext.request.contextPath}/member/${uid}/mypage/orderinfo" class="btn btn-warning" style="display:block; text-align: center;">메인으로 돌아가기</a>
			</div>
		</div>
	</div><!-- End row -->
</div><!-- End container -->
<!-- End Content =============================================== -->

	<!-- Footer 시작  -->
	<jsp:include page="../include/footer.jsp" flush="false" />
	<!-- Footer 끝  -->
	<script>
		var order=${orderconfirm};
	</script>
	<script src="/customer/resources/js/order/order-confirm.js"></script>
</body>
</html>