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
  <div>

  
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
							<!-- 	<div class="col-sm-3">
									<div class="menu-item-pic dropzone">
										
										<div class="dz-default dz-message"><span>Click or Drop<br>Images Here</span>
										</div>
									</div>
								</div> -->
								<div class="col-sm-11">
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
												<p id="total"><span></span>원</p>
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
															<td style="width:30%;" class="menuinfo">
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
																	 <c:forEach  items="${option.value }" var ="optioninner" varStatus="comma">
																			<span>
																				${optioninner.key}(${optioninner.value}원)
																				<c:if test="${not comma.last }">,</c:if>
																			</span>
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
	
	//가게별 총금액 구해주기 
	$('.wrapper_indent').each(function(i,f){
		var total=0;
		
		$(this).find('.menuinfo').each(function(x,y){
			var v= $('.menudetail:eq('+i+')').find('.menuinfo:eq('+x+') p:eq(3) span')
			money = Number(v.text())
			total+=money
		})
		$(this).find('#total>span').append(total)
		
		total=0;
		
	})

</script>
    
  </body> 
 </html>