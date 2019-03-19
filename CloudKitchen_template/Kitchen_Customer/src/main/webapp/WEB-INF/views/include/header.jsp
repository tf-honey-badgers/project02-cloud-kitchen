<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--  로딩중 -->
   <div id="preloader">
        <div class="sk-spinner sk-spinner-wave" id="status">
            <div class="sk-rect1"></div>
            <div class="sk-rect2"></div>
            <div class="sk-rect3"></div>
            <div class="sk-rect4"></div>
            <div class="sk-rect5"></div>
        </div>
    </div> 
    
    <!-- End Preload -->
<!-- Favicons-->
    <link rel="shortcut icon" href="/customer/sresources/img/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" type="/customer/resources/image/x-icon" href="/customer/resources/img/apple-touch-icon-57x57-precomposed.png">
    <link rel="apple-touch-icon" type="/customer/resources/image/x-icon" sizes="72x72" href="/customer/resources/img/apple-touch-icon-72x72-precomposed.png">
    <link rel="apple-touch-icon" type="/customer/resources/image/x-icon" sizes="114x114" href="/customer/resources/img/apple-touch-icon-114x114-precomposed.png">
    <link rel="apple-touch-icon" type="/customer/resources/image/x-icon" sizes="144x144" href="/customer/resources/img/apple-touch-icon-144x144-precomposed.png">

    <!-- GOOGLE WEB FONT -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900" rel="stylesheet">

    <!-- BASE CSS -->
    <link href="/customer/resources/css/animate.min.css" rel="stylesheet">
    <link href="/customer/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/customer/resources/css/menu.css" rel="stylesheet">
    <link href="/customer/resources/css/style.css" rel="stylesheet">
    <link href="/customer/resources/css/responsive.css" rel="stylesheet">
    <link href="/customer/resources/css/elegant_font/elegant_font.min.css" rel="stylesheet">
    <link href="/customer/resources/css/fontello/css/fontello.min.css" rel="stylesheet">
    <link href="/customer/resources/css/magnific-popup.css" rel="stylesheet">
    <link href="/customer/resources/css/pop_up.css" rel="stylesheet">

    <!-- YOUR CUSTOM CSS -->
    <link href="/customer/resources/css/custom.css" rel="stylesheet">

    <!-- Modernizr -->
    <script src="/customer/resources/js/modernizr.js"></script>


 <!-- Header ================================================== -->
    <header>
    <div class="container-fluid">
        <div class="row">
            <div class="col--md-4 col-sm-4 col-xs-4">
                <a href="#" id="logo">
                <img src="/customer/resources/img/logo.png" width="190" height="23" alt="" data-retina="true" class="hidden-xs">
                <img src="/customer/resources/img/logo_mobile.png" width="59" height="23" alt="" data-retina="true" class="hidden-lg hidden-md hidden-sm">
                </a>
            </div>
            <nav class="col--md-8 col-sm-8 col-xs-8">
            <a class="cmn-toggle-switch cmn-toggle-switch__htx open_close" href="javascript:void(0);"><span>Menu mobile</span></a>
            <div class="main-menu">
                <div id="header_menu">
                    <img src="/customer/resources/img/logo.png" width="190" height="23" alt="" data-retina="true">
                </div>
                <a href="#" class="open_close" id="close_in"><i class="icon_close"></i></a>
                <ul>
                    <li class="submenu">
                    <a href="javascript:void(0);" class="show-submenu">Home</a>
                    </li>
                    <li class="submenu">
                    <a href="javascript:void(0);" class="show-submenu">Cloud Kitchen<i class="icon-down-open-mini"></i></a>
                    <ul>
                        <li><a href="list_page.html">줄형</a></li>
                        <li><a href="grid_list.html">박스형</a></li>
                    </ul>
                    </li>
             
                    <li><a href="#0" data-toggle="modal" data-target="#login_2">로그인</a></li>
               
               		
               
                    <li><a href="#0" data-toggle="modal" data-target="#register">회원가입</a></li>
                    
                    <li><a href="#0">마이 페이지</a></li>
                    
                    <li><a href="about.html">About us</a></li>
                </ul>
            </div><!-- End main-menu -->
            </nav>
        </div><!-- End row -->
    </div><!-- End container -->
    </header>
	<!-- End Header =============================================== -->
    
    <!-- SubHeader =============================================== -->
    
    <div class="layer"></div><!-- Mobile menu overlay mask -->

    <!-- Login modal -->
    <div class="modal fade" id="login_2" tabindex="-1" role="dialog" aria-labelledby="myLogin" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content modal-popup">
                <a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
                <form action="#" class="popup-form" id="myLogin">
                    <div class="login_icon"><i class="icon_lock_alt"></i></div>
                    <input type="text" class="form-control form-white" placeholder="아이디">
                    <input type="text" class="form-control form-white" placeholder="비밀번호">
                    <div class="text-left">
                        <a href="#">아이디 or 비밀번호 찾기 </a>
                    </div>
                    <button type="submit" class="btn btn-submit">Submit</button>
                </form>
            </div>
        </div>
    </div><!-- End modal -->

    <!-- Register modal -->
    <div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myRegister" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content modal-popup">
                <a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
                <form action="#" class="popup-form" id="myRegister">
                    <div class="login_icon"><i class="icon_lock_alt"></i></div>
                    <input type="text" class="form-control form-white" placeholder="아이디">
                    <input type="password" class="form-control form-white" placeholder="비밀번호" id="password1">
                    <input type="password" class="form-control form-white" placeholder="비밀번호 재확인" id="password2">
                    <input type="text" class="form-control form-white" placeholder="이름">
                    <input type="text" class="form-control form-white" placeholder="생년 월일">
                    <input type="text" class="form-control form-white" placeholder="휴대폰 번호">
                    <input type="email" class="form-control form-white" placeholder="Email">
                    <div>

                        <input type="radio" name="gender" value="남" style="width:23px;height:23px"><span style="font-size: 30px; color: white; padding-right: 100px;">남</span>
                        <input type="radio" name="gender" value="여" style="width:23px;height:23px"><span style="font-size: 30px; color: white">여</span>
                    </div>


                    <div id="pass-info" class="clearfix"></div>
                    <div class="checkbox-holder text-left">
                        <div class="checkbox">
                            <input type="checkbox" value="accept_2" id="check_2" name="check_2" />
                            <label for="check_2"><span>I Agree to the <strong>Terms &amp; Conditions</strong></span></label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-submit">회원가입</button>
                </form>
            </div>
        </div>
    </div><!-- End Register modal -->

    <!-- COMMON SCRIPTS -->
    <script src="/customer/resources/js/jquery-2.2.4.min.js"></script>
    <script src="/customer/resources/js/common_scripts_min.js"></script>
    <script src="/customer/resources/js/functions.js"></script>
    <script src="/customer/resources/assets/validate.js"></script>
  <!-- SPECIFIC SCRIPTS -->
  <script type="text/javascript">
    
    $(document).ready(function() { // makes sure the whole site is loaded
        $('#status').fadeOut(); // will first fade out the loading animation
        $('#preloader').delay(250).fadeOut('slow'); // will fade out the white DIV that covers the website.
        $('body').delay(250).css({'overflow':'visible'});
        $('#sub_content').addClass('animated zoomIn');
        $(window).scroll();
        $('.number').each(function () {
            $(this).prop('Counter',0).animate({
                Counter: $(this).text()
            }, {
                duration: 2000,
                easing: 'swing',
                step: function (now) {
                    $(this).text(Math.ceil(now));
                }
            });
        });
    });
    </script>