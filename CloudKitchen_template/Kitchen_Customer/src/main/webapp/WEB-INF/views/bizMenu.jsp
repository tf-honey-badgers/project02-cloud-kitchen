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
	                    <div><strong>최소 주문 금액:</strong> ${bizMember.bizMinAmt}원</div>
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
						<c:forEach var="menu" items="${bizMember.bizMenuCatVo}" varStatus="loop">
							<li><a href="#${loop.index + 100}">${menu.mcName} <span>(141)</span></a></li>
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
			</div> <!-- End col-md-3 -->

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
															<h5>${extras.mocName}</h5>
															<c:if test="${extras.mocMenuOptType == 'OPT001'}">
																<c:forEach var="option" items="${extras.menuOptEx}">
																	<label> <input type="radio" data-name="${option.moName}" data-id="${option.moCode}" name="${extras.mocName}" required>${option.moName} <span data-price="${option.moAddPrice}">+ ${option.moAddPrice} 원</span> </label>
																</c:forEach>
															</c:if>
															<c:if test="${extras.mocMenuOptType == 'OPT002'}">
																<c:forEach var="option" items="${extras.menuOptEx}">
																	<label> <input type="checkbox" data-name="${option.moName}" data-id="${option.moCode}" name="${extras.mocName}" required>${option.moName} <span data-price="${option.moAddPrice}">+ ${option.moAddPrice} 원</span> </label>
																</c:forEach>
															</c:if>
															<c:if test="${extras.mocMenuOptType == 'OPT003'}">
																<c:forEach var="option" items="${extras.menuOptEx}">
																	<label> <input type="radio" data-name="${option.moName}" data-id="${option.moCode}" name="${extras.mocName}">${option.moName} <span data-price="${option.moAddPrice}">+ ${option.moAddPrice} 원</span> </label>
																</c:forEach>
															</c:if>
															<c:if test="${extras.mocMenuOptType == 'OPT004'}">
																<c:forEach var="option" items="${extras.menuOptEx}">
																	<label> <input type="checkbox" data-name="${option.moName}" data-id="${option.moCode}" name="${extras.mocName}">${option.moName} <span data-price="${option.moAddPrice}">+ ${option.moAddPrice} 원</span> </label>
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
							<thead>
								<tr>
									<th style="width: 15px;"><input type="checkbox"></th>
									<th style="width: 80px;">전체선택</th>
									<th style="text-align: right" colspan="2"><input type="checkbox"></th>
								</tr>							
							</thead>
							<tbody>
								<tr>
									<td style="width: 15px;"><input type="checkbox"></td>
									<td>
									<strong>1x</strong> Enchiladas<strong class="pull-right">$11</strong>
									</td>
									<td style="width: 15px;"><input type="checkbox" class="pull-right"></td>
								</tr>
								<tr>
									<td style="width: 15px;"><input type="checkbox"></td>
									<td>
									<strong>2x</strong> Burrito<strong class="pull-right">$14</strong>
									</td>
									<td style="width: 15px;"><input type="checkbox" class="pull-right"></td>
								</tr>
								<tr>
									<td style="width: 15px"><input type="checkbox"></td>
									<td>
									<strong>1x</strong> Chicken<strong class="pull-right">$20</strong>
									</td>
									<td style="width: 15px;"><input type="checkbox" class="pull-right"></td>
								</tr>
							</tbody>
						</table>

						<hr>
						<table class="table table_summary">
							<tbody>
								<tr>
									<td>Subtotal <span class="pull-right">$56</span>
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
			/* 옵션이 없는 메뉴는 "+" 클릭하면 장바구니에 추가하도록 */
			for(var i = 0; i < $('.dropdown-menu').size(); i++) {
				if($('.dropdown-menu').eq(i).children('div').length == 0) {
					// 옵션이 없으니까 옵션용 팝업을 보여주는 대신 곧바로 카트에 추가할 수 있다 (옵션용 팝업 속 "Add to cart" 버튼과 똑같다)
					$('.dropdown-menu').eq(i).siblings('a').removeClass('dropdown-toggle').addClass('add_to_basket').removeAttr('data-toggle');
				}
			}
			
			/* "Add to cart" 버튼을 클릭하면 선택한 메뉴와 옵션 정보와 가격을 장바구니에 추가하고 Rest도메인을 호출하여 DB에 입력하도록 */
			$('.add_to_basket').on('click', function(event) {
				event.preventDefault();
			/* 선택한 메뉴의 ID */
				const menuId = $(this).parents('td').siblings('td:eq(0)').children('h5').attr('data-id');
			/* 선택한 메뉴의 가격 (옵션 제외) */
				const menuPrice = $(this).parents('td').siblings('td:eq(1)').attr('data-price');
			/* 선택한 옵션들 (input tag) */
				const checkedOptions = $(this).siblings('div').children().children('input:checked');
			/* 선택한 옵션을 담을 배열 */
				let optArr = [];
			/* 메뉴와 옵션의 가격 총 합 */
				let totalPrice = 0;
				
			/* 선택한 각 옵션의 가격을 optArr 배열에 담는다 */
				$.each(checkedOptions, function(index, item) {
					optArr.push(checkedOptions.eq(index).siblings('span').attr('data-price'));
				})
			
			/* 메뉴 가격과 각 옵션의 가격을 더해서 가격 총 합을 구한다 */
				totalPrice += parseInt(menuPrice);
				$.each(optArr, function(index, item) {
					totalPrice += parseInt(item);
				})
				console.log(totalPrice);
				console.log($(this).siblings('div').children().children('input:checked').length);

			/* 선택한 옵션의 개수를 cur변수의 값으로 삼는다. */
				let cur = $(this).siblings('div').children().children('input:checked').length; // 브라우저 콘솔에서 작업용 : $('.add_to_basket').eq(0).siblings('div').children().children('input:checked')
			/* 옵션 정보를 담을 배열 (List<CartDetailVO>에 매핑) */
				let inputOptions = [];
				for(let i = 0; i < cur; i++) {
					id = menuId;
					optName = $(this).siblings('div').children().children('input:checked').eq(i).attr('data-name');
					optId = $(this).siblings('div').children().children('input:checked').eq(i).attr('data-id');
					optPrice = $(this).siblings('div').children().children('input:checked').eq(i).siblings('span').attr('data-price');
					
					inputOptions.push({ menuOptId : optId, menuId : id, menuOptName : optName, menuOptPrice : optPrice });
				}

				// 비동기 요청하면 CartVOExtended에 매핑되도록
				var inputData = {
						custId : 'tjtjtj'
						, quantity : 1
						, unitPrice : menuPrice
						, totalAmt : totalPrice
						, kitchenName : '예테버리'
						, bizName : 'biz_2'
						, menuId : menuId
						, options : inputOptions
					};
				console.log("INPUTDATA = 제대로 입력되었는지 확인하기 : ", inputData)
				
				// CartController로 비동기 요청하기
 				$.ajax({
					type : 'POST'
					, url : 'http://localhost:12004/customer/kitchen/cart/add'
					, dataType : 'json'
					, contentType : 'application/json'
					, data : JSON.stringify(inputData)
		    		, success : function(data) {
		    			console.log("AAA");
						console.log(data);
					}
					, error : function(data) {
						console.log("ZZZ");
						console.log('ERRoR oCCURRED');
						console.log(data);
					}
				});
			});
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