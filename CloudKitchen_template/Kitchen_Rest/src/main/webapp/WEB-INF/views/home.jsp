<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<h1>
	Rest Test페이지 입니다.
</h1>
		custIdx : <input type="text" value="" id="cust_Idx">
		bizId : <input type="text" value="" id="biz_id"><br><br>
    	<input type="button" id="recommendation" value="추천받기">
    	<input type="button" id="review" value="리뷰내역">
    	<input type="button" id="kitchenbranch" value="지점보기">
    	<input type="button" id="biz" value="해당지점가게현황">
    	<input type="button" id="bizinfo" value="가게메뉴및정보">
</body>
<script>
	$(document).ready(function(e){
		
		// 해당 가게에 정보 및 메뉴 불러오기
		$('#bizinfo').on('click',function(e){
			$.ajax({
        		type : "POST",
        		url : "./kitchenbranch/bizinfo",
/*         		data : {
        			bizid : $('#"biz_id"').val()
        		}, */
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
	
		// 해당 지점에 가게 불러오기
		$('#biz').on('click',function(e){
			$.ajax({
        		type : "POST", 
        		url : "./kitchenbranch/bizlist",
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
		// 키친 지점불러오기
		$('#kitchenbranch').on('click',function(e){
			$.ajax({
        		type : "POST", 
        		url : "./kitchenbranch/kitchenlist",
        		error : function(data){
        			console.log(data);
        		},
        		
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
		// 리뷰관련
		$('#recommendation').on('click',function(e){
			console.log($('#cust_Idx').val());
			$.ajax({
        		type : "POST", 
        		url : "./review/recommendation",
        		data : {
        			idx : $('#cust_Idx').val()
        		},
        		error : function(data){
        			console.log(data);
        		},
        		
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// btn clic 끝
		
		
		$('#review').on('click',function(e){

			$.ajax({
        		type : "POST", 
        		url : "./review/list",
        		error : function(data){
        			console.log(data);
        		},
        		
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// btn clic 끝

	});
	// 리뷰관련 끝
</script>
	

</html>
