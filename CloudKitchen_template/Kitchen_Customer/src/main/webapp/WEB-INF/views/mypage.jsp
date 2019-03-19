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
					<h2 class="inner">개인정보 수정</h2>
					<p>비번 , 이름 , 이메일 변경 가능 </p>
					<form action="">
					<div class="form-group">
						<label>아이디</label>
						<input type="text" class="form-control" id="id" name="customerId" disabled value="${customer.id}">
					</div>																		  
					<div class="form-group">
						<label>비밀번호</label>
						<input type="text" class="form-control" id="pw" name="customerPw" value="${customer.pw}">
					</div>
					<div class="form-group">
						<label>이름</label>
						<input type="text" id="name" name="customerName" class="form-control" value="${customer.name}">
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
						<input type="text" id="email" name="customerEmail" class="form-control"  value="${customer.email}">
					</div>
					<div class="form-group">
						<label>성별</label>
						<input type="text" id="Gender" name="customerGender" class="form-control" disabled value="${customer.gender}">
					</div>
					<div class="form-group">
						<label>주소</label>
						<input type="text" id="location" name="customerLocation" class="form-control"  placeholder="원주니네 통닭 ">
					</div>
					<button type="button" id="changeCustomer" class="btn btn-primary">사용자 정보 변경</button>
					</form>
				</div><!-- End box_style_1 -->
			</div><!-- End col-md-6 -->
			
			  <!-- Footer -->
            <jsp:include page="include/footer.jsp" flush="false"></jsp:include>
            <!-- End Footer -->
			
			
    <script type="text/javascript">
 
  //비번 , 이름 , 이메일
	$('#changeCustomer').on('click', function() {
		$.ajax({
    		url : '/customer/member/' + $('#id').val() + '/modify'
    		, type : 'POST'
			, contentType : 'application/json'
    		, data : JSON.stringify({
    				id : $('#id').val(),
    				 pw : $('#pw').val()
    				, name : $('#name').val()
    				, email : $('#email').val()
    			})
    		, error : function() { alert("회원 정보를 수정하는데 에러가 발생했습니다."); }
    		, success : function() { alert("성공적으로 회원 정보를 수정했습니다."); }
		});
	});
    </script>
    
     <c:if test="${not empty message}">
    	<script>
    		$(document).ready(function() { alert("${message}"); });
    	</script>
	</c:if>
</body>
</html>