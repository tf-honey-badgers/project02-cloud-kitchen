<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="pizza, delivery food, fast food, sushi, take away, chinese, italian food">
    <meta name="description" content="">
    <meta name="author" content="Ansonika">
    <title>BADGERS -  일반 사용자</title>
	<%-- <jsp:include page="/WEB-INF/customers/resources/img/favicon.ico" /> --%>
    <!-- Favicons-->
    <link rel="shortcut icon" href="/customers/resources/img/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" type="/customers/resources/image/x-icon" href="/customers/resources/img/apple-touch-icon-57x57-precomposed.png">
    <link rel="apple-touch-icon" type="/customers/resources/image/x-icon" sizes="72x72" href="/customers/resources/img/apple-touch-icon-72x72-precomposed.png">
    <link rel="apple-touch-icon" type="/customers/resources/image/x-icon" sizes="114x114" href="/customers/resources/img/apple-touch-icon-114x114-precomposed.png">
    <link rel="apple-touch-icon" type="/customers/resources/image/x-icon" sizes="144x144" href="/customers/resources/img/apple-touch-icon-144x144-precomposed.png">

    <!-- GOOGLE WEB FONT -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900" rel="stylesheet">

    <!-- BASE CSS -->
    <link href="/customers/resources/css/animate.min.css" rel="stylesheet">
    <link href="/customers/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/customers/resources/css/menu.css" rel="stylesheet">
    <link href="/customers/resources/css/style.css" rel="stylesheet">
    <link href="/customers/resources/css/responsive.css" rel="stylesheet">
    <link href="/customers/resources/css/elegant_font/elegant_font.min.css" rel="stylesheet">
    <link href="/customers/resources/css/fontello/css/fontello.min.css" rel="stylesheet">
    <link href="/customers/resources/css/magnific-popup.css" rel="stylesheet">
    <link href="/customers/resources/css/pop_up.css" rel="stylesheet">

    <!-- YOUR CUSTOM CSS -->
    <link href="/customers/resources/css/custom.css" rel="stylesheet">

    <!-- Modernizr -->
    <script src="/customers/resources/js/modernizr.js"></script>
</head>
 
<body>
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
 <!--헤더 -->
  			<!-- 위쪽 헤더바  -->
            <jsp:include page="include/header.jsp" flush="false"/>
            <!--  영상 및 주문  -->
		    <jsp:include page="include/header2.jsp" flush="false"/>



