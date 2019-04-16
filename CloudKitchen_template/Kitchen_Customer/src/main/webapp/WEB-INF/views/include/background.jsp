<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- SubHeader & Position =============================================== -->
<section data-parallax="scroll" data-natural-width="1400" data-natural-height="470">
		<img alt="대문" id = "introImg" src="${pageContext.request.contextPath}/resources/img/mypage/mypage_bg1.jpg" style="-webkit-filter: grayscale(66%);
																	filter: gray; width: 100%; height: 470px;">

	
        	 
  
</section><!-- End section -->
<!-- End SubHeader ============================================ -->

<!-- Position ============================================ -->

<!-- End Position ============================================ -->
<script>
//마이페이지 사진 바꾸기 
$(document).ready(function() {
var imgArray = new Array();
 imgArray[0] ="${pageContext.request.contextPath}/resources/img/mypage/mypage_bg1.jpg";
 imgArray[1] ="${pageContext.request.contextPath}/resources/img/mypage/mypage_bg1.jpg";
 imgArray[2] ="${pageContext.request.contextPath}/resources/img/mypage/mypage_bg3.jpg";
 imgArray[3] ="${pageContext.request.contextPath}/resources/img/mypage/mypage_bg4.jpg";
 imgArray[4] ="${pageContext.request.contextPath}/resources/img/mypage/mypage_bg5.jpg";
 imgArray[5] ="${pageContext.request.contextPath}/resources/img/mypage/mypage_bg6.jpg";
 imgArray[5] ="http://www.koreainus.com/v1/data/file/cook/854108902_qS5lWHQf_5d1f9912549d25db6c166d1372581a93e00520f6.png";

	var imgNum = Math.round(Math.random()*7);
	var objImg = document.getElementById("introImg");
	objImg.src = imgArray[imgNum];
 
});
</script>