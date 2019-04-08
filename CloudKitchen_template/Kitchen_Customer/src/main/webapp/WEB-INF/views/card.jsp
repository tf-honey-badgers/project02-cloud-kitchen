<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카드 계좌 관리 </title>
<style>
</style>
</head>
<body>
<!-- 위쪽 헤더바  -->
	<jsp:include page="include/header.jsp" />
	<jsp:include page="include/background.jsp" flush="false" />
	<!-- 헤드 끝 -->
	<div class="col-6">
	<h1>카드 관리</h1>  <button type="button" class="btn btn-submit" style="width:150px; margin-left:62%;" >카드 추가</button>
	    <hr>
    <table class="type11" style="margin-left:18%;">
      <thead>
          <tr>
              <th>카드 이미지</th>
              <th>카드 종류</th>
              <th>카드 번호 </th>
              <th>삭제 </th>
          </tr>
      </thead>
        <tbody>
           <tr>
            <td><img src="${pageContext.request.contextPath}/resources/img/nhcard.png" width="300" height="150" alt="nh"></td>
            <td><h2>농협카드</h2></td>
            <td><h2>*******-1644</h2></td>
             <td><button type="button" class="btn btn-submit">삭제</button></td>
          </tr>
          <tr>
              <td><img src="${pageContext.request.contextPath}/resources/img/kbcard.png" width="300" height="150" alt="kb"></td>
              <td><h2>국민 카드</h2></td>
              <td><h2>*******-9434</h2></td>
              <td><button type="button" class="btn btn-submit">삭제</button></td>
          <tr>
              <td><img src="${pageContext.request.contextPath}/resources/img/sinhan.png" width="300" height="150" alt="sin"></td>
              <td><h2>신한 카드</h2></td>
              <td><h2>*******-7514</h2></td>
              <td><button type="button" class="btn btn-submit">삭제</button></td>
                  
          </tr>
          
        </tbody>
        	
    </table>
	</div>
	<!-- 위쪽 헤더바  -->
	<jsp:include page="include/footer.jsp" />
	<!-- 헤드 끝 -->
	
</body>
</html>