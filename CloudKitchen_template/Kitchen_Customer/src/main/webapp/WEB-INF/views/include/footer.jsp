<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Search Menu ============================================ -->
	<div class="search-overlay-menu">
		<span class="search-overlay-close"><i class="icon_close"></i></span>
		<form role="search" id="searchform" method="get">
			<input value="" name="q" type="search" placeholder="Search..." />
			<button type="submit">
				<i class="icon-search-6"></i>
			</button>
		</form>
	</div>
<!-- End Search Menu ============================================ -->

<!-- Footer ================================================== -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-3">
                <h3>Secure payments with</h3>
                <p><img src="/customer/resources/img/cards.png" alt="" class="img-responsive"></p>
            </div>
            <div class="col-md-3 col-sm-3">
                <h3>About</h3>
                <ul>                    
                    <li><a href="faq.html">Faq</a></li>
                    <li><a href="contacts.html">Contacts</a></li>
                    <li><a href="#0" data-toggle="modal" data-target="#login_2">Login</a></li>
                    <li><a href="#0" data-toggle="modal" data-target="#register">Register</a></li>
                    <li><a href="#0">Terms and conditions</a></li>
                    <li><a href="about.html">About us</a></li>
                </ul>
            </div>
            <div class="col-md-3 col-sm-3" id="newsletter">
                <h3>Newsletter</h3>
                <p>Join our newsletter to keep be informed about offers and news.</p>
                <div id="message-newsletter_2"></div>
                <form method="post" action="assets/newsletter.php" name="newsletter_2" id="newsletter_2">
                    <div class="form-group">
                        <input name="email_newsletter_2" id="email_newsletter_2" type="email" value="" placeholder="Your mail" class="form-control">
                    </div>
                    <input type="submit" value="Subscribe" class="btn_1" id="submit-newsletter_2">
                </form>
            </div>
            <div class="col-md-2 col-sm-3">
                <h3>Settings</h3>
                <div class="styled-select">
                    <select class="form-control" name="lang" id="lang">
                        <option value="English" selected>English</option>
                        <option value="French">French</option>
                        <option value="Spanish">Spanish</option>
                        <option value="Russian">Russian</option>
                    </select>
                </div>
                <div class="styled-select">
                    <select class="form-control" name="currency" id="currency">
                        <option value="USD" selected>USD</option>
                        <option value="EUR">EUR</option>
                        <option value="GBP">GBP</option>
                        <option value="RUB">RUB</option>
                    </select>
                </div>
            </div>
        </div> <!-- End row -->
        <div class="row">
            <div class="col-md-12">
                <div id="social_footer">
                    <ul>
                        <li><a href="#0"><i class="icon-facebook"></i></a></li>
                        <li><a href="#0"><i class="icon-twitter"></i></a></li>
                        <li><a href="#0"><i class="icon-google"></i></a></li>
                        <li><a href="#0"><i class="icon-instagram"></i></a></li>
                        <li><a href="#0"><i class="icon-pinterest"></i></a></li>
                        <li><a href="#0"><i class="icon-vimeo"></i></a></li>
                        <li><a href="#0"><i class="icon-youtube-play"></i></a></li>
                    </ul>
                    <p>© Quick Food 2015</p>
                </div>
            </div>
        </div> <!-- End row -->
    </div> <!-- End container -->
</footer> <!-- End Footer =============================================== -->

<!-- COMMON SCRIPTS -->
<script src="/customer/resources/js/jquery-2.2.4.min.js"></script>
<script src="/customer/resources/js/common_scripts_min.js"></script>
<script src="/customer/resources/js/functions.js"></script>
<script src="/customer/resources/assets/validate.js"></script>

<!-- Modernizr -->
<script src="/customer/resources/js/modernizr.js"></script>

<!-- Customer Member 관련 각종 JavaScript 함수 모음 -->
<script src="/customer/resources/js/member.js" type="text/javascript"></script>

<!-- 카톡  -->
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<!-- 주소  -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<!-- SPECIFIC SCRIPTS -->
<script type="text/javascript">
	$(document).ready(function() { // makes sure the whole site is loaded
		$('#status').fadeOut(); // will first fade out the loading animation
		$('#preloader').delay(250).fadeOut('slow'); // will fade out the white DIV that covers the website.
		$('body').delay(250).css({
			'overflow' : 'visible'
		});
		$('#sub_content').addClass('animated zoomIn');
		$(window).scroll();
		$('.number').each(function() {
			$(this).prop('Counter', 0).animate({
				Counter : $(this).text()
			}, {
				duration : 2000,
				easing : 'swing',
				step : function(now) {
					$(this).text(Math.ceil(now));
				}
			});
		});
	});
