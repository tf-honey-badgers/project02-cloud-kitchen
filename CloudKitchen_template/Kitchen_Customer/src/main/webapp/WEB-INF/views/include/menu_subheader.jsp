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
			(<small><a href="detail_page_2.html">Read 98 reviews</a></small>)
		</div>
		<h1>${bizMember.bizName}</h1>
        <div><strong>최소 주문 금액:</strong> ${bizMember.bizMinAmt}원</div>
    </div><!-- End sub_content -->
</div><!-- End subheader -->
</section><!-- End section -->
<!-- End SubHeader ============================================ -->
	
<!-- Position ============================================ -->
<div id="position">
	<div class="container">
		<ul>
			<li><a href="</a>${pageContext.request.contextPath}/main">Home</a></li>
			<li><a href="#0">Category</a></li>
			<li>Page active</li>
		</ul>
		<a href="#0" class="search-overlay-menu-btn"><i class="icon-search-6"></i> Search</a>
	</div>
</div>
<!-- End Position ============================================ -->