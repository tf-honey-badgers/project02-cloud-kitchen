
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/android/androidTest.js"></script>
</head>
<body>
	<h2>Hybrid App (WEB+APP)</h2>
	<hr />
	<input type="text" id="textMessageFromWeb" value="Hello, Hybrid(WEB)!!" />
	<input type="button" value="Send Message"
		onclick="sendMessage(document.getElementById('textMessageFromWeb').value)" />

	<hr />
	Message From App
	<p id="textMessageFromApp"></p>

</body>
</html>