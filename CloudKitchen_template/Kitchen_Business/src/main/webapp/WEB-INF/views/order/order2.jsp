<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
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
                        <div class="col-md-6">
                            <h4 class="card-title">Notifications Style</h4>
                      
                         
                                 <div class="alert alert-success alert-with-icon" data-notify="container">
                                <i class="material-icons" data-notify="icon">add_alert</i>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span data-notify="message">This is a notification with close button and icon and have many lines. You can see that the icon and the close button are always vertically aligned. This is a beautiful notification. So you don't have to worry about the style.</span>
                            </div>
                                 <div class="alert alert-success alert-with-icon" data-notify="container">
                                <i class="material-icons" data-notify="icon">add_alert</i>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span data-notify="message">This is a notification with close button and icon and have many lines. You can see that the icon and the close button are always vertically aligned. This is a beautiful notification. So you don't have to worry about the style.</span>
                            </div>
                                 <div class="alert alert-success alert-with-icon" data-notify="container">
                                <i class="material-icons" data-notify="icon">add_alert</i>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span data-notify="message">This is a notification with close button and icon and have many lines. You can see that the icon and the close button are always vertically aligned. This is a beautiful notification. So you don't have to worry about the style.</span>
                            </div>
                                 <div class="alert alert-success alert-with-icon" data-notify="container">
                                <i class="material-icons" data-notify="icon">add_alert</i>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span data-notify="message">This is a notification with close button and icon and have many lines. You can see that the icon and the close button are always vertically aligned. This is a beautiful notification. So you don't have to worry about the style.</span>
                            </div>
                                 <div class="alert alert-info alert-with-icon" data-notify="container">
                                <i class="material-icons" data-notify="icon">add_alert</i>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span data-notify="message">This is a notification with close button and icon and have many lines. You can see that the icon and the close button are always vertically aligned. This is a beautiful notification. So you don't have to worry about the style.</span>
                            </div>
                                 <div class="alert alert-info alert-with-icon" data-notify="container">
                                <i class="material-icons" data-notify="icon">add_alert</i>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span data-notify="message">This is a notification with close button and icon and have many lines. You can see that the icon and the close button are always vertically aligned. This is a beautiful notification. So you don't have to worry about the style.</span>
                            </div>
                                 <div class="alert alert-info alert-with-icon" data-notify="container">
                                <i class="material-icons" data-notify="icon">add_alert</i>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span data-notify="message">This is a notification with close button and icon and have many lines. You can see that the icon and the close button are always vertically aligned. This is a beautiful notification. So you don't have to worry about the style.</span>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <h4 class="card-title">Notification states</h4>
                            <div class="alert alert-info">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span>
                                    <b> 주문 대기 상태 - </b></span>
                            </div>
                            <div class="alert alert-success">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span>
                                    <b> 주문 접수 상태</b></span>
                            </div>
                            <div class="alert alert-warning">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span>
                                    <b> 조리 중 상태</b> </span>
                            </div>
                            <div class="alert alert-danger">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span>
                                    <b> 주문 취소 및 거부 상태</b> </span>
                            </div>
                            <div class="alert alert-primary">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span>
                                    <b> 조리 완료 상태 </b> </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="places-buttons">
                        <div class="row">
                            <div class="col-md-6 ml-auto mr-auto text-center">
                            
                       <!--         <h4 class="card-title">
                                    Notifications Places
                                    <p class="category">Click to view notifications</p>
                                </h4>-->
                            </div>
                        </div>
                        <div class="row">

                            <div class="col-md-4">
                                <button class="btn btn-primary btn-block" onclick="notifyOrder('bottom','right','order12345')">Bottom Right</button>
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
    
    
<!--    <footer class="footer">
        <div class="container-fluid">
            <nav class="float-left">
                <ul>
                    <li>
                        <a href="https://www.creative-tim.com">
                            Creative Tim
                        </a>
                    </li>
                    <li>
                        <a href="https://creative-tim.com/presentation">
                            About Us
                        </a>
                    </li>
                    <li>
                        <a href="http://blog.creative-tim.com">
                            Blog
                        </a>
                    </li>
                    <li>
                        <a href="https://www.creative-tim.com/license">
                            Licenses
                        </a>
                    </li>
                </ul>
            </nav>
            <div class="copyright float-right">
                &copy;
                <script>
                    document.write(new Date().getFullYear())

                </script>, made with <i class="material-icons">favorite</i> by
                <a href="https://www.creative-tim.com" target="_blank">Creative Tim</a> for a better web.
            </div>
        </div>
    </footer>-->
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
            
    
        });
        
        
        /* 1. 알람 함수 -------------------------------------------------------- */
        function notifyOrder (from, align, orderId) {
        	  type = ['', 'info'/*, 'danger', 'success', 'warning', 'rose', 'primary'*/];
        	  color = Math.floor((Math.random() * 6) + 1);
        	  $.notify({
        	    icon: "add_alert",
        	    title: orderId,
        	    message: "<b>[주문번호]&nbsp;"+orderId+"</b>"
        	      +"<div><h6>[메뉴]&nbsp;페퍼로니M<span>[옵션]&nbsp; 치즈크러스트, 올리브추가</span><span>[수량]&nbsp;1</span><h6></div>",
        	    target:orderId
        	      ,order: orderId

        	  }, {
        	    type: type[color],
        	    timer: 600000,
        	    placement: {
        	      from: from,
        	      align: align
        	    }
        	  })
        	 };
        
        /* 2. firebase 이벤트 --------------------------------------------------------------------- */
        
         // Initialize Firebase
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
		  var dbRef = firebase.database().ref('biz_1').orderByChild('time');
		  
		  var test= firebase.database.ref('biz_1').oncreate();
		  
