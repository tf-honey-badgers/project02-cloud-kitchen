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
       	
        border: 1px solid #78cfcf;
      	border-radius: 50px 50px 50px 50px; 
    }
    div.left {
        width: 20%;
        height: 100%;
        float: left;
       box-sizing: border-box;
 /*         border: 1px solid #000; */
       
    }
    div.middle {
        width: 50%;
        float: left;
         height: 100%;
       box-sizing: border-box;
     /*     border: 1px solid #000; */
    
    }
    div.right{
    width:30%;
    float:right;
    height: 100%;
    box-sizing: border-box;
    
    }
    img{
    display:block;
    margin: 0px auto;
	border-radius: 50px 50px 50px 50px; 
    }
    div.left2{
     width: 50%;
     float: left;
     height: 100%;
     box-sizing: border-box;
    }
    div.right2{
     width: 50%;
        float: right;
         height: 100%;
       box-sizing: border-box;
    }

    
    </style>
    
</head>
<body>
	<!-- 위쪽 헤더바  -->
	<jsp:include page="include/header.jsp" />
	<jsp:include page="include/background.jsp" flush="false" />
	<!-- 헤드 끝 -->
	
	
	<div class="c">
	
	<div class="center">
	
	<div class="left2">
	<a class="strip_list grid" href="${pageContext.request.contextPath}/member/fav/${uid}/mypage">
	<h2>찜 가게로 이동</h2>
	 <img class="shopImg"  src="	https://img.lovepik.com/element/40052/1687.png_1200.png" alt="하트" style="width: 200px; height: 150px;">
	</a>
	</div>
	
	<div class="right2">
	<a class="strip_list grid" href="${pageContext.request.contextPath}/member/card">
	<h2>카드 관리 이동</h2>
	 <img class="shopImg"  src="https://circuitree.com/wp-content/uploads/2014/08/credit-card-71.png" alt="카드" style="width: 200px; height: 150px;">
	</a>
	</div>
	
	

	</div>
	
	</div>
	
	<br><br>
	<hr>
	
<div style="margin-left:45%;">
	
	<h2>2019.04</h2>
	</div>

		 <div class="c">
  <div class="center">
    <div class="left">
    <br>
     <img class="shopImg"  src="http://newsimg.hankookilbo.com/2014/08/19/201408191596070672_1.jpg" alt="피자" style="width: 200px; height: 150px;">
      </div>
      <div class="middle" >
         <h1>고르곤졸라</h1>
          <h1> 21,900 ￦  ㅣ  2019-04-01 </h1>
          
          <button type="button" class="btn btn-default" id="price2"><h4>결제 상세 내역 보기</h4></button> 
         
      </div>
      <div class="right">
    	 <h1>스톡홀름 1호점</h1>
     	<h1>02-222-2222</h1>
     	 <h1>유니네 피자</h1>
      </div>
    </div>
    </div>
    <br><br>
		 <div class="c">
  <div class="center">
    <div class="left">
    	<br>
    	<img class="shopImg"  src="https://media-cdn.tripadvisor.com/media/photo-s/0a/85/0a/ab/2.jpg" alt="피자" style="width: 200px; height: 150px;">
     		 </div>					
      		<div class="middle" >
        	  <h1>떡튀순</h1>
          	<h1>22,500 ￦ㅣ 2019-04-01 </h1>
          	
          	<button type="button" class="btn btn-default" id="price"><h4>결제 상세 내역 보기</h4></button>  
          
    	    </div>
      
     		 <div class="right">
     	    	<h1>스톡홀름 1호점</h1>
      			<h1>02-222-2222</h1>
      			<h1>태주네 떡볶이</h1>
     		 </div>
    </div>
   </div>		
    
		
		
		<table  class="type11" id="list" style="margin-left:17%;" >
		<thead>
			<tr>

				<th>키친 위치</th>
				<th>주소</th>
				<th>가게 이름</th>
				<th>메인 메뉴</th>
				<th>수량</th>
				<th>옵션</th>
				<th>주문 가격</th>
				
				
			</tr>
			</thead>
			<tbody id="t1">
			</tbody>
		</table>
		
	<br><br><br>
	
<table class="type11" id="list2" style="margin-left:17%; ">
<thead>
<tr>
<th>옵션</th>
<th>가격</th>
</tr>
</thead>
<tbody id="t2">
</tbody>

</table>

<table class="type11" id="list3" style="margin-left:17%; ">
<thead>
<tr>
<th>결제 방법</th>
<th>총 금액</th>
<th>남긴말 </th>
</tr>
</thead>
<tbody id="t3">
</tbody>
</table>
		
		<script>
		
	
		

		 var tbody = $('#t1');
		$(document).ready(function(){
	
			$.getJSON( 'http://13.209.21.25/rest/customer/${custId}/mypage/orderinfo', function(list){
				for(var i = 0, len = 5 || 0 ; i < len; i++){
					var tr = $('<tr></tr>');
					var kitchenName = $('<td id="'+ list[i].kitchenName +'">' + list[i].kitchenName + '</td>');
					var address = $('<td>' + list[i].address + '</td>');
					var bizName = $('<td>' + list[i].bizName + '</td>');
					var menuName = $('<td>' + list[i].menuName + '</td>');
					var quantity = $('<td>' + list[i].quantity + '</td>');
					var menuPrice = $('<td>' + list[i].menuPrice + '</td>');
					var totalAmt = $('<td>' + list[i].totalAmt + '</td>');

			
					
					tr.append(kitchenName).append(address).append(bizName).append(menuName).append(quantity).append(menuPrice).append(totalAmt);
					tbody.append(tr);
					console.log(list[i]);
				}
			});
		 
		
		});
		
		 var tbody2 = $('#t2');
			$(document).ready(function(){
		
				$.getJSON( 'http://13.209.21.25/rest/customer/${custId}/mypage/orderinfo', function(list2){
					
					for(var i = 0, len = 5 || 0 ; i < len; i++){
						var tr = $('<tr></tr>');
						var optName =  $('<td id="'+ list2[i].optName +'">' + list2[i].optName + '</td>');
						var optPrice = $('<td>' + list2[i].optPrice + '</td>');

				
						
						tr.append(optName).append(optPrice);
						tbody2.append(tr);
						console.log(list2[i]);
					}
				});
			 
			
			});
			 var tbody3 = $('#t3');
				$(document).ready(function(){
			
					$.getJSON( 'http://13.209.21.25/rest/customer/${custId}/mypage/orderinfo', function(list3){
						
						for(var i = 0, len = 5 || 0 ; i < len; i++){
							var tr = $('<tr></tr>');
							var method = $('<td id="'+ list3[i].method +'">' + list3[i].method + '</td>');
							var payAmt = $('<td>' + list3[i].payAmt + '</td>');
							var msg = $('<td>' + list3[i].msg + '</td>');

					
							
							tr.append(method).append(payAmt).append(msg);
							tbody3.append(tr);
							console.log(list3[i]);
						}
					});
				 
				
				});
	
		
		$('#price').on('click', function() {
		    var cons = document.getElementById("list");
		    if(cons.style.display=='none'){
		        cons.style.display = 'block';
		    }else{
		        cons.style.display = 'none';
		    }
		});
		
		$('#price2').on('click', function() {
		    var con = document.getElementById("list2");
		    if(con.style.display=='none'){
		        con.style.display = 'block';
		    }else{
		        con.style.display = 'none';
		    }
		});
		</script>
		
		
		
		
		
		<!-- 위쪽 헤더바  -->
	<jsp:include page="include/footer.jsp" />
	<!-- 헤드 끝 -->
		
		
</body>
</html>