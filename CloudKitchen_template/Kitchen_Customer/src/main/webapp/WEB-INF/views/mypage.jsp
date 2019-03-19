<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<!-- 위쪽 헤더바  -->
    <jsp:include page="include/header.jsp"/>
    <!-- 헤드 끝 -->
<br><br><br><br><br><br><br><br><br>
    <div class="col-md-6">
				<div class="box_style_2" id="order_process">
					<h2 class="inner">Your order details</h2>
					<div class="form-group">
						<label>아이디</label>
						<input type="text" class="form-control" id="id" name="customerId" value="${customer.id}">
					</div>																		  
					<div class="form-group">
						<label>비밀번호</label>
						<input type="text" class="form-control" id="pw" name="customerPw" value="${customer.pw}">
					</div>
					<div class="form-group">
						<label>이름</label>
						<input type="text" id="name" name="customerName" class="form-control" disabled value="${customer.name}">
					</div>
					<div class="form-group">
						<label>생년 월일</label>
						<input type="email" id="birthDate" name="customerBirthDate" class="form-control" disabled value="${customer.birthDate}">
					</div>
					<div class="form-group">
						<label>핸드폰</label>
						<input type="text" id="phone" name="customerPhone" class="form-control" disabled value="${customer.phone}">
					</div>
					<div class="form-group">
						<label>이메일</label>
						<input type="text" id="email" name="customerEmail" class="form-control" disabled value="${customer.email}">
					</div>
					<div class="form-group">
						<label>성별</label>
						<input type="text" id="Gender" name="customerGender" class="form-control"disabled value="${customer.gender}">
					</div>
					<div class="form-group">
						<label>주소</label>
						<input type="text" id="location" name="customerLocation" class="form-control"  placeholder="원주니네 통닭 ">
					</div>
					
				</div><!-- End box_style_1 -->
			</div><!-- End col-md-6 -->
    
    
</body>
</html>