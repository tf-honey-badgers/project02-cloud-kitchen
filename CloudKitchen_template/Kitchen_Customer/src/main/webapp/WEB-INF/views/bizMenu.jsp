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
	<jsp:include page="include/menu_subheader.jsp" flush="false" />
<!-- End SubHeader & Position =============================================== -->

<!-- Content ================================================== -->
	<div class="container margin_60_35">
		<div class="row">
			<div class="col-md-2">
				<p>
					<a href="javascript:history.back()" class="btn_side">Back to search</a>
				</p>
				<div class="box_style_1">
					<ul id="cat_nav">
						<c:forEach var="menu" items="${bizMember.bizMenuCatVo}" varStatus="loop">
							<li><a href="#${loop.index + 100}">${menu.mcName}</a></li>
						</c:forEach>
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
			</div> <!-- End col-md-2 -->

			<div class="col-md-6">
				<div class="box_style_2" id="main_menu">
					<h2 class="inner">Menu</h2>
					<c:forEach var="menu" items="${bizMember.bizMenuCatVo}" varStatus="loop">
						<h3 class="nomargin_top" id="${loop.index + 100}">${menu.mcName}</h3>
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
											<h5 style="padding-top: 10px;" data-id="${dish.mcode}">${loop.index+1}. ${dish.mname}</h5>
										</td>
										<td data-price="${dish.mbasicPrice}"><strong>${dish.mbasicPrice} 원</strong></td>
										<td class="options">
											<div class="dropdown dropdown-options">
												<a href="#" id="addCart" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
												<div class="dropdown-menu">
													<c:forEach var="extras" items="${dish.menuOptCl}">
														<div>
															<c:if test="${extras.mocMenuOptType == 'OPT001'}">
																<h5>${extras.mocName} (필수 선택)</h5>
																<c:forEach var="option" items="${extras.menuOptEx}">
																	<label> <input type="radio" data-required="yes" data-name="${option.moName}" data-id="${option.moCode}" name="${extras.mocName}">${option.moName} <span data-price="${option.moAddPrice}">+ ${option.moAddPrice} 원</span> </label>
																</c:forEach>
															</c:if>
															<c:if test="${extras.mocMenuOptType == 'OPT002'}">
																<h5>${extras.mocName} (필수 선택)</h5>
																<c:forEach var="option" items="${extras.menuOptEx}">
																	<label> <input type="checkbox" data-required="yes" data-name="${option.moName}" data-id="${option.moCode}" name="${extras.mocName}">${option.moName} <span data-price="${option.moAddPrice}">+ ${option.moAddPrice} 원</span> </label>
																</c:forEach>
															</c:if>
															<c:if test="${extras.mocMenuOptType == 'OPT003'}">
																<h5>${extras.mocName}</h5>
																<c:forEach var="option" items="${extras.menuOptEx}">
																	<label> <input type="radio" data-required="no" data-name="${option.moName}" data-id="${option.moCode}" name="${extras.mocName}">${option.moName} <span data-price="${option.moAddPrice}">+ ${option.moAddPrice} 원</span> </label>
																</c:forEach>
															</c:if>
															<c:if test="${extras.mocMenuOptType == 'OPT004'}">
																<h5>${extras.mocName}</h5>
																<c:forEach var="option" items="${extras.menuOptEx}">
																	<label> <input type="checkbox" data-required="no" data-name="${option.moName}" data-id="${option.moCode}" name="${extras.mocName}">${option.moName} <span data-price="${option.moAddPrice}">+ ${option.moAddPrice} 원</span> </label>
																</c:forEach>
															</c:if>														
														</div>
													</c:forEach>
													<a class="add_to_basket">Add to cart</a>													
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

			<div class="col-md-4" id="sidebar">
				<div class="theiaStickySidebar">
					<div id="cart_box">
						<h3>
							Your order <i class="icon_cart_alt pull-right"></i>
						</h3>
						<table class="table table_summary">
							<thead>
								<tr>
									<th style="width: 10%;"><input type="checkbox"></th>
									<th style="width: 80px;">
										전체선택
										<a class="btn_intro pull-right" id="deleteCart" >삭제하기</a>
									</th>
									<th style="text-align: right; width: 10%;" colspan="2"><input type="checkbox"></th>
								</tr>							
							</thead>
							<tbody class="cartTable">
								<c:forEach var="cart" items="${cart}">
									<tr>
										<td style="width: 10%;"><input class="check-order" type="checkbox"></td>
										<td class="menuData" data-cart-id="${cart.id}"><strong>${cart.quantity}x</strong> ${cart.name}<strong class="pull-right">${cart.totalAmt}원</strong></td>
										<td style="text-align: right; width: 10%;"><input class="check-delete" type="checkbox"></td>
									</tr>
									<c:forEach var="options" items="${cart.options}">									
										<tr>
											<td style="width: 10%;"></td>
											<td style="font-size: 12px;">${options.menuOptName}</td>
											<td style="width: 10%;"></td>
										</tr>
									</c:forEach>
								</c:forEach>
							</tbody>
						</table>
						<hr>
						<table class="table table_summary">
							<tbody>
								<tr>
									<td class="total">총 금액 <span class="pull-right"></span>
									</td>
								</tr>
							</tbody>
						</table>
						<hr>
						<a href="${pageContext.request.contextPath}/order/orderinfo" class="btn_full" id="orderNow">Order now</a>
					</div> <!-- End cart_box -->
				</div> <!-- End theiaStickySidebar -->
			</div> <!-- End col-md-4 -->
		</div> <!-- End row -->
	</div> <!-- End container -->
<!-- End Content =============================================== -->

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
	</script>
	
	<script src="/customer/resources/js/menu/menu-functions.js"></script>

	<c:if test="${not empty message}">
		<script>
			$(document).ready(function() {
				alert('${message}');
			});
		</script>
	</c:if>
</body>
</html>