<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜목록 보기</title>
</head>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
	var custId = '${custId}';
</script>




<body>

<!-- 위쪽 헤더바  -->
<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/background.jsp" flush="false" />
<!-- 헤드 끝 -->
<div class="container margin_60">
	<jsp:include page="mypage_sidebar.jsp" />
	<div class="col-md-9">
		<div id="tabs" class="tabs">
			<nav>
				<ul>
					<li><a href="#section-2" class="icon-menut-items"><span>찜 리스트</span></a>
					</li>

				</ul>
			</nav>
			<div class="content">
				<section id="section-2">
					<div class="col-md-12">
					<c:forEach var="biz" items="${list}">
			        		<div class="strip_list wow fadeIn" data-wow-delay="0.1s">
							<div class="row">
								<div class="col-md-9 col-sm-9">
									<div class="desc">
										<div class="thumb_strip">
											<a href="${pageContext.request.contextPath}/kitchen/${biz.bizId}/main"><img class="shopImg" src="https://s3.ap-northeast-2.amazonaws.com/honeybadgersfile/MenuPhoto/${biz.bizId}.png" alt="없음" title="이거"></a>
										</div>
										<div class="rating">
											<i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i> (<small><a href="#0">98 reviews</a></small>)
										</div>
											
										<h3>${biz.bizName}</h3>
										<div class="type" data-cat-id="${biz.bizCatId}" data-kitchen-id="${biz.bizKitchenId}">${biz.bizCatName}  ${biz.bizKitchenName}</div>
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
						
						
						</div>
					</section>
				</div>
			</div>
		</div>
	</div>


	<div style="margin-bottom: 50%"></div>
	<!-- 아래 풋터바  -->
	<jsp:include page="../include/footer.jsp" />
	<!-- 풋터 끝 -->
	


</body>
</html>