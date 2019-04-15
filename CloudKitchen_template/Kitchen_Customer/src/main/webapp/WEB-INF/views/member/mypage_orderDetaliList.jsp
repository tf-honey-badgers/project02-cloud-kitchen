 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
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
  <h1>${orderinfo}</h1>
  
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
                    
					<div class="wrapper_indent">
						<div class="form-group">
							<label>가게이름</label>
							<h4>유니네 피자집</h4>
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
												<label>Title</label>
												<p> 떡볶이</p>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label>Total Price</label>
												<p>5,000원</p>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label>요청사항</label>
										<p>많이 주세요</p>
									</div>

									<div class="form-group">
										<label>Item options</label>
										<div class="table-responsive">
											<table class="table table-striped edit-options">
												<tbody>
													<tr>
														<td style="width:20%">
															+ $3.50
														</td>
														<td style="width:70%">
															<input type="text" class="form-control" placeholder="Ex. Medium">
														</td>
														
													</tr>
												</tbody>
											</table>
										</div>
									</div><!-- End form-group -->

									<div class="form-group">
										<label>Item ingredients</label>
                                        <div class="table-responsive">
										<table class="table table-striped notifications">
											<tbody>
												<tr>
													<td style="width:20%">
														<input type="text" class="form-control" placeholder="+ $2.50">
													</td>
													<td style="width:70%">
														<input type="text" class="form-control" placeholder="Ex. Extra tomato">
													</td>
												
												</tr>
												<tr>
													<td style="width:20%">
														<input type="text" class="form-control" placeholder="+ $5.50">
													</td>
													<td style="width:70%">
														<input type="text" class="form-control" placeholder="Ex. Extra Pepper">
													</td>
													
												</tr>
											</tbody>
										</table>
                                        </div>
									</div><!-- End form-group -->
								</div>
							</div><!-- End row -->
						</div><!-- End strip_menu_items -->
					</div><!-- End wrapper_indent -->
				</section>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../include/footer.jsp" />
<script>
	
	var s = JSON.parse(${orderinfo})
	console.log(s)

</script>
    
  </body> 
 </html>