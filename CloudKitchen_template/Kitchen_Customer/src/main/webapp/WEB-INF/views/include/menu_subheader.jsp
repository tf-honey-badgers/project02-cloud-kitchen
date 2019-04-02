<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- SubHeader =============================================== -->
<section class="parallax-window HImg" data-parallax="scroll" data-image-src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtkLB-Xn3h1aABKa9hBXPfkbTA2NbQWZ1B4r9CP0DlHPXcjfLo" data-natural-width="1400" data-natural-height="470">
	<div id="subheader">
	<div id="sub_content">
		<div id="thumb">
				<img  class='shopImg' src="" alt="">
		</div>
		<div class="rating">
			<i class="icon_star voted"></i>
			<i class="icon_star voted"></i>
			<i class="icon_star voted"></i>
			<i class="icon_star voted"></i>
			<i class="icon_star"></i>
		</div>
		<h1>${bizMember.bizName}</h1>
        <div id="minAmt" data-min-amt="${bizMember.bizMinAmt}"><strong>최소 주문 금액:</strong> ${bizMember.bizMinAmt}원</div>
        <div><strong>가게 찜 횟수:</strong> <span id="likes">${bizMember.bizLikeCnt}</span> (<span id="likeText">찜해주세요!!</span>&nbsp;<span id="likeWrapper"><i id="likeBiz" class="icon-heart-empty"></i></span>)</div>
        	<!--
        		내가 찜했다면 class="icon-heart", span은 "찜하셨어요!!"
        		내가 찜하지 않았다면 class="icon-heart-empty", span은 "찜해주세요!!"
        	-->
    </div><!-- End sub_content -->
</div><!-- End subheader -->
</section><!-- End section -->
<!-- End SubHeader ============================================ -->

<script>
	bizName = '${bizMember.bizName}';
</script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		if(bizName=='유니네 피자집'){
			$('.shopImg').attr('src','http://newsimg.hankookilbo.com/2014/08/19/201408191596070672_1.jpg');				
			$('.HImg').attr('data-image-src','https://cbmpress.com/calgary/wp-content/uploads/sites/4/2017/09/pizzaweek.jpg');
		}else{
			$('.shopImg').attr('src','https://media-cdn.tripadvisor.com/media/photo-s/0a/85/0a/ab/2.jpg');
			$('.HImg').attr('data-image-src','http://leegane.co.kr/images/main/visual_01.jpg');
		}
	})
</script>