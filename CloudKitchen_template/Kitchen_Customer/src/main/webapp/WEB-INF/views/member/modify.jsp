<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>개인정보 수정</title>

</head>
<body>
<!-- 위쪽 헤더바  -->
    <jsp:include page="../include/header.jsp"/>
    <jsp:include page="../include/background.jsp" flush="false" />

	<div class="container margin_60">
		<div class="row">
		<jsp:include page="mypage_sidebar.jsp"/>
  		<div class="col-md-9">
	

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
						<input type="password" class="form-control" id="pw" name="customerPw" value="${customer.pw}">
					</div>
					<div class="form-group">
						<label>이름</label>
						<input type="text" id="name" name="customerName" class="form-control" value="${customer.name}">
					</div>
					<div class="form-group">
						<label>생년 월일</label>
						<input type="text" id="birthDate" name="customerBirthDate" class="form-control" disabled value="${customer.birthDate}">
					</div>
					<div class="form-group">
						<label>핸드폰</label>
						<input type="text" id="phone" name="customerPhone" class="form-control" disabled value="${customer.phone}">
					</div>
					<div class="form-group">
						<label>이메일</label>
						<input type="email" id="email" name="customerEmail" class="form-control"  value="${customer.email}">
					</div>
					<div class="form-group">
						<label>성별</label>
						<input type="text" id="Gender" name="customerGender" class="form-control" disabled value="${customer.gender}">
					</div>
					<div class="form-group">
						<label>주소</label> 
						<button  type="button" class="btn btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>
						<input type="text" id="address" name="customerLocation" class="form-control"  value="${customer.address}">
					</div>
					<div class="form-group">
					<label>상세 주소</label>
						<input type="text" id="addressDetail" name="" class="form-control"  value="${customer.addressDetail}">
					</div>
					<button type="button" id="changeCustomer" class="btn btn-primary" style="align-content: left;">사용자 정보 변경</button>
					<!--  a 태그 넣어 data-toggle  모달 띄워서 회원 탈퇴 status 변경 하기  -->
					
					<a href="#0" data-toggle="modal" data-target="#deletemodal">
					<button type="button" id="delete" class="btn btn-primary" style="align-content:right;   background-color: red;">클라우드키친 탈퇴</button>
					</a>
						
					</form>
					<input type="hidden" id="address" name="customerLocation" class="form-control"  value="${customer.status}">
				</div><!-- End box_style_1 -->
			</div><!-- End col-md-6 -->
			</div>
	</div>
	
			<!-- Footer -->
            <jsp:include page="../include/footer.jsp" flush="false"></jsp:include>
            <!-- End Footer -->
           <!-- 탈퇴 모달  -->
		 <jsp:include page="../include/delete.jsp" flush="false"></jsp:include>
            		<script>
			function execPostCode() {
				
		         new daum.Postcode({
		             oncomplete: function(data) {
		                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
		 
		                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
		                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
		                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
		 
		                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
		                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
		                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
		                    extraRoadAddr += data.bname;
		                }
		                // 건물명이 있고, 공동주택일 경우 추가한다.
		                if(data.buildingName !== '' && data.apartment === 'Y'){
		                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		                }
		                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
		                if(extraRoadAddr !== ''){
		                    extraRoadAddr = ' (' + extraRoadAddr + ')';
		                }
		                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
		                if(fullRoadAddr !== ''){
		                    fullRoadAddr += extraRoadAddr;
		                }
		 
		                // 우편번호와 주소 정보를 해당 필드에 넣는다.
		                console.log(data.zonecode);
		                console.log(fullRoadAddr);
		                
		                
		               // document.getElementByName('').value = data.zonecode; //5자리 새우편번호 사용
		                document.getElementById('address').value = fullRoadAddr;
		               
		            }
		         }).open();
		     }

			</script>
</body>
</html>