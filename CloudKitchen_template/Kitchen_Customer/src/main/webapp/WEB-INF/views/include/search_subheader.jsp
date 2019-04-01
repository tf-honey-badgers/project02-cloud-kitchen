<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- SubHeader & Position =============================================== -->
<section class="parallax-window" id="short" data-parallax="scroll" data-image-src="/customer/resources/img/sub_header_short.jpg" data-natural-width="1400" data-natural-height="350">
    <div id="subheader">
	<div id="sub_content">
    	<h1>${fn:length(searchResults)}개 검색 결과가 있습니다.</h1>
    </div><!-- End sub_content -->
</div><!-- End subheader -->
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