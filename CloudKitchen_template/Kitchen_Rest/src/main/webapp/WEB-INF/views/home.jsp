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
<%-- <c:out value="test12345"></c:out> --%>
<h1>
	Rest Test페이지 입니다.
</h1>
		custIdx : <input type="text" value="" id="cust_Idx"><br>
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
    	<input type="button" id="nameclassification" value="메뉴카테고리분류"><br><br><br><br>
    	
    	1번항목(인기메뉴/일반메뉴/세트메뉴/음료/기타 등 카테고리를 입력해주세요)<br>
    	메뉴 카테고리 name : <input type="text" value="인기메뉴" name="mcName" id="menuCategoryName"><br>
    	메뉴 카테고리 biz_id: <input type="text" value="biz_4" name="mcBizId" id="menuCategoryBizId"><br><br>
    	
     	2번항목<br>
    	메뉴 name : <input type="text" value="간장치킨" name="mName" id="menuVoName"><br>
		메뉴 basic_price : <input type="text" value="16000" name="mBasicPrice" id="menuVoBasicPrice"><br>
		메뉴 photo : <input type="text" value="없어" name="mPhoto" id="menuVoPhoto"><br><br>
		
		3번항목<br>
		해당메뉴의 옵션3-1 cat name : <input type="text" value="반반" name="menuOptClVoEx[0].mocName" id="menuOptClVoName1"><br>
		해당메뉴의 옵션3-1 cat menu_opt_type : <input type="text" value="OTP001" name="menuOptClVoEx[0].mocMenuOptType" id="menuOptClVoMenuOptType1"><br>
		
		해당메뉴의 옵션3-2 cat name : <input type="text" value="순살" name="menuOptClVoEx[1].mocName" id="menuOptClVoName2"><br>
		해당메뉴의 옵션3-2 cat menu_opt_type : <input type="text" value="OTP001" name="menuOptClVoEx[1].mocMenuOptType" id="menuOptClVoMenuOptType2"><br><br>
		
		4번항목<br>
		해당메뉴의 옵션4-1 name : <input type="text" value="간장반핫양념반" name="menuOptVoEx[0].moName" id="menuOptVoName1"><br>
		해당메뉴의 옵션4-1 add_price : <input type="text" value="3000" name="menuOptVoEx[0].moAddPrice" id="menuOptVoAddPrice1"><br>
		
		해당메뉴의 옵션4-2 name : <input type="text" value="순살변경" name="menuOptVoEx[1].menu_option" id="menuOptVoName2"><br>
		해당메뉴의 옵션4-2 add_price : <input type="text" value="2000" name="menuOptVoEx[1].menu_option" id="menuOptVoAddPrice2"><br>
		<input type="button" id="RegisterMenu" value="메뉴등록">
		<input type="button" id="RegisterMenu" value="메뉴등록">
		<input type="button" id="RegisterOnlyMenu" value="메뉴만등록"><br><br>
		
		삭제할 메뉴Idx : <input type="text" id="deleteMenuIdx"><input type="button" id="deleteMenu" value="메뉴삭제"><br>
		삭제할 메뉴Idx : <input type="text" id="deleteMenuIdx"><input type="button" id="deleteMenu" value="메뉴옵션삭제"><br>

		<input type="text" value="" id="menuIdx"> <input type="button" id="RegisterOnlyOpt" value="옵션만등록"><br><br>
		삭제할 메뉴Idx : <input type="text" id="deleteMenuIdx">
		<input type="button" id="deleteMenu" value="메뉴삭제"><br><br>
		삭제할 메뉴옵션Idx : <input type="text" id="deleteMenuOptIdx">
		<input type="button" id="deleteOptMenu" value="메뉴옵션삭제"><br><br>
		
		변경할 메뉴Idx : <input type="text" id="updateMenuIdx"><br>
		변경할 메뉴Name : <input type="text" id="updateMenuName" value=""><br>
		변경할 메뉴Price : <input type="text" id="updateMenuPrice" value=""><br>
		변경할 메뉴Photo : <input type="text" id="updateMenuPhoto" value=""><br>
		<input type="button" id="updateMenu" value="메뉴변경"><br><br>
		
		변경할 메뉴옵션Idx : <input type="text" id="updateMenuOptIdx"><br>
		변경할 메뉴옵션Name : <input type="text" id="updateMenuOptMenu" value=""><br>
		변경할 메뉴옵션Price : <input type="text" id="updateMenuOptPrice" value=""><br>
		<input type="button" id="updateMenuOpt" value="메뉴옵션변경"><br><br>
		

