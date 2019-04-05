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
    <jsp:include page="include/background.jsp" flush="false" />
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
      <a href = "${pageContext.request.contextPath}/main">
      <button type="button" id ="kakaologin123" class="btn btn-submit">클라우드 서비스 이용하러 가기</button>
      </a><br>
 <input type="hidden" id="kakaoidss" value="${sessionScope.uid}" />
<input type="hidden" id="kakaoniks" value="${sessionScope.knikname}" />
<input type ="hidden" id="kakaopws" value="${sessionScope.kpw }"/>
      

	</div>
	</div>
	<br>
	
<jsp:include page="include/footer.jsp" flush="false"/>
  <script>		
  if ('${k_userInfo}') {

    $("#k_id").text("아이디 : " + '${kakaoid}');
    $("#k_email").text("이메일 : " + '${kakaoemail}');
    $("#k_nickname").text("이름 : " + '${nickname}');

    imageURL = ${image};

    $("#k_image").children("img").attr("src", imageURL);
  }
  </script>
    
<script src='https://developers.kakao.com/sdk/js/kakao.min.js'></script>




</body>
</html>


