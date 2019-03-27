<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="/business/resources/img/apple-icon.png">
<link rel="icon" type="image/png"
	href="/business/resources/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>${bizMenu[0].bizName} - 메뉴 수정</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
	name='viewport' />
<!-- Fonts and icons -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<!-- CSS Files -->
<link href="/business/resources/css/joon/menu.css" rel="stylesheet" />
<link href="/business/resources/css/material-dashboard.css?v=2.1.1"
	rel="stylesheet" />

</head>

<body class="">
<div id="menuModal" class="menuModal">
	<div class="menuModalOpt">
		<span class="menuModalClose">&times;</span>
		<h3>변경</h3>
		<table class="menuOpt">
		</table>
		<div class="modelBtnArea"><button id="updateMenuBtn">메뉴변경</button></div>
	</div>
</div>

<div id="menuInsertModal" class="menuInsertModal">
	<div class="menuInsertModalOpt">
		<span class="menuInsertModalClose">&times;</span>
		<h3>추가</h3>
		<table class="menuInsertOpt">
				<tr>
					<th>메뉴사진</th><th>메뉴이름</th><th>메뉴가격</th><th>메뉴분류</th>
				</tr>
				<tr>
					<td><input type="file" id="menuPhoto" value="선택"></td>
					<td><input type="text" id="menuName"></td>
					<td><input type="text" id="menuPrice"></td>
					<td>
						<select name="" class="menuCatSelect">
   		 				</select>
					</td>
				</tr>
				
<!-- 				<tr>
					<th>카테고리이름</th><th>옵션카테고리</th>
				</tr>
				<tr>
					<td><input type="text" id="menuCatName"></td>
					<td>
						<select name="" class="menuOptSelect">
        					<option value="OPT001">기본단일</option>
        					<option value="OPT002">기본다중</option>
        					<option value="OPT003">추가단일</option>
        					<option value="OPT004">추가다중</option>
   		 				</select>
					</td>
				</tr> -->

		</table>
		<div class="modelInsertBtnArea"><button id="updateInsertMenuBtn">메뉴변경</button></div>
		<h3>메뉴추가</h3>
		<table class="menuInsertOpt">
		</table>
		<div class="modelInsertBtnArea"><button id="insertMenuBtn">메뉴변경</button></div>
	</div>