</script>

<!-- "message" 속성이 있다면 알림창 띄우기 -->
<%-- <c:if test="${not empty message}">
	<script>
		$(document).ready(function() {
			alert('${message}');
		});
	</script>
</c:if> --%>

<!-- Autocomplete =============================================== -->
	<!-- 자동완성에 필요한 CDN -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"
	integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>
<style>
	.ui-autocomplete-category { font-weight: bold; padding: .2em .4em; margin: .8em 0 .2em; line-height: 1.5; }
</style>
	<!-- 자동완성 script -->
<script src="/customer/resources/js/search/search-functions.js"></script>
<!-- End Autocomplete =============================================== -->

<script>
    //로그인 및 로그아웃 버튼 생성 처리
    var cookiedata = document.cookie;

    if(cookiedata.indexOf('kakao_login=done') < 0){
        createLoginKakao();
    }else{
        createLogoutKakao();
    }

    /* 로그인 관련 쿠키 생성 및 삭제 */
    function setCookie( name , value , expired ){

     var date = new Date();
     date.setHours(date.getHours() + expired);
     var expried_set = "expries="+date.toGMTString();
     document.cookie = name + "=" + value + "; path=/;" + expried_set + ";"

    }

    
    
    /* 쿠키 삭제 다른방법
    function deleteCookie( name ){

        var date = new Date();
         date.setHours(date.getHours() - 1);
         var expried_set = "expries="+date.toGMTString();
         document.cookie = name + "="  + "; path=/;" + expried_set + ";"
    }
    */

    // 
    function getCookie(name){

        var nameofCookie = name + "=";
        var x = 0;
        while(x <= document.cookie.length){
            var y = ( x + nameofCookie.length);
            if(document.cookie.substring(x,y) == nameofCookie){
                if((endofCookie = document.cookie.indexOf(";",y)) == -1)
                    endofCookie = document.cookie.length;
                return unescape(document.cookie.substring(y,endofCookie));
            }
            x = document.cookie.indexOf(" ",x) + 1;
            if( x == 0 )
                break;
            }

            return "";
    }


    // 카카오 script key 입력
    Kakao.init('f974d2d246e51518f4c5d60e83a2ee41');

     // 로그인 처리
    function loginWithKakao(){

        Kakao.Auth.cleanup();
        Kakao.Auth.login({
            persistAccessToken: true,
            persistRefreshToken: true,
            success: function(authObj) {
                setCookie("kakao_login","done",1); // 쿠키생성 (로그인)
                //alert(cookiedata);
                createLogoutKakao();
                window.location.href="http://localhost:3001/customer/main/kakaologin";
                document.getElementById('unlink-desc').style.display = "block";

            },
                fail: function(err) {
                 alert(JSON.stringify(err));
            }

        });
    }


    // 로그아웃 처리
    function logoutWithKakao(){
        Kakao.Auth.logout();
        alert('카카오 로그아웃 완료!');
        setCookie("kakao_login","",-1);  // 쿠키삭제 (로그아웃)
        //deleteCookie( "kakao_login" ); 쿠키삭제 다른 방법
        createLoginKakao();
        window.location.href="http://localhost:3001/customer/main";
    }



    // 로그인 버튼생성
    function createLoginKakao(){
     var login_btn = "<a id='custom-login-btn' href='javascript:loginWithKakao()'>"+
                    "<img src='https://k.kakaocdn.net/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg' width='250'/>"+
                    "</a>";
     document.getElementById('kakao_btn_changed').innerHTML  = login_btn;
    }


    // 로그아웃 버튼생성
    function createLogoutKakao(){
     var logout_btn = "<a id='custom-logout-btn' href='javascript:logoutWithKakao()'>"+
                    "<img src='/customer/resources/img/kakao.png' width='200'/>"+
                    "</a>";
     document.getElementById('kakao_btn_changed').innerHTML  = logout_btn;

    }


      //]]>



      //<![CDATA[
        // 사용할 앱의 JavaScript 키를 설정해 주세요.

        function unlinkApp(){
            Kakao.API.request({
                url: '/v1/user/unlink',
                success: function(res) {
                    alert('success!');	
                    console.log(res);
                //    document.getElementById('unlink-desc').style.display = "none";
                },
                fail: function(error) {
                    console.log(error);
                    document.getElementById('unlink-desc').style.display = "block";
                    document.getElementById('error-desc').innerHTML = JSON.stringify(error);

                }
            })
        }
      //]]>
      
</script>
