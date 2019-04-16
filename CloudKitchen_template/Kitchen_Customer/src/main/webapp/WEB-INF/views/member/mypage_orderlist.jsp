 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--  <%@taglib prefix="fmt" %> --%>
 <!DOCTYPE html> 
 <html> 
  <head> 
  <meta charset="UTF-8"> 
  <title>Insert title here</title> 	

  </head> 
  <body> 
  <!-- End Preload -->
 <!-- Header ================================================== -->
<!-- SubHeader =============================================== -->
<!-- Content ================================================== -->
  	<jsp:include page="../include/header.jsp" />
	<jsp:include page="../include/background.jsp" flush="false" />
  
  <div class="container margin_60_35">
	<div class="row">
    
		<jsp:include page="mypage_sidebar.jsp"/>
        
		<div class="col-md-9">
        
 
        <!--  strip_list-->
        <c:if test="${!empty order }">
        <c:forEach var="order" items="${order}"  begin="0" end="4">
			<div class="strip_list wow fadeIn" data-wow-delay="0.1s">
				
				<div class="row">
					<div class="col-md-9 col-sm-9">
						<div class="desc">
							<div class="thumb_strip">
								<a href="detail_page.html"><img src="img/thumb_restaurant.jpg" alt=""></a>
							</div>
						
							<h3>${order.kitchenName }</h3>
							<div class="type">
								주문 시간 &nbsp;: &nbsp;<span>${order.time}</span> 
							</div>
							<div class="location">
								${order.address}
							</div>
							<div class="location">
								총 결제 금액 &nbsp;: &nbsp;<span class="opening">${order.payAmt}</span>
							</div>
							<ul>
								<li>결제상태<i class="icon_check_alt2 ok"></i></li>
							</ul>
						</div>
					</div>
					<div class="col-md-3 col-sm-3">
						<div class="go_to">
							<div>
								<a href="${pageContext.request.contextPath}/member/${order.id}/mypage/orderinfoDetail" class="btn_1">View Menu</a>
							</div>
						</div>
					</div>
				</div><!-- End row-->
			</div><!-- End strip_list-->
           </c:forEach>
           </c:if>
            <a href="#0" class="load_more_bt wow fadeIn" data-wow-delay="0.2s">Load more...</a>  
		</div><!-- End col-md-9-->
        
	</div><!-- End row -->
</div><!-- End container -->

<!-- footer -->
    <jsp:include page="../include/footer.jsp" />
  </body> 
 </html>