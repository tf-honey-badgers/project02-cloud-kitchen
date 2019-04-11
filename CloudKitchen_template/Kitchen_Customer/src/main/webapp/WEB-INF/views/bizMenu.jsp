<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>${bizMember.bizName}</title>
</head>
<body>
<!-- Header =============================================== -->
	<jsp:include page="include/header.jsp" flush="false" />
<!-- End Header =============================================== -->
<!-- SubHeader & Position =============================================== -->
	<jsp:include page="include/menu_subheader.jsp" flush="false" />
<!-- End SubHeader & Position =============================================== -->

<!-- Content ================================================== -->
	<input type="hidden" value="${bizMember.bizName}" id="bizId">
	<div class="container margin_60_35">
		<div class="row">
			<div class="sidebar col-md-2">
				<div class="theiaStickySidebar">
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
						<h4>도움이</h4>
						<h4>필요하세요?</h4>
						<a href="tel://01012349876" class="phone"><span style="font-size:15px;">010-1234-9876</span></a> <small>1년 365일 오전 9시부터 오후 6시까지!</small>
					</div>
				</div>
			</div> <!-- End col-md-2 -->

			<div class="col-md-6">
				<!-- 1. The <iframe> (and video player) will replace this <div> tag. -->
    			<div style="height:360px;">
					<iframe width="560" height="315" src="https://www.youtube.com/embed/${bizMember.bizLiveStrm}?controls=0&showinfo=0&rel=0&autoplay=1&loop=1&playlist=${bizMember.bizLiveStrm}&mute=1" frameborder="0" allowfullscreen data-autoplay data-keepplaying></iframe>
    			</div>
				<div class="box_style_2" id="main_menu" data-biz-id="${bizMember.bizId}" data-biz-name="${bizMember.bizName}" data-kb-id="${bizMember.bizKitchenId}" data-kb-name="${bizMember.bizKitchenName}">
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
												<img class="foodIMG" src="https://s3.ap-northeast-2.amazonaws.com/honeybadgersfile/MenuPhoto/${dish.mcode}.png"	alt="thumb">
											</figure>
											<h5 style="padding-top: 10px; width: 220px !important;" data-id="${dish.mcode}">${loop.index+1}. ${dish.mname}</h5>
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
			<div class="sidebar col-md-4">
				<div class="theiaStickySidebar">
					<form action="${pageContext.request.contextPath}/order/orderinfo" method="post">
						<div id="cart_box">
							<h3>Your order <i class="icon_cart_alt pull-right"></i></h3>
							<c:set var="cid" value="${sessionScope.uid}"></c:set>
							<c:if test="${cid == null}">
								<input type="button" class="btn_full" id="loginNow" value="사용하려면 로그인해주세요." data-toggle="modal" data-target="#login_2">
							</c:if>
							<c:if test="${cid != null}">
								<table class="table table_summary">
									<thead>
										<tr>
											<th style="width: 10%;"><input type="checkbox"></th>
											<th style="width: 90%;">전체선택<a class="btn_intro pull-right" id="deleteCart" >삭제하기</a></th>
										</tr>
									</thead>
									<tbody class="cartTable">
									<!-- bizName이 다를 때 가게 이름을 출력하기 위한 반복문 -->
										<!-- 카트 메뉴를 출력하기 위한 반복문  -->
										<c:forEach var="cart" items="${cart}">
											<tr class="bizNameRow">
												<td colspan="3"><strong>${cart.bizName}</strong></td>
											</tr>
											<tr>
												<td style="width: 10%;"><input class="check-order" type="checkbox" name="selectedCart" value="${cart.id}"></td>
												<td class="menuData" data-cart-id="${cart.id}"><strong>${cart.quantity}x</strong> ${cart.menuName}<span class="pull-right">${cart.unitPrice}원</span></td>
											</tr>
											<!-- 옵션을 출력하기 위한 반복문 -->
											<c:forEach var="options" items="${cart.options}">									
												<tr>
													<td style="width: 10%;"></td>
													<td style="font-size: 11px;">${options.menuOptName} <span class="pull-right">+ ${options.menuOptPrice}원</span></td>
													<td style="width: 10%;"></td>
												</tr>
											</c:forEach>
											<tr class="priceRow">
												<td colspan="2" class="priceData" data-total-price="${cart.totalAmt}"><strong class="pull-right">합계&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${cart.totalAmt}원</strong></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<hr>
								<table class="table table_summary">
									<tbody>
										<tr>
											<td class="total">총 금액 <span class="pull-right" data-total=""></span></td>
										</tr>
									</tbody>
								</table>
								<hr>
								<input type="submit" class="btn_full" id="orderNow" value="Order now">
							</c:if>
						</div> <!-- End cart_box -->
					</form>
				</div> <!-- End theiaStickySidebar -->
			</div> <!-- End col-md-4 -->
		</div> <!-- End row -->
	</div> <!-- End container -->
<!-- End Content =============================================== -->

<!-- Footer =============================================== -->
<jsp:include page="include/footer.jsp" flush="false"/>
<!-- Footer =============================================== -->

<!-- SPECIFIC SCRIPTS ============================================ -->
	<script src="${pageContext.request.contextPath}/resources/js/cat_nav_mobile.js"></script>
	<script>$('#cat_nav').mobileMenu();</script>
	<script src="${pageContext.request.contextPath}/resources/js/ResizeSensor.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/theia-sticky-sidebar.min.js"></script>
	<script>
		jQuery('.sidebar').theiaStickySidebar({ // 중요!! class="sidebar" 안에 class="theiaStickySidebar" 위치해야 한다!!
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
		
		/* 회원ID 변수에 저장 (외부 JS 파일에서 EL 안먹히기 때문에 여기 위치) */
		const custId = '${sessionScope.uid}';
	</script>
	
	<script src="${pageContext.request.contextPath}/resources/js/menu/menu-functions.js"></script>
</body>
</html>