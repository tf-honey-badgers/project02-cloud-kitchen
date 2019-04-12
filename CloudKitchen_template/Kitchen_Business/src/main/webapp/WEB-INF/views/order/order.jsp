<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/img/apple-icon.png">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>
        Material Dashboard by Creative Tim
    </title>
    
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="${pageContext.request.contextPath}/resources/css/order.css?v=2.1.1" rel="stylesheet" />
</head>

<body class="">
    <!-- Preload -->
	<jsp:include page="../include/preload.jsp" flush="false"></jsp:include>
	<!-- End Preload -->
   	<div class="wrapper ">
        <!-- Sidebar -->
        <jsp:include page="../include/sidebar.jsp" flush="false"></jsp:include>
        <!-- End Sidebar -->
       <div class="main-panel">
            <!-- Header -->
            <jsp:include page="../include/header.jsp" flush="false"></jsp:include>
            <!-- End Header -->
    <div class="content">
        <div class="container-fluid">
            <div class="card">
                <div class="card-header card-header-primary">
                    <h3 class="card-title">Notifications</h3>
                    <p class="card-category">주문 실시간 알림
                    </p>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div id="orderList" class="col-md-6" >
                            <h4 class="card-title">주문 리스트</h4>
                            <div class="orderListWrap common rounded bg-dark">
                            
                            </div>
                            
                        </div>
                        
                        
                        <!-- ================================================================================================ -->
                        
                        <div id="waitArea" class="col-md-6" >
                            <h4 class="card-title">주문 대기 현황</h4>
                            <div class="waitAreaWrap common rounded bg-dark">
                            
	                        </div>
                        </div>
                        
                    </div>
                </div>
   
                <!---->
            </div>
            <!--card End-->
        </div>
        <!--container-fluid-->
    </div>
    
  			<%-- <!-- Footer -->
            <jsp:include page="../include/footer.jsp" flush="false"></jsp:include>
            <!-- End Footer --> --%>
        </div>
    </div>
    <div id="notifydiv"></div>
    <!--   Core JS Files   -->
    <script src="${pageContext.request.contextPath}/resources/js/core/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/core/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/core/bootstrap-material-design.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plugins/perfect-scrollbar.jquery.min.js"></script>
    <!-- Plugin for the momentJs  -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/moment.min.js"></script>
    <!--  Plugin for Sweet Alert -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/sweetalert2.js"></script>
    <!-- Forms Validations Plugin -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jquery.validate.min.js"></script>
    <!-- Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jquery.bootstrap-wizard.js"></script>
    <!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-selectpicker.js"></script>
    <!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-datetimepicker.min.js"></script>
    <!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jquery.dataTables.min.js"></script>
    <!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-tagsinput.js"></script>
    <!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jasny-bootstrap.min.js"></script>
    <!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/fullcalendar.min.js"></script>
    <!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jquery-jvectormap.js"></script>
    <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/nouislider.min.js"></script>
    <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
    <!-- Library for adding dinamically elements -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/arrive.min.js"></script>
    <!--  Google Maps Plugin    -->
<!--    <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>-->
    <!-- Chartist JS -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/chartist.min.js"></script>
    <!--  Notifications Plugin    -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-notify2.js"></script>
    <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
    <script src="${pageContext.request.contextPath}/resources/js/material-dashboard.js?v=2.1.1" type="text/javascript"></script>
