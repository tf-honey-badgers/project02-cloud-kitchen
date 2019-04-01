<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="sidebar" data-color="azure" data-background-color="white"
	data-image="/business/resources/img/sidebar-1.jpg">
	<!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
	<div class="logo">
		<a href="${pageContext.request.contextPath}/main" class="simple-text logo-normal">Honey Badgers <br> Cloud Kitchen </a>
	</div>
	<div class="sidebar-wrapper">
		<ul class="nav">
			<li class="nav-item active sidebar-home"><a class="nav-link" href="${pageContext.request.contextPath}/main">
					<i class="material-icons">home</i>
					<p>메인</p>
			</a></li>
			<li class="nav-item sidebar-mypage"><a class="nav-link" href="/business/member/mypage">
					<i class="material-icons">person</i>
					<p>마이페이지</p>
			</a></li>
			<li class="nav-item sidebar-menu"><a class="nav-link" href="${pageContext.request.contextPath}/menu/main?bizId=${sessionScope.bizId}">
					<i class="material-icons">library_books</i>
					<p>메뉴관리</p>
			</a></li>
			<li class="nav-item sidebar-marketing"><a class="nav-link" href="#">
					<i class="material-icons">camera</i>
					<p>마케팅관리</p>
			</a></li>
			<li class="nav-item sidebar-orders"><a class="nav-link" href="${pageContext.request.contextPath}/order/main">
					<i class="material-icons">notifications</i>
					<p>주문현황</p>
			</a></li>
			<li class="nav-item sidebar-settings"><a class="nav-link" href="#">
					<i class="fa fa-cog fa-2x"> </i>
					<p>환경설정</p>
			</a></li>
		</ul>
	</div>
</div>
