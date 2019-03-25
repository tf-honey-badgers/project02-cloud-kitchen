<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <link rel="apple-touch-icon" sizes="76x76" href="/business/resources/img/apple-icon.png">
    <link rel="icon" type="image/png" href="/business/resources/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>
        Material Dashboard by Creative Tim
    </title>
    
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="/business/resources/css/order.css?v=2.1.1" rel="stylesheet" />
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
                            <div class="orderListWrap common">
                            
                            </div>
                            
                        </div>
                        
                        
                        <!-- ================================================================================================ -->
                        
                        <div id="waitArea" class="col-md-6" >
                            <h4 class="card-title">주문 대기 현황</h4>
                            <div class="waitAreaWrap common">
                            
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
    
  			<!-- Footer -->
            <jsp:include page="../include/footer.jsp" flush="false"></jsp:include>
            <!-- End Footer -->
        </div>
    </div>
    <div id="notifydiv"></div>
    <!--   Core JS Files   -->
    <script src="/business/resources/js/core/jquery.min.js"></script>
    <script src="/business/resources/js/core/popper.min.js"></script>
    <script src="/business/resources/js/core/bootstrap-material-design.min.js"></script>
    <script src="/business/resources/js/plugins/perfect-scrollbar.jquery.min.js"></script>
    <!-- Plugin for the momentJs  -->
    <script src="/business/resources/js/plugins/moment.min.js"></script>
    <!--  Plugin for Sweet Alert -->
    <script src="/business/resources/js/plugins/sweetalert2.js"></script>
    <!-- Forms Validations Plugin -->
    <script src="/business/resources/js/plugins/jquery.validate.min.js"></script>
    <!-- Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
    <script src="/business/resources/js/plugins/jquery.bootstrap-wizard.js"></script>
    <!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
    <script src="/business/resources/js/plugins/bootstrap-selectpicker.js"></script>
    <!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
    <script src="/business/resources/js/plugins/bootstrap-datetimepicker.min.js"></script>
    <!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
    <script src="/business/resources/js/plugins/jquery.dataTables.min.js"></script>
    <!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
    <script src="/business/resources/js/plugins/bootstrap-tagsinput.js"></script>
    <!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
    <script src="/business/resources/js/plugins/jasny-bootstrap.min.js"></script>
    <!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
    <script src="/business/resources/js/plugins/fullcalendar.min.js"></script>
    <!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
    <script src="/business/resources/js/plugins/jquery-jvectormap.js"></script>
    <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
    <script src="/business/resources/js/plugins/nouislider.min.js"></script>
    <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
    <!-- Library for adding dinamically elements -->
    <script src="/business/resources/js/plugins/arrive.min.js"></script>
    <!--  Google Maps Plugin    -->
<!--    <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>-->
    <!-- Chartist JS -->
    <script src="/business/resources/js/plugins/chartist.min.js"></script>
    <!--  Notifications Plugin    -->
    <script src="/business/resources/js/plugins/bootstrap-notify2.js"></script>
    <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
    <script src="/business/resources/js/material-dashboard.js?v=2.1.1" type="text/javascript"></script>
    <script src="/business/resources/js/order.js" type="text/javascript"></script>
    <!-- firebase -->
      <script src="https://www.gstatic.com/firebasejs/5.9.0/firebase.js"></script>

   
    <script>
        $(document).ready(function() {
            //init DateTimePickers
            md.initFormExtendedDatetimepickers();
            
            //주문상세 보기 toggle 
             $('body').on('click','.ordTgg', function(event){
                $(this).siblings('.detailOrder').stop().slideToggle();
                
            }) 
            
            var url='';
            var bizId='';
            var orderId='';
            var status='';
             
            
            //주문 접수 눌렀을 때
            $('body').on('click', '.confirm', function(e){
            	//부모에게 물려받은 이벤트 멈춰버림 
            	e.stopPropagation();
            	$(this).siblings().css({display:'none'})
            	$(this).parents('div[class="alert alert-info ordTgg"]').removeClass('alert-info').addClass('alert-success');
            	$(this).removeClass('btn-primary confirm').addClass('btn-warning cooking')
            	$(this).attr({'value': '조리시작'})
            	$(this).parents('div[class="ORD"]').appendTo('.orderListWrap')
            	orderId=$(this).parents('div.ORD').attr('id')
            	status='ORD002'
            	url='biz_1/'+orderId+'/'+status
            	updateStatus(url)
            });
            // 조리시작 눌렀을 때
             $('body').on('click', '.cooking', function(e){
            	 e.stopPropagation();
            	 console.log($(this).parents('div[class="alert ordTgg alert-success"]').removeClass('alert-success').addClass('alert-warning'))
            	 $(this).removeClass('btn-warning cooking').addClass('btn-danger complete')
            	 $(this).attr({'value': '조리완료'})
            	 orderId=$(this).parents('div.ORD').attr('id')
            	 status='ORD003'
            	 url='biz_1/'+orderId+'/'+status
            	 updateStatus(url)
            	 
            	 
            	 
             });
             //조리완료 눌렀을때
             $('body').on('click', '.complete', function(e){
            	 e.stopPropagation();
            	 status='ORD004'
                 url='biz_1/'+orderId+'/'+status
                 updateStatus(url)
            	 $(this).parents('div.ORD').remove()
                	 
             });
		  
            
    
        });
        
        /* 1. firebase 이벤트 --------------------------------------------------------------------- */
        
         
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
		  var dbRef = firebase.database().ref('biz_1').orderByChild('time').limitToLast(3);
		  
		  
