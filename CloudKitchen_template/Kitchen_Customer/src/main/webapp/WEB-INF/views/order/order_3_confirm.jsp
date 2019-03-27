<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>payment Temp</title>
</head>
<body>
	<!--헤더 -->
	<!-- 위쪽 헤더바  -->
	<jsp:include page="../include/header.jsp" flush="false" />
	<!-- 주문 헤더 -->
	<jsp:include page="../include/header_order.jsp" flush="false" />
	
	<div id="position">
		<div class="container">
			<ul>
				<li><a href="#0">Home</a></li>
				<li><a href="#0">Category</a></li>
				<li>Page active</li>
			</ul>
			<a href="#0" class="search-overlay-menu-btn"><i
				class="icon-search-6"></i> Search</a>
		</div>
	</div>
	<!-- Position -->

	<!-- Content ================================================== -->
<div class="container margin_60_35">
	<div class="row">
		<div class="col-md-offset-3 col-md-6">
			<div class="box_style_2">
				<h2 class="inner">Order confirmed!</h2>
				<div id="confirm">
					<i class="icon_check_alt2"></i>
					<h3>주문 완료!</h3>
					<p>
						고객님이 주문하신 음식의 조리가 시작되면 실시간으로 주방의 모습을 확인하실 수 있습니다. 고객님의 핸드폰으로 발송된 링크를 통해 청결한 주방과 요리 과정을 확인하세요!
					</p>
				</div>
				<h4>주문 확인</h4>
				<div id="orderBox">
                </div>
			</div>
		</div>
	</div><!-- End row -->
</div><!-- End container -->
${list}
<!-- End Content =============================================== -->

	<!-- Footer 시작  -->
	<jsp:include page="../include/footer.jsp" flush="false" />
	<!-- Footer 끝  -->
	<script>
    
    var order = {"태주네 떡볶이":{"id":"order201903160","bizName":"태주네 떡볶이","phone":"010-1111-8888","address":"두식이네집","time":"2019-03-26 01:53:33.0","status":"주문 대기 상태","kitchenName":"종각점","method":"kakaoPay","msg":"빨리오세요","payAmt":10500,"menus":{"찹쌀순대":{"menuPrice":3500,"quantity":1,"totalAmt":3500,"option":{"없음":0}},"모듬 튀김":{"menuPrice":4000,"quantity":1,"totalAmt":4000,"option":{"없음":0}},"떡볶이":{"menuPrice":3000,"quantity":1,"totalAmt":3000,"option":{"매우 매움":0}}}}};
    
    var StringHTML="";

    
    var orderArr = Object.entries(order);
    var orderInfo = orderArr[0];
    var orders=[];
    
    for(i=0;i<orderArr.length;i++){
        var temp=orderArr[i];
        orders[i]=temp[1];
    }
    
    
    
    
              StringHTML =
                '<table class="table padding-4">'
                +'<tbody>'
                +'<tr>'
                +'<th class="th-color" scope="row">주문번호</th>'
                +'<td class="pl-2">'+orderInfo[1].id+'</td>'
                +'</tr>'
                +'<tr>'
                +'<th class="th-color" scope="row">연락번호</th>'
                +'<td class="pl-2">'+orderInfo[1].phone+'</td>'
                +'</tr>'
                +'<tr>'
                +'<th class="th-color" scope="row" >주소</th>'
                +'<td class="pl-2">'+orderInfo[1].address+'</td>'
                +'</tr>'
                +'<tr>'
                +'<th class="th-color" scope="row" >주문 시간</th>'
                +'<td class="pl-2">'+orderInfo[1].time+'</td>'
                +'</tr>'
                +'<tr>'
                +'<th class="th-color" scope="row">지점명</th>'
                +'<td class="pl-2">'+orderInfo[1].kitchenName+'</td>'
                +'</tr>'
                +'<tr>'
                +'<th class="th-color" scope="row">결제 수단</th>'
                +'<td class="pl-2">'+orderInfo[1].method+'</td>'
                +'</tr>'
                +'<tr>'
                +'<th class="th-color" scope="row">요청 메세지</th>'
                +'<td class="pl-2">'+orderInfo[1].msg+'</td>'
                +'</tr>'
                +'</tbody>'
                +'</table>';
    
    StringHTML =StringHTML
                +'<table class="table borderSeper">'
                +'<tbody>'
              
     $.each(orders, function(key,value){
         StringHTML =StringHTML
                +'<tr>'
                +'<td  class="bizName" colspan="2">'
                +value.bizName
                +'</td>'
                +'</tr>';
         
         $.each(value.menus, function(key,value2){
             StringHTML =StringHTML
                +'<tr>'
                +'<td>'
                +'<strong>'+value2.quantity+'x</strong> <span>'+key+'</span>'
                +'<ul>';
             
            
             $.each(value2.option,function(key, value3){
                 StringHTML =StringHTML
                     +'<li>'+key+'</li>';
                 
             })
             
             StringHTML =StringHTML
                +'</ul>'
                +'</td>'
                +'<td>'
                +'<strong class="stickRight">'+value2.menuPrice+'원</strong>'
                +'<ul class="ulNone">';
             
             
             $.each(value2.option,function(key, value3){
                 StringHTML =StringHTML
                     +'<li>+'+value3+'원</li>';
                 
             })
             
             StringHTML =StringHTML
                +'</ul>'
                +'</td>'
                +'</tr>'
                +'<tr class="menuCnt">'
                +'<td>'
                +'금액'
                +'</td>'
                +'<td class="stickRight">'
                +'<strong>'+value2.totalAmt+'원</strong>'
                +'</td>'
                +'</tr>';
                
             
         });
         
            
     });
    StringHTML =StringHTML
                +'<tr>'
                +'<td class="total_confirm">'
                +'결제액'
                +'</td>'
                +'<td class="total_confirm">'
                +'<span class="pull-right">'+orderInfo[1].payAmt+'원</span>'
                +'</td>'
                +'</tr>'
                +'</tbody>'
                +'</table>';
         
            console.log(StringHTML);
			$('#orderBox').append(StringHTML);
    
    
</script>
</body>
</html>