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
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" type="${pageContext.request.contextPath}/resources/img/x-icon" href="${pageContext.request.contextPath}/resources/img/apple-touch-icon-57x57-precomposed.png">
<link rel="apple-touch-icon" type="${pageContext.request.contextPath}/resources/img/x-icon" sizes="72x72" href="${pageContext.request.contextPath}/resources/img/apple-touch-icon-72x72-precomposed.png">
<link rel="apple-touch-icon" type="${pageContext.request.contextPath}/resources/img/x-icon" sizes="114x114" href="${pageContext.request.contextPath}/resources/img/apple-touch-icon-114x114-precomposed.png">
<link rel="apple-touch-icon" type="${pageContext.request.contextPath}/resources/img/x-icon" sizes="144x144" href="${pageContext.request.contextPath}/resources/img/apple-touch-icon-144x144-precomposed.png">

<!-- GOOGLE WEB FONT -->
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900" rel="stylesheet">

<!-- BASE CSS -->
<link href="${pageContext.request.contextPath}/resources/css/table.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/animate.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/menu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/responsive.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/elegant_font/elegant_font.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/fontello/css/fontello.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/magnific-popup.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/pop_up.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/custom.css" rel="stylesheet">

<!-- Radio and check inputs -->
<link href="${pageContext.request.contextPath}/resources/css/skins/square/grey.css" rel="stylesheet">

<!-- YOUR CUSTOM CSS -->
<link href="${pageContext.request.contextPath}/resources/css/custom.css" rel="stylesheet">

<header>
	<div class="container-fluid">
		<div class="row">
			<div class="col--md-4 col-sm-4 col-xs-4">
				<a href="${pageContext.request.contextPath}/main" id="logo">
					<img src="${pageContext.request.contextPath}/resources/img/logo.png" width="120" height="" alt="" data-retina="true" class="hidden-xs" style="position:absolute; top:-21px">
					<img src="${pageContext.request.contextPath}/resources/img/logo.png" width="120"  alt="" data-retina="true" class="hidden-lg hidden-md hidden-sm" style="position:absolute; top:-20px">
				</a>
			</div>
			<nav class="col--md-8 col-sm-8 col-xs-8">
				<a class="cmn-toggle-switch cmn-toggle-switch__htx open_close" href="javascript:void(0);"><span>Menu mobile</span></a>
				<div class="main-menu">
					<div id="header_menu">
						<a href="${pageContext.request.contextPath}/main">
						<img src="${pageContext.request.contextPath}/resources/img/logo.png" width="120" height="" alt="logo" data-retina="true" style="position:absolute; top:-8px; right:15px">
						</a>
					</div>
					<a href="#" class="open_close" id="close_in"><i class="icon_close"></i></a>
					<ul>
						<li class="submenu"><a href="${pageContext.request.contextPath}/main" class="show-submenu"><i class="icon-home-2"></i></a></li>
						<c:if test="${empty sessionScope.uid}" > <!-- 기본상태 세션 X  -->
							<li><a href="#0" data-toggle="modal" data-target="#login_2">로그인</a></li>
							<li><a href="#0" data-toggle="modal" data-target="#register">회원가입</a></li>
			    		</c:if>

				

						<c:if test="${!empty sessionScope.uid}" > <!-- 로그인 되어 세션 있는 상태 -->
							<li class="submenu"><a href="#" class="show-submenu">${uname }님</a></li>
							<li><a href="${pageContext.request.contextPath}/member/logout" id="logout">Logout</a><li>
							<li><a href="${pageContext.request.contextPath}/member/${uid}/change">MyPage</a></li>
						</c:if>
						<li><a href="${pageContext.request.contextPath}/about">About Us</a></li>
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
    	<div class="modal-dialog" style="margin-top: 151px;">
           <div class="modal-content modal-popup" style="position:relative; padding:1px 30px 10px 30px;
					text-align:center; background: #78cfcf; border-radius: 0px;border:none;">
                <a href="javascrpit:void()" class="close-link"><i class="icon_close_alt2"></i></a>
                <form action="${pageContext.request.contextPath}/member/login" class="popup-form" id="myLogin">
                    <div class="login_icon"><i class="icon_lock_alt"></i></div>
                    <input type="text" class="form-control form-white" placeholder="아이디">
                    <input type="password" class="form-control form-white" placeholder="비밀번호">
                    <div class="text-left">
                        <a id="findId" href="#" style="font-size: 13px;">아이디를 잊으셨나요?</a> <br/>
				    	<a class="changePw" href="#" style="font-size: 13px;">비밀번호를 잊으셨나요?</a>
                     </div>
                    <button type="button" class="btn btn-submit">로그인</button>

					<a href="https://kauth.kakao.com/oauth/authorize?client_id=3aedd6d785bf068e8df19174bf251262&redirect_uri=http://localhost:3001/customer/main/kakaologin&response_type=code">
						<img alt="카카오 로그인" src="${pageContext.request.contextPath}/resources/img/kakaobutton.png"
						class="btn" style="width: 100%; padding: 0; height: 44px; margin-top: 3px">
					</a>

			</form>
    	</div>
	</div>
