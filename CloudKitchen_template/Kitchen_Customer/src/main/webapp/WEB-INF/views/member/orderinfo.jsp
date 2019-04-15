<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 리스트</title>

<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

var custId = '${custId}';

</script>
<style>
table{
 font-size: 1.5em;
}
</style>
</head>
<body>
	<!-- 위쪽 헤더바  -->
	<jsp:include page="../include/header.jsp" />
	<jsp:include page="../include/background.jsp" flush="false" />
	<!-- 헤드 끝 -->
	<br><br>
	<div class="container margin_60_35">
	<div class="row">
	
	
	
	

	<div class="col-md-8">
	<div class="box_style_2">
	<h1 style="margin-left:35%;">최근 주문 내역 </h1>
	<br>
	
<table class="type12" style="margin:auto;">
		<thead>
			<tr>
			<th>주소</th>
				<th colspan="4">키친네임 :<span>${order[0].kitchenName}</span></th>
			<th>요구 사항</th>
				
				
			</tr>
			</thead>
			<tbody>
			<tr>
			<td rowspan="2">
            ${order[0].address}</td>
             <td colspan="2"> 가격 :${order[0].payAmt} </td>
               <td colspan="2">날짜 :${order[0].time}</td>
               <td rowspan="2">${order[0].msg}</td>   
            </tr>
            <tr>
            
            <td colspan="2" id="orders">주문번호:<br>${order[0].id}</td>
                <td colspan="2"><a href="${pageContext.request.contextPath}/member/${order[0].id}/mypage/orderinfoDetail"><button type="button" id ="col" class="btn btn-submit2">상세설명 보기</button></a></td> 
                    
                    
            </tr>
            <tr>
                   

            </tr>
                       
			</tbody>
	</table>
<br><br><br>
<table class="type12" style="margin:auto;">
		<thead>
			<tr>
			<th>주소</th>
				<th colspan="4">키친네임 :<span>${order[1].kitchenName}</span></th>
			<th>요구 사항</th>
				
				
			</tr>
			</thead>
			<tbody>
			<tr>
			<td rowspan="2">
            ${order[1].address}</td>
             <td colspan="2"> 가격 :${order[1].payAmt} </td>
               <td colspan="2">날짜 :${order[1].time}</td>
               <td rowspan="2">${order[1].msg}</td>   
            </tr>
            <tr>
            
            <td colspan="2">주문번호:<br>${order[1].id}</td>
                <td colspan="2"><a href="${pageContext.request.contextPath}/member/${order[1].id}/mypage/orderinfoDetail"><button type="button" class="btn btn-submit">상세설명 보기</button></a></td> 
                    
                    
            </tr>
            <tr>
                   

            </tr>
                       
			</tbody>
	</table>
	
	<br><br><br>
	
	<table class="type12" style="margin:auto;">
		<thead>
			<tr>
			<th>주소</th>
				<th colspan="4">키친네임 :<span>${order[2].kitchenName}</span></th>
			<th>요구 사항</th>
				
				
			</tr>
			</thead>
			<tbody>
			<tr>
			<td rowspan="2">
            ${order[2].address}</td>
             <td colspan="2"> 가격 :${order[2].payAmt} </td>
               <td colspan="2">날짜 :${order[2].time}</td>
               <td rowspan="2">${order[2].msg}</td>   
            </tr>
            <tr>
            
            <td colspan="2">주문번호:<br>${order[2].id}</td>
                <td colspan="2"><a href="${pageContext.request.contextPath}/member/${order[2].id}/mypage/orderinfoDetail"><button type="button" class="btn btn-submit">상세설명 보기</button></a></td> 
                    
                    
            </tr>
            <tr>
                   

            </tr>
                       
			</tbody>
	</table>
	</div>
	</div>
	</div>
	</div>
	
	
	
		<!-- 위쪽 헤더바  -->
	<jsp:include page="../include/footer.jsp" />
	<!-- 헤드 끝 -->
		
		
</body>
</html>