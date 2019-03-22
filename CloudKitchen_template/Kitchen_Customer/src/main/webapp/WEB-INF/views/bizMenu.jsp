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
<!-- SubHeader =============================================== -->
	<section class="parallax-window" data-parallax="scroll" data-image-src="/customer/resources/img/sub_header_2.jpg" data-natural-width="1400" data-natural-height="470">
		<div id="subheader">
		<div id="sub_content">
			<div id="thumb"><img src="/customer/resources/img/thumb_restaurant.jpg" alt=""></div>
	                     <div class="rating"><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i> (<small><a href="detail_page_2.html">Read 98 reviews</a></small>)</div>
	                    <h1>${bizMember.bizName}</h1>
	                    <div><strong>최소 주문 금액:</strong> ${bizMember.bizMinAmt}.</div>
	    </div><!-- End sub_content -->
	</div><!-- End subheader -->
	</section><!-- End section -->
<!-- End SubHeader ============================================ -->
	
<!-- Position ============================================ -->
	<div id="position">
		<div class="container">
			<ul>
				<li><a href="#0">Home</a></li>
				<li><a href="#0">Category</a></li>
				<li>Page active</li>
			</ul>
			<a href="#0" class="search-overlay-menu-btn"><i
				class="icon-search-6"></i> Search</a>
		</div>
	</div>
<!-- End Position ============================================ -->

<!-- Content ================================================== -->
	<div class="container margin_60_35">
		<div class="row">
			<div class="col-md-3">
				<p>
					<a href="list_page.html" class="btn_side">Back to search</a>
				</p>
				<div class="box_style_1">
					<ul id="cat_nav">
						<li><a href="#starters" class="active">Starters <span>(141)</span></a></li>
						<li><a href="#main_courses">Main Courses <span>(20)</span></a></li>
						<li><a href="#beef">Beef <span>(12)</span></a></li>
						<li><a href="#desserts">Desserts <span>(11)</span></a></li>
						<li><a href="#drinks">Drinks <span>(20)</span></a></li>
					</ul>
				</div> <!-- End box_style_1 -->
				<div class="box_style_2 hidden-xs" id="help">
					<i class="icon_lifesaver"></i>
					<h4>
						Need <span>Help?</span>
					</h4>
					<a href="tel://004542344599" class="phone">+45 423 445 99</a> <small>Monday
						to Friday 9.00am - 7.30pm</small>
				</div>
			</div> <!-- End col-md-3 -->

			<div class="col-md-6">
				<div class="box_style_2" id="main_menu">
					<h2 class="inner">Menu</h2>
					
					<c:forEach var="menu" items="${bizMember.bizMenuCatVo}">
						<h3 class="nomargin_top" id="starters">${menu.mcName}</h3>
						<table class="table table-striped cart-list">
							<thead>
								<tr>
									<th>메뉴</th>
									<th>가격</th>
									<th>추가</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="dish" items="${menu.mcMenuVo}" varStatus="loop">
									<tr>
										<td>
											<figure class="thumb_menu_list">
												<img src="/customer/resources/img/menu-thumb-1.jpg"	alt="thumb">
											</figure>
											<h5>${loop.index+1}. ${dish.mname}</h5>
										</td>
										<td><strong>${dish.mbasicPrice} 원</strong></td>
										<td class="options">
											<div class="dropdown dropdown-options">
												<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
												<div class="dropdown-menu">
													<c:forEach var="extras" items="${dish.menuOptCl}">
														<div>
															<h5>${extras.mocName}</h5>
															<c:if test="${extras.mocMenuOptType == 'OPT001'}">
																<c:forEach var="option" items="${extras.menuOptEx}">
																	<label> <input type="radio" value="option1" name="${extras.menuOptEx}" required="required">${option.moName} <span>+ ${option.moAddPrice} 원</span> </label>
																</c:forEach>
															</c:if>
															<c:if test="${extras.mocMenuOptType == 'OPT002'}">
																<c:forEach var="option" items="${extras.menuOptEx}">
																	<label> <input type="checkbox" value="option1" name="${extras.menuOptEx}" required="required">${option.moName} <span>+ ${option.moAddPrice} 원</span> </label>
																</c:forEach>
															</c:if>
															<c:if test="${extras.mocMenuOptType == 'OPT003'}">
																<c:forEach var="option" items="${extras.menuOptEx}">
																	<label> <input type="radio" value="option1" name="${extras.menuOptEx}">${option.moName} <span>+ ${option.moAddPrice} 원</span> </label>
																</c:forEach>
															</c:if>
															<c:if test="${extras.mocMenuOptType == 'OPT004'}">
																<c:forEach var="option" items="${extras.menuOptEx}">
																	<label> <input type="checkbox" value="option1" name="${extras.menuOptEx}">${option.moName} <span>+ ${option.moAddPrice} 원</span> </label>
																</c:forEach>
															</c:if>														
														</div>
													</c:forEach>
													<a href="#0" class="add_to_basket">Add to cart</a>													
												</div>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<hr>
					</c:forEach>
				</div> <!-- End box_style_2 -->
			</div> <!-- End col-md-6 -->

			<div class="col-md-3" id="sidebar">
				<div class="theiaStickySidebar">
					<div id="cart_box">
						<h3>
							Your order <i class="icon_cart_alt pull-right"></i>
						</h3>
						<table class="table table_summary">
							<tbody>
								<tr>
									<td><a href="#0" class="remove_item"><i
											class="icon_minus_alt"></i></a> <strong>1x</strong> Enchiladas</td>
									<td><strong class="pull-right">$11</strong></td>
								</tr>
								<tr>
									<td><a href="#0" class="remove_item"><i
											class="icon_minus_alt"></i></a> <strong>2x</strong> Burrito</td>
									<td><strong class="pull-right">$14</strong></td>
								</tr>
								<tr>
									<td><a href="#0" class="remove_item"><i
											class="icon_minus_alt"></i></a> <strong>1x</strong> Chicken</td>
									<td><strong class="pull-right">$20</strong></td>
								</tr>
								<tr>
									<td><a href="#0" class="remove_item"><i
											class="icon_minus_alt"></i></a> <strong>2x</strong> Corona Beer</td>
									<td><strong class="pull-right">$9</strong></td>
								</tr>
								<tr>
									<td><a href="#0" class="remove_item"><i
											class="icon_minus_alt"></i></a> <strong>2x</strong> Cheese Cake</td>
									<td><strong class="pull-right">$12</strong></td>
								</tr>
							</tbody>
						</table>
						<hr>
						<div class="row" id="options_2">
							<div class="col-lg-6 col-md-12 col-sm-12 col-xs-6">
								<label><input type="radio" value="" checked
									name="option_2" class="icheck">Delivery</label>
							</div>
							<div class="col-lg-6 col-md-12 col-sm-12 col-xs-6">
								<label><input type="radio" value="" name="option_2"
									class="icheck">Take Away</label>
							</div>
						</div>
						<!-- Edn options 2 -->

						<hr>
						<table class="table table_summary">
							<tbody>
								<tr>
									<td>Subtotal <span class="pull-right">$56</span>
									</td>
								</tr>
								<tr>
									<td>Delivery fee <span class="pull-right">$10</span>
									</td>
								</tr>
								<tr>
									<td class="total">TOTAL <span class="pull-right">$66</span>
									</td>
								</tr>
							</tbody>
						</table>
						<hr>
						<a class="btn_full" href="cart.html">Order now</a>
					</div>
					<!-- End cart_box -->
				</div>
				<!-- End theiaStickySidebar -->
			</div>
			<!-- End col-md-3 -->

		</div>
		<!-- End row -->
	</div> <!-- End container -->
