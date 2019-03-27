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
	<jsp:include page="../include/header.jsp" flush="false" />
	<!-- 주문 헤더 -->
	<jsp:include page="../include/header_order.jsp" flush="false" />

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
						Delivery time <i class="icon_quotations pull-left"></i>
					</h4>
					<p>Lorem ipsum dolor sit amet, in pri partem essent. Qui
						debitis meliore ex, tollit debitis conclusionemque te eos.</p>
					<hr>
					<h4>
						Secure payment <i class="icon_creditcard pull-left"></i>
					</h4>
					<p>Lorem ipsum dolor sit amet, in pri partem essent. Qui
						debitis meliore ex, tollit debitis conclusionemque te eos.</p>
				</div>
				<!-- End box_style_2 -->

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
				<div class="box_style_2">
					<h2 class="inner">Payment methods</h2>
					<div class="payment_select">
						<label><input type="radio" value="" checked
							name="payment_method" class="icheck">Credit card</label> <i
							class="icon_creditcard"></i>
					</div>
					<div class="form-group">
						<label>Name on card</label> <input type="text"
							class="form-control" id="name_card_order" name="name_card_order"
							placeholder="First and last name">
					</div>
					<div class="form-group">
						<label>Card number</label> <input type="text" id="card_number"
							name="card_number" class="form-control" placeholder="Card number">
					</div>
					<div class="row">
						<div class="col-md-6">
							<label>Expiration date</label>
							<div class="row">
								<div class="col-md-6 col-sm-6">
									<div class="form-group">
										<input type="text" id="expire_month" name="expire_month"
											class="form-control" placeholder="mm">
									</div>
								</div>
								<div class="col-md-6 col-sm-6">
									<div class="form-group">
										<input type="text" id="expire_year" name="expire_year"
											class="form-control" placeholder="yyyy">
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 col-sm-12">
							<div class="form-group">
								<label>Security code</label>
								<div class="row">
									<div class="col-md-4 col-sm-6">
										<div class="form-group">
											<input type="text" id="ccv" name="ccv" class="form-control"
												placeholder="CCV">
										</div>
									</div>
									<div class="col-md-8 col-sm-6">
										<img src="/customer/resources/img/icon_ccv.gif" width="50" height="29" alt="ccv"><small>Last
											3 digits</small>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--End row -->
					<div class="payment_select" id="paypal">
						<label><input type="radio" value="" name="payment_method"
							class="icheck">Pay with paypal</label>
					</div>
					<div class="payment_select nomargin">
						<label><input type="radio" value="" name="payment_method"
							class="icheck">Pay with cash</label> <i class="icon_wallet"></i>
					</div>
				</div>
				<!-- End box_style_1 -->
			</div>
			<!-- End col-md-6 -->

			<div class="col-md-3" id="sidebar">
				<div class="theiaStickySidebar">
					<div id="cart_box">
						<h3>
							Your order <i class="icon_cart_alt pull-left"></i>
						</h3>
						<table class="table table_summary">
							<tbody>
								<tr>
									<td><a href="#0" class="remove_item"><i
											class="icon_minus_alt"></i></a> <strong>1x</strong> Enchiladas</td>
									<td><strong class="pull-left">$11</strong></td>
								</tr>
								<tr>
									<td><a href="#0" class="remove_item"><i
											class="icon_minus_alt"></i></a> <strong>2x</strong> Burrito</td>
									<td><strong class="pull-left">$14</strong></td>
								</tr>
								<tr>
									<td><a href="#0" class="remove_item"><i
											class="icon_minus_alt"></i></a> <strong>1x</strong> Chicken</td>
									<td><strong class="pull-left">$20</strong></td>
								</tr>
								<tr>
									<td><a href="#0" class="remove_item"><i
											class="icon_minus_alt"></i></a> <strong>2x</strong> Corona Beer</td>
									<td><strong class="pull-left">$9</strong></td>
								</tr>
								<tr>
									<td><a href="#0" class="remove_item"><i
											class="icon_minus_alt"></i></a> <strong>2x</strong> Cheese Cake</td>
									<td><strong class="pull-left">$12</strong></td>
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
									<td>Subtotal <span class="pull-left">$56</span>
									</td>
								</tr>
								<tr>
									<td>Delivery fee <span class="pull-left">$10</span>
									</td>
								</tr>
								<tr>
									<td class="total">TOTAL <span class="pull-left">$66</span>
									</td>
								</tr>
							</tbody>
						</table>
						<hr>
						<a class="btn_full" href="confirm">Confirm your order</a>
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
	<jsp:include page="../include/footer.jsp" flush="false" />
	<!-- Footer 끝  -->
</body>
</html>