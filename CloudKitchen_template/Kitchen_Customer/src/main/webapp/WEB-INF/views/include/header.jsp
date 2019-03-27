<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Preload =============================================== -->
   <div id="preloader">
        <div class="sk-spinner sk-spinner-wave" id="status">
            <div class="sk-rect1"></div>
            <div class="sk-rect2"></div>
            <div class="sk-rect3"></div>
            <div class="sk-rect4"></div>
            <div class="sk-rect5"></div>
        </div>
    </div> 
<!-- End Preload =============================================== -->

<!-- Favicons-->
<link rel="shortcut icon" href="/customer/resources/img/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" type="/customer/resources/img/x-icon" href="/customer/resources/img/apple-touch-icon-57x57-precomposed.png">
<link rel="apple-touch-icon" type="/customer/resources/img/x-icon" sizes="72x72" href="/customer/resources/img/apple-touch-icon-72x72-precomposed.png">
<link rel="apple-touch-icon" type="/customer/resources/img/x-icon" sizes="114x114" href="/customer/resources/img/apple-touch-icon-114x114-precomposed.png">
<link rel="apple-touch-icon" type="/customer/resources/img/x-icon" sizes="144x144" href="/customer/resources/img/apple-touch-icon-144x144-precomposed.png">

<!-- GOOGLE WEB FONT -->
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900" rel="stylesheet">

<!-- BASE CSS -->
<link href="/customer/resources/css/table.css" rel="stylesheet">
<link href="/customer/resources/css/animate.min.css" rel="stylesheet">
<link href="/customer/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/customer/resources/css/menu.css" rel="stylesheet">
<link href="/customer/resources/css/style.css" rel="stylesheet">
<link href="/customer/resources/css/responsive.css" rel="stylesheet">
<link href="/customer/resources/css/elegant_font/elegant_font.min.css" rel="stylesheet">
<link href="/customer/resources/css/fontello/css/fontello.min.css" rel="stylesheet">
<link href="/customer/resources/css/magnific-popup.css" rel="stylesheet">
<link href="/customer/resources/css/pop_up.css" rel="stylesheet">

<!-- Radio and check inputs -->
<link href="/customer/resources/css/skins/square/grey.css" rel="stylesheet">

<!-- YOUR CUSTOM CSS -->
<link href="/customer/resources/css/custom.css" rel="stylesheet">

<header>
	<div class="container-fluid">
		<div class="row">
			<div class="col--md-4 col-sm-4 col-xs-4">
				<a href="${pageContext.request.contextPath}/main" id="logo">
					<img src="/customer/resources/img/logo.png" width="190" height="23" alt="" data-retina="true" class="hidden-xs">
					<img src="/customer/resources/img/logo_mobile.png" width="59" height="23" alt="" data-retina="true" class="hidden-lg hidden-md hidden-sm">
				</a>
			</div>
			<nav class="col--md-8 col-sm-8 col-xs-8">
				<a class="cmn-toggle-switch cmn-toggle-switch__htx open_close" href="javascript:void(0);"><span>Menu mobile</span></a>
				<div class="main-menu">
					<div id="header_menu">
						<a href="${pageContext.request.contextPath}/main">
						<img src="/customer/resources/img/logo.png" width="190" height="23" alt="logo" data-retina="true">
						</a>
					</div>
					<a href="#" class="open_close" id="close_in"><i class="icon_close"></i></a>
					<ul>
						<li class="submenu"><a href="${pageContext.request.contextPath}/main" class="show-submenu">Home</a></li>
						<li class="submenu"><a href="javascript:void(0);" class="show-submenu">Cloud Kitchen<i class="icon-down-open-mini"></i></a>
							<ul>
								<li><a href="list_page.html">줄형</a></li>
								<li><a href="grid_list.html">박스형</a></li>
							</ul></li>
						<li><a href="#0" data-toggle="modal" data-target="#login_2">로그인</a></li>
						<li><a href="#0" data-toggle="modal" data-target="#register">회원가입</a></li>
						<li><a href="#0">마이 페이지</a></li>
						<li><a href="about.html">About us</a></li>
					</ul>
				</div> <!-- End main-menu -->
			</nav>
		</div> <!-- End row -->
	</div> <!-- End container -->
