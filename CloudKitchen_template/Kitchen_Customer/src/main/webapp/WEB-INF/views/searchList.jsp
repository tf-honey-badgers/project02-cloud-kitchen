<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>검색 결과</title>
</head>
<body>
<!-- Header =============================================== -->
	<jsp:include page="include/header.jsp" flush="false" />
<!-- End Header =============================================== -->
<!-- SubHeader & Position =============================================== -->
	<jsp:include page="include/search_subheader.jsp" flush="false" />
<!-- End SubHeader & Position =============================================== -->

<!-- Content ================================================== -->
<div class="container margin_60_35">
	<div class="row">
		<!-- Sidebar =================================================== -->
		<div class="col-md-3">
			<div id="filters_col">
				<a data-toggle="collapse" href="#collapseFilters" aria-expanded="false" aria-controls="collapseFilters" id="filters_col_bt">Filters <i class="icon-plus-1 pull-right"></i></a>
				<div class="collapse" id="collapseFilters">
					<div class="filter_type">
						<h6>Type</h6>
						<ul>
							<li><label><input type="checkbox" checked class="icheck">All <small></small></label></li>
							<c:forEach var="cat" items="${bizCat}" varStatus="loop">
								<li><label><input type="checkbox" class="icheck" data-cat-id="${cat.id}">${cat.name}<small></small></label><i class="color_${loop.index % 7 + 1}"></i></li>
							</c:forEach>
						</ul>
					</div>
				</div><!--End collapse -->
			</div><!--End filters col-->
		</div><!--End col-md-3 -->
		<!-- End Sidebar =================================================== -->

		<div class="col-md-9">
			<!-- Tools =================================================== -->
			<div id="tools">
				<div class="row">
					<form action="${pageContext.request.contextPath}/kitchen/search" method="post">
						<div class="form-group">
                        	<input type="text" class="search-query form-control" name="query" value="${query}" placeholder="검색어를 자유롭게 입력해주세요." style="display:inline;width:70%;">
	                    	<input type="submit" id="searchBtn" class="btn_1" value="검색" style="width:28.3%;height:40px;position:absolute;top:1px;">
	                    </div>
					</form>
				</div>
			</div>
			<!-- End Tools =================================================== -->

        	<!-- Search Results =================================================== -->
        	<c:forEach var="biz" items="${searchResults}">
        		<div class="strip_list wow fadeIn" data-wow-delay="0.1s">
					<div class="row">
						<div class="col-md-9 col-sm-9">
							<div class="desc">
								<div class="thumb_strip">
									<a href="detail_page.html"><img class="shopImg" src="https://s3.ap-northeast-2.amazonaws.com/honeybadgersfile/MenuPhoto/${biz.bizId}.png" alt="없음" title="이거"></a>
								</div>
								<div class="rating">
									<i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i> (<small><a href="#0">98 reviews</a></small>)
								</div>
								
								<h3>${biz.bizName}</h3>
								<div class="type" data-cat-id="${biz.bizCatId}" data-kitchen-id="${biz.bizKitchenId}">${biz.bizCatName} / ${biz.bizKitchenName}</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-3">
							<div class="go_to">
								<div>
									<a href="${pageContext.request.contextPath}/kitchen/${biz.bizId}/main" class="btn_1">가게 보기</a>
								</div>
							</div>
						</div>
					</div><!-- End row-->
				</div><!-- End strip_list-->
        	</c:forEach>
        	<!-- End Search Results =================================================== -->
        	
        	<!-- 미래 확장용으로 남겨둠. -->
<!--             <a href="#0" class="load_more_bt wow fadeIn" data-wow-delay="0.2s">Load more...</a> -->

		</div><!-- End col-md-9-->        
	</div><!-- End row -->
</div><!-- End container -->
<!-- End Content =============================================== -->

<!-- Footer =============================================== -->
<jsp:include page="include/footer.jsp" flush="false"/>
<!-- Footer =============================================== -->

<!-- SPECIFIC SCRIPTS -->
<script src="${pageContext.request.contextPath}/resources/js/cat_nav_mobile.js"></script>
<script>$('#cat_nav').mobileMenu();</script>
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script src="${pageContext.request.contextPath}/resources/js/map.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/infobox.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ion.rangeSlider.js"></script>
<script>
    $(function () {
		 'use strict';
        $("#range").ionRangeSlider({
            hide_min_max: true,
            keyboard: true,
            min: 0,
            max: 15,
            from: 0,
            to:5,
            type: 'double',
            step: 1,
            prefix: "Km ",
            grid: true
        });
    });
    
/*     var imgArr=[];
    imgArr[0]='https://previews.123rf.com/images/cookelma/cookelma1502/cookelma150200141/36986768-%EB%A7%9B%EC%9E%88%EA%B3%A0-%EC%8B%9D%EC%9A%95%EC%9D%84-%EB%8F%8B%EC%9A%B0%EB%8A%94-%ED%96%84%EB%B2%84%EA%B1%B0-%EC%B9%98%EC%A6%88-%EB%B2%84%EA%B1%B0.jpg';
    imgArr[1]='https://media-cdn.tripadvisor.com/media/photo-s/0a/85/0a/ab/2.jpg';
    imgArr[2]='http://newsimg.hankookilbo.com/2014/08/19/201408191596070672_1.jpg';
    imgArr[3]='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBLKuH5NAblA06SW3d2qSb21--5e5UsEqL05vQZPYuMdyjm3zF';
    
    $(document).ready(function(){
    	var $IMG = $('.shopImg');
    	console.log($IMG);
    	
    	$('.shopImg').each(function(index,data){
    		$(data).attr('src',imgArr[index]);
    	});
    	
    }) */
    
</script>
	
<script src="${pageContext.request.contextPath}/resources/js/menu/menu-functions.js"></script>
</body>
</html>