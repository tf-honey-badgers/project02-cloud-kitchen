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

<!-- End Position ============================================ -->
<script>
//마이페이지 사진 바꾸기 
$(document).ready(function() {
var imgArray = new Array();
imgArray[0] = "http://mblogthumb1.phinf.naver.net/MjAxNzEyMDVfMTk1/MDAxNTEyNDM5NzAxNjYy.9f8sRIp6IYn6NlRz4zQguCvI0t_09W5KTVHA4DLZiJUg.V0ex8EdRKbWs_oFHnklwoPZo7jmecSckNaTV6ZR5IT0g.JPEG.designbyat/%EB%A0%88%EC%8A%A4%ED%86%A0%EB%9E%91%EC%9D%B8%ED%85%8C%EB%A6%AC%EC%96%B4_%EC%B9%B4%ED%8E%98%EC%9D%B8%ED%85%8C%EB%A6%AC%EC%96%B4_%EA%B3%A0%EA%B8%89%EC%B9%B4%ED%8E%98%EC%9D%B8%ED%85%8C%EB%A6%AC%EC%96%B4_%EC%BB%A4%ED%94%BC%EC%88%8D%EC%9D%B8%ED%85%8C.jpg?type=w800";
imgArray[1] = "http://cfile217.uf.daum.net/image/2528513353BF874017D99E";
imgArray[2] = "https://churaumi.okinawa/userfiles/images/area/restaurant/img_160421_09.jpg";
imgArray[3] = "https://cd.visitmelbourne.com/-/media/images/the-murray/food-and-wine/stefanos_mur_r_sup_1600x900.jpg?ts=20170130130308";
imgArray[4] = "https://media1.tokyodisneyresort.jp/images/adventure/restaurant/472_main_visual_name_2.jpg?mod=20190320202459";
imgArray[5] = "https://post-phinf.pstatic.net/MjAxNzA2MjBfMTI5/MDAxNDk3OTM5NjI3MDIx.Wb1ctEQc1DKHwDLjd9RjXj4duipRz8EIVqzvGtmUxGwg.Vl7u2n_CEypyGbGspJOx8jqQ4OnRsBd7E3rDiI-aPjcg.JPEG/%EB%B8%8C%EB%A1%9C%EC%BD%9C%EB%A6%AC%ED%93%A8%EB%A0%88_%EA%B3%BC%EC%A0%956.jpg?type=w1200";
imgArray[6] = "http://www.koreainus.com/v1/data/file/cook/854108902_qS5lWHQf_5d1f9912549d25db6c166d1372581a93e00520f6.png";


	var imgNum = Math.round(Math.random()*7);
	var objImg = document.getElementById("introImg");
	objImg.src = imgArray[imgNum];

});
</script>