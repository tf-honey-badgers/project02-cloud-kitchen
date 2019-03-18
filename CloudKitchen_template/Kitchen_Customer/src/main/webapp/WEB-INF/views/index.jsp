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

    <!-- Favicons-->
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" type="image/x-icon" href="img/apple-touch-icon-57x57-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="72x72" href="img/apple-touch-icon-72x72-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="114x114" href="img/apple-touch-icon-114x114-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="144x144" href="img/apple-touch-icon-144x144-precomposed.png">

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
</head>
  <!-- Header -->
            <jsp:include page="include/header.jsp" flush="false"></jsp:include>
<body>

    <div id="preloader">
        <div class="sk-spinner sk-spinner-wave" id="status">
            <div class="sk-rect1"></div>
            <div class="sk-rect2"></div>
            <div class="sk-rect3"></div>
            <div class="sk-rect4"></div>
            <div class="sk-rect5"></div>
        </div>
    </div><!-- End Preload -->

<!-- Content ================================================== -->
    <div class="container margin_60">

        <div class="main_title">
            <h2 class="nomargin_top" style="padding-top:0">How it works</h2>
            <p>
                Cum doctus civibus efficiantur in imperdiet deterruisset.
            </p>
        </div>
        <div class="row">
            <div class="col-md-3">
                <div class="box_home" id="one">
                    <span>1</span>
                    <h3>Search by address</h3>
                    <p>
                        Find all restaurants available in your zone.
                    </p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="box_home" id="two">
                    <span>2</span>
                    <h3>Choose a restaurant</h3>
                    <p>
                        We have more than 1000s of menus online.
                    </p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="box_home" id="three">
                    <span>3</span>
                    <h3>Pay by card or cash</h3>
                    <p>
                        It's quick, easy and totally secure.
                    </p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="box_home" id="four">
                    <span>4</span>
                    <h3>Delivery or takeaway</h3>
                    <p>
                        You are lazy? Are you backing home?
                    </p>
                </div>
            </div>
        </div><!-- End row -->

        <div id="delivery_time" class="hidden-xs">
            <strong><span>2</span><span>5</span></strong>
            <h4>The minutes that usually takes to deliver!</h4>
        </div>
    </div><!-- End container -->

    <div class="white_bg">
        <div class="container margin_60">

            <div class="main_title">
                <h2 class="nomargin_top">Choose from Most Popular</h2>
                <p>
                    Cum doctus civibus efficiantur in imperdiet deterruisset.
                </p>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <a href="detail_page.html" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip">
                                <img src="/customer/resources/img/thumb_restaurant.jpg" alt="">
                            </div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>Taco Mexican</h3>
                            <div class="type">
                                Mexican / American
                            </div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4. <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul>
                                <li>Take away<i class="icon_check_alt2 ok"></i></li>
                                <li>Delivery<i class="icon_check_alt2 ok"></i></li>
                            </ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                    <a href="detail_page.html" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip">
                                <img src="img/thumb_restaurant_2.jpg" alt="">
                            </div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>Naples Pizza</h3>
                            <div class="type">
                                Italian / Pizza
                            </div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4. <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul>
                                <li>Take away<i class="icon_check_alt2 ok"></i></li>
                                <li>Delivery<i class="icon_check_alt2 ok"></i></li>
                            </ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                    <a href="detail_page.html" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip">
                                <img src="img/thumb_restaurant_3.jpg" alt="">
                            </div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>Japan Food</h3>
                            <div class="type">
                                Sushi / Japanese
                            </div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4. <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul>
                                <li>Take away<i class="icon_check_alt2 ok"></i></li>
                                <li>Delivery<i class="icon_check_alt2 ok"></i></li>
                            </ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                </div><!-- End col-md-6-->
                <div class="col-md-6">
                    <a href="detail_page.html" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip">
                                <img src="img/thumb_restaurant_4.jpg" alt="">
                            </div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>Sushi Gold</h3>
                            <div class="type">
                                Sushi / Japanese
                            </div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4. <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul>
                                <li>Take away<i class="icon_check_alt2 ok"></i></li>
                                <li>Delivery<i class="icon_close_alt2 no"></i></li>
                            </ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                    <a href="detail_page.html" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip">
                                <img src="img/thumb_restaurant_5.jpg" alt="">
                            </div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>Dragon Tower</h3>
                            <div class="type">
                                Chinese / Thai
                            </div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4. <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul>
                                <li>Take away<i class="icon_check_alt2 ok"></i></li>
                                <li>Delivery<i class="icon_check_alt2 ok"></i></li>
                            </ul>
                        </div><!-- End desc-->
                    </a><!-- End strip_list-->
                    <a href="detail_page.html" class="strip_list">
                        <div class="ribbon_1">Popular</div>
                        <div class="desc">
                            <div class="thumb_strip">
                                <img src="/customer/resources/img/thumb_restaurant_6.jpg" alt="">
                            </div>
                            <div class="rating">
                                <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                            </div>
                            <h3>China Food</h3>
                            <div class="type">
                                Chinese / Vietnam
                            </div>
                            <div class="location">
                                135 Newtownards Road, Belfast, BT4. <span class="opening">Opens at 17:00</span>
                            </div>
                            <ul>
                                <li>Take away<i class="icon_check_alt2 ok"></i></li>
                                <li>Delivery<i class="icon_check_alt2 ok"></i></li>
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

    <section class="parallax-window" data-parallax="scroll" data-image-src="img/bg_office.jpg" data-natural-width="1200" data-natural-height="600">
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
                    <img src="img/submit_restaurant.jpg" width="848" height="480" alt="" class="img-responsive">
                    <h3>Submit your Restaurant<span>Start to earn customers</span></h3>
                    <p>Lorem ipsum dolor sit amet, ut virtute fabellas vix, no pri falli eloquentiam adversarium. Ea legere labore eam. Et eum sumo ocurreret, eos ei saepe oratio omittantur, legere eligendi partiendo pro te.</p>
                    <div class="btn_1">Read more</div>
                </a>
            </div>
            <div class="col-md-4">
                <a class="box_work" href="submit_driver.html">
                    <img src="img/delivery.jpg" width="848" height="480" alt="" class="img-responsive">
                    <h3>We are looking for a Driver<span>Start to earn money</span></h3>
                    <p>Lorem ipsum dolor sit amet, ut virtute fabellas vix, no pri falli eloquentiam adversarium. Ea legere labore eam. Et eum sumo ocurreret, eos ei saepe oratio omittantur, legere eligendi partiendo pro te.</p>
                    <div class="btn_1">Read more</div>
                </a>
            </div>
        </div><!-- End row -->
    </div><!-- End container -->

</body>
</html>