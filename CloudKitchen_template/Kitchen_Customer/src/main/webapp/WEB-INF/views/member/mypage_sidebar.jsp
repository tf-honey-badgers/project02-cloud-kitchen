 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
		<div class="col-md-3">
			<p>
				<a class="btn_map" data-toggle="collapse" href="#collapseMap" aria-expanded="false" aria-controls="collapseMap">My Page</a>
			</p>
			<div id="filters_col">
				
				<div class="collapse" id="collapseFilters">
			
			
					<div class="filter_type">
						<h6><a href="${pageContext.request.contextPath}/member/${uid}/change">회원정보 수정</a></h6>
						<h6><a href="${pageContext.request.contextPath}/member/${uid}/mypage/orderinfo">주문 내역보기</a></h6>
						<h6><a href="${pageContext.request.contextPath}/member/fav/${uid}/mypage">찜 내역</a></h6>
					</div>
				</div><!--End collapse -->
			</div><!--End filters col-->
		</div><!--End col-md -->