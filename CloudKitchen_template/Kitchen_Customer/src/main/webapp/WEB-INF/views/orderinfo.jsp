<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 리스트</title>
<script src="/customer/resources/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

var custId = '${custId}';

</script>
<style type="text/css">

        div.c{
            margin: 0 10% 0 10%;
            width: 1500px;
            height: 200px;
            text-align: center;
        }
      div.center {
       width: 100%;
        height:100%;
       
        border: 1px solid #000;
    }
    div.left {
        width: 20%;
        height: 100%;
        float: left;
       box-sizing: border-box;
        
        background: #ff0;
    }
    div.right {
        width: 80%;
        float: right;
         height: 100%;
       box-sizing: border-box;
        
        background: #0ff;
    }

    
    </style>
    
</head>
<body>
	<!-- 위쪽 헤더바  -->
	<jsp:include page="include/header.jsp" />
	<jsp:include page="include/background.jsp" flush="false" />
	<!-- 헤드 끝 -->
<br><br>
	<h2>주문 리스트</h2>
	<br><br>
		   
		 <div class="c">
  <div class="center">
    <div class="left">
     <h1>사진넣구</h1> 
      </div>
      <div class="right" >
          <h1>유니네 피자집</h1>
          <h1>총 가격  ㅣ  결제 일시</h1>
          <button type="button" class="btn btn-default"><h3>결제 상세 내역 보기</h3></button>  
      </div>
    </div>
    </div>
    
		 <div class="c">
  <div class="center">
    <div class="left">
     <h1>사진</h1> 
      </div>
      <div class="right" >
          <span></span>
          <h1>총 가격  ㅣ  결제 일시</h1>
          <button type="button" class="btn btn-default"><h3>결제 상세 내역 보기</h3></button>  
      </div>
    </div>
    </div>		
    <div id="co">
    <span></span>
  
    </div>
    
		
		
		
		
		
		
		
		
		
		
		
		
		
		<table  class="type11" id="list">
		<thead style="display:none">
			<tr>

				<th>주문 시간</th>
				<th>키친 주소</th>
				<th>주문 가게</th>
				<th>결제 방법</th>
				<th>메인 메뉴</th>
				<th>옵션</th>
				<th>주문 가격</th>
				<th>하고싶은말</th>
				
			</tr>
			</thead>
			<tbody style="display:none">
			</tbody>
		</table>
	
<%-- 	var kk = ${list[i].kitchenName}; --%>
		
		<script>
		 var tbody = $('tbody');
		$(document).ready(function(){
	
			$.getJSON( 'http://localhost/rest/customer/${custId}/mypage/orderinfo', function(list){
				
				for(var i = 0, len = list.length || 0 ; i < len; i++){
					var tr = $('<tr></tr>');
					var time = $('<td>' + list[i].time + '</td>');
					var kitchenName = $('<td>' + list[i].kitchenName + '</td>');
					var bizName = $('<td>' + list[i].bizName + '</td>');
					var method = $('<td>' + list[i].method + '</td>');
					var menuName = $('<td>' + list[i].menuName + '</td>');
					var optName = $('<td>' + list[i].optName + '</td>');
					var payAmt = $('<td>' + list[i].payAmt + '</td>');
					var msg = $('<td>' + list[i].msg + '</td>');
			
					tr.append(time).append(kitchenName).append(bizName).append(method).append(menuName)
					.append(optName).append(payAmt).append(msg);
					tbody.append(tr);
					console.log(list[i]);
			
				}
			});
		 
		
		});
		
		</script>
		
		
		
		
		
		<!-- 위쪽 헤더바  -->
	<jsp:include page="include/footer.jsp" />
	<!-- 헤드 끝 -->
		
		
</body>
</html>