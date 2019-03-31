
    /*var order = {"태주네 떡볶이":{"id":"order201903160","bizName":"태주네 떡볶이","phone":"010-1111-8888","address":"두식이네집","time":"2019-03-26 01:53:33.0","status":"주문 대기 상태","kitchenName":"종각점","method":"kakaoPay","msg":"빨리오세요","payAmt":10500,"menus":{"찹쌀순대":{"menuPrice":3500,"quantity":1,"totalAmt":3500,"option":{"없음":0}},"모듬 튀김":{"menuPrice":4000,"quantity":1,"totalAmt":4000,"option":{"없음":0}},"떡볶이":{"menuPrice":3000,"quantity":1,"totalAmt":3000,"option":{"매우 매움":0}}}}};*/
	

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
         
			$('#orderBox').append(StringHTML);