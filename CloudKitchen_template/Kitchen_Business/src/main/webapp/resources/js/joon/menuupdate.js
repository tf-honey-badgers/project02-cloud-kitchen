$(document)
		.ready(
				function() {
					
					// S3 업로드를 위한 초기화작업
					var albumBucketName = 'honeybadgersfile';
					var bucketRegion = 'ap-northeast-2';
					var IdentityPoolId = 'ap-northeast-2:1817daac-6a56-4e36-9a56-9bc772d96a0b';
					
					AWS.config.update({
					  region: bucketRegion,
					  credentials: new AWS.CognitoIdentityCredentials({
					    IdentityPoolId: IdentityPoolId
					  })
					});
					
					var s3 = new AWS.S3({
					  apiVersion: '2006-03-01',
					  params: {Bucket: 'honeybadgersfile'}
					}); // S3 초기화 끝

					// 메뉴 추가시 사진파일 업로드
					function addPhoto(menuId) {
						  var files = document.getElementById('menuPhotoInsert').files;
						  if (!files.length) {
						    return alert('Please choose a file to upload first.');
						  }
						  var file = files[0];
						  var fileName = menuId+'.png';
						  var albumPhotosKey = encodeURIComponent(albumName) + '/';
						  var albumName = 'MenuPhoto';
						  var photoKey = albumPhotosKey + fileName;
						  
						  s3.upload({
						    Key: photoKey,
						    Body: file,
						    ACL: 'public-read'
						  }, function(err, data) {
						    if (err) {
						      return alert('There was an error uploading your photo: ', err.message);
						    }
//						    alert('Successfully uploaded photo.');
						  });
						}
					
					function updatePhoto(menuId) {
						  var files = document.getElementById('updatePhoto').files;
						  if (!files.length) {
						    return alert('Please choose a file to upload first.');
						  }
						  var file = files[0];
						  var fileName = menuId+'.png';
						  var albumName = 'MenuPhoto';
						  var albumPhotosKey = encodeURIComponent(albumName) + '/';
						  var photoKey = albumPhotosKey + fileName;
						  console.log(photoKey);
						  s3.upload({
						    Key: photoKey,
						    Body: file,
						    ACL: 'public-read'
						  }, function(err, data) {
						    if (err) {
						      return alert('There was an error uploading your photo: ', err.message);
						    }
//						    alert('사진 업로드 완료');
						  });
						}
			        
					function deletePhoto(photoKey) {
						let albumPath = 'MenuPhoto/';
						let extention = '.png';
						let photoName = albumPath+photoKey+extention;
						  s3.deleteObject({Key: photoName}, function(err, data) {
						    if (err) {
						      return alert('There was an error deleting your photo: ', err.message);
						    }
						    alert('Successfully deleted photo.');
						  });
						}

					$('.insertMenuCatModalOpt').on('click','#insertMenuCatBtn',function(e){
						
						let menuCat = new Object();
						let menuCatArr = new Array();
						
						for(let i=0; i<$('.insertMenuCatModalOpt tbody tr').length; i++){
							menuCatArr.push($('.insertMenuCatModalOpt tbody tr').eq(i).children().eq(0).children().eq(0).val());
						}
						
						menuCat.menuCat = menuCatArr;
						menuCat.bizId = $('#bizId').val();
						
						$.ajax({
							type : "GET",
							dataType : 'json',
							url : "../../menu/main/insertmenucat",
							data : {
								insertMenuCat : JSON.stringify(menuCat),
							},
							error : function(data){
								console.log(data);
							},
							success(data){
								console.log(data);
								$('.insertMenuCatModal tbody').empty();
							}
						});
						
					}); // insertMenuCatBtn 끝
					
					$('.insertMenuCatModal').on('click','.deleteMenuCat',function(e){
						$(this).parent().parent().remove();
					}); // deleteMenuCat
					
					$('.insertMenuCatModal').on('click','.addMenuCat',function(e){
						
						$('.insertMenuCatModal tbody').append(
							 '<tr>'
							+'<td><input type="text" class="menuCat" /></td>'
							+'<td>'
							+'<button class="deleteMenuCat">'
							+'<img src="/business/resources/img/baseline_remove_circle_outline_black_18dp.png">'
							+'</button>'
							+'</td></tr>'
						);
					}); // addMenuCat
					
					$('#insertMenuCat').on('click',function(e){
						$('.insertMenuCatModal tbody').empty();
						$('.insertMenuCatModal').css('display', 'block');
					}); // insertMenuCat

					
					$('.menuModalOpt').on('click','.deleteUpdateMenuOpt',function(e){
						let optId = $(this).parent().parent();
						console.log(optId);
						let deleteCheck = confirm("정말 삭제하시겠습니까?");
						
						if(deleteCheck == true){
							$.ajax({
								type : "GET",
								dataType : 'json',
								url : "../../menu/main/deletemenuopt",
								data : {
									menuOptId : optId.children().eq(0).text()
								},
								error : function(data){
									console.log(data);
								},
								success(data){
									console.log(data);
									optId.remove();
								}
							});
							
						}
					}); // deleteUpdateMenuOpt
				
					
					$('.table-responsive').on('click','table tbody tr td .menu-option-delete',function(e){
						e.preventDefault();
						let deleteCheck = confirm("정말 삭제하시겠습니까?");
						let deleteMenu = $(this).parent().parent();
						let deleteMenuId = $(this).parent().parent().children().eq(0).text();
						console.log($(this).parent().parent().children().eq(0).text());
						
						if(deleteCheck == true){
							$.ajax({
								type : "POST",
								dataType : 'json',
								url : "../../menu/main/deletemenu",
								data : {
									menuId : deleteMenuId
								},
								error : function(data){
									console.log(data);
								},
								success(data){
									console.log(data);
									deleteMenu.remove();
									deleteMenuPhoto(deleteMenuId);
								}
							});
						} else {
							return false;
						}
						
					}); // menu-option-delete
					
					$('.menuInsertModalOpt')
						.on('click','.col-md-12 .card .card-body .table-responsive .table tbody .menuOptCl td .deleteMenuOpt',function(e){
						
						$(this).parent().parent().parent().parent().parent().parent().parent().parent().remove();	
					}); // deleteMenuOpt
					
					
					$('#insertMenu').on('click',function(e){
						
						let insertMenu = new Object();
						insertMenu.mName = $('.menuInsertModalOpt .table tbody tr')[0].children[1].children[0].value;
						insertMenu.mBasicPrice = $('.menuInsertModalOpt .table tbody tr')[0].children[2].children[0].value;
						insertMenu.mPhoto = $('.menuInsertModalOpt .table tbody tr')[0].children[0].children[0].value;
						insertMenu.menuCatCode = $('#menuCatSelect').children().eq(document.getElementById('menuCatSelect').selectedIndex).attr('id');
						
						let menuOptClArr = new Array();
						for(let i=0; i<$('.menuOptClSelect').length; i++){
							
							let insertMenuOptCl = new Object();
							insertMenuOptCl.mocName = $('.menuOptCl')[i].children[1].children[0].value;
							insertMenuOptCl.mocMenuOptType = $('.menuOptClSelect')[i].children[$('.menuOptClSelect')[0].selectedIndex].className;
							
							let menuOptArr = new Array();
							insertMenuOptCl.menuOpt = menuOptArr;
							menuOptClArr.push(insertMenuOptCl);
							
							for(let j=0; j<$('.addMenuList .menuOptCl')[i].parentNode.childNodes.length; j++){
								
								let insertMenuOpt = new Object();
								insertMenuOpt.moName = $('.addMenuList .menuOptCl')[i].parentNode.childNodes[j].childNodes[2].childNodes[0].value;
								insertMenuOpt.moAddPrice = $('.addMenuList .menuOptCl')[i].parentNode.childNodes[j].childNodes[3].childNodes[0].value;
								menuOptArr.push(insertMenuOpt);
							}
						}
						insertMenu.menuOptCl = menuOptClArr;
						console.log(insertMenu);
						addPhoto('MenuPhoto');
		                    
						$.ajax({
			        		type : "POST",
			        		dataType : 'json',
			        		url : "../../menu/main/insertMenu",
			         		data : {
			         			menuInfo : JSON.stringify(insertMenu)
			         		},
			        		error : function(data){
			        			console.log(data);
			        		},
			        		success(data){
			        			console.log(data);
			        			addPhoto(data);
			        			
			        			let menuCat = $('#menuCatSelect').children().eq(document.getElementById('menuCatSelect').selectedIndex).text();
			        			for(let i=0; i<menuCat.length; i++){
			        				if(menuCat == $('.container-fluid .card-title')[i].innerHTML){
//			        					$('.container-fluid .table tbody')[i].innerHTML+=(
			        					$('.container-fluid .table tbody').eq(i).append(
			        							'<tr>'
			        							+'<td>'+data+'</td>'
			        							+'<td>'+$('.menuInsertModalOpt .table tbody tr')[0].children[0].children[0].value+'</td>'
			        							+'<td>'+$('.menuInsertModalOpt .table tbody tr')[0].children[1].children[0].value+'</td>'
			        							+'<td>'+$('.menuInsertModalOpt .table tbody tr')[0].children[2].children[0].value+'</td>'
			        							+'<td><a href="#" class="menu-option-select">변경</a> /'
												+'<a href="#" class="menu-option-delete">삭제</a></td></tr>'
			        							);
			        					
			        					$('.menuInsertModal').css('display', 'none');
			        				}
			        			}
			        		}
						});
					});	 // insertMenu
					
					$('.menuInsertModalOpt')
						.on('click','.addMenuList .card .card-body .table-responsive table tbody tr td .deleteOpt',function(e){
						e.preventDefault();
						$(this).parent().parent().remove();
					}); // menuInsertModalOpt
					
					$('.menuInsertModalOpt')
						.on('click','.addMenuList .card .card-body .table-responsive table tbody tr td .addOpt',function(e){
						
						e.preventDefault();
						$(this).parent().parent().parent().append(
							'<tr><td></td>'
							+'<td></td>'
							+'<td><input type="text" class=""></td>'
							+'<td><input type="text" class=""></td>'
							+'<td><button class="deleteOpt">'
							+'<img src="/business/resources/img/baseline_remove_circle_outline_black_18dp.png">'
							+'</button></td></tr>'
						);
					}); // menuInsertModalOpt
					
					
					$('#insertOpt').on('click',function(e){
						e.preventDefault();
							
			        		$('.menuInsertModalOpt').append(
			        				'<div class="col-md-12 addMenuList">'
			        				+'<div class="card">'
			        				+'<div class="card-header card-header-primary">'
			        				+'<h4 class="card-title ">옵션종류선택</h4>'
			        				+'</div>'
			        				+'<div class="card-body">'
			        				+'<div class="table-responsive">'
			        				+'<table class="table">'
			        				+'<thead class="text-primary">'
			        				+'<th>옵션분류</th>'
			        				+'<th>옵션분류이름</th>'
			        				+'<th>옵션이름</th>'
			        				+'<th>옵션추가가격</th>'
			        				+'<th>옵션추가삭제</th>'
			        				+'<th></th>'
			        				+'</thead>'
			        				+'<tbody>'
			        				+'<tr class="menuOptCl">'
			        				+'<td>'
			        				+'<select class="menuOptClSelect">'
			        				+'<option value="" class="OPT001" id="undefined">기본 단일(필수)</option>'
			        				+'<option value="" class="OPT002" id="undefined">기본 다중(필수)</option>'
			        				+'<option value="" class="OPT003" id="undefined">추가 단일(선택)</option>'
			        				+'<option value="" class="OPT004" id="undefined">추가 다중(선택)</option>'
			        				+'</select>'
			        				+'</td>'
			        				+'<td><input type="text" class=""></td>'
			        				+'<td><input type="text" class=""></td>'
			        				+'<td><input type="text" class=""></td>'
			        				+'<td><button class="addOpt">'
			        				+'<img src="/business/resources/img/baseline_add_circle_outline_black_18dp.png">'
			        				+'</button>'
			        				+'<button class="deleteMenuOpt">'
			        				+'<img src="/business/resources/img/baseline_remove_circle_outline_black_18dp.png">'
			        				+'</button>'
			        				+'</td></tr>'
			        				+'</tbody>'
			        				+'</table>'
			        				+'</div>'
			        				+'</div>'
			        				+'</div>'
			        				+'</div>'
			        		);
					}); // insertOpt
					
					$('.content #menuInsert').on('click',function(e){
						e.preventDefault();
						$('.menuInsertModal').css('display', 'block');
						$('.menuInsertModalOpt .addMenuList').remove();	
						
						$.ajax({
			        		type : "GET",
			        		dataType : 'json',
			        		url : "../../menu/main/getMenuCat",
			         		data : {
			         			bizId : $('#bizId').val()
			         		},
			        		error : function(data){
			        			console.log(data);
			        		},
			        		success(data){
//			        			console.log(data);
			        			$('#menuCatSelect').empty();
			        			for(let i=0;i<data.length;i++){
			        				$('#menuCatSelect').append('<option value="" class="'+data[i].mcBizId
			        						+'" id="'+data[i].mcNo+'" >'+data[i].mcName+'</option>');
			        			}
			        			
			        		}
						});
						
						$.ajax({
			        		type : "GET",
			        		dataType : 'json',
			        		url : "../../menu/main/getComCode.json",
			        		error : function(data){
//			        			console.log(data);
			        		},
			        		success(data){
//			        			console.log(data);
			        			$('#menuOptClSelect').empty();
			        			for(let i=0;i<data.length;i++){
			        				if(data[i].name=='기본 단일' || data[i].name=='기본 다중'){
			        					$('#menuOptClSelect').append('<option value="" class="'+data[i].id
			        							+'" id="'+data[i].mcNo+'" >'+data[i].name+'(필수)</option>');
			        				}else{
			        					$('#menuOptClSelect').append('<option value="" class="'+data[i].id
			        							+'" id="'+data[i].mcNo+'" >'+data[i].name+'(선택)</option>');
			        				}
			        			}
			        		}
						});
						
					}); // menuInsert click end

					
					$('#updateMenuBtn').on('click',function(e){
						
						let menuOptSel = $('.menuOptUp');
						let menuOptAll = $('.optAll');
						
						
						let menu = new Object();
						menu.mCode = $('.menuModalOpt tbody').children().eq(0).children().eq(0).text();
						menu.mPhoto = $('.menuModalOpt tbody').children().eq(0).children().eq(1).children().val();
						menu.mName = $('.menuModalOpt tbody').children().eq(0).children().eq(2).children().val();
						menu.mBasicPrice = $('.menuModalOpt tbody').children().eq(0).children().eq(3).children().val();
						console.log(menu.mPhoto);
						// 카테고리용
						let menuOptCl = new Array();
						
						for(let i=0;i<$('.menuOptUp').length;i++){
							let menuOptClsub = new Object();
							
//							// 카테고리 안의 옵션용
							let menuOpt = new Array();
							
							for(let j=0;j<$('.menuOptUp').eq(i).children().length;j++){
									let menuOptsub = new Object();
									menuOptsub.moCode = $('.menuOptUp').eq(i).children().eq(j).children().eq(0).text();
									menuOptsub.moName = $('.menuOptUp').eq(i).children().eq(j).children().eq(1).children().val();
									menuOptsub.moAddPrice = $('.menuOptUp').eq(i).children().eq(j).children().eq(2).children().val();
									menuOptsub.moOptClNo = $('.menuOptUp').eq(i).children().eq(j).children().eq(3).text();
									menuOpt.push(menuOptsub);
									console.log(menuOptsub);
							} // menuOptAll end
							menuOptClsub.menuOptEx = menuOpt;
							menuOptCl.push(menuOptClsub);
						} // menuOptSelect end
						menu.menuOptCl = menuOptCl;
						
						$.ajax({
			        		type : "POST",
			        		dataType : 'json',
			        		url : "../../menu/main/menuupdate",
			         		data : {
			         			"updateMenu" : JSON.stringify(menu)
			        		},
			        		error : function(data){
			        			console.log(data);
			        		},
			        		success(data){
			        			console.log(data);
			        			let menuCode = $('.menuModalOpt tbody tr').eq(0).children().eq(0).text();
			        			
			        			for(let i=0; i<$('.container-fluid .table tbody tr').length; i++){
			        				if($('.container-fluid .table tbody tr').eq(i).children().eq(0).text()
			        						== menuCode){
			        					
			        					$('.container-fluid .table tbody tr').eq(i).children().eq(1).innerHTML =  
			        							'<img src="https://s3.ap-northeast-2.amazonaws.com/honeybadgersfile/MenuPhoto/'+menuCode+'.png" style="width:60px;height:60px;"/>'
			        							;
			        					
			        					$('.container-fluid .table tbody tr').eq(i).children().eq(2).text($('.menuModalOpt tbody tr').eq(0).children().eq(2).children().val());
			        					
			        					$('.container-fluid .table tbody tr').eq(i).children().eq(3).text($('.menuModalOpt tbody tr').eq(0).children().eq(3).children().val());
			        				}
			        			}
			        			alert('변경되었습니다');
			        			deletePhoto(menu.mCode);
			        			updatePhoto(menu.mCode);
			        		}
						});
						
						$('.menuModal').css('display', 'none');
						
					}); // click end
					
			 		$('table tbody tr td ').on('click','.menu-option-select', function(e) {
						e.preventDefault();
						$('.menuModalOpt .col-md-12').remove();
						$('.menuModal').css('display', 'block');
						
						let menuNo = $(this).parent().parent().children().eq(0).text();
						let menuPhoto = $(this).parent().parent().children().eq(1).val();
						let menuName = $(this).parent().parent().children().eq(2).text();
						let menuPrice = $(this).parent().parent().children().eq(3).text();
						let menuCatName = $(this).parent().parent().parent().parent().parent().parent().parent().parent().children().eq(0).children().eq(0).children().eq(0).text();
						let menuInfo = $(this).parent().parent().children();
						
						$.ajax({
			        		type : "GET",
			        		url : "../../menu/main/update",
			        		dataType : "json",
			         		data : {
			         			mIdx : menuInfo.eq(0).text()
			        		},
			        		error : function(data){
			        			console.log(data);
			        		},
			        		success(data){
			        			console.log(data);
			        				$('.menuModalOpt').append(
			        						'<div class="col-md-12">'
			        						+'<div class="card">'
			        						+'<div class="card-header card-header-primary">'
			        						+'<h4 class="card-title ">메뉴변경</h4>'
			        						+'</div>'
			        						+'<div class="card-body">'
			        						+'<div class="table-responsive">'
			        						+'<table class="table">'
			        						+'<thead class="text-primary">'
			        						+'<th>메뉴코드</th>'
			        						+'<th>메뉴사진</th>'
			        						+'<th>메뉴이름</th>'
			        						+'<th>메뉴가격</th>'
			        						+'<th>메뉴구분</th>'
			        						+'</thead>'
			        						+'<tbody>'
			        						+'<tr>'
			        						+'<td>'+data[0].mcode+'</td>'
			        						+'<td><input type="file" id="updatePhoto" value="파일"></td>'
			        						+'<td><input type="text" class="" value="'+data[0].mname+'"></td>'
			        						+'<td><input type="text" class="" value="'+data[0].mbasicPrice+'"></td>'
			        						+'<td>'+menuCatName+'</td>'
			        						+'</tr>'
			        						+'</tbody>'
			        						+'</table>'
			        						+'</div>'
			        						+'</div>'
			        						+'</div>'
			        						+'</div>'
			        				);
			        				
			        				for(let i of data[0].menuOptCl){
				        				$('.menuModalOpt').append(
				        						'<div class="col-md-12">'
				        						+'<div class="card">'
				        						+'<div class="card-header card-header-primary">'
				        						+'<h4 class="card-title" id="'+i.mocNo+'">'+i.mocName+'</h4>'
				        						+'</div>'
				        						+'<div class="card-body">'
				        						+'<div class="table-responsive">'
				        						+'<table class="table">'
				        						+'<thead class="text-primary">'
				        						+'<th>옵션코드</th>'
				        						+'<th>옵션이름</th>'
				        						+'<th>옵션추가금액</th>'
				        						+'<th>옵션분류번호</th>'
				        						+'<th>옵션삭제</th>'
				        						+'</thead>'
				        						+'<tbody class="menuOptUp" id="opt'+i.mocNo+'">'
				        						+'</tbody>'
				        						+'</table>'
				        						+'</div>'
				        						+'</div>'
				        						+'</div>'
				        						+'</div>'
				        				);
				        				
				        				for(let j of i.menuOptEx){
				        					$('#opt'+i.mocNo+'').append(
				        							'<tr>'
					        						+'<td>'+j.moCode+'</td>'
					        						+'<td><input type="text" class="" value="'+j.moName+'"></td>'
					        						+'<td><input type="text" class="" value="'+j.moAddPrice+'"></td>'
					        						+'<td>'+j.moOptClNo+'</td>'
					        						+'<td><button class="deleteUpdateMenuOpt">'
							        				+'<img src="/business/resources/img/baseline_remove_circle_outline_black_18dp.png">'
							        				+'</button></td>'
					        						+'</tr>'
				        					);
				        				}
			        				}
			        				
			        			
								$.ajax({
					        		type : "GET",
					        		dataType : 'json',
					        		url : "../../menu/main/getMenuCat",
					         		data : {
					         			bizId : 'biz_2'
					         		},
					        		error : function(data){
					        			console.log(data);
					        		},
					        		success(data){
//					        			console.log(data);
					        			$('#menuCatUpdate').empty();
					        			for(let i=0;i<data.length;i++){
					        				$('.menuModalOpt #menuCatUpdate').append('<option value="" class="'+data[i].mcBizId
					        						+'" id="'+data[i].mcNo+'" >'+data[i].mcName+'</option>');
					        			}
					        		}
								}); // ajax2 소환

			        		} // success
			        	});	// post ajax끝
					}); 
				
					$('.menuModalClose').on('click', function() {
						$('.menuModal').css('display', 'none');
						});
					
					$('.menuInsertModalClose').on('click', function() {
						$('.menuInsertModal').css('display', 'none');
						});
					
					$('.insertMenuCatModalClose').on('click', function() {
						$('.insertMenuCatModal').css('display', 'none');
						});


					$()
							.ready(
									function() {
										$sidebar = $('.sidebar');

										$sidebar_img_container = $sidebar
												.find('.sidebar-background');

										$full_page = $('.full-page');

										$sidebar_responsive = $('body > .navbar-collapse');

										window_width = $(window).width();

										fixed_plugin_open = $(
												'.sidebar .sidebar-wrapper .nav li.active a p')
												.html();

										if (window_width > 767
												&& fixed_plugin_open == 'Dashboard') {
											if ($('.fixed-plugin .dropdown')
													.hasClass('show-dropdown')) {
												$('.fixed-plugin .dropdown')
														.addClass('open');
											}

										}

										$('.fixed-plugin a')
												.click(
														function(event) {
															// Alex if we click
															// on switch, stop
															// propagation of
															// the event, so the
															// dropdown will not
															// be hide,
															// otherwise we set
															// the section
															// active
															if ($(this)
																	.hasClass(
																			'switch-trigger')) {
																if (event.stopPropagation) {
																	event
																			.stopPropagation();
																} else if (window.event) {
																	window.event.cancelBubble = true;
																}
															}
														});

										$('.fixed-plugin .active-color span')
												.click(
														function() {
															$full_page_background = $('.full-page-background');

															$(this)
																	.siblings()
																	.removeClass(
																			'active');
															$(this).addClass(
																	'active');

															var new_color = $(
																	this).data(
																	'color');

															if ($sidebar.length != 0) {
																$sidebar
																		.attr(
																				'data-color',
																				new_color);
															}

															if ($full_page.length != 0) {
																$full_page
																		.attr(
																				'filter-color',
																				new_color);
															}

															if ($sidebar_responsive.length != 0) {
																$sidebar_responsive
																		.attr(
																				'data-color',
																				new_color);
															}
														});

										$(
												'.fixed-plugin .background-color .badge')
												.click(
														function() {
															$(this)
																	.siblings()
																	.removeClass(
																			'active');
															$(this).addClass(
																	'active');

															var new_color = $(
																	this)
																	.data(
																			'background-color');

															if ($sidebar.length != 0) {
																$sidebar
																		.attr(
																				'data-background-color',
																				new_color);
															}
														});

										$('.fixed-plugin .img-holder')
												.click(
														function() {
															$full_page_background = $('.full-page-background');

															$(this)
																	.parent(
																			'li')
																	.siblings()
																	.removeClass(
																			'active');
															$(this)
																	.parent(
																			'li')
																	.addClass(
																			'active');

															var new_image = $(
																	this)
																	.find("img")
																	.attr('src');

															if ($sidebar_img_container.length != 0
																	&& $('.switch-sidebar-image input:checked').length != 0) {
																$sidebar_img_container
																		.fadeOut(
																				'fast',
																				function() {
																					$sidebar_img_container
																							.css(
																									'background-image',
																									'url("'
																											+ new_image
																											+ '")');
																					$sidebar_img_container
																							.fadeIn('fast');
																				});
															}

															if ($full_page_background.length != 0
																	&& $('.switch-sidebar-image input:checked').length != 0) {
																var new_image_full_page = $(
																		'.fixed-plugin li.active .img-holder')
																		.find(
																				'img')
																		.data(
																				'src');

																$full_page_background
																		.fadeOut(
																				'fast',
																				function() {
																					$full_page_background
																							.css(
																									'background-image',
																									'url("'
																											+ new_image_full_page
																											+ '")');
																					$full_page_background
																							.fadeIn('fast');
																				});
															}

															if ($('.switch-sidebar-image input:checked').length == 0) {
																var new_image = $(
																		'.fixed-plugin li.active .img-holder')
																		.find(
																				"img")
																		.attr(
																				'src');
																var new_image_full_page = $(
																		'.fixed-plugin li.active .img-holder')
																		.find(
																				'img')
																		.data(
																				'src');

																$sidebar_img_container
																		.css(
																				'background-image',
																				'url("'
																						+ new_image
																						+ '")');
																$full_page_background
																		.css(
																				'background-image',
																				'url("'
																						+ new_image_full_page
																						+ '")');
															}

															if ($sidebar_responsive.length != 0) {
																$sidebar_responsive
																		.css(
																				'background-image',
																				'url("'
																						+ new_image
																						+ '")');
															}
														});

										$('.switch-sidebar-image input')
												.change(
														function() {
															$full_page_background = $('.full-page-background');

															$input = $(this);

															if ($input
																	.is(':checked')) {
																if ($sidebar_img_container.length != 0) {
																	$sidebar_img_container
																			.fadeIn('fast');
																	$sidebar
																			.attr(
																					'data-image',
																					'#');
																}

																if ($full_page_background.length != 0) {
																	$full_page_background
																			.fadeIn('fast');
																	$full_page
																			.attr(
																					'data-image',
																					'#');
																}

																background_image = true;
															} else {
																if ($sidebar_img_container.length != 0) {
																	$sidebar
																			.removeAttr('data-image');
																	$sidebar_img_container
																			.fadeOut('fast');
																}

																if ($full_page_background.length != 0) {
																	$full_page
																			.removeAttr(
																					'data-image',
																					'#');
																	$full_page_background
																			.fadeOut('fast');
																}

																background_image = false;
															}
														});

										$('.switch-sidebar-mini input')
												.change(
														function() {
															$body = $('body');

															$input = $(this);

															if (md.misc.sidebar_mini_active == true) {
																$('body')
																		.removeClass(
																				'sidebar-mini');
																md.misc.sidebar_mini_active = false;

																$(
																		'.sidebar .sidebar-wrapper, .main-panel')
																		.perfectScrollbar();

															} else {

																$(
																		'.sidebar .sidebar-wrapper, .main-panel')
																		.perfectScrollbar(
																				'destroy');

																setTimeout(
																		function() {
																			$(
																					'body')
																					.addClass(
																							'sidebar-mini');

																			md.misc.sidebar_mini_active = true;
																		}, 300);
															}

															// we simulate the
															// window Resize so
															// the charts will
															// get updated in
															// realtime.
															var simulateWindowResize = setInterval(
																	function() {
																		window
																				.dispatchEvent(new Event(
																						'resize'));
																	}, 180);

															// we stop the
															// simulation of
															// Window Resize
															// after the
															// animations are
															// completed
															setTimeout(
																	function() {
																		clearInterval(simulateWindowResize);
																	}, 1000);

														});
									}); // ()ready
			});	// document ready	