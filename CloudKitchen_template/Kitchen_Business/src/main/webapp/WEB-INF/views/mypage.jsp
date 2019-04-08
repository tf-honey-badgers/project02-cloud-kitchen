<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/img/apple-icon.png">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>
        BADGERS - 사업자
    </title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!-- Fonts and icons -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="${pageContext.request.contextPath}/resources/css/material-dashboard.css?v=2.1.1" rel="stylesheet" />
    
</head>

<body>
	<!-- Preload -->
	<jsp:include page="include/preload.jsp" flush="false"></jsp:include>
	<!-- End Preload -->
    <div class="wrapper ">
        <!-- Sidebar -->
        <jsp:include page="include/sidebar.jsp" flush="false"></jsp:include>
        <!-- End Sidebar -->
        <div class="main-panel">
            <!-- Header -->
            <jsp:include page="include/header.jsp" flush="false"></jsp:include>
            <!-- End Header -->
			<!-- Main Content -->
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
						<!-- View / Change profile data -->
						<div class="col-md-12">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title">Profile</h4>
									<p class="card-category">비밀번호와 계좌번호만 변경할 수 있습니다.</p>
								</div>
								<div class="card-body" style="padding-top: 50px;">
									<form>
										<div class="row">
											<div class="col-md-3">
												<div class="form-group">
													<label class="bmd-label-floating">사업자 이름</label> <input
														type="text" id="bizMemberName" class="form-control"
														disabled value="${bizMember.name}">
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label class="bmd-label-floating">사업자 아이디</label> <input
														type="text" id="bizId" class="form-control" disabled
														value="${bizMember.bizId}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="bmd-label-floating">사업자 등록번호</label> <input
														type="text" id="regNo" class="form-control" disabled
														value="${bizMember.regNo}">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label class="bmd-label-floating">비밀번호</label> <input
														type="password" id="pw" class="form-control" disabled
														value="********************">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="bmd-label-floating">계좌번호</label> <input
														type="text" id="account" class="form-control"
														value="${bizMember.account}">
												</div>
											</div>
										</div>
										<button type="button"
											class="changePw btn btn-primary pull-left">사업자 비밀번호
											수정</button>
										<button type="button" id="changeAccount"
											class="btn btn-primary pull-right">사업자 계좌번호 수정</button>
										<div class="clearfix"></div>
									</form>
								</div>
							</div>
						</div>
						<!-- View / Change YouTube player code -->
						<div class="col-md-12">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title">YouTube Live Streaming</h4>
									<p class="card-category">스트리밍을 시작하면 현재 유효한 유투브 생방송 코드를 입력해주세요.</p>
								</div>
								<div class="card-body" style="padding-top: 50px;">
									<form>
										<div class="row">
											<div class="col-md-8">
												<div class="form-group">
													<label class="bmd-label-floating">유투브 생방송 코드</label>
													<input type="text" id="bizLiveStrm" class="form-control" value="${bizMember.biz.bizLiveStrm}">
												</div>
											</div>
											<button type="button" id="changeBizLiveStrm" class="btn btn-primary pull-right">유투브 생방송 코드 입력</button>
										</div>
										<div class="clearfix"></div>
									</form>
								</div>
							</div>
						</div>
						<!-- View / Change business data -->
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header card-header-primary">
                                    <h4 class="card-title">Business</h4>
                                    <p class="card-category">가게 소개문, 최소주문금액, 생방송 키 코드만 변경할 수 있습니다.</p>
                                </div>
                                <div class="card-body" style="padding-top: 50px;">
                                    <form>
                                        <div class="row">
                                            <div class="col-md-5">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">가게 이름</label>
                                                    <input type="text" id="bizName" class="form-control" disabled value="${bizMember.biz.name}">
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">찜 횟수</label>
                                                    <input type="text" id="favorites" class="form-control" disabled value="${favCnt}">
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">최소주문금액</label>
                                                    <input type="text" id="minAmt" class="form-control" value="
                                                    <fmt:formatNumber value="${bizMember.biz.minAmt}" type="currency" currencySymbol="￦"/>
                                                   "/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">주소</label>
                                                    <input type="text" id="addr" class="form-control" disabled value="${bizMember.kb.address}">
                                                </div>
                                                <div class="">
                                                	<label class="bmd-label-floating">사진변경</label>
                                                    <input type="file" id="bizPhoto" value="사진변경"/> 
                                                    <input type="text" id="addr" class="form-control" disabled value="">
                                                </div>   
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>가게 설명문</label>
                                                    <div class="form-group">
                                                        <label class="bmd-label-floating"></label>
                                                        <textarea id="bizInfo" class="form-control" rows="5">${bizMember.biz.info}</textarea>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <button type="button" id="changeBiz" class="btn btn-primary pull-right">가게 정보 업데이트</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
			<!-- End Main Content -->
            <!-- Login Modal -->
            <jsp:include page="include/loginModal.jsp" flush="false"></jsp:include>
            <!-- End Login Modal -->
			<!-- Find ID / Find PW Modal -->
            <jsp:include page="include/finderModal.jsp" flush="false"></jsp:include>
            <!-- End Find ID / Find PW Modal -->
            <!-- Footer -->
            <jsp:include page="include/footer.jsp" flush="false"></jsp:include>
            <!-- End Footer -->
        </div>
    </div>
    <div class="fixed-plugin">
        <div class="dropdown show-dropdown">
            <a href="#" data-toggle="dropdown">
                <i class="fa fa-cog fa-2x"> </i>
            </a>
            <ul class="dropdown-menu">
                <li class="header-title"> Sidebar Filters</li>
                <li class="adjustments-line">
                    <a href="javascript:void(0)" class="switch-trigger active-color">
                        <div class="badge-colors ml-auto mr-auto">
                            <span class="badge filter badge-purple" data-color="purple"></span>
                            <span class="badge filter badge-azure" data-color="azure"></span>
                            <span class="badge filter badge-green" data-color="green"></span>
                            <span class="badge filter badge-warning" data-color="orange"></span>
                            <span class="badge filter badge-danger" data-color="danger"></span>
                            <span class="badge filter badge-rose active" data-color="rose"></span>
                        </div>
                        <div class="clearfix"></div>
                    </a>
                </li>
                <li class="header-title">Images</li>
                <li class="active">
                    <a class="img-holder switch-trigger" href="javascript:void(0)">
                        <img src="${pageContext.request.contextPath}/resources/img/sidebar-1.jpg" alt="">
                    </a>
                </li>
                <li>
                    <a class="img-holder switch-trigger" href="javascript:void(0)">
                        <img src="${pageContext.request.contextPath}/resources/img/sidebar-2.jpg" alt="">
                    </a>
                </li>
                <li>
                    <a class="img-holder switch-trigger" href="javascript:void(0)">
                        <img src="${pageContext.request.contextPath}/resources/img/sidebar-3.jpg" alt="">
                    </a>
                </li>
                <li>
                    <a class="img-holder switch-trigger" href="javascript:void(0)">
                        <img src="${pageContext.request.contextPath}/resources/img/sidebar-4.jpg" alt="">
                    </a>
                </li>
                <li class="button-container">
                    <a href="https://www.creative-tim.com/product/material-dashboard" target="_blank" class="btn btn-primary btn-block">Free Download</a>
                </li>
                <li class="button-container">
                    <a href="https://demos.creative-tim.com/material-dashboard/docs/2.1/getting-started/introduction.html" target="_blank" class="btn btn-default btn-block">
                        View Documentation
                    </a>
                </li>
                <li class="button-container github-star">
                    <a class="github-button" href="https://github.com/creativetimofficial/material-dashboard" data-icon="octicon-star" data-size="large" data-show-count="true" aria-label="Star ntkme/github-buttons on GitHub">Star</a>
                </li>
                <li class="header-title">Thank you for 95 shares!</li>
                <li class="button-container text-center">
                    <button id="twitter" class="btn btn-round btn-twitter"><i class="fa fa-twitter"></i> &middot; 45</button>
                    <button id="facebook" class="btn btn-round btn-facebook"><i class="fa fa-facebook-f"></i> &middot; 50</button>
                    <br>
                    <br>
                </li>
            </ul>
        </div>
    </div>
    
    <!--   Core JS Files   -->
    <script src="${pageContext.request.contextPath}/resources/js/core/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/core/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/core/bootstrap-material-design.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plugins/perfect-scrollbar.jquery.min.js"></script>
    <!-- Plugin for the momentJs -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/moment.min.js"></script>
    <!-- Plugin for Sweet Alert -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/sweetalert2.js"></script>
    <!-- Forms Validations Plugin -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jquery.validate.min.js"></script>
    <!-- Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jquery.bootstrap-wizard.js"></script>
    <!-- Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-selectpicker.js"></script>
    <!-- Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-datetimepicker.min.js"></script>
    <!-- DataTables.net Plugin, full documentation here: https://datatables.net/ -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jquery.dataTables.min.js"></script>
    <!-- Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-tagsinput.js"></script>
    <!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jasny-bootstrap.min.js"></script>
    <!-- Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/fullcalendar.min.js"></script>
    <!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jquery-jvectormap.js"></script>
    <!-- Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/nouislider.min.js"></script>
    <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
    <!-- Library for adding dinamically elements -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/arrive.min.js"></script>
    <!--  Google Maps Plugin    -->
    <!-- <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script> -->
    <!-- Chartist JS -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/chartist.min.js"></script>
    <!--  Notifications Plugin    -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-notify.js"></script>
    <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
    <script src="${pageContext.request.contextPath}/resources/js/material-dashboard.js?v=2.1.1" type="text/javascript"></script>
    <script src="http://sdk.amazonaws.com/js/aws-sdk-2.1.24.min.js"></script>
    <script src="https://sdk.amazonaws.com/js/aws-sdk-2.283.1.min.js"></script>
    <script>
    	/* 브라우저 사이즈 변경에 따른 반응형 처리 */
        $(document).ready(function() {
            $().ready(function() {
                $sidebar = $('.sidebar');

                $sidebar_img_container = $sidebar.find('.sidebar-background');

                $full_page = $('.full-page');

                $sidebar_responsive = $('body > .navbar-collapse');

                window_width = $(window).width();

                fixed_plugin_open = $('.sidebar .sidebar-wrapper .nav li.active a p').html();

                if (window_width > 767 && fixed_plugin_open == 'Dashboard') {
                    if ($('.fixed-plugin .dropdown').hasClass('show-dropdown')) {
                        $('.fixed-plugin .dropdown').addClass('open');
                    }
                }

                $('.fixed-plugin a').click(function(event) {
                    // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
                    if ($(this).hasClass('switch-trigger')) {
                        if (event.stopPropagation) {
                            event.stopPropagation();
                        } else if (window.event) {
                            window.event.cancelBubble = true;
                        }
                    }
                });

                $('.fixed-plugin .active-color span').click(function() {
                    $full_page_background = $('.full-page-background');

                    $(this).siblings().removeClass('active');
                    $(this).addClass('active');

                    var new_color = $(this).data('color');

                    if ($sidebar.length != 0) {
                        $sidebar.attr('data-color', new_color);
                    }

                    if ($full_page.length != 0) {
                        $full_page.attr('filter-color', new_color);
                    }

                    if ($sidebar_responsive.length != 0) {
                        $sidebar_responsive.attr('data-color', new_color);
                    }
                });

                $('.fixed-plugin .background-color .badge').click(function() {
                    $(this).siblings().removeClass('active');
                    $(this).addClass('active');

                    var new_color = $(this).data('background-color');

                    if ($sidebar.length != 0) {
                        $sidebar.attr('data-background-color', new_color);
                    }
                });

                $('.fixed-plugin .img-holder').click(function() {
                    $full_page_background = $('.full-page-background');

                    $(this).parent('li').siblings().removeClass('active');
                    $(this).parent('li').addClass('active');


                    var new_image = $(this).find("img").attr('src');

                    if ($sidebar_img_container.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
                        $sidebar_img_container.fadeOut('fast', function() {
                            $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
                            $sidebar_img_container.fadeIn('fast');
                        });
                    }

                    if ($full_page_background.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
                        var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

                        $full_page_background.fadeOut('fast', function() {
                            $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
                            $full_page_background.fadeIn('fast');
                        });
                    }

                    if ($('.switch-sidebar-image input:checked').length == 0) {
                        var new_image = $('.fixed-plugin li.active .img-holder').find("img").attr('src');
                        var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

                        $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
                        $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
                    }

                    if ($sidebar_responsive.length != 0) {
                        $sidebar_responsive.css('background-image', 'url("' + new_image + '")');
                    }
                });

                $('.switch-sidebar-image input').change(function() {
                    $full_page_background = $('.full-page-background');

                    $input = $(this);

                    if ($input.is(':checked')) {
                        if ($sidebar_img_container.length != 0) {
                            $sidebar_img_container.fadeIn('fast');
                            $sidebar.attr('data-image', '#');
                        }

                        if ($full_page_background.length != 0) {
                            $full_page_background.fadeIn('fast');
                            $full_page.attr('data-image', '#');
                        }

                        background_image = true;
                    } else {
                        if ($sidebar_img_container.length != 0) {
                            $sidebar.removeAttr('data-image');
                            $sidebar_img_container.fadeOut('fast');
                        }

                        if ($full_page_background.length != 0) {
                            $full_page.removeAttr('data-image', '#');
                            $full_page_background.fadeOut('fast');
                        }

                        background_image = false;
                    }
                });

                $('.switch-sidebar-mini input').change(function() {
                    $body = $('body');

                    $input = $(this);

                    if (md.misc.sidebar_mini_active == true) {
                        $('body').removeClass('sidebar-mini');
                        md.misc.sidebar_mini_active = false;

                        $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar();

                    } else {

                        $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar('destroy');

                        setTimeout(function() {
                            $('body').addClass('sidebar-mini');

                            md.misc.sidebar_mini_active = true;
                        }, 300);
                    }

                    // we simulate the window Resize so the charts will get updated in realtime.
                    var simulateWindowResize = setInterval(function() {
                        window.dispatchEvent(new Event('resize'));
                    }, 180);

                    // we stop the simulation of Window Resize after the animations are completed
                    setTimeout(function() {
                        clearInterval(simulateWindowResize);
                    }, 1000);

                });
            });
        });
    </script>
    <!-- Business Member 관련 각종 JavaScript 함수 모음 -->
    <script src="${pageContext.request.contextPath}/resources/js/member/member-functions.js" type="text/javascript"></script>
    
    <!-- 사이드바 하이라이트된 바꾸기 -->
    <script type="text/javascript">
	    $(document).ready(function() {
	    	$('.nav-item').removeClass('active');
	    	$('.nav-item.sidebar-mypage').addClass('active');
	    });
    </script>
    
    <!-- message 속성이 있으면 알림 띄우기 -->
    <c:if test="${not empty message}">
    	<script>
    		$(document).ready(function() { md.showNotification('top', 'center', 'danger', '${message}'); });
    	</script>
	</c:if>
</body>
</html>