</header> <!-- End Header =============================================== -->

<div class="layer"></div>
<!-- Mobile menu overlay mask -->

<!-- Login modal -->
<div class="modal fade" id="login_2" tabindex="-1" role="dialog" aria-labelledby="myLogin" aria-hidden="true">
<<<<<<< HEAD
       <div class="modal-dialog" style="margin-top: 151px;">
           <div class="modal-content modal-popup" style="position: relative;padding:1px 30px 10px 30px;
					text-align: center;background: #78cfcf;border-radius: 0px;border:none;">
                <a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
                <form action="#" class="popup-form" id="myLogin">
                    <div class="login_icon"><i class="icon_lock_alt"></i></div>
                    <input type="text" class="form-control form-white" placeholder="아이디">
                    <input type="text" class="form-control form-white" placeholder="비밀번호">
                    <div class="text-left">
                        <a id="findId" href="#" style="font-size: 13px;">아이디를 잊으셨나요?</a> <br/>
				    	<a class="changePw" href="#" style="font-size: 13px;">비밀번호를 잊으셨나요?</a>
                     </div>
                    <button type="button" class="btn btn-submit">로그인</button>
                </form>
            </div>
        </div>
    </div><!-- End modal -->




<!-- Find modal -->
<div class="modal fade" id="finder" tabindex="-1" role="dialog"
	aria-labelledby="myLogin" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 151px;">
		<div class="modal-content modal-popup" style="position: relative;padding:1px 30px 10px 30px;
		text-align: center;background: #78cfcf;border-radius: 0px;border:none;">
			<a href="#" class="close-link"><i class="material-icons">close</i></a>
			<form action="#" class="popup-form" id="myId">
				<div class="login_icon" style="margin-top: 20px; margin-bottom: 10px;">
				<i class="material-icons" style="width: 60px; font-size: 60px;">lock_alt</i></div>
				<h2>ID 찾기</h2>
				<h5>ID를 찾으려면 본인인증을 해주세요.</h5>
				<input type="text" class="form-control form-white" placeholder="이름">
				<input type="text" class="form-control form-white" placeholder="이메일">
				<button type="button" id="getId" class="btn btn-submit">ID 찾기</button>
			</form>
		</div>
	</div>
</div>
<!-- End Find Modal -->

<!-- Register modal -->
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myRegister" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content modal-popup">
        	<a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
            <form action="#" class="popup-form" id="myRegister" name ="myRegister">
            	<div class="login_icon"><i class="icon_lock_alt"></i></div>
                <input type="text" class="form-control form-white" placeholder="아이디">
                <input type="password" class="form-control form-white" placeholder="비밀번호" id="password1">
                <input type="password" class="form-control form-white" placeholder="비밀번호 재확인" id="password2">
                <input type="text" class="form-control form-white" placeholder="이름">
                <input type="text" class="form-control form-white" placeholder="생년 월일">
                <input type="text" class="form-control form-white" placeholder="휴대폰 번호">
                <input type="email" class="form-control form-white" placeholder="Email">
                <div>
					<input type="radio" name="gender" value="남" checked onclick="doIt('남')" id = "r1" style="width:23px;height:23px"> 
					<label for = "r1" style="font-size: 30px; color: white; padding-right: 100px;" > 남 </label>
                    <input type="radio" name="gender" value="여" onclick="doIt('여')" id = "r2" style="width:23px;height:23px">
                     <label for = "r2" style="font-size: 30px; color: white; padding-right: 100px;" > 여 </label>
                   	<input type=text name=genders  value="남" style="display:none">
				</div>
                <div id="pass-info" class="clearfix"></div>
                <div class="checkbox-holder text-left">
                	<div class="checkbox">
                    	<input type="checkbox" value="accept_2" id="check_2" name="check_2" />
                        <label for="check_2"><span>I Agree to the <strong>Terms &amp; Conditions</strong></span></label>
					</div>
				</div>
                <button type="button" class="btn btn-submit">회원가입</button>
			</form>
		</div>
	</div>
</div><!-- End Register modal -->

<script>
	function doIt(_v) {
		document.myRegister.genders.value=_v;
	}
</script>