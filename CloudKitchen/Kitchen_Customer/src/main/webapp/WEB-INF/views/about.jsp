<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>About Us</title>
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
				<h3 class="nomargin_top">About Our Project</h3>
				<div class="layer hidden-sm hidden-xs">
					<div class="slick">
						<div class="">
							<img class="Simg"
								src="${pageContext.request.contextPath}/resources/img/aboutus/systemMock.png"
								alt="architecture">
						</div>
						<div class="">
							<img class="Simg"
								src="${pageContext.request.contextPath}/resources/img/aboutus/fcm.png"
								alt="architecture">
						</div>
						<div class="">
							<img class="Simg"
								src="${pageContext.request.contextPath}/resources/img/aboutus/flow.png"
								alt="architecture">
						</div>
						<div class="">
							<img class="Simg"
								src="${pageContext.request.contextPath}/resources/img/aboutus/systemflow.png"
								alt="architecture">
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-8 center hidden-md hidden-lg hidden-xl img-responsive">
				<img src="${pageContext.request.contextPath}/resources/img/aboutus/cover1.png" alt="" style="width:130%; position:relative; left:-15%">
			</div>
		</div>
		<!-- End row -->
		<hr class="more_margin">
		<div class="main_title">
			<h2 class="nomargin_top">클라우드 키친을 만든 사람들</h2>
		</div>
		<div class="row">
			<div class="col-md-6 wow fadeIn" data-wow-delay="0.1s">
				<div class="feature">
					<i class="icon-group"></i>
					<h3>
						Team. HoneyBadgers
					</h3>
					<p>
					팀원 : 김명준, 김종현, 손윤, 이태주, 정원준<br>
					GitHub : <a target="_blank" href="https://github.com/tf-honey-badgers">https://github.com/tf-honey-badgers</a></p>
					<br>
					<br>
				</div>
			</div>
			<div class="col-md-6 wow fadeIn" data-wow-delay="0.2s">
				<div class="feature">
					<i class="icon-user"></i>
					<h3>
						김명준
					</h3>
					<p>공통  : RESTful 아키텍쳐설계, DB설계, 화면설계 <br>
					주요담당 : 사용자 검색 기능과 자동완성, 가게 메뉴 선택과 카트 관리, YouTube 실시간 방송 처리, 사업자/가게 정보 수정 기능<br>
					GitHub : <a target="_blank" href="https://github.com/yuriel849">https://github.com/yuriel849</a></p></p>
				</div>
			</div>
		</div> <!-- End row -->
		<div class="row">
			<div class="col-md-6 wow fadeIn" data-wow-delay="0.1s">
				<div class="feature">
					<i class="icon-user"></i>
					<h3>
						김종현
					</h3>
					<p>공통  : RESTful 아키텍쳐설계, DB설계, 화면설계<br>
					주요담당 : 회원가입(카카오 주소 api,이메일 인증 Spring security 
					회원정보 암호화 bcrypt)로그인, 회원정보 수정 <br>
					GitHub : <a target="_blank" href="https://github.com/a4015z">https://github.com/a4015z</a></p>
				</div>
			</div>
			<div class="col-md-6 wow fadeIn" data-wow-delay="0.2s">
				<div class="feature">
					<i class="icon-user"></i>
					<h3>
						손 윤
					</h3>
					<p>공통  : RESTful 아키텍쳐설계, DB설계, 화면설계 <br>
					주요담당 : 주문시스템 (카카오페이, Firebase Database, FCM 푸시 알림 ), 사업자 로그인 처리<br>
					GitHub : <a target="_blank" href="https://github.com/sonyoon7">https://github.com/sonyoon7</a></p></p>
				</div>
			</div>
		</div> <!-- End row -->
		<div class="row">
			<div class="col-md-6 wow fadeIn" data-wow-delay="0.1s">
				<div class="feature">
					<i class="icon-user"></i>
					<h3>
						이태주
					</h3>
					<p>공통  : RESTful 아키텍쳐설계, DB설계, 화면설계<br>
					주요담당 : 주문시스템 (카카오페이, 카카오주소api, Firebase Database, FCM 푸시 알림 ), QNA 챗봇<br>
					GitHub : <a target="_blank" href="https://github.com/cn3085">https://github.com/cn3085</a></p>
				</div>
			</div>
			<div class="col-md-6 wow fadeIn" data-wow-delay="0.2s">
				<div class="feature">
					<i class="icon-user"></i>
					<h3>
						정원준
					</h3>
					<p>공통  : RESTful 아키텍쳐설계, DB설계, 화면설계 <br>
					주요담당 : 메뉴등록/삭제/변경과 사진파일(AWS S3)관리 및 메뉴추천(Mahout)<br>
					GitHub : <a target="_blank" href="https://github.com/shot013/CloudKitchen"><img src="">https://github.com/shot013/CloudKitchen</a></p></p>
				</div>
			</div>
		</div> <!-- End row -->
	</div> <!-- End container -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 nopadding features-intro-img">
				<div class="features-bg">
					<div class="features-img"><img alt="" src=""></div>
				</div>
			</div>
			<div class="col-md-6 nopadding">
				<div class="features-content">
					<h3>"Honey Badgers"</h3>
					<p>서비스명 & 앱설명  : 클라우드 키친 - 공유 주방을 활용한 실시간 다중 주문 시스템<br>
						운영 대상 & 구현목표 : CUSTOMER (일반 고객) - 실시간 복수 가맹점 다중 주문 서비스 제공<br>
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
						BUSINESS (사업자) - 실시간 주문 관리 및 조리 장면 실시간 스트리밍 서비스 제공
					</p>
					<p>개발 툴 : Git, Spring Tool Suite, Eclipse, PuTTY, MySQL Workbench<br>
						라이브러리 : Kakao Login, KakaoPay, Mahout, AWS S3, Firebase Realtime Database & FCM, <br>
						 &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						 Google Dialogflow (Chatbot) jQuery, Bootstrap
					</p>
				</div>
			</div>
		</div>
	</div> <!-- End container-fluid  -->
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
					autoplaySpeed : 2400,
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