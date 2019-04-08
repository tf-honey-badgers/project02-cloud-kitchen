<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜목록 보기</title>
</head>
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

var custId = '${custId}';

</script>




<body>

<!-- 위쪽 헤더바  -->
	<jsp:include page="include/header.jsp" />
	<jsp:include page="include/background.jsp" flush="false" />
	<!-- 헤드 끝 -->
<br><br><br><br><br><br>
<div style="margin-left:33%;">	
<h1>찜 리스트</h1>
</div>

<table  class="type11" style="margin-left:33%;">
		<thead>
			<tr>
				<th>회원 아이디</th>
				<th>가게 이름</th>
				<th>키친 이름</th>
			</tr>
			</thead>
			<tbody>
			</tbody>
		</table>


		<script>
		 var tbody = $('tbody');
		
		$(document).ready(function(){
			$.getJSON( 'http://13.209.21.25/rest/favorite/${custId}/mypage', function(list){
				
				for(var i = 0, len = list.length || 0 ; i < len; i++){
					var tr = $('<tr></tr>');
					var custId = $('<td id="'+ list[i].custId +'">' + list[i].custId + '</td>');
					var bizName =  $('<td>' + list[i].bizName + '</td>');
					var kitchenName = $('<td>' + list[i].kitchenName + '</td>');
					tr.append(custId).append(bizName).append(kitchenName);
					tbody.append(tr);
					console.log(list[i]);
				}
			});
		 
		
		});
			</script>

	<!-- 아래 풋터바  -->
	<jsp:include page="include/footer.jsp" />
	<!-- 풋터 끝 -->

</body>
</html>