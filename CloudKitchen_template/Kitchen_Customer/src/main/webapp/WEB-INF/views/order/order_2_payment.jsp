<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>
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
<form action="${pageContext.request.contextPath}/order/payready" method="post">
		<div class="row">
			<div class="col-md-3">
				<div class="box_style_2 hidden-xs info">
					<h4 class="nomargin_top">
						Delivery time <i class="icon_quotations pull-left"></i>
					</h4>
					<p>Lorem ipsum dolor sit amet, in pri partem essent. Qui
						debitis meliore ex, tollit debitis conclusionemque te eos.</p>
					<hr>
					<h4>
						Secure payment <i class="icon_creditcard pull-left"></i>
					</h4>
					<p>Lorem ipsum dolor sit amet, in pri partem essent. Qui
						debitis meliore ex, tollit debitis conclusionemque te eos.</p>
				</div>
				<!-- End box_style_2 -->

				<div class="box_style_2 hidden-xs" id="help">
					<i class="icon_lifesaver"></i>
					<h4>
						Need <span>Help?</span>
					</h4>
					<a href="tel://004542344599" class="phone">+45 423 445 99</a> <small>Monday
						to Friday 9.00am - 7.30pm</small>
				</div>
			</div>
			<!-- End col-md-3 -->
			<div class="col-md-6">
				<div class="box_style_2">
					<h2 class="inner">Payment methods</h2>
					<div class="payment_select">
						<label><input type="radio" value="KAKAO" checked
							name="method" class="icheck">KAKAO PAY</label>
							<i>
								<img style="width:60px; " alt="$kakao icon" src="${pageContext.request.contextPath}/resources/img/kakako_payment_icon.png"></i>
					</div>
					
					<!--End row -->
					<div class="payment_select" id="paypal">
						<label><input type="radio" value="" name="payment_method"
							class="icheck">Pay with paypal</label>
					</div>
					<div class="payment_select nomargin">
						<label><input type="radio" value="" name="payment_method"
							class="icheck">Pay with cash</label> <i class="icon_wallet"></i>
							
					</div>
				</div>
				<!-- End box_style_1 -->
			</div>
			<!-- End col-md-6 -->

			<jsp:include page="selected_cart.jsp"></jsp:include>
			<!-- End col-md-3 -->
			
		</div>
		<!-- End row -->
</form>
	</div>

	<!-- End container -->
	<!-- End Content =============================================== -->
	<!-- Footer 시작  -->
	<jsp:include page="../include/footer.jsp" flush="false" />
	<!-- Footer 끝  -->
	<script src="/customer/resources/js/order/order-payment.js"></script>
	<jsp:include page="pay_modal.jsp" flush="false" />
	
	
</body>
</html>