<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- SubHeader =============================================== -->
<section class="parallax-window HImg" data-parallax="scroll" data-image-src="https://upload.wikimedia.org/wikipedia/commons/2/29/%EC%A2%85%EA%B0%81%EC%97%AD_131.jpg" data-natural-width="1400" data-natural-height="470">
	<div id="subheader">
	<div id="sub_content">
		<div id="thumb">
			<img  class='shopImg' src="https://s3.ap-northeast-2.amazonaws.com/honeybadgersfile/MenuPhoto/${bizMember.bizId}.png" width="130px" height="130px" alt="">
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
    </div><!-- End sub_content -->
</div><!-- End subheader -->
</section><!-- End section -->
<!-- End SubHeader ============================================ -->

<script>
	bizName = '${bizMember.bizName}';
</script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>