/* 		  var dbRef = firebase.database().ref('biz_2').orderByChild('time').limitToLast(1); */


		  
		  //
		  var n=0
		  
		  dbRef.on('value', function(snapshot){
		  var obj = snapshot.val()
		  console.log(obj)
		  
		  //
		  for(var i  in obj){
			  var orderId = Object.keys(obj)[n];
			  var orderInfo = obj[Object.keys(obj)[n++]];
			  console.log(orderId)
			  
			  
			  
			  
			 
			//firebase 트리거 사용하려면  다시 다 뒤집어야 해서.. 임시방편으로 한번 들어온 값은 업데이트가 되어도 다시 알람 뜨지 않게  만등
			// 값이 들어올때만다 localStrorage에 키: 값 넣어놔서 다음에 들어온 알람과 비교
			  
		 	//i 는 key 역할이고  value 반납하는데 value 가 orderId 랑 같지 않으면  저장하려고 함  저장할 때  key 값은 숫자로...
		 	  for (var i=1; i <= localStorage.length; i++)  {
		 		  
		 		  if(localStorage.getItem(orderId)!=orderId){
					console.log('.......................................')
			  		//localStorage.setItem(orderId, orderId);
			  		
					  $('<div id="'+orderId+'" class="ORD" >'
							  	+'<div class="alert alert-info ordTgg"> '
								+'<span style="display:inline-block"><b>[주문번호]&nbsp;</b>'+orderId+'</span>'
								+'<span class="float-right">'
								+'<input type="button" class="btn btn-primary btn-sm confirm" value="접수">'
								+'<input type="button" class="btn btn-primary btn-sm cancel" value="취소">'
								+'</span></div>'
								+'<div class="detailOrder alert alert-light bg-light" style="border: 1px solid black; display: none;">'
								+'<h4 class="alert-heading font-weight-bold">주문 상세 </h4>'
							  	+'<table><tbody><tr><th scope="row">주소</th>'
							  	+'<td class="pl-2">dsfsd'+'</td></tr>'
							  	+'<tr><th scope="row" >주문 상태</th>'
							  	+'<td class="pl-2">'+'</td></tr>'
							  	+'<tr><th scope="row" >주문 시간</th>'
							  	+'<td class="pl-2">'+'</td></tr>'
							  	+'<tr><th scope="row">요청사항</th><td class="pl-2">'+'</td></tr></tbody></table>'
							  	+'<table class="table table-striped table-hover"><thead class="thead-dark"><th scope="col">메뉴 이름</th><th scope="col">옵션</th><th scope="col">수량</th></thead> <tbody>'
							  	+'<tr><td>'+'</td><td>'+'</td><td>'+'</td></tr>'
							  	+'<tr><td>'+'</td><td>'+'</td><td>'+'</td></tr></tbody></table></div></div>'
							  )
								.appendTo('.waitAreaWrap')
		 		  }
				} 
			  
		
			  
			 
			  
			 // console.log(orderInfo)
			  //
		  }
			  
		 })
		 
		 /* --------------------------------------------------------------------- */
		 
		 function updateStatus(url){
			  //order/{bizId}/{orderId}/{status}
			  
			  $.ajax(url, {
				  method: "put",
				  dataType: "json"
				});
			  
		  }
		  
		 
		 
		  
		  
		  
    </script>
</body>

</html>

