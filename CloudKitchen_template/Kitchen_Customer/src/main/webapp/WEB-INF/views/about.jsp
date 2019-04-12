<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회사 소개</title>
<style>
.slick div {
	width: 100%;
	margin: 0 auto;
}

.Simg {
	width: 100%;
	height: 500px;
}

.layer {
	display: contents !important;
	width: 100%;
	height: 400px;
	background-color: #000;
}

/*  slick 쓸때  공통적으로 넣어줘야 하는것       */
.slick {
	position: relative;
}

.slick-list {
	width: 100%;
	position: relative;
	overflow: hidden;
}

.slick-slide {
	float: left;
}
</style>
<script></script>

</head>
<body>
	<!--헤더 -->
	<!-- 위쪽 헤더바  -->
	<jsp:include page="include/header.jsp" flush="false" />
	<!-- 영상 및 주문  -->
	<jsp:include page="include/about_subheader.jsp" flush="false" />

	<!-- Content ================================================== -->
	<div class="container margin_60_35">
		<div class="row" style="margin-left:10%; margin-right:10%;">
			<div class="">
				<h3 class="nomargin_top">About us Project</h3>
				<div class="layer">
					<div class="slick">
						<div class="">
							<img class="Simg"
								src="${pageContext.request.contextPath}/resources/img/aboutus/arch.png"
								alt="architecture">
						</div>
						<div class="">
							<img class="Simg"
								src="${pageContext.request.contextPath}/resources/img/aboutus/cat.jpg"
								alt="architecture">
						</div>
						<div class="">
							<img class="Simg"
								src="${pageContext.request.contextPath}/resources/img/aboutus/9.jpg"
								alt="architecture">
						</div>
						<div class="">
							<img class="Simg"
								src="${pageContext.request.contextPath}/resources/img/aboutus/hhh.jpg"
								alt="architecture">
						</div>
						<div class="">
							<img class="Simg"
								src="${pageContext.request.contextPath}/resources/img/aboutus/flow.png"
								alt="architecture">
						</div>
					</div>
				</div>



			</div>
			<div class="col-md-7 col-md-offset-1 text-right hidden-sm hidden-xs">
				<img src="img/devices.jpg" alt="" class="img-responsive">
			</div>
		</div>
		<!-- End row -->
		<hr class="more_margin">
		<div class="main_title">
			<h2 class="nomargin_top">클라우드 키친을 만든 사람들</h2>
			<p>당신은 이것을 읽으십시오.</p>
		</div>
		<div class="row">
			<div class="col-md-6 wow fadeIn" data-wow-delay="0.1s">
				<div class="feature">
					<i class="icon_building"></i>
					<h3>
						<span>1.</span> 이태주
					</h3>
					<p>안녕하십니까. 저는 아주 좋습니다.<br>
					그리고 이거는<br>
					세줄 쓰십시오</p>
				</div>
			</div>
			<div class="col-md-6 wow fadeIn" data-wow-delay="0.2s">
				<div class="feature">
					<i class="icon_documents_alt"></i>
					<h3>
						<span>+1000</span> Food Menu
					</h3>
					<p>Lorem ipsum dolor sit amet, vix erat audiam ei. Cum doctus
						civibus efficiantur in. Nec id tempor imperdiet deterruisset,
						doctus volumus explicari qui ex, appareat similique an usu.</p>
				</div>
			</div>
		</div>
		<!-- End row -->
		<div class="row">
			<div class="col-md-6 wow fadeIn" data-wow-delay="0.3s">
				<div class="feature">
					<i class="icon_bag_alt"></i>
					<h3>
						<span>Delivery</span> or Takeaway
					</h3>
					<p>Lorem ipsum dolor sit amet, vix erat audiam ei. Cum doctus
						civibus efficiantur in. Nec id tempor imperdiet deterruisset,
						doctus volumus explicari qui ex, appareat similique an usu.</p>
				</div>
			</div>
			<div class="col-md-6 wow fadeIn" data-wow-delay="0.4s">
				<div class="feature">
					<i class="icon_mobile"></i>
					<h3>
						<span>Mobile</span> support
					</h3>
					<p>Lorem ipsum dolor sit amet, vix erat audiam ei. Cum doctus
						civibus efficiantur in. Nec id tempor imperdiet deterruisset,
						doctus volumus explicari qui ex, appareat similique an usu.</p>
				</div>
			</div>
		</div>
		<!-- End row -->
		<div class="row">
			<div class="col-md-6 wow fadeIn" data-wow-delay="0.5s">
				<div class="feature">
					<i class="icon_wallet"></i>
					<h3>
						<span>Cash</span> payment
					</h3>
					<p>Lorem ipsum dolor sit amet, vix erat audiam ei. Cum doctus
						civibus efficiantur in. Nec id tempor imperdiet deterruisset,
						doctus volumus explicari qui ex, appareat similique an usu.</p>
				</div>
			</div>
			<div class="col-md-6 wow fadeIn" data-wow-delay="0.6s">
				<div class="feature">
					<i class="icon_creditcard"></i>
					<h3>
						<span>Secure card</span> payment
					</h3>
					<p>Lorem ipsum dolor sit amet, vix erat audiam ei. Cum doctus
						civibus efficiantur in. Nec id tempor imperdiet deterruisset,
						doctus volumus explicari qui ex, appareat similique an usu.</p>
				</div>
			</div>
		</div>
		<!-- End row -->
	</div>
	<!-- End container -->

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 nopadding features-intro-img">
				<div class="features-bg">
					<div class="features-img"></div>
				</div>
			</div>
			<div class="col-md-6 nopadding">
				<div class="features-content">
					<h3>"Ex vero mediocrem"</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
						a lorem quis neque interdum consequat ut sed sem. Duis quis tempor
						nunc. Interdum et malesuada fames ac ante ipsum primis in
						faucibus.</p>
					<p>Per ea erant aeque corpora, an agam tibique nec. At recusabo
						expetendis vim. Tractatos principes mel te, dolor solet viderer
						usu ad.</p>
				</div>
			</div>
		</div>
	</div>
	<!-- End container-fluid  -->
	<!-- End Content =============================================== -->

	<!-- Footer 시작  -->
	<jsp:include page="include/footer.jsp" flush="false" />
	<!-- Footer 끝  -->
	<script src="${pageContext.request.contextPath}/resources/js/slick.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			function slide() {
				$('.slick').slick({
					sslideToshow : 1,
					autoplay : true,
					autoplaySpeed : 2000,
					arrows : false,
					dots : false,
					puaseOnHover : true

				})
			}
			$('.layer').show();
			slide();

		})
	</script>
</body>
</html>