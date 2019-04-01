<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BADGERS - 일반 사용자</title>
</head>
<body>
<!--헤더 -->
  	<!-- 위쪽 헤더바  -->
    <jsp:include page="include/header.jsp" flush="false"/>
    <!-- 영상 및 주문  -->
	<jsp:include page="include/header2.jsp" flush="false"/>

<!-- 본문 ================================================== -->
    <div class="container margin_60">
		<div class="main_title">
            <h2 class="nomargin_top" style="padding-top:0">클라우드 키친이란?</h2>
            <p>한곳에서 ~~~~~~~~</p>
        </div>
        <div class="row">
            <div class="col-md-3">
                <div class="box_home" id="one">
                    <span>1</span>
                    <h3>주소 찾기</h3>
                    <p>근처 클라우드 키친 찾기</p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="box_home" id="two">
                    <span>2</span>
                    <h3>가게 선택 </h3>
                    <p>다양한 가게에서 선택</p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="box_home" id="three">
                    <span>3</span>
                    <h3>결제 종류 선택</h3>
                    <p>빠르고 간편하게 결제</p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="box_home" id="four">
                    <span>4</span>
                    <h3>집앞까지 배달합니다.</h3>
                    <p>배달 얍</p>
                </div>
            </div>
        </div><!-- End Row -->
        <div id="delivery_time" class="hidden-xs">
            <strong><span>3</span><span>0</span></strong>
            <h4>평균 배송 소요 </h4>
        </div>
    </div><!-- End Container -->

    <div class="white_bg">
        <div class="container margin_60">
            <div class="main_title">
                <h2 class="nomargin_top">인기 메뉴 </h2>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <a href="${pageContext.request.contextPath}/kitchen/biz_2/main" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip"><img src="/customer/resources/img/thumb_restaurant.jpg" alt=""></div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>유니네 피자집</h3>
                            <div class="type">이태리 / 피자</div>
                            <div class="location">
                            	주소를 적으세요
                            	<span class="opening">오픈 09:00</span>
                            </div>
                            <ul><li>배달<i class="icon_check_alt2 ok"></i></li></ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                    <a href="/detail_page.jsp" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip"><img src="/customer/resources/img/thumb_restaurant_2.jpg" alt=""></div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>태주네 떡볶이</h3>
                            <div class="type">한국 / 분식</div>
                            <div class="location">
                            	135 Newtownards Road, Belfast, BT4.
                            	<span class="opening">Opens at 17:00</span>
                            </div>
                            <ul><li>배달<i class="icon_check_alt2 ok"></i></li></ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                    <a href="detail_page.jsp" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip"><img src="/customer/resources/img/thumb_restaurant_3.jpg" alt=""></div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>종혀니네 햄버거</h3>
                            <div class="type">한국 / 패스트 푸드</div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4.
                                <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul><li>배달<i class="icon_check_alt2 ok"></i></li></ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                </div><!-- End col-md-6-->
                <div class="col-md-6">
                    <a href="/detail_page.jsp" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip"><img src="/customer/resources/img/thumb_restaurant_4.jpg" alt=""></div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>원주니네 통닭</h3>
                            <div class="type">한국 / 치킨</div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4.
                                <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul><li>배달<i class="icon_close_alt2 no"></i></li></ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                    <a href="/detail_page.jsp" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip"><img src="/customer/resources/img/thumb_restaurant_5.jpg" alt=""></div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>명주니네 카레</h3>
                            <div class="type">인도 / 카레</div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4.
                                <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul><li>배달<i class="icon_check_alt2 ok"></i></li></ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                    <a href="/detail_page.jsp" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip"><img src="/customer/resources/img/thumb_restaurant_6.jpg" alt=""></div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>계정이 안맞대자나 </h3>
                            <div class="type">아저씨야 변화없으면 500원</div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4.
                                <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul><li>배달<i class="icon_check_alt2 ok"></i></li></ul>
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

    <section class="parallax-window" data-parallax="scroll" data-image-src="/customer/resources/img/kitchenmain.jpg" data-natural-width="1200" data-natural-height="600">
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
                    <img src="/customer/resources/img/submit_restaurant.jpg" width="848" height="480" alt="" class="img-responsive">
                    <h3>Submit your Restaurant<span>Start to earn customer</span></h3>
                    <p>Lorem ipsum dolor sit amet, ut virtute fabellas vix, no pri falli eloquentiam adversarium. Ea legere labore eam. Et eum sumo ocurreret, eos ei saepe oratio omittantur, legere eligendi partiendo pro te.</p>
                    <div class="btn_1">Read more</div>
                </a>
            </div>
            <div class="col-md-4">
                <a class="box_work" href="submit_driver.html">
                    <img src="/customer/resources/img/delivery.jpg" width="848" height="480" alt="" class="img-responsive">
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



   <script src="/customer/resources/js/video_header.js"></script>
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