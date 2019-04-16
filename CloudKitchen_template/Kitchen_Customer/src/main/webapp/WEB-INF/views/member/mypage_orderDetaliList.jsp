 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html> 
 <html> 
  <head> 
  <meta charset="UTF-8"> 
  <title>Insert title here</title> 	

  </head> 
  <body> 
    <jsp:include page="../include/header.jsp" />
	<jsp:include page="../include/background.jsp" flush="false" />
	
  <div class="container margin_60">
<%--  <h1>${orderinfo}</h1>  --%>
  <div>
  <%-- 	<c:forEach items="${orderinfo}" var="map">
		<c:forEach items="${map.value}" var="innerMap">
		 	<c:if test="${innerMap.key eq \"bizName\"}">
				<h4>bizName: ${innerMap.value}</h4>
			</c:if>
			<c:if test="${innerMap.key eq \"method\"}">
				<h4>bizName: ${innerMap.value}</h4>
			</c:if>
		<h4>주문정보 키 : ${innerMap.key}</h4>
			<h4>주문정보 내용 : ${innerMap.value}</h4> 
		</c:forEach>
		<h1>----------------------------------------------------------</h1>
  	</c:forEach> --%>
  
  </div>
  	<jsp:include page="mypage_sidebar.jsp"/>
  		<div class="col-md-9">
		<div id="tabs" class="tabs">
			<nav>
				<ul>
					<li><a href="#section-2" class="icon-menut-items"><span>Menu</span></a>
					</li>
					
				</ul>
			</nav>
			<div class="content">
				
				<section id="section-2">
					<div class="indent_title_in">
						<i class="icon_document_alt"></i>
						<h3>주문 상세 내역</h3>
						<p></p>
					</div>
                    
                    
                <c:forEach items="${orderinfo}" var="map" varStatus="status">
				
                    
					<div class="wrapper_indent index${status.count }">
						<div class="form-group">
							<label>가게이름</label>
							<c:forEach items="${map.value}" var="innerMap">
								<c:if test="${innerMap.key eq \"bizName\"}">
									<h4>${innerMap.value}</h4>
								</c:if>
							</c:forEach>
							
						</div>

						<div class="menu-item-section clearfix">
							<div>&nbsp;</div>
						</div>

						<div class="strip_menu_items">
							<div class="row">
								<div class="col-sm-3">
									<div class="menu-item-pic dropzone">
										
										<div class="dz-default dz-message"><span>Click or Drop<br>Images Here</span>
										</div>
									</div>
								</div>
								<div class="col-sm-9">
									<div class="row">
										<div class="col-md-8">
											<div class="form-group">
												<label>결제수단</label>
														<c:forEach items="${map.value}" var="method">
															<c:if test="${method.key eq \"method\"}">
																<p>${method.value}</p>
															</c:if>
														</c:forEach>
													
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label>Total Price</label>
												<p id="total">5000원</p>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label>주문 상태</label>
										<c:forEach items="${map.value}" var="method">
											<c:if test="${method.key eq \"status\"}">
												<p>${method.value}</p>
											</c:if>
										</c:forEach>
													
									</div>
									
										<div class="form-group menudetail">
											<label>Menu Detail</label>
											<div class="table-responsive">
												<table class="table table-striped edit-options">
													<tbody>
														<c:forEach items="${map.value}" var="menu">
														<c:if test="${menu.key eq \"menus\"}">
															<c:forEach items="${menu.value }"  var="menuinner">
														<tr>
															<c:forEach items="${menuinner.value }"  var="option">
																<c:if test="${option.key eq \"option\"}">
															<td style="width:35%;" class="menuinfo">
																<p style="font-weight: bold;font-size: 14px;">${menuinner.key }</p><!-- 메뉴 이름 -->
																	 <c:forEach  items="${menuinner.value}" var ="menuprice" varStatus="st" >
																		 <c:if test="${menuprice.key eq  \"menuPrice\"}">
																			<p>기본 금액 :&nbsp;${menuprice.value } 원</p>
																		</c:if>
																		 <c:if test="${menuprice.key eq  \"quantity\"}">
																			<p>수&nbsp; 량 :&nbsp;${menuprice.value } </p>
																		</c:if>
																		<c:if test="${menuprice.key eq  \"totalAmt\"}">
																			<p>합&nbsp; 계 :&nbsp;<span>${menuprice.value }</span>원 </p>
																		</c:if>
																	</c:forEach> 
															</td>
																
																		<td style="width:60%">
																	 <c:forEach  items="${option.value }" var ="optioninner" >
																			<span>${optioninner.key}(${optioninner.value}원)&nbsp;</span>
																	</c:forEach> 
																		</td>
																</c:if>
															</c:forEach>
															
														</tr>
															</c:forEach>
															</c:if>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div><!-- End form-group -->
					
								</div>
							</div><!-- End row -->
						</div><!-- End strip_menu_items -->
					</div><!-- End wrapper_indent -->
					
  					</c:forEach>
					
					
				</section>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../include/footer.jsp" />
<script>
	
	$('.wrapper_indent').each(function(i,f){
		console.log(i,f)
		var n= $('.menudetail')
		console.log(n)
		var v= $('.menudetail:eq('+i+')').find('.menuinfo p:eq(3) span')
			
			console.log(v)
		
		
		
		//find('.menuinfo p:eq(3) span')
		//console.log(v)
		
		
	})

</script>
    
  </body> 
 </html>