<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- SubHeader =============================================== -->
<section class="parallax-window" id="short" data-parallax="scroll"
	data-image-src="/customer/resources/RTL_version/img/sub_header_cart.jpg"
	data-natural-width="1400" data-natural-height="350">
	<div id="subheader">
		<div id="sub_content">
			<h1>Place your order</h1>
			<div class="bs-wizard">
				<c:choose>
					<c:when
						test="${requestScope['javax.servlet.forward.servlet_path']=='/order/info'}">
						<div id="info" class="col-xs-4 bs-wizard-step active">
					</c:when>
					<c:when
						test="${requestScope['javax.servlet.forward.servlet_path']=='/order/payment'}">
						<div id="info" class="col-xs-4 bs-wizard-step complete">
					</c:when>
					<c:when
						test="${requestScope['javax.servlet.forward.servlet_path']=='/order/confirm'}">
						<div id="info" class="col-xs-4 bs-wizard-step complete">
					</c:when>
				</c:choose>
					<div class="text-center bs-wizard-stepnum">
						<strong>1.</strong> Your details
					</div>
					<div class="progress">
						<div class="progress-bar"></div>
					</div>
					<a href="cart.html" class="bs-wizard-dot"></a>
				</div>

				<c:choose>
					<c:when
						test="${requestScope['javax.servlet.forward.servlet_path']=='/order/info'}">
						<div id="info" class="col-xs-4 bs-wizard-step disabled">
					</c:when>
					<c:when
						test="${requestScope['javax.servlet.forward.servlet_path']=='/order/payment'}">
						<div id="info" class="col-xs-4 bs-wizard-step active">
					</c:when>
					<c:when
						test="${requestScope['javax.servlet.forward.servlet_path']=='/order/confirm'}">
						<div id="info" class="col-xs-4 bs-wizard-step complete">
					</c:when>
				</c:choose>
					<div class="text-center bs-wizard-stepnum">
						<strong>2.</strong> Payment
					</div>
					<div class="progress">
						<div class="progress-bar"></div>
					</div>
					<a href="cart_2.html" class="bs-wizard-dot"></a>
				</div>

				<c:choose>
					<c:when
						test="${requestScope['javax.servlet.forward.servlet_path']=='/order/info'}">
						<div id="info" class="col-xs-4 bs-wizard-step disabled">
					</c:when>
					<c:when
						test="${requestScope['javax.servlet.forward.servlet_path']=='/order/payment'}">
						<div id="info" class="col-xs-4 bs-wizard-step disabled">
					</c:when>
					<c:when
						test="${requestScope['javax.servlet.forward.servlet_path']=='/order/confirm'}">
						<div id="info" class="col-xs-4 bs-wizard-step complete">
					</c:when>
				</c:choose>
					<div class="text-center bs-wizard-stepnum">
						<strong>3.</strong> Finish!
					</div>
					<div class="progress">
						<div class="progress-bar"></div>
					</div>
					<a href="#0" class="bs-wizard-dot"></a>
				</div>
			</div>
			<!-- End bs-wizard -->
		</div>
		<!-- End sub_content -->
	</div>
	<!-- End subheader -->
</section>

<!-- End section -->
<!-- End SubHeader ============================================ -->