<!-- 본문 ================================================== -->
    <div class="container margin_60">

        <div class="main_title">
            <h2 class="nomargin_top" style="padding-top:0">클라우드 키친이란?</h2>
            <p>
               한곳에서 ~~~~~~~~
            </p>
        </div>
        <div class="row">
            <div class="col-md-3">
                <div class="box_home" id="one">
                    <span>1</span>
                    <h3>주소 찾기</h3>
                    <p>
                       	근처 클라우드 키친 찾기 
                    </p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="box_home" id="two">
                    <span>2</span>
                    <h3>가게 선택 </h3>
                    <p>
                     	다양한 가게에서 선택 
                    </p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="box_home" id="three">
                    <span>3</span>
                    <h3>결제 종류 선택</h3>
                    <p>
                   			 빠르고 간편하게 결제
                    </p>
                </div>
            </div>
            
            <div class="col-md-3">
                <div class="box_home" id="four">
                    <span>4</span>
                    <h3>집앞까지 배달합니다.</h3>
                    <p>
                      		배달 얍 
                    </p>
                </div>
            </div>
        </div><!-- End row -->

        <div id="delivery_time" class="hidden-xs">
            <strong><span>3</span><span>0</span></strong>
            <h4>평균 배송 소요 </h4>
        </div>
    </div><!-- End container -->

    <div class="white_bg">
        <div class="container margin_60">

            <div class="main_title">
                <h2 class="nomargin_top">인기 메뉴 </h2>
               
            </div>

            <div class="row">
                <div class="col-md-6">
                    <a href="detail_page.jsp" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip">
                                <img src="/customers/resources/img/thumb_restaurant.jpg" alt="">
                            </div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>유니네 피자집</h3>
                            <div class="type">
                                	이태리 / 피자
                            </div>
                            <div class="location">
                                		주소를 적으세요 <span class="opening">오픈 09:00</span>
                            </div>
                            <ul>
                               		<li>배달<i class="icon_check_alt2 ok"></i></li>
                            </ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                    <a href="/detail_page.jsp" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip">
                                <img src="/customers/resources/img/thumb_restaurant_2.jpg" alt="">
                            </div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>태주네 떡볶이</h3>
                            <div class="type">
                             		 한국 /분식
                            </div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4. <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul>
                               
                                <li>배달<i class="icon_check_alt2 ok"></i></li>
                            </ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                    <a href="detail_page.jsp" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip">
                                <img src="/customers/resources/img/thumb_restaurant_3.jpg" alt="">
                            </div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>종혀니네 햄버거</h3>
                            <div class="type">
                                	한국 / 패스트 푸드
                            </div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4. <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul>
                               
                                <li>배달<i class="icon_check_alt2 ok"></i></li>
                            </ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                </div><!-- End col-md-6-->
                <div class="col-md-6">
                    <a href="/detail_page.jsp" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip">
                                <img src="/customers/resources/img/thumb_restaurant_4.jpg" alt="">
                            </div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>원주니네 통닭</h3>
                            <div class="type">
                                	한국  / 치킨
                            </div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4. <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul>
                   
                                <li>배달<i class="icon_close_alt2 no"></i></li>
                            </ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                    <a href="/detail_page.jsp" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip">
                                <img src="/customers/resources/img/thumb_restaurant_5.jpg" alt="">
                            </div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>명주니네 카레</h3>
                            <div class="type">
                                	인도 / 카레
                            </div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4. <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul>
                                
                                <li>배달<i class="icon_check_alt2 ok"></i></li>
                            </ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                    <a href="/detail_page.jsp" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip">
                                <img src="/customers/resources/img/thumb_restaurant_6.jpg" alt="">
                            </div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>계정이 안맞대자나 </h3>
                            <div class="type">
                               		아저씨야 변화없으면 500원
                            </div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4. <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul>
                              
                                <li>배달<i class="icon_check_alt2 ok"></i></li>
                            </ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                </div>
            </div><!-- End row -->

        </div><!-- End container -->
    </div><!-- End white_bg -->

    <div class="high_light">
        <div class="container">
            <h3>Choose from over 2,000 Restaurants</h3>
            <p>Ridiculus sociosqu cursus neque cursus curae ante scelerisque vehicula.</p>
            <a href="list_page.html">View all Restaurants</a>
        </div><!-- End container -->
    </div><!-- End hight_light -->

    <section class="parallax-window" data-parallax="scroll" data-image-src="/customers/resources/img/bg_office.jpg" data-natural-width="1200" data-natural-height="600">
        <div class="parallax-content">
            <div class="sub_content">
                <i class="icon_mug"></i>
                <h3>We also deliver to your office</h3>
                <p>
                    Ridiculus sociosqu cursus neque cursus curae ante scelerisque vehicula.
                </p>
            </div><!-- End sub_content -->
        </div><!-- End subheader -->
    </section><!-- End section -->
    <!-- End Content =============================================== -->

    <div class="container margin_60">
        <div class="main_title margin_mobile">
            <h2 class="nomargin_top">Work with Us</h2>
            <p>
                Cum doctus civibus efficiantur in imperdiet deterruisset.
            </p>
        </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-2">
                <a class="box_work" href="submit_restaurant.html">
                    <img src="/customers/resources/img/submit_restaurant.jpg" width="848" height="480" alt="" class="img-responsive">
                    <h3>Submit your Restaurant<span>Start to earn customers</span></h3>
                    <p>Lorem ipsum dolor sit amet, ut virtute fabellas vix, no pri falli eloquentiam adversarium. Ea legere labore eam. Et eum sumo ocurreret, eos ei saepe oratio omittantur, legere eligendi partiendo pro te.</p>
                    <div class="btn_1">Read more</div>
                </a>
            </div>
            <div class="col-md-4">
                <a class="box_work" href="submit_driver.html">
                    <img src="/customers/resources/img/delivery.jpg" width="848" height="480" alt="" class="img-responsive">
                    <h3>We are looking for a Driver<span>Start to earn money</span></h3>
                    <p>Lorem ipsum dolor sit amet, ut virtute fabellas vix, no pri falli eloquentiam adversarium. Ea legere labore eam. Et eum sumo ocurreret, eos ei saepe oratio omittantur, legere eligendi partiendo pro te.</p>
                    <div class="btn_1">Read more</div>
                </a>
            </div>
        </div><!-- End row -->
    </div><!-- End container -->
    
    <!-- Footer 시작  -->
<jsp:include page="include/footer.jsp" flush="false"/>
<!-- Footer 끝  -->
			

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
    <script src="/customers/resources/js/jquery-2.2.4.min.js"></script>
    <script src="/customers/resources/js/common_scripts_min.js"></script>
    <script src="/customers/resources/js/functions.js"></script>
    <script src="/customers/resources/assets/validate.js"></script>
  <!-- SPECIFIC SCRIPTS -->
  
   <script src="/customers/resources/js/video_header.js"></script>
    <script>
        $(document).ready(function() {
            'use strict';
            HeaderVideo.init({
                container: $('.header-video'),
                header: $('.header-video--media'),
                videoTrigger: $("#video-trigger"),
                autoPlayVideo: true
            });

        });
    </script>
    

</body>
</html>