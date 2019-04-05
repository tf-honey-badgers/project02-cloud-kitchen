<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
	<div class="container-fluid">
		<div class="navbar-wrapper">
			<a class="navbar-brand" href="#">Dashboard</a>
		</div>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			aria-controls="navigation-index" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="sr-only">Toggle navigation</span> <span
				class="navbar-toggler-icon icon-bar"></span> <span
				class="navbar-toggler-icon icon-bar"></span> <span
				class="navbar-toggler-icon icon-bar"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-end">
			<form class="navbar-form">
				<div class="input-group no-border">
					<input type="text" value="" class="form-control"
						placeholder="Search...">
					<button type="submit" class="btn btn-white btn-round btn-just-icon">
						<i class="material-icons">search</i>
						<div class="ripple-container"></div>
					</button>
				</div>
			</form>
			<ul class="navbar-nav">
				<!-- <li class="nav-item"><a class="nav-link" href="#" data-toggle="modal" data-target="#login_2">
						<i class="material-icons">lock</i>
						<p class="d-lg-none d-md-block">Login</p>
				</a></li> -->
				<li class="nav-item"><a class="nav-link" href="#pablo"> <i
						class="material-icons">dashboard</i>
						<p class="d-lg-none d-md-block">Stats</p>
				</a></li>
				<li class="nav-item dropdown"><a class="nav-link"
					href="http://example.com" id="navbarDropdownMenuLink"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<i class="material-icons">notifications</i> <span
						class="notification">5</span>
						<p class="d-lg-none d-md-block">Some Actions</p>
				</a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="#">Mike John responded to your
							email</a> <a class="dropdown-item" href="#">You have 5 new tasks</a>
						<a class="dropdown-item" href="#">You're now friend with
							Andrew</a> <a class="dropdown-item" href="#">Another Notification</a>
						<a class="dropdown-item" href="#">Another One</a>
					</div></li>
					
					<!-- 회원 관리  -->
				<li class="nav-item dropdown">
					<a class="nav-link" href="#pablo"id="navbarDropdownProfile" data-toggle="dropdown"aria-haspopup="true" aria-expanded="false">
					 <i class="material-icons">person</i>
						<p class="d-lg-none d-md-block">Account</p>
				    </a>
					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
						<a class="dropdown-item" href="#">Profile</a> 
						<a class="dropdown-item" href="#">Settings</a>
						<div class="dropdown-divider"></div>
						<c:if test="${empty sessionScope.bizId }" > 
							<a class="dropdown-item" href="#" id="login"  data-toggle="modal" data-target="#login_2">Login</a>
						</c:if>
						<c:if test="${!empty sessionScope.bizId }" >
							<a class="dropdown-item" href="${pageContext.request.contextPath}/member/logout" id="logout">Logout</a>
						</c:if>
					</div>
				</li>
			</ul>
		</div>
	</div>
</nav>