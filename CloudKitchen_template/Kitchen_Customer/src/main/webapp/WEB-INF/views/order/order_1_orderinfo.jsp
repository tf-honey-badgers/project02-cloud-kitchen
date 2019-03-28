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
<form action="payment" method="post">
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
					<!-- <div class="form-group">
						<label>이름</label> <input type="text" class="form-control"
							id="firstname_order" name="firstname_order" placeholder="이름">
					</div> -->
			
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

<jsp:include page="selected_cart.jsp"></jsp:include>
			<!-- End col-md-3 -->

		</div>
		<!-- End row -->
	</div>
	<!-- End container -->
	<!-- End Content =============================================== -->
</form>
	<!-- Footer 시작  -->
	<jsp:include page="../include/footer.jsp" flush="false" />
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