</div><!-- End modal -->

<!-- Find modal -->
<div class="modal fade" id="finder" tabindex="-1" role="dialog" aria-labelledby="myLogin" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 151px;">
		<div class="modal-content modal-popup" style="position: relative;padding:1px 30px 10px 30px;
				text-align: center;background: #78cfcf;border-radius: 0px;border:none;">
			<a href="#" class="close-link"><i class="material-icons">close</i></a>
			<form action="#" class="popup-form" id="myId">
				<div class="login_icon" style="margin-top: 20px; margin-bottom: 10px;">
					<i class="material-icons" style="width: 60px; font-size: 60px;">lock_alt</i>
				</div>
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

<!-- chatbot -->

	 <div
	 	class="QnA qnaiframe"
		style="display:none; width:50vh; height:50vh; position:fixed; right:0; bottom:0; z-index:999 ">
		<span style="
		font-weight: bolder;
	    position: relative;
	    right: 10px;
	    display: block;
	    text-align: right;
	    bottom: 20px;
	    top: 20px;
	    color: white;
	    cursor: default;
	    ">
		X
		</span>
		<iframe
			id="QnAbotFrame"
		    allow="microphone;"
		    width="100%"
		    height="100%"
		    src="https://console.dialogflow.com/api-client/demo/embedded/d15a26ba-2ee8-4799-884b-6dbce206a063">
		 </iframe>
	 </div>
	 <img 
	 	id="QnAImg"
	 	class="QnA qnaImg"
	 	alt="chatbot_btn"
	 	src="${pageContext.request.contextPath}/resources/img/bot.png"
	 	style="display:block; width:9vh; height:9vh; position:fixed; bottom:5vh; right:5vh; z-index:999">

<!-- chatbot -->


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
                <div id="pass-info" class="clearfix"></div>
                <input type="text" class="form-control form-white" placeholder="이름">
                <input type="text" class="form-control form-white" placeholder="생년 월일">
                <input type="text" class="form-control form-white" placeholder="휴대폰 번호">
                <input type="email" class="form-control form-white" placeholder="Email">
                <div>
					<input type="radio" name="gender" value="남" checked onclick="doIt('남')" id = "r1" style="width:23px;height:18px;">
					<label for = "r1" style="font-size: 15px; color: white; padding-right: 30%;" > 남 </label>
                    <input type="radio" name="gender" value="여" onclick="doIt('여')" id = "r2" style="width:23px;height:18px;">
                    <label for = "r2" style="font-size: 15px; color: white; padding-right: 10px;" > 여 </label>
                   	<input type=text name=genders  value="남" style="display:none">
				</div>				
                <div class="form-group">                   
					<input class="form-control" style="width: 50%;  display: inline;" placeholder="우편번호" name="addr1" id="addr1" type="text" readonly="readonly" >
    				<button type="button" class="btn btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
				</div>
				<div class="form-group">
  			    	<input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="location" id="addr2" type="text" readonly="readonly" />
				</div>
				<div class="form-group">
					<input class="form-control" placeholder="상세주소" name="location" id="addr3" type="text"  />
				</div>
                <button type="button" class="btn btn-submit">회원가입</button><input type="hidden" id="bizIdx" value="${idx}">
			</form>
		</div>
	</div>
</div><!-- End Register modal -->

<script>
	function doIt(_v) {
		document.myRegister.genders.value=_v;
	}
</script>
<script>
function execPostCode() {
	new daum.Postcode({
		oncomplete: function(data) {
        	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
            	extraRoadAddr += data.bname;
			}
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
            	extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			}
            // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
            	extraRoadAddr = ' (' + extraRoadAddr + ')';
			}
            // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
            if(fullRoadAddr !== ''){
            	fullRoadAddr += extraRoadAddr;
			}
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            console.log(data.zonecode);
            console.log(fullRoadAddr);
            
            document.getElementById('addr1').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('addr2').value = fullRoadAddr;
               
		}
	}).open();
}
</script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('.QnA').on('click',function(event){
			console.log(this);
			
			$('.QnA').toggle();
		});
		
	});

</script>