<!-- End Content =============================================== -->

<div class="layer"></div>
<!-- Mobile menu overlay mask -->

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

<!-- Footer =============================================== -->
<jsp:include page="include/footer.jsp" flush="false"/>
<!-- Footer =============================================== -->

<!-- SPECIFIC SCRIPTS ============================================ -->
	<script src="/customer/resources/js/cat_nav_mobile.js"></script>
	<script>
		$('#cat_nav').mobileMenu();
	</script>
	<script src="/customer/resources/js/ResizeSensor.min.js"></script>
	<script src="/customer/resources/js/theia-sticky-sidebar.min.js"></script>
	<script>
		jQuery('#sidebar').theiaStickySidebar({
			additionalMarginTop : 80
		});
	</script>
<!-- SMOOTH SCROLL ============================================ -->
	<script>
		$('#cat_nav a[href^="#"]').click(
				function() {
					if (location.pathname.replace(/^\//, '') == this.pathname
							.replace(/^\//, '')
							|| location.hostname == this.hostname) {
						var target = $(this.hash);
						target = target.length ? target : $('[name='
								+ this.hash.slice(1) + ']');
						if (target.length) {
							$('html,body').animate({
								scrollTop : target.offset().top - 75
							}, 800);
							return false;
						}
					}
				});

		$(document).ready(function() {
			console.log('${bizMember}');
		});
	</script>

	<c:if test="${not empty message}">
		<script>
			$(document).ready(function() {
				alert('${message}');
			});
		</script>
	</c:if>
</body>
</html>