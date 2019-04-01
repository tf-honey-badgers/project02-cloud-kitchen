<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- SubHeader & Position =============================================== -->
<section class="parallax-window" data-parallax="scroll" data-image-src="/customer/resources/img/sub_header_2.jpg" data-natural-width="1400" data-natural-height="470">
	<div id="subheader">
	<div id="sub_content">
		<div id="thumb"><img src="/customer/resources/img/thumb_restaurant.jpg" alt=""></div>
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