<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		This is the Kitchen_Business server!!!
	</h1>

	<P>  The time on the server is ${serverTime}. </P>
	
	<ul>
		<li><a href="/member/biz_1">사업자 ID biz_1 보기 (마이페이지로 이동)</a></li>
	</ul>
</body>
</html>
