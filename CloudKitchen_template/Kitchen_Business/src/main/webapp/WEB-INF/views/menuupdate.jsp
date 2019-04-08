<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="false"%> --%>
<%-- <%@page isELIgnored="false" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="${pageContext.request.contextPath}/resources/img/apple-icon.png">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/resources/img/favicon.png">
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
<link href="${pageContext.request.contextPath}/resources/css/joon/menu.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/material-dashboard.css?v=2.1.1"
	rel="stylesheet" />

</head>

<body class="">
<div id="insertMenuCatModal" class="insertMenuCatModal">
	<div class="insertMenuCatModalOpt">
		<span class="insertMenuCatModalClose">&times;</span>
					<div class="col-md-12">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title ">메뉴</h4><h4 class="card-title "></h4>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table menuUpdate">
											<thead class="text-primary">
												<th>카테고리이름</th>
												<th>추가삭제<input type="hidden" id="bizId" value="${sessionScope.bizId}"/>
													<button class="addMenuCat">
													<img src="${pageContext.request.contextPath}/resources/img/baseline_add_circle_outline_black_18dp.png">
													</button>
												</th>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>	
		<div class="insertMenuCatBtnArea"><button type="button" id="insertMenuCatBtn" class="btn btn-primary pull-right">카테고리 추가</button></div>
	</div>
</div>

<div id="menuModal" class="menuModal">
	<div class="menuModalOpt">
		<span class="menuModalClose">&times;</span>
					<div class="col-md-12">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title ">메뉴</h4>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table menuUpdate">
											
										</table>
									</div>
								</div>
							</div>
						</div>	
		<div class="modelBtnArea"><button type="button" id="updateMenuBtn" class="btn btn-primary pull-right">메뉴 변경</button></div>
	</div>
</div>

<div id="menuInsertModal" class="menuInsertModal">
	<div class="menuInsertModalOpt">
		<span class="menuInsertModalClose">&times;</span>
		<div class="addOptBtnArea">
			<button type="button" id="insertMenu" class="btn btn-primary pull-right">메뉴 추가</button>
		</div>
		
						<div class="col-md-12">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title ">메뉴</h4>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table">
											<thead class="text-primary">
												<th>메뉴사진</th>
												<th>메뉴이름</th>
												<th>메뉴가격</th>
												<th>메뉴구분</th>
											</thead>
											<tbody>
													<tr>
														<td>
														<input type="file" id="menuPhotoInsert" value="">
														</td>
														<td><input type="text" class=""></td>
														<td><input type="text" class=""></td>
														<td>
														<select id="menuCatSelect">
															
														</select>
														</td>
													</tr>
													
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="addOptBtnArea">
							<button type="button" id="insertOpt" class="btn btn-primary pull-right">옵션분류추가</button>
						</div>
						
						<div class="col-md-12 addMenuList">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title ">옵션종류선택</h4>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table">
											<thead class="text-primary">
												<th>옵션분류</th>
												<th>옵션분류이름</th>
												<th>옵션이름</th>
												<th>옵션추가가격</th>
												<th>옵션추가삭제</th>
											</thead>
											<tbody>
													<tr class="menuOptCl">
														<td>
															<select id="menuOptClSelect">
															</select>
														</td>
														<td><input type="text" class=""></td>
														<td><input type="text" class=""></td>
														<td><input type="text" class=""></td>
														<td><input type="text" class=""></td>
														<td>
															<button class="addOpt">
															<img src="${pageContext.request.contextPath}/resources/img/baseline_add_circle_outline_black_18dp.png">
															</button>
															<button class="deleteMenuOpt">
															<img src="${pageContext.request.contextPath}/resources/img/baseline_remove_circle_outline_black_18dp.png">
															</button>
														 </td>
													</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						
	</div>
</div>
<!-- Preload -->
<jsp:include page="include/preload.jsp" flush="false"></jsp:include>
<!-- End Preload -->
	<div class="wrapper ">
		<!-- Sidebar -->
		<jsp:include page="include/sidebar.jsp" flush="false"></jsp:include>
		
		<div class="main-panel">
			<!-- Header -->
			<jsp:include page="include/header.jsp" flush="false"></jsp:include>
			<!-- End Header -->
			<div class="content">
			<div class="btnArea">
				<button type="button" id="insertMenuCat" class="btn btn-primary pull-right">카테고리 추가</button>
				<button type="button" id="menuInsert" class="btn btn-primary pull-right">메뉴추가</button>
			</div>
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
														<td><img src="https://s3.ap-northeast-2.amazonaws.com/honeybadgersfile/MenuPhoto/${menu.mcode}.png" style="width:60px;height:60px;"/></td>
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
								<div class="card">
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
															<td><img src="https://s3.ap-northeast-2.amazonaws.com/honeybadgersfile/MenuPhoto/${menu.mcode}.png" style="width:60px;height:60px;"/></td>
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
						src="${pageContext.request.contextPath}/resources/img/sidebar-1.jpg" alt="">
				</a></li>
				<li><a class="img-holder switch-trigger"
					href="javascript:void(0)"> <img
						src="${pageContext.request.contextPath}/resources/img/sidebar-2.jpg" alt="">
				</a></li>
				<li><a class="img-holder switch-trigger"
					href="javascript:void(0)"> <img
						src="${pageContext.request.contextPath}/resources/img/sidebar-3.jpg" alt="">
				</a></li>
				<li><a class="img-holder switch-trigger"
					href="javascript:void(0)"> <img
						src="${pageContext.request.contextPath}/resources/img/sidebar-4.jpg" alt="">
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
	<script src="${pageContext.request.contextPath}/resources/js/core/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/core/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/core/bootstrap-material-design.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/plugins/perfect-scrollbar.jquery.min.js"></script>
	<!-- Plugin for the momentJs  -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/moment.min.js"></script>
	<!--  Plugin for Sweet Alert -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/sweetalert2.js"></script>
	<!-- Forms Validations Plugin -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/jquery.validate.min.js"></script>
	<!-- Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/jquery.bootstrap-wizard.js"></script>
	<!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-selectpicker.js"></script>
	<!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
	<script
		src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-datetimepicker.min.js"></script>
	<!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/jquery.dataTables.min.js"></script>
	<!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-tagsinput.js"></script>
	<!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/jasny-bootstrap.min.js"></script>
	<!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/fullcalendar.min.js"></script>
	<!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/jquery-jvectormap.js"></script>
	<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/nouislider.min.js"></script>
	<!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
	<!-- Library for adding dinamically elements -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/arrive.min.js"></script>
	<!--  Google Maps Plugin    -->
	<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
	<!-- Chartist JS -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/chartist.min.js"></script>
	<!--  Notifications Plugin    -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-notify.js"></script>
	<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
	<script src="${pageContext.request.contextPath}/resources/js/material-dashboard.js?v=2.1.1"
		type="text/javascript"></script>
	<!-- Material Dashboard DEMO methods, don't include it in your project! -->
	<script src="https://sdk.amazonaws.com/js/aws-sdk-2.283.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/joon/menuupdate.js"></script>
	<script src="http://sdk.amazonaws.com/js/aws-sdk-2.1.24.min.js"></script>
	
	<script type="text/javascript">
    	/* 사이드바 하이라이트된 바꾸기 */
    	$('.nav-item').removeClass('active');
    	$('.nav-item.sidebar-menu').addClass('active');
    </script>
</body>
</html>