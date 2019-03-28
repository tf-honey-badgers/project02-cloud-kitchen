<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오 로그인</title>
</head>

<body>
  	<!-- 위쪽 헤더바  -->
    <jsp:include page="include/header.jsp" flush="false"/>
    <br><br><br><br><br><br>	
    <div style="height:20%; border:5px solid; padding:10px;"></div>
<span style="margin-left:33%"><h3>카카오톡 로그인 성공 화면</h3></span>
  <hr />
  <div>
  <div style="border:5px solid #78cfcf;">
  <div id="k_image" style="text-align:center"><img></img</div>
  <div id="k_id" style="text-align:center"></div>
  <div id="k_email" style="text-align:center"></div>
  <div id="k_nickname" style="text-align:center"></div>
      <a href = "${pageContext.request.contextPath}/logout">
      <button type="button" id ="kakaologout" class="btn btn-submit">로그아웃</button>
      </a><br>
      <a href=" https://developers.kakao.com/logout">dddddd</a>
	</div>
	</div>
	<br>
	
<jsp:include page="include/footer.jsp" flush="false"/>
  <script>		
  if ('${k_userInfo}') {

    $("#k_id").text("아이디 : " + '${id}');
    $("#k_email").text("이메일 : " + '${email}');
    $("#k_nickname").text("이름 : " + '${nickname}');

    imageURL = ${image};

    $("#k_image").children("img").attr("src", imageURL);
  }
  </script>
    
<script src='https://developers.kakao.com/sdk/js/kakao.min.js'></script>
<script>
$(document).ready(function(){
	 if ( window.location == 'https://developers.kakao.com/logout' ) {
		   window.location.href='http://localhost:3001/customer/main';
		  };
	 
$('#kakaologout').on('click', function() {
Kakao.init('f974d2d246e51518f4c5d60e83a2ee41'); //카카오에서 제공 myceo.co.kr 수정
Kakao.Auth.logout(
function(obj) {
	if(obj==true){
		setTimeout(function(){
 location.href = "${pageContext.request.contextPath}/logout";
 alert('로그아웃  성공');		
 });
	}else{alert('실패')}
});
});
});
</script>

</body>
</html>


