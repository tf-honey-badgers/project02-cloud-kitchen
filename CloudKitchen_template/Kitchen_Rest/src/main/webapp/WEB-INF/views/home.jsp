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
		bizIdx : <input type="text" value="" id="biz_idx"><br>
		bizId : <input type="text" value="" id="biz_id"><br>
		카테고리명 : <input type="text" value="" id="comname"><br>
		<br>
		<br>
    	<input type="button" id="recommendation" value="추천받기">
    	<input type="button" id="review" value="리뷰내역">
    	<input type="button" id="kitchenbranch" value="지점보기">
    	<input type="button" id="biz" value="해당지점가게현황">
    	<input type="button" id="bizinfo" value="가게메뉴및정보">
    	<input type="button" id="gpa" value="평점보기">
    	<input type="button" id="categorization" value="메뉴분류">
    	<input type="button" id="nameclassification" value="메뉴카테고리분류">
</body>
<script>
	$(document).ready(function(e){
		
		// 해당 가게에 정보 및 메뉴 불러오기
		$('#categorization').on('click',function(e){
			
			$.ajax({
        		type : "POST",
        		url : "./kitchenbranch/categorization.json",
/*          		data : {
         			gpa : $('#biz_id').val()
        		}, */
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
		// 해당 가게에 정보 및 메뉴 불러오기
		$('#bizinfo').on('click',function(e){
			$.ajax({
        		type : "POST",
        		url : "./kitchenbranch/bizinfo.json",
         		data : {
         			bizIdx : $('#biz_idx').val()
        		},
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
        		url : "./kitchenbranch/bizlist.json",
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
        		url : "./kitchenbranch/kitchenlist.json",
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
        		url : "./review/recommendation.json",
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
        		url : "./review/list.json",
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
			
		// 해당 가게에 정보 및 메뉴 불러오기
		$('#gpa').on('click',function(e){
			$.ajax({
        		type : "POST",
        		url : "./review/gpa.json",
         		data : {
         			gpa : $('#biz_id').val()
        		},
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data[0].bizId);
        			console.log(data[0].gpa);
        			console.log(data[0].cnt);
        			console.log('평점 : '+(data[0].gpa/data[0].cnt).toFixed(1));
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
		$('#nameclassification').on('click',function(e){
			$.ajax({
        		type : "POST",
        		url : "./kitchenbranch/nameclassification.json",
         		data : {
         			comName : $('#comname').val()
        		},
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
</script>
	

</html>
