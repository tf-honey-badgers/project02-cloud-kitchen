<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>BADGERS - 일반 사용자</title>
</head>
<body>
<!-- Header =============================================== -->
	<jsp:include page="include/header.jsp" flush="false" />
<!-- End Header =============================================== -->
<!-- SubHeader & Position =============================================== -->
	<jsp:include page="include/search_subheader.jsp" flush="false" />
<!-- End SubHeader & Position =============================================== -->

<!-- Content ================================================== -->
<div class="container margin_60_35">
	<div class="row">
    
		<div class="col-md-3">
			<p>
				<a class="btn_map" data-toggle="collapse" href="#collapseMap" aria-expanded="false" aria-controls="collapseMap">View on map</a>
			</p>
			<div id="filters_col">
				<a data-toggle="collapse" href="#collapseFilters" aria-expanded="false" aria-controls="collapseFilters" id="filters_col_bt">Filters <i class="icon-plus-1 pull-right"></i></a>
				<div class="collapse" id="collapseFilters">
					<div class="filter_type">
                    	<h6>Distance</h6>
                        <input type="text" id="range" value="" name="range">
						<h6>Type</h6>
						<ul>
							<li><label><input type="checkbox" checked class="icheck">All <small>(49)</small></label></li>
							<li><label><input type="checkbox" class="icheck">American <small>(12)</small></label><i class="color_1"></i></li>
							<li><label><input type="checkbox" class="icheck">Chinese <small>(5)</small></label><i class="color_2"></i></li>
							<li><label><input type="checkbox" class="icheck">Hamburger <small>(7)</small></label><i class="color_3"></i></li>
							<li><label><input type="checkbox" class="icheck">Fish <small>(1)</small></label><i class="color_4"></i></li>
							<li><label><input type="checkbox" class="icheck">Mexican <small>(49)</small></label><i class="color_5"></i></li>
							<li><label><input type="checkbox" class="icheck">Pizza <small>(22)</small></label><i class="color_6"></i></li>
							<li><label><input type="checkbox" class="icheck">Sushi <small>(43)</small></label><i class="color_7"></i></li>
						</ul>
					</div>
					<div class="filter_type">
						<h6>Rating</h6>
						<ul>
							<li><label><input type="checkbox" class="icheck"><span class="rating">
							<i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i>
							</span></label></li>
							<li><label><input type="checkbox" class="icheck"><span class="rating">
							<i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
							</span></label></li>
							<li><label><input type="checkbox" class="icheck"><span class="rating">
							<i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i><i class="icon_star"></i>
							</span></label></li>
							<li><label><input type="checkbox" class="icheck"><span class="rating">
							<i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i><i class="icon_star"></i><i class="icon_star"></i>
							</span></label></li>
							<li><label><input type="checkbox" class="icheck"><span class="rating">
							<i class="icon_star voted"></i><i class="icon_star"></i><i class="icon_star"></i><i class="icon_star"></i><i class="icon_star"></i>
							</span></label></li>
						</ul>
					</div>
					<div class="filter_type">
						<h6>Options</h6>
						<ul class="nomargin">
							<li><label><input type="checkbox" class="icheck">Delivery</label></li>
							<li><label><input type="checkbox" class="icheck">Take Away</label></li>
							<li><label><input type="checkbox" class="icheck">Distance 10Km</label></li>
							<li><label><input type="checkbox" class="icheck">Distance 5Km</label></li>
						</ul>
					</div>
				</div><!--End collapse -->
			</div><!--End filters col-->
		</div><!--End col-md -->
        
		<div class="col-md-9">
        
        <div id="tools">
				<div class="row">
					<div class="col-md-3 col-sm-3 col-xs-6">
						<div class="styled-select">
							<select name="sort_rating" id="sort_rating">
								<option value="" selected>Sort by ranking</option>
								<option value="lower">Lowest ranking</option>
								<option value="higher">Highest ranking</option>
							</select>
						</div>
					</div>
					<div class="col-md-9 col-sm-9 hidden-xs">
						<a href="list_page.html" class="bt_filters"><i class="icon-list"></i></a>
					</div>
				</div>
			</div><!--End tools -->
        
        	<div class="row">
            	<div class="col-md-6 col-sm-6 wow zoomIn" data-wow-delay="0.1s">
                	<a class="strip_list grid" href="detail_page.html">
                    	<div class="ribbon_1">Popular</div>
                    	<div class="desc">
							<div class="thumb_strip">
								<img src="img/thumb_restaurant.jpg" alt="">
							</div>
							<div class="rating">
								<i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
							</div>
							<h3>Taco Mexican</h3>
							<div class="type">
								Mexican / American
							</div>
							<div class="location">
								135 Newtownards Road, Belfast, BT4. <br><span class="opening">Opens at 17:00.</span> Minimum order: $15
							</div>
							<ul>
								<li>Take away<i class="icon_check_alt2 ok"></i></li>
								<li>Delivery<i class="icon_check_alt2 ok"></i></li>
							</ul>
						</div>
                    </a><!-- End strip_list-->
                </div><!-- End col-md-6-->
               <div class="col-md-6 col-sm-6 wow zoomIn" data-wow-delay="0.2s">
                	<a class="strip_list grid" href="detail_page.html">
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
								135 Newtownards Road, Belfast, BT4. <br><span class="opening">Opens at 17:00.</span> Minimum order: $15
							</div>
							<ul>
								<li>Take away<i class="icon_check_alt2 ok"></i></li>
								<li>Delivery<i class="icon_check_alt2 ok"></i></li>
							</ul>
						</div>
                    </a><!-- End strip_list-->
                </div><!-- End col-md-6-->                
            </div><!-- End row-->
            
            <div class="row">
            	<div class="col-md-6 col-sm-6 wow zoomIn" data-wow-delay="0.3s">
                	<a class="strip_list grid" href="detail_page.html">
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
								135 Newtownards Road, Belfast, BT4. <br><span class="opening">Opens at 17:00.</span> Minimum order: $15
							</div>
							<ul>
								<li>Take away<i class="icon_check_alt2 ok"></i></li>
								<li>Delivery<i class="icon_check_alt2 ok"></i></li>
							</ul>
						</div>
                    </a><!-- End strip_list-->
                </div><!-- End col-md-6-->
                <div class="col-md-6 col-sm-6 wow zoomIn" data-wow-delay="0.4s">
                	<a class="strip_list grid" href="detail_page.html">
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
								135 Newtownards Road, Belfast, BT4. <br><span class="opening">Opens at 17:00.</span> Minimum order: $15
							</div>
							<ul>
								<li>Take away<i class="icon_check_alt2 ok"></i></li>
								<li>Delivery<i class="icon_check_alt2 ok"></i></li>
							</ul>
						</div>
                    </a><!-- End strip_list-->
                </div><!-- End col-md-6-->                
            </div><!-- End row-->
            
            <div class="row">
            	<div class="col-md-6 col-sm-6 wow zoomIn" data-wow-delay="0.5s">
                	<a class="strip_list grid" href="detail_page.html">
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
								135 Newtownards Road, Belfast, BT4. <br><span class="opening">Opens at 17:00.</span> Minimum order: $15
							</div>
							<ul>
								<li>Take away<i class="icon_check_alt2 ok"></i></li>
								<li>Delivery<i class="icon_check_alt2 ok"></i></li>
							</ul>
						</div>
                    </a><!-- End strip_list-->
                </div><!-- End col-md-6-->
                <div class="col-md-6 col-sm-6 wow zoomIn" data-wow-delay="0.6s">
                	<a class="strip_list grid" href="detail_page.html">
                    	<div class="desc">
							<div class="thumb_strip">
								<img src="img/thumb_restaurant_6.jpg" alt="">
							</div>
							<div class="rating">
								<i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
							</div>
							<h3>China Food</h3>
							<div class="type">
								Chinese / Vietnam
							</div>
							<div class="location">
								135 Newtownards Road, Belfast, BT4. <br><span class="opening">Opens at 17:00.</span> Minimum order: $15
							</div>
							<ul>
								<li>Take away<i class="icon_check_alt2 ok"></i></li>
								<li>Delivery<i class="icon_check_alt2 ok"></i></li>
							</ul>
						</div>
                    </a><!-- End strip_list-->
                </div><!-- End col-md-6-->                
            </div><!-- End row-->
            <a href="#0" class="load_more_bt wow fadeIn" data-wow-delay="0.2s">Load more...</a>
            ${searchResults}
		</div><!-- End col-md-9-->
        
	</div><!-- End row -->
</div><!-- End container -->
<!-- End Content =============================================== -->

<!-- Footer =============================================== -->
<jsp:include page="include/footer.jsp" flush="false"/>
<!-- Footer =============================================== -->

<!-- SPECIFIC SCRIPTS -->
<script  src="js/cat_nav_mobile.js"></script>
<script>$('#cat_nav').mobileMenu();</script>
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script src="js/map.js"></script>
<script src="js/infobox.js"></script>
<script src="js/ion.rangeSlider.js"></script>
<script>
    $(function () {
		 'use strict';
        $("#range").ionRangeSlider({
            hide_min_max: true,
            keyboard: true,
            min: 0,
            max: 15,
            from: 0,
            to:5,
            type: 'double',
            step: 1,
            prefix: "Km ",
            grid: true
        });
    });
</script>
	
<script src="/customer/resources/js/menu/menu-functions.js"></script>

<script>
	$(document).ready(function() {

	}
</script>
</body>
</html>