</body>
<script>
	$(document).ready(function(e){
		
		// 해당메뉴 옵션만 변경
		$('#updateMenuOpt').on('click',function(e){
			$.ajax({
        		type : "POST",
        		url : "./bizmenu/updateMenuOpt.json",
         		data : {
         			moCode : $('#updateMenuOptIdx').val(),
         			moName : $('#updateMenuOptMenu').val(),
         			moAddPrice : $('#updateMenuOptPrice').val()
        		},
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
		// 해당메뉴내용만 변경
		$('#updateMenu').on('click',function(e){
			$.ajax({
        		type : "POST",
        		url : "./bizmenu/updateMenu.json",
         		data : {
         			mCode : $('#updateMenuIdx').val(),
         			mName : $('#updateMenuName').val(),
         			mBasicPrice : $('#updateMenuPrice').val(),
         			mPhoto : $('#updateMenuPhoto').val()
        		},
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
		// 해당메뉴에 옵션만 등록
		$('#RegisterOnlyOpt').on('click',function(e){
			$.ajax({
        		type : "POST",
        		url : "./bizmenu/addOnlyOpt.json",
         		data : {
         			'menuIdx' : $('#menuIdx').val(),
         			'menuOptCl[0].mocName' : $('#menuOptClVoName1').val(),
         			'menuOptCl[0].mocMenuOptType' : $('#menuOptClVoMenuOptType1').val(),
         			'menuOptCl[1].mocName' : $('#menuOptClVoName2').val(),
         			'menuOptCl[1].mocMenuOptType' : $('#menuOptClVoMenuOptType2').val(),
         			'menuOptEx[0].moName' : $('#menuOptVoName1').val(),
         			'menuOptEx[0].moAddPrice' : $('#menuOptVoAddPrice1').val(),
         			'menuOptEx[1].moName' : $('#menuOptVoName2').val(),
         			'menuOptEx[1].moAddPrice' : $('#menuOptVoAddPrice2').val() 
        		},
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
		// 메뉴만 등록
		$('#RegisterOnlyMenu').on('click',function(e){
			$.ajax({
        		type : "POST",
        		url : "./bizmenu/addOnlyOpt.json",
         		data : {
          			'mcName' : $('#menuCategoryName').val(),
         			'mcBizId' : $('#menuCategoryBizId').val(),
         			'mName' : $('#menuVoName').val(),
         			'mBasicPrice' : $('#menuVoBasicPrice').val(),
         			'mPhoto' : $('#menuVoPhoto').val()
        		},
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
		// 메뉴옵션 삭제
		$('#deleteOptMenu').on('click',function(e){
			$.ajax({
        		type : "POST",
        		url : "./bizmenu/deleteMenuOpt.json",
         		data : {
         			menuOptIdx : $('#deleteMenuOptIdx').val()
        		},
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
		// 메뉴옵션 삭제
		$('#deleteOptMenu').on('click',function(e){
			$.ajax({
        		type : "POST",
        		url : "./bizmenu/deleteMenuOpt.json",
         		data : {
         			menuOptIdx : $('#deleteMenuOptIdx').val()
        		},
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
		// 메뉴 삭제, property = cascade
		$('#deleteMenu').on('click',function(e){
			$.ajax({
        		type : "POST",
        		url : "./bizmenu/deletemenu.json",
         		data : {
         			menuIdx : $('#deleteMenuIdx').val()
        		},
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
		// 해당 가게에 정보 및 메뉴 불러오기
		$('#RegisterMenu').on('click',function(e){
	
			$.ajax({
        		type : "POST",
        		url : "./bizmenu/addmenu.json",
         		data : {
          			'mcName' : $('#menuCategoryName').val(),
         			'mcBizId' : $('#menuCategoryBizId').val(),
         			'mName' : $('#menuVoName').val(),
         			'mBasicPrice' : $('#menuVoBasicPrice').val(),
         			'mPhoto' : $('#menuVoPhoto').val(),
         			'menuOptCl[0].mocName' : $('#menuOptClVoName1').val(),
         			'menuOptCl[0].mocMenuOptType' : $('#menuOptClVoMenuOptType1').val(),
         			'menuOptCl[1].mocName' : $('#menuOptClVoName2').val(),
         			'menuOptCl[1].mocMenuOptType' : $('#menuOptClVoMenuOptType2').val(),
         			'menuOptEx[0].moName' : $('#menuOptVoName1').val(),
         			'menuOptEx[0].moAddPrice' : $('#menuOptVoAddPrice1').val(),
         			'menuOptEx[1].moName' : $('#menuOptVoName2').val(),
         			'menuOptEx[1].moAddPrice' : $('#menuOptVoAddPrice2').val() 
        		}, 
        		error : function(data){
        			console.log(data);
        		},
        		success : function(data){
        			console.log(data);
        		} // success
        	});	// post ajax끝
		});	// kitchenbranch clic 끝
		
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
         			bizId : $('#biz_id').val()
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
        		type : "GET", 
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
