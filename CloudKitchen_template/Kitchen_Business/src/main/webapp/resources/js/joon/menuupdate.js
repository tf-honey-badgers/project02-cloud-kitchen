$(document)
		.ready(
				function() {
					
					$('.menuInsert').on('click',function(e){
						$('.menuInsertModalOpt').css('display', 'block');
					});
					
					
					
					$('#updateMenuBtn').on('click',function(e){
						
						let menuOptSel = $('.menuOptSelect');
						let menuOptAll = $('.optAll');
						
						// 카테고리용
						let menuOptCl = new Array();
						
						for(let i=0;i<$('.menuOptSelect').length;i++){
							let menuOptClsub = new Object();
							
							menuOptClsub.mocNo = parseInt(menuOptSel[i].childNodes[0].innerHTML);
							menuOptClsub.mocName = menuOptSel[i].childNodes[1].innerHTML;
							menuOptClsub.mocMenuOptType = menuOptSel[i].childNodes[2].innerHTML;
							menuOptClsub.mocMenuCode = parseInt(menuOptSel[i].childNodes[3].innerHTML);
							
							// 카테고리 안의 옵션용
							let menuOpt = new Array();
							
							for(let j=0;j<menuOptAll.length;j++){
								if(menuOptSel[i].childNodes[0].innerHTML == menuOptAll[j].children[3].innerHTML){
									let menuOptsub = new Object();
									menuOptsub.moCode = parseInt(menuOptAll[j].children[0].innerHTML);
									menuOptsub.moName = menuOptAll[j].children[1].children[0].value;
									menuOptsub.moAddPrice = parseInt(menuOptAll[j].children[2].children[0].value);
									menuOptsub.moOptClNo = parseInt(menuOptAll[j].children[3].innerHTML);
									menuOpt.push(menuOptsub);
								}// menuOptAll if end
							} // menuOptAll end
							menuOptClsub.menuOptEx = menuOpt;
							menuOptCl.push(menuOptClsub);
						} // menuOptSelect end
						
						let menu = new Object();
						menu.mCode = parseInt($('.menuVal').children().eq(0).text());
						menu.mPhoto = $('.menuVal').children().eq(1).text();
						menu.mName = $('.menuVal').children().eq(2).children().val();
						menu.mBasicPrice = parseInt($('.menuVal').children().eq(3).children().val());
						menu.menuOptCl = menuOptCl;
						console.log(menu);

						$.ajax({
			        		type : "POST",
			        		dataType : 'json',
			        		url : "../menu/main/menuupdate",
			         		data : {
			         			"updateMenu" : JSON.stringify(menu)
			        		},
			        		error : function(data){
			        			console.log(data);
			        		},
			        		success(data){
			        			console.log(data);
			        			alert('변경되었습니다');
			        		}
						});
						
						$('.menuModal').css('display', 'none');
						
					}); // click end
					
			 		$('table tbody tr td .menu-option-select').on('click', function(e) {
						e.preventDefault();
						$('.menuModalOpt table').empty();
						$('.menuModal').css('display', 'block');
						
						let menuNo = $(this).parent().parent().children().eq(0).text();
						let menuPhoto = $(this).parent().parent().children().eq(1).text();
						let menuName = $(this).parent().parent().children().eq(2).text();
						let menuPrice = $(this).parent().parent().children().eq(3).text();
						
						$.ajax({
			        		type : "GET",
			        		url : "../menu/main/update",
			        		dataType : "json",
			         		data : {
			         			mIdx : $(this).parent().parent().children().eq(0).text()
			        		},
			        		error : function(data){
			        			console.log(data);
			        		},
			        		success(data){
		        				$('.menuOpt').append('<tr class="menuSelect">'
		        						+'<th class="menuNo">'+$('.text-primary tr th').eq(0).text()+'</th>'
		        						+'<th>'+$('.text-primary tr th').eq(1).text()+'</th>'
		        						+'<th>'+$('.text-primary tr th').eq(2).text()+'</th>'
		        						+'<th class="menuCat">'+$('.text-primary tr th').eq(3).text()+'</th>'
		        						+'</tr>');
		        				
		        				$('.menuOpt').append('<tr class="menuVal">'
		        						+'<td class="menuNo">'+menuNo+'</td>'
		        						+'<td>'+menuPhoto+'</td>'
		        						+'<td><input type="text" value="'+menuName+'"></td>'
		        						+'<td><input type="text" value="'+menuPrice+'"></td>'
		        						+'</tr>');

			        			for(let i of data[0].menuOptCl){
			        				$('.menuOpt').append('<tr class="menuOptSelect">'
			        						+'<th class="">'+i.mocNo+'</th>'
			        						+'<th>'+i.mocName+'</th>'
			        						+'<th>'+i.mocMenuOptType+'</th>'
			        						+'<th class="optNoCl">'+i.mocMenuCode+'</th>'
			        						+'</tr>');
			        				
			        				for(let j of i.menuOptEx){
			        					if(i.mocMenuOptType == 'OPT001'){
			        						$('.menuOpt').append('<tr class="menuOptVal1 optAll">'
			        								+'<td class="optNo1">'+j.moCode+'</td>'
			        								+'<td class="optNo1"><input type="text" value="'+j.moName+'"></td>'
			        								+'<td class="optNo1"><input type="text" value="'+j.moAddPrice+'"></td>'
			        								+'<td class="optNo1" id="optNoCl">'+j.moOptClNo+'</td>'
			        								+'</tr>');
			        						
			        					} else if(i.mocMenuOptType == 'OPT002'){
			        						$('.menuOpt').append('<tr class="menuOptVal2 optAll">'
			        								+'<td class="optNo2">'+j.moCode+'</td>'
			        								+'<td class="optNo2"><input type="text" value="'+j.moName+'"></td>'
			        								+'<td class="optNo2"><input type="text" value="'+j.moAddPrice+'"></td>'
			        								+'<td class="optNo2" id="optNoCl">'+j.moOptClNo+'</td>'
			        								+'</tr>');
			        					
			        					} else if(i.mocMenuOptType == 'OPT003'){
			        						$('.menuOpt').append('<tr class="menuOptVal3 optAll">'
			        								+'<td class="optNo3">'+j.moCode+'</td>'
			        								+'<td class="optNo3"><input type="text" value="'+j.moName+'"></td>'
			        								+'<td class="optNo3"><input type="text" value="'+j.moAddPrice+'"></td>'
			        								+'<td class="optNo3">'+j.moOptClNo+'</td>'
			        								+'</tr>');
			        						
			        					} else if(i.mocMenuOptType == 'OPT004'){
			        						$('.menuOpt').append('<tr class="menuOptVal4 optAll">'
			        								+'<td class="optNo4">'+j.moCode+'</td>'
			        								+'<td class="optNo4"><input type="text" value="'+j.moName+'"></td>'
			        								+'<td class="optNo4"><input type="text" value="'+j.moAddPrice+'"></td>'
			        								+'<td class="optNo4">'+j.moOptClNo+'</td>'
			        								+'</tr>');
			        					}
			        				}
			        			} // 옵션분류 for
			        		} // success
			        	});	// post ajax끝
					}); 
				
					$('.menuModalClose').on('click', function() {
						$('.menuModal').css('display', 'none');
						$('.menuInsertModal').css('display', 'none');
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
									});
				});