<%--     <script src="${pageContext.request.contextPath}/resources/js/order.js" type="text/javascript"></script> --%>
    <!-- firebase -->
    <script src="https://www.gstatic.com/firebasejs/5.9.0/firebase.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/member/member-functions.js" type="text/javascript"></script>
   
    <script>
        $(document).ready(function() {
        	
        	
            //init DateTimePickers
            md.initFormExtendedDatetimepickers();
            
            //주문상세 보기 toggle 
             $('body').on('click','.ordTgg', function(event){
            	 $(this).parent().siblings().find('.detailOrder').hide()
                $(this).siblings('.detailOrder').stop().slideToggle();
                
            }) 
            
            var url='';
            var bizId='';
            var orderId='';
            var status='';
            var bizId ='${sessionScope.bizId}';
            
          	//취소 눌렀을때
            $('body').on('click', '.cancel', function(e){
           	 e.stopPropagation();
           	 orderId=$(this).parents('div.ORD').attr('id')
           	 status='ORD005'
                url=bizId+'/'+orderId+'/'+status
                updateStatus(url)
           	 $(this).parents('div.ORD').remove()
               	 
            });
            
            //주문 접수 눌렀을 때
            $('body').on('click', '.confirm', function(e){
            	//부모에게 물려받은 이벤트 멈춰버림 
            	e.stopPropagation();
            	$(this).siblings().css({display:'none'})
            	$(this).parents('div[class="alert ordTgg alert-info"]').removeClass('alert-info').addClass('alert-success');
            	$(this).removeClass('btn-primary confirm').addClass('btn-warning cooking')
            	$(this).attr({'value': '조리시작'})
            	$(this).parents('div[class="ORD"]').appendTo('.orderListWrap')
            	orderId=$(this).parents('div.ORD').attr('id')
            	status='ORD002'
            	url=bizId+'/'+orderId+'/'+status;
            	updateStatus(url)
            });
            // 조리시작 눌렀을 때
             $('body').on('click', '.cooking', function(e){
            	 e.stopPropagation();
            	 $(this).parents('div[class="alert ordTgg alert-success"]').removeClass('alert-success').addClass('alert-warning')
            	 $(this).removeClass('btn-warning cooking').addClass('btn-danger complete')
            	 $(this).attr({'value': '조리완료'})
            	 orderId=$(this).parents('div.ORD').attr('id')
            	 status='ORD003'
            	 url=bizId+'/'+orderId+'/'+status
            	 updateStatus(url)
             });
             //조리완료 눌렀을때
             $('body').on('click', '.complete', function(e){
            	 e.stopPropagation();
            	 orderId=$(this).parents('div.ORD').attr('id')
            	 status='ORD004'
                 url=bizId+'/'+orderId+'/'+status
                 updateStatus(url)
            	 $(this).parents('div.ORD').remove()
                	 
             });
            
		  
            
    
        });
        
        /* 1. firebase 이벤트 --------------------------------------------------------------------- */
          var bizId ='${sessionScope.bizId}';
            console.log(bizId)
         
 		  var config = {
		    apiKey: "AIzaSyDZ4Zt7FAQrf8ah4FDlGZU2-qLeinySOSs",
		    authDomain: "honeybadgers-d29cf.firebaseapp.com",
		    databaseURL: "https://honeybadgers-d29cf.firebaseio.com",
		    projectId: "honeybadgers-d29cf",
		    storageBucket: "honeybadgers-d29cf.appspot.com",
		    messagingSenderId: "595672061077"
		  };
		  firebase.initializeApp(config); 
		  
		  // biz_1이라는 사업자에 들어온 order 정보 중  time으로 orderby 하여 가장 최근에 들어온 주문 1개만 받을 수 있도록 제한함  
		  var dbRef = firebase.database().ref(bizId).orderByChild('time')/* .limitToLast(1) */;
			
		  //새로 들어온 주문에 대한 알람 설정 
 		  dbRef.on('child_added', function(snapshot){
			  var obj = snapshot.val()
			 // console.log(obj)
		  
			  var orderId =obj[Object.keys(obj)[1]];
			  var address= obj[Object.keys(obj)[0]];
			  var menus =obj[Object.keys(obj)[2]];
			  var msg =obj[Object.keys(obj)[3]];
			  var status =obj[Object.keys(obj)[5]];
			  var time =obj[Object.keys(obj)[6]];
			  
			  //주문번호 뿌려줄땐 고객아이디 안보이게 해서 뿌려주기 
			  var idx= orderId.indexOf('_')+1;
			  var trimedOrderId= orderId.substring(idx)
			  
		  	  // 주문 상태가 ORD001 일때만 알람이 뜸  접수 이후로는 알람 안뜸
		 	  if(status==='ORD001'){
				  notification(orderId,trimedOrderId,address,time,msg,'alert-info',ord001btn).appendTo('.waitAreaWrap');						  		   	  	
		  		  getMenu(orderId, menus);
			 	
			  }else if(status==='ORD002'){
				  notification(orderId,trimedOrderId,address,time,msg,'alert-success', ord002btn).appendTo('.orderListWrap');						  		   	  	
		  		  getMenu(orderId, menus); 
			  }else if(status==='ORD003'){
				  notification(orderId,trimedOrderId,address,time,msg,'alert-warning', ord003btn).appendTo('.orderListWrap');						  		   	  	
		  		  getMenu(orderId, menus);
				  
			  } 
			
			
		 })/* 알람설정 end */
		 
		 
		 /* --------------------------------------------------------------------- */
		 //주문상태 firebase로 실시간 업데이트 해주기
		 function updateStatus(url){
			  //order/{bizId}/{orderId}/{status}
			  
			  $.ajax(url, {
				  method: "put",
				  dataType: "json"
				});
			  
		  }
		  
		  var ord001btn= '<input type="button" class="btn btn-primary btn-sm confirm" value="접수"><input type="button" class="btn btn-primary btn-sm cancel" value="취소">'
		  var ord002btn='<input type="button" class="btn btn-warning btn-sm cooking" value="조리시작">';
		  var ord003btn='<input type="button" class="btn btn-danger btn-sm complete" value="조리완료">';
		//함수로 알람시 필요한 태그들 리턴 함 
		  function notification(orderId,trimedOrderId,address,time,msg, status,button){
			 return $('<div id="'+orderId+'" class="ORD" >'
						+'<div class="alert ordTgg '+status+'">'
						+'<span style="display:inline-block"><b>[주문번호]&nbsp;</b>'+trimedOrderId+'</span>'
						+'<span class="float-right">'
						+button
						+'</span></div>'
						+'<div class="detailOrder alert alert-light bg-light" style="border: 1px solid black; display: none;">'
						+'<h4 class="alert-heading font-weight-bold">주문 상세 </h4>'
					  	+'<table><tbody><tr><th scope="row">주소</th>'
					  	+'<td class="pl-2">'+address+'</td></tr>'
					  	+'<tr><th scope="row" >주문 시간</th>'
					  	+'<td class="pl-2">'+time+'</td></tr>'
					  	+'<tr><th scope="row">요청사항</th><td class="pl-2">'+msg+'</td></tr></tbody></table>'
					  	+'<table class="table table-striped table-hover"><thead class="thead-dark"><th scope="col">메뉴 이름</th><th scope="col">옵션</th><th scope="col">수량</th></thead> <tbody class="inputMenuInfo">'
					  	+'</tbody></table></div></div>'
					  )
		  }
		// 메뉴 뿌려주기 함수 
		  function getMenu(orderId, menus){
			  $.each(menus, function(key, value){
					 // console.log(key, value)
					  $('div[id='+orderId+'] .inputMenuInfo ').append('<tr value="'+orderId+key+'">')
					  $.each(value, function(k,v){
						  if(v=='null'){v=''}
						  //console.log(k, v)
						  $('.inputMenuInfo >tr[value="'+orderId+key+'"]').append('<td>'+v+'</td>')
					 })
			  }) 
		  }
		  
		 
		 
		  
		  
		  
    </script>
    
	<script type="text/javascript">
	    $(document).ready(function() {
	    	/* 사이드바 하이라이트된 바꾸기 */
	    	$('.nav-item').removeClass('active');
	    	$('.nav-item.sidebar-orders').addClass('active');
	    });
    </script>
</body>
</html>