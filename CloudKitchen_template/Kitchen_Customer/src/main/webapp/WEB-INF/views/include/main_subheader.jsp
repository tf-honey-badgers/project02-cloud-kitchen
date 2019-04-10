<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<section class="header-video">
	<div id="hero_video">
		<div id="sub_content">
            <h1>주문 & 음식 배달</h1>
            <p>벌꿀오소리 5명이 운영하는 클라우드 키친 홈페이지입니다! 많이 사랑해주세요!</p>
            <form action="${pageContext.request.contextPath}/kitchen/search" method="post">
				<div id="custom-search-input">
                    <div class="input-group">
                        <input type="text" class="search-query" name="query" placeholder="검색어를 자유롭게 입력해주세요." style="border-radius: 0 !important;">
                        <span>
                        	<input type="submit" id="searchBtn" class="btn_search" value="">
                        </span>
                    </div>
                </div>
            </form>
        </div><!-- End sub_content -->
    </div>
    <img src="${pageContext.request.contextPath}/resources/img/video_fix.png" alt="" class="header-video--media" data-video-src="" data-teaser-source="/customer/resources/video/intro" data-provider="" data-video-width="1920" data-video-height="960">
    <div id="count" class="hidden-xs">
        <ul>
            <li><span class="number">2650</span> Restaurant</li>
            <li><span class="number">5350</span> People Served</li>
            <li><span class="number">12350</span> Registered Users</li>
        </ul>
    </div>
</section> <!-- End Header video -->
<script src="${pageContext.request.contextPath}/resources/js/mahout/mahout.js"></script>
<!-- End SubHeader ============================================ -->