<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- SubHeader & Position =============================================== -->
<section data-parallax="scroll" data-image-src="" data-natural-width="1400" data-natural-height="470">
		<img alt="대문" id = "introImg"  style="-webkit-filter: grayscale(66%);
																	filter: gray; width: 100%; height: 470px;">

	
        	 
  
</section><!-- End section -->
<!-- End SubHeader ============================================ -->

<!-- Position ============================================ -->
<div id="position">
	<div class="container">
		<ul>
			<li><a href="${pageContext.request.contextPath}/main">Home</a></li>
			<li><a href="#0">Category</a></li>
			<li>Page active</li>
		</ul>
		<a href="#0" class="search-overlay-menu-btn"><i class="icon-search-6"></i> Search</a>
	</div>
</div>
<!-- End Position ============================================ -->
<script>
//마이페이지 사진 바꾸기 
$(document).ready(function() {
var imgArray = new Array();
imgArray[0] = "http://starbbquiuc.com/wp-content/uploads/2018/11/menu_04.jpg";
imgArray[1] = "http://img.khan.co.kr/news/2018/04/19/l_2018042001002453300196681.jpg";
imgArray[2] = "http://www.journal-d.kr/news/photo/201704/14768_9689_3049.jpg";
imgArray[3] = "http://cowboy2014.com/wp-content/uploads/2012/07/main_image_05.jpg";
imgArray[4] = "http://image.aafood.co.kr/image/upload/yk/p54k8dfj/i88k1414379507462.png";
imgArray[5] = "http://img1.daumcdn.net/thumb/R720x0/?fname=https://t1.daumcdn.net/liveboard/shopping/6ee2b995fc1b4db6a30753370076786d.JPG";
imgArray[6] = "http://애플돈까스.com/skin/img/slide/slide_201708031501764283_1";


	var imgNum = Math.round(Math.random()*3);
	var objImg = document.getElementById("introImg");
	objImg.src = imgArray[imgNum];

});
</script>