</div>

	<div class="wrapper ">
		<!-- Sidebar -->
		<jsp:include page="include/sidebar.jsp" flush="false"></jsp:include>
		
		<div class="main-panel">
			<!-- Header -->
			<jsp:include page="include/header.jsp" flush="false"></jsp:include>
			<!-- End Header -->
			<div class="content">
				<input type="button" class="menuInsert" value="메뉴추가">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title ">${bizMenu[0].bizMenuCatVo[0].mcName}</h4>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table">
											<thead class="text-primary">
												<th>메뉴코드</th>
												<th>메뉴사진</th>
												<th>메뉴이름</th>
												<th>메뉴가격</th>
												<th>옵션</th>
											</thead>
											<tbody>
												<c:forEach var="menu"
													items="${bizMenu[0].bizMenuCatVo[0].mcMenuVo}">
													<tr>
														<td>${menu.mcode}</td>
														<td>${menu.mphoto}</td>
														<td>${menu.mname}</td>
														<td class="text-primary">${menu.mbasicPrice}</td>
														<td><a href="" class="menu-option-select">변경</a> / 
														<a href="" class="menu-option-delete">삭제</a></td>
													</tr>
													
													
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						
						<c:forEach var="menucat" items="${bizMenu[0].bizMenuCatVo}"
							begin="1">
							<div class="col-md-12">
								<div class="card card-plain">
									<div class="card-header card-header-primary">
										<h4 class="card-title mt-0">${menucat.mcName}</h4>
									</div>
									<div class="card-body">
										<div class="table-responsive">
											<table class="table table-hover">
												<thead class="">
													<th>메뉴코드</th>
													<th>메뉴사진</th>
													<th>메뉴이름</th>
													<th>메뉴가격</th>
													<th>옵션</th>
												</thead>
												<tbody>
													<c:forEach var="menu" items="${menucat.mcMenuVo}">
														<tr>
															<td>${menu.mcode}</td>
															<td>${menu.mphoto}</td>
															<td>${menu.mname}</td>
															<td class="text-primary">${menu.mbasicPrice}</td>
															<td><a href="#" class="menu-option-select">변경</a> / <a
																href="#" class="menu-option-delete">삭제</a></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>

			<!-- Footer -->
			<jsp:include page="include/footer.jsp" flush="false"></jsp:include>
			<!-- End Footer -->

		</div>
	</div>
	<div class="fixed-plugin">
		<div class="dropdown show-dropdown">
			<a href="#" data-toggle="dropdown"> <i class="fa fa-cog fa-2x">
			</i>
			</a>
			<ul class="dropdown-menu">
				<li class="header-title">Sidebar Filters</li>
				<li class="adjustments-line"><a href="javascript:void(0)"
					class="switch-trigger active-color">
						<div class="badge-colors ml-auto mr-auto">
							<span class="badge filter badge-purple" data-color="purple"></span>
							<span class="badge filter badge-azure" data-color="azure"></span>
							<span class="badge filter badge-green" data-color="green"></span>
							<span class="badge filter badge-warning" data-color="orange"></span>
							<span class="badge filter badge-danger" data-color="danger"></span>
							<span class="badge filter badge-rose active" data-color="rose"></span>
						</div>
						<div class="clearfix"></div>
				</a></li>
				<li class="header-title">Images</li>
				<li class="active"><a class="img-holder switch-trigger"
					href="javascript:void(0)"> <img
						src="/business/resources/img/sidebar-1.jpg" alt="">
				</a></li>
				<li><a class="img-holder switch-trigger"
					href="javascript:void(0)"> <img
						src="/business/resources/img/sidebar-2.jpg" alt="">
				</a></li>
				<li><a class="img-holder switch-trigger"
					href="javascript:void(0)"> <img
						src="/business/resources/img/sidebar-3.jpg" alt="">
				</a></li>
				<li><a class="img-holder switch-trigger"
					href="javascript:void(0)"> <img
						src="/business/resources/img/sidebar-4.jpg" alt="">
				</a></li>
				<li class="button-container"><a
					href="https://www.creative-tim.com/product/material-dashboard"
					target="_blank" class="btn btn-primary btn-block">Free Download</a>
				</li>
				<!-- <li class="header-title">Want more components?</li>
            <li class="button-container">
                <a href="https://www.creative-tim.com/product/material-dashboard-pro" target="_blank" class="btn btn-warning btn-block">
                  Get the pro version
                </a>
            </li> -->
				<li class="button-container"><a
					href="https://demos.creative-tim.com/material-dashboard/docs/2.1/getting-started/introduction.html"
					target="_blank" class="btn btn-default btn-block"> View
						Documentation </a></li>
				<li class="button-container github-star"><a
					class="github-button"
					href="https://github.com/creativetimofficial/material-dashboard"
					data-icon="octicon-star" data-size="large" data-show-count="true"
					aria-label="Star ntkme/github-buttons on GitHub">Star</a></li>
				<li class="header-title">Thank you for 95 shares!</li>
				<li class="button-container text-center">
					<button id="twitter" class="btn btn-round btn-twitter">
						<i class="fa fa-twitter"></i> &middot; 45
					</button>
					<button id="facebook" class="btn btn-round btn-facebook">
						<i class="fa fa-facebook-f"></i> &middot; 50
					</button> <br> <br>
				</li>
			</ul>
		</div>
	</div>
	<!--   Core JS Files   -->
	<script src="/business/resources/js/core/jquery.min.js"></script>
	<script src="/business/resources/js/core/popper.min.js"></script>
	<script
		src="/business/resources/js/core/bootstrap-material-design.min.js"></script>
	<script
		src="/business/resources/js/plugins/perfect-scrollbar.jquery.min.js"></script>
	<!-- Plugin for the momentJs  -->
	<script src="/business/resources/js/plugins/moment.min.js"></script>
	<!--  Plugin for Sweet Alert -->
	<script src="/business/resources/js/plugins/sweetalert2.js"></script>
	<!-- Forms Validations Plugin -->
	<script src="/business/resources/js/plugins/jquery.validate.min.js"></script>
	<!-- Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
	<script src="/business/resources/js/plugins/jquery.bootstrap-wizard.js"></script>
	<!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
	<script src="/business/resources/js/plugins/bootstrap-selectpicker.js"></script>
	<!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
	<script
		src="/business/resources/js/plugins/bootstrap-datetimepicker.min.js"></script>
	<!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
	<script src="/business/resources/js/plugins/jquery.dataTables.min.js"></script>
	<!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
	<script src="/business/resources/js/plugins/bootstrap-tagsinput.js"></script>
	<!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
	<script src="/business/resources/js/plugins/jasny-bootstrap.min.js"></script>
	<!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
	<script src="/business/resources/js/plugins/fullcalendar.min.js"></script>
	<!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
	<script src="/business/resources/js/plugins/jquery-jvectormap.js"></script>
	<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
	<script src="/business/resources/js/plugins/nouislider.min.js"></script>
	<!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
	<!-- Library for adding dinamically elements -->
	<script src="/business/resources/js/plugins/arrive.min.js"></script>
	<!--  Google Maps Plugin    -->
	<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
	<!-- Chartist JS -->
	<script src="/business/resources/js/plugins/chartist.min.js"></script>
	<!--  Notifications Plugin    -->
	<script src="/business/resources/js/plugins/bootstrap-notify.js"></script>
	<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
	<script src="/business/resources/js/material-dashboard.js?v=2.1.1"
		type="text/javascript"></script>
	<!-- Material Dashboard DEMO methods, don't include it in your project! -->
	<script src="/business/resources/js/joon/menuupdate.js"></script>

</body>
</html>