/* 		  var dbRef = firebase.database().ref('biz_2').orderByChild('time').limitToLast(1); */
		  
		  var orderId;
		  var orderInfo;
		  
		  
		  dbRef.on('value', function(snapshot){
		  var obj = snapshot.val()
		  console.log(obj)
		 
		  var n=0;
		  for(var i in obj){
			  var orderId = Object.keys(obj)[n];
					orderInfo = obj[Object.keys(obj)[n++]];
			/* 		console.log('orderId        : ',orderId)
			
					console.log('orderInfo      : ', orderInfo) */
					notifyOrder('bottom','right',orderId)
					
				$('body').on('click','#'+orderId+' .confirm',function(e){
		
				 
				 alert(orderId+'먹히나')
				})
				
				$('body').on('click', '#'+orderId+' span.alertTitle', function (e) {
					console.log(orderId)
					//클릭 전 offset 측정
					var currentOffset= $(this).parent().offset().top;
					$(this).siblings('.msg').toggle();
					//클릭 후 offset 측정
					var changedOffset= $(this).parent().offset().top;
					var height= currentOffset-changedOffset;
					//전- 후 높이 차이 계산
					console.log(currentOffset)
					console.log(changedOffset)
					console.log(height)
						console.log("-------------------------------------------------------------------------")
    				
					
					//this 보다 위에 있는 형제들만 추출해서 offset 변경해 줘야 함 
					
					//console.log($(this).parent().siblings())
					var t =$(this).parent().siblings();
					var idx =$(this).parent().index();
					console.log(idx)
					
					var o= $('div[id="notifydiv"] >div:gt('+idx+')')
					console.log($('div[id="notifydiv"] >div:gt('+idx+')'))
					$.each(o, function(idx, val){
/* 						console.log(idx)
						console.log(val) */
						var elementTop = $(this).offset().top-height;
						var elementBottom = elementTop + $(this).outerHeight()-height;
						console.log('top',elementTop)
						console.log('bottom',elementBottom)
						
						console.log("----------------------------------------------------------------------------")
					
						
						//$(this).offset({top:elementTop});
						//$(this).css({height: $(this).outerHeight()-height})
						$(this).css({
							'position':'absolute',
							'top':elementTop,
							'height':$(this).innerHeight()-50
							
						})


						
						
						
					})
					
					
					
    			  })
				  
				  
			}
			  
			  
		 })
		  
		  
		  
		  
		  
/* 		  dbRef.on('value', function(snapshot){
				console.log('새로들어온 주문 있음')		
				var obj=snapshot.val()
				var orderId = Object.keys(obj)[0];
				var orderInfo = obj[Object.keys(obj)[0]];
				console.log(orderId)
				console.log(orderInfo)
				notifyOrder('bottom','right',orderId)
				
				//알람 팝업이후 알림창에 넣어 주기 
				
				
			 $('body').on('click','#'+orderId+' .confirm',function(){
				 
				 alert('gkgkgkgk')
			 })
				
  		}); */
		  /* 
                            <div class="alert alert-success alert-with-icon" data-notify="container">
                                <i class="material-icons" data-notify="icon">add_alert</i>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span data-notify="message">hhh</span>
                            </div>
		  
		  */
		  
		  
    </script>
</body>

</html>

