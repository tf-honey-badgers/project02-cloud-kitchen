<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSTL core 라이브러리 도입 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Starkhaven</title>
	<!-- CSS 설정을 외부 파일로 분리 -->
	<link rel="stylesheet" href="/resources/css/OpenProject.css">
	<!-- jQuery를 사용하기 위한 라이브러리 도입 -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<!-- "header.jsp" -> 모든 페이지에서 공통적으로 사용해야하기에 외부파일로 분리 -->
	<jsp:include page="header.jsp" flush="false"></jsp:include>
	
	<!-- 속성 중 "message" 속성이 존재할 경우, 페이지 로딩 후 팝업창으로 보여준다. -->
	<c:if test="${not empty message}">
    	<script>
    		$(document).ready(function() { alert("${message}"); });
    	</script>
	</c:if>
</body>
</html>