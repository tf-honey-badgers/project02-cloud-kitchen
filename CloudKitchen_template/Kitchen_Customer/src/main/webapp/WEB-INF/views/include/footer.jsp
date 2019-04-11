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
            	<h3>기타 링크</h3>
                <ul>
                    <li><a href="faq.html">FAQ</a></li>
                    <li><a href="contacts.html">연락하기</a></li>
                    <li><a href="#0" data-toggle="modal" data-target="#login_2">로그인</a></li>
                    <li><a href="#0" data-toggle="modal" data-target="#register">회원가입</a></li>
                    <li><a href="#0">이용약관</a></li>
                    <li><a href="#0">개인정보처리방침</a></li>
                    <li><a href="about.html">회사소개</a></li>
                    <li><a href="about.html">고객센터</a></li>
                </ul>
            </div>
            <div class="col-md-3 col-sm-3" id="newsletter">
                <h3>벌꿀오소리들 소식지</h3>
                <p>새로운 소식을 전해받고 싶으시면 소식지를 구독해주세요!</p>
                <div id="message-newsletter_2"></div>
                <form method="post" action="assets/newsletter.php" name="newsletter_2" id="newsletter_2">
                    <div class="form-group">
                        <input name="email_newsletter_2" id="email_newsletter_2" type="email" value="" placeholder="이메일 주소" class="form-control">
                    </div>
                    <input type="submit" value="구독하기" class="btn_1" id="submit-newsletter_2">
                </form>
            </div>
            <div class="col-md-2 col-sm-3">
                <h3>Settings</h3>
                <div class="styled-select">
                    <select class="form-control" name="lang" id="lang">
                    	<option value="한국어" selected>한국어</option>
                        <option value="English">English</option>
                        <option value="German">Deutsch</option>
                        <option value="French">Francais</option>
                    </select>
                </div>
                <div class="styled-select">
                    <select class="form-control" name="currency" id="currency">
                        <option value="KRW" selected>원화</option>
                        <option value="USD">USD</option>
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
                    <p>© Honey Badgers Cloud Kitchen 2019</p>
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
<script src="${pageContext.request.contextPath}/resources/js/modernizr.js"></script>

<!-- Customer Member 관련 각종 JavaScript 함수 모음 -->
<script src="${pageContext.request.contextPath}/resources/js/member.js" type="text/javascript"></script>

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

	history.replaceState({}, null, location.pathname);

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
<script src="${pageContext.request.contextPath}/resources/js/search/search-functions.js"></script>
<!-- End Autocomplete =============================================== -->

