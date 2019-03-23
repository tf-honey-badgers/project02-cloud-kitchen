<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>payment Temp</title>
</head>
<body>
	<!--헤더 -->
	<!-- 위쪽 헤더바  -->
	<jsp:include page="include/header.jsp" flush="false" />
	<!-- 주문 헤더 -->
	<jsp:include page="include/header_order.jsp" flush="false" />

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
	<!-- Position -->

	<!-- Content ================================================== -->
	<div class="container margin_60_35">
		<div class="row">
			<div class="col-md-3">

				<div class="box_style_2 hidden-xs info">
					<h4 class="nomargin_top">
						Delivery time <i class="icon_clock_alt pull-right"></i>
					</h4>
					<p>Lorem ipsum dolor sit amet, in pri partem essent. Qui
						debitis meliore ex, tollit debitis conclusionemque te eos.</p>
					<hr>
					<h4>
						Secure payment <i class="icon_creditcard pull-right"></i>
					</h4>
					<p>Lorem ipsum dolor sit amet, in pri partem essent. Qui
						debitis meliore ex, tollit debitis conclusionemque te eos.</p>
				</div>
				<!-- End box_style_1 -->

				<div class="box_style_2 hidden-xs" id="help">
					<i class="icon_lifesaver"></i>
					<h4>
						Need <span>Help?</span>
					</h4>
					<a href="tel://004542344599" class="phone">+45 423 445 99</a> <small>Monday
						to Friday 9.00am - 7.30pm</small>
				</div>

			</div>
			<!-- End col-md-3 -->

			<div class="col-md-6">
				<div class="box_style_2" id="order_process">
					<h2 class="inner">주문 정보 입력</h2>
					<div class="form-group">
						<label>이름</label> <input type="text" class="form-control"
							id="firstname_order" name="firstname_order" placeholder="이름">
					</div>

					<div class="form-group">
						<label>연락 받을 번호</label> <span>(회원 번호와 동일)</span> <input
							type="checkbox" id="defaultPhone" class="icheck"> <input type="text" id="phone"
							name="phone" class="form-control" placeholder="연락 받을 번호">
					</div>
					<div class="form-group">
						<label>배달 주소</label> <span>(회원 주소와 동일)</span> <input
							type="checkbox" id="defaultAddress" class="icheck"> <input type="text"
							id="address" name="address" class="form-control"
							placeholder="배달 주소">
					</div>
					<hr>
					<div class="row">
						<div class="col-md-12">

							<label>주문 요청 사항</label>
							<textarea class="form-control" style="height: 150px"
								placeholder="주문 요청 사항" name="notes" id="notes"></textarea>

						</div>
					</div>
				</div>
				<!-- End box_style_1 -->
			</div>
			<!-- End col-md-6 -->

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
						<a class="btn_full" href="payment">Go to Payment</a> <a
							class="btn_full_outline" href="detail_page.html"><i
							class="icon-right"></i> Add other items</a>
					</div>
					<!-- End cart_box -->
				</div>
				<!-- End theiaStickySidebar -->
			</div>
			<!-- End col-md-3 -->

		</div>
		<!-- End row -->
	</div>
	<!-- End container -->
	<!-- End Content =============================================== -->

	<!-- Footer 시작  -->
	<jsp:include page="include/footer.jsp" flush="false" />
	<!-- Footer 끝  -->
	
	<!-- Script 시작 -->
	<script>
		$(document).ready(function(){
			/* 회원 번호 사용 */
			defaultPhoneInit();
			/* 회원 주소 사용 */
			defaultAddressInit();
		})
		
		function defaultPhoneInit(){
			$('#defaultPhone').siblings().click(function(){
				if($(this).parent().hasClass('checked')){
					$('#phone').val('${phone}');
					return;
				}
				$('#phone').val('');
			})
		}
		
		function defaultAddressInit(){
			$('#defaultAddress').siblings().click(function(){
				if($(this).parent().hasClass('checked')){
					$('#address').val('${address}');
					return;
				}
				$('#address').val('');
			})
		}
	</script>
	<!-- Script 끝 -->
</body>
</html>