<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>벌꿀오소리 클라우드 키친</title>
</head>
<body>
<!-- Headers ================================================== -->
  	<!-- 위쪽 헤더바  -->
    <jsp:include page="include/header.jsp" flush="false"/>
    <!-- 영상 및 주문  -->
	<jsp:include page="include/main_subheader.jsp" flush="false"/>
<!-- End Headers ================================================== -->

<!-- Content ================================================== -->

    <div class="container margin_60">
		<div class="main_title">
            <h2 class="nomargin_top" style="padding-top:0">클라우드 키친이란?</h2>

        </div>
        <div class="row">
            <div class="col-md-3">
                <div class="box_home" id="one">
                    <span>1</span>
                    <h3>근처 키친 찾기</h3>
                </div>
            </div>
            <div class="col-md-3">
                <div class="box_home" id="two">
                    <span>2</span>
                    <h3>다양한 가게 선택 </h3>
                </div>
            </div>
            <div class="col-md-3">
                <div class="box_home" id="three">
                    <span>3</span>
                    <h3>빠르고 간편하게 결제</h3>
                </div>
            </div>
            <div class="col-md-3">
                <div class="box_home" id="four">
                    <span>4</span>
                    <h3>집앞까지 배달합니다.</h3>
                </div>
            </div>
        </div><!-- End Row -->
        <div id="delivery_time" class="hidden-xs">
            <strong><span>3</span><span>0</span></strong>
            <h4>평균 배송 시간 </h4>
        </div>
    </div><!-- End Container -->
	<input type="hidden" id="bizIdx" value="${idx}">
    <div class="white_bg" id="mahout">
        <div class="container margin_60">
            <div class="main_title">
                <h2 class="nomargin_top">고객 맞춤 추천메뉴입니다. </h2>
            </div>
            <div class="row">
                <div class="col-md-6">

                </div>
            </div><!-- End row -->
        </div><!-- End container -->
    </div><!-- End white_bg -->

    <div class="high_light">
        <div class="container">
            <h3>모든 키친과 음식점을 보실래요?</h3>
            <p>벌꿀오소리 클라우드 키친은 총 205개 키친과 2,059개 음식점을 운영하고 있습니다.</p>
            <a id="searchAll">모든 음식점 보기</a>
        </div><!-- End container -->
    </div><!-- End hight_light -->

    <section class="parallax-window" data-parallax="scroll" data-image-src="${pageContext.request.contextPath}/resources/img/kitchenmain.jpg" data-natural-width="1200" data-natural-height="800">
        <div class="parallax-content">
            <div class="sub_content">
                <i class="icon_mug"></i>
                <h3>We also deliver to your office</h3>
                <p>
                    Ridiculus sociosqu cursus neque cursus curae ante scelerisque vehicula.
                </p>
            </div><!-- End sub_content -->
        </div><!-- End subheader -->
    </section><!-- End section -->
<!-- End Content =============================================== -->

<%--    나중에 본인 프로필 정보 올리면 좋을 곳
 <div class="container margin_60">
        <div class="main_title margin_mobile">
            <h2 class="nomargin_top">Work with Us</h2>
            <p>
                Cum doctus civibus efficiantur in imperdiet deterruisset.
            </p>
        </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-2">
                <a class="box_work" href="submit_restaurant.html">
                    <img src="${pageContext.request.contextPath}/resources/img/submit_restaurant.jpg" width="848" height="480" alt="" class="img-responsive">
                    <h3>Submit your Restaurant<span>Start to earn ${pageContext.request.contextPath} </span></h3>
                    <p>Lorem ipsum dolor sit amet, ut virtute fabellas vix, no pri falli eloquentiam adversarium. Ea legere labore eam. Et eum sumo ocurreret, eos ei saepe oratio omittantur, legere eligendi partiendo pro te.</p>
                    <div class="btn_1">Read more</div>
                </a>
            </div>
            <div class="col-md-4">
                <a class="box_work" href="submit_driver.html">
                    <img src="${pageContext.request.contextPath}/resources/img/delivery.jpg" width="848" height="480" alt="" class="img-responsive">
                    <h3>We are looking for a Driver<span>Start to earn money</span></h3>
                    <p>Lorem ipsum dolor sit amet, ut virtute fabellas vix, no pri falli eloquentiam adversarium. Ea legere labore eam. Et eum sumo ocurreret, eos ei saepe oratio omittantur, legere eligendi partiendo pro te.</p>
                    <div class="btn_1">Read more</div>
                </a>
            </div>
        </div><!-- End row -->
    </div><!-- End container --> --%>

<!-- Footer 시작  -->
<jsp:include page="include/footer.jsp" flush="false"/>
<!-- Footer 끝  -->

<script src="${pageContext.request.contextPath}/resources/js/video_header.js"></script>
<script>
	$(document).ready(function() {
    	'use strict';
        HeaderVideo.init({
        	container: $('.header-video'),
            header: $('.header-video--media'),
            videoTrigger: $("#video-trigger"),
            autoPlayVideo: true
		});
	});
	
	$(document).ready(function() {
    	$('#searchAll').on('click', function() {
    		const query = 'a';
    		$.ajax({
    	    	type : 'GET'
    	        , url : '${pageContext.request.contextPath}/kitchen/lists.json'
    	        , contentType : 'application/json'
    	        , success : function(data) {
    	        	let readList, category;
    	            for(let i = 0; i < 3; i++) {
    	            	if(i == 0) {
    	            		readList = data.kitchenList;
    	                    category = "지점";
    	                    for(let j = 0; j < readList.length; j++) {
    	                    	let readLine = readList[j];
    	                        source.push({label: readLine.kitchenname, category: category});				 		
    	                    }
    	            	}
    	                if(i == 1) {
    	                	readList = data.bizList;
    	                    category = "가게";
    	                    for(let j = 0; j < readList.length; j++) {
    	                    	let readLine = readList[j];
    	                        source.push({label: readLine.bizName, category: category});				 		
    	                    }
    	                }
    	                if(i == 2) {
    	                	readList = data.menuList;
    	                    category = "메뉴";
    	                    for(let j = 0; j < readList.length; j++) {
    	                    	let readLine = readList[j];
    	                        source.push({label: readLine.mname, category: category});				 		
    	                    }
    	                }
    	            }
    	        }
    	    	, error : function(data) {
    	    		console.log('ERRoR oCCURRED');
    	            console.log(data);
    	    	}
    	    });
    	});
	});
	

</script>
</body>
</html>