 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="utf-8">
    <title>ErrorPage</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    <!-- Favicons-->
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="apple-touch-icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/error/img/apple-touch-icon-57x57-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="72x72" href="${pageContext.request.contextPath}/resources/error/img/apple-touch-icon-72x72-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="114x114" href="${pageContext.request.contextPath}/resources/error/img/apple-touch-icon-114x114-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="144x144" href="${pageContext.request.contextPath}/resources/error/img/apple-touch-icon-144x144-precomposed.png">
    
    <!-- CSS -->
    <link href="${pageContext.request.contextPath}/resources/error/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/error/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/error/fontello/css/fontello.css" rel="stylesheet" > 
    <link href="${pageContext.request.contextPath}/resources/error/fontello/css/animation.css" rel="stylesheet" > 
  
  </head>
  <body>
  
<div id="wrapper">
	<div id="main">
		<div class="container">
			
			<div class="row countdown">
            	<div class="col-md-12">
                	<div id="logo"><img src="${pageContext.request.contextPath}/resources/img/logo.png" width="190"  alt="" data-retina="true"></div>
                    <h1>SORRY!</h1>
                   <!--  <h2>We're temporary Under Construction. We will be Back soon!</h2> -->
                    <h2>${msg }</h2>
                </div>
				<div id="countdown_wp">
                    <div class="container_count"><div id="days">00</div>days</div>
                    <div class="container_count"><div id="hours">00</div>hours</div>
                    <div class="container_count"><div id="minutes">00</div>minutes</div>
                    <div class="container_count last"><div id="seconds">00</div>seconds</div>
                </div>
			</div>
            <div class="row">
						<div class="col-md-6 col-md-offset-3">
                        <div id="newsletter_wp" >
                                   <div class="row" id="newsletter" name="newsletter"  autocomplete="off">
                                       <div class="col-md-12 nogutter">
                                               <a class="btn-check" id="submit-newsletter" href="${pageContext.request.contextPath}/main">GO BACK HOME</a>
                                       </div>
                                   </div>
                                <div id="message-newsletter"></div>                        
                            </div>
                        </div>	
                    </div>
                    <div id="social_footer">
                        <ul>
                            <li><a href="#"><i class="icon-facebook"></i></a></li>
                            <li><a href="#"><i class="icon-twitter"></i></a></li>
                            <li><a href="#"><i class="icon-google"></i></a></li>
                            <li><a href="#"><i class="icon-vimeo"></i></a></li>
                            <li><a href="#"><i class="icon-youtube-play"></i></a></li>
                        </ul>
                        <p>© QuickFood 2015</p>
                    </div>            
		</div><!-- End container -->
	</div><!-- End main -->	
</div>

<div id="slides">
	<ul class="slides-container">
		<li><img src="${pageContext.request.contextPath}/resources/error/img/error_bg1.jpg" alt=""></li>
		<li><img src="${pageContext.request.contextPath}/resources/error/img/error_bg2.jpg" alt=""></li>
		<li><img src="${pageContext.request.contextPath}/resources/error/img/error_bg3.jpg" alt=""></li>
	</ul>
</div><!-- End background slider -->

<!-- JQUERY -->
<script src="${pageContext.request.contextPath}/resources/error/js/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/error/js/jquery.easing.1.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/error/js/jquery.animate-enhanced.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/error/js/jquery.superslides.min.js"></script>
<script  type="text/javascript">
  $('#slides').superslides({
	  play: 6000,
	  pagination:false,
	  animation_speed: 800,
      animation: 'fade'
    });
</script>
<!-- OTHER JS --> 
<script src="${pageContext.request.contextPath}/resources/error/js/retina.min.js"></script>
<script  src="${pageContext.request.contextPath}/resources/error/js/functions.js"></script>
<script src="${pageContext.request.contextPath}/resources/error/assets/validate.js"></script>

  </body>
</html>