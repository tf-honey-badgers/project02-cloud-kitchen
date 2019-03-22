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
			<div class="col-md-offset-3 col-md-6">
				<div class="box_style_2">
					<h2 class="inner">Order confirmed!</h2>
					<div id="confirm">
						<i class="icon_check_alt2"></i>
						<h3>Thank you!</h3>
						<p>Lorem ipsum dolor sit amet, nostrud nominati vis ex, essent
							conceptam eam ad. Cu etiam comprehensam nec. Cibo delicata mei
							an, eum porro legere no.</p>
					</div>
					<h4>Summary</h4>
					<table class="table table-striped nomargin">
						<tbody>
							<tr>
								<td><strong>1x</strong> Enchiladas</td>
								<td><strong class="pull-left">$11</strong></td>
							</tr>
							<tr>
								<td><strong>2x</strong> Burrito</td>
								<td><strong class="pull-left">$14</strong></td>
							</tr>
							<tr>
								<td><strong>1x</strong> Chicken</td>
								<td><strong class="pull-left">$20</strong></td>
							</tr>
							<tr>
								<td><strong>2x</strong> Corona Beer</td>
								<td><strong class="pull-left">$9</strong></td>
							</tr>
							<tr>
								<td><strong>2x</strong> Cheese Cake</td>
								<td><strong class="pull-left">$12</strong></td>
							</tr>
							<tr>
								<td>Delivery schedule <a href="#" class="tooltip-1"
									data-placement="top" title=""
									data-original-title="Please consider 30 minutes of margin for the delivery!"><i
										class="icon_question_alt"></i></a>
								</td>
								<td><strong class="pull-left">Today 07.30 pm</strong></td>
							</tr>
							<tr>
								<td class="total_confirm">TOTAL</td>
								<td class="total_confirm"><span class="pull-left">$66</span>
								</td>
							</tr>
						</tbody>
					</table>
					${list}
				</div>
			</div>
		</div>
		<!-- End row -->
	</div>
	<!-- End container -->
	<!-- End Content =============================================== -->
	<!-- Footer 시작  -->
	<jsp:include page="include/footer.jsp" flush="false" />
	<!-- Footer 끝  -->
</body>
</html>