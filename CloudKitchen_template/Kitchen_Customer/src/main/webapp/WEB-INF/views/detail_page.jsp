<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="pizza, delivery food, fast food, sushi, take away, chinese, italian food">
    <meta name="description" content="">
    <meta name="author" content="Ansonika">
    <title>QuickFood - Quality delivery or take away food</title>

    <!-- Favicons-->
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" type="image/x-icon" href="img/apple-touch-icon-57x57-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="72x72" href="img/apple-touch-icon-72x72-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="114x114" href="img/apple-touch-icon-114x114-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="144x144" href="img/apple-touch-icon-144x144-precomposed.png">
    
    <!-- GOOGLE WEB FONT -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900" rel="stylesheet">

    <!-- BASE CSS -->
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/menu.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
    <link href="css/elegant_font/elegant_font.min.css" rel="stylesheet">
    <link href="css/fontello/css/fontello.min.css" rel="stylesheet">
    <link href="css/magnific-popup.css" rel="stylesheet">
    <link href="css/pop_up.css" rel="stylesheet">
    
    
    <!-- Radio and check inputs -->
    <link href="css/skins/square/grey.css" rel="stylesheet">

    <!-- YOUR CUSTOM CSS -->
    <link href="css/custom.css" rel="stylesheet">

</head>

<body>

	<div id="preloader">
        <div class="sk-spinner sk-spinner-wave" id="status">
            <div class="sk-rect1"></div>
            <div class="sk-rect2"></div>
            <div class="sk-rect3"></div>
            <div class="sk-rect4"></div>
            <div class="sk-rect5"></div>
        </div>
    </div><!-- End Preload -->

    <!-- Header ================================================== -->
    <header>
    <div class="container-fluid">
        <div class="row">
            <div class="col--md-4 col-sm-4 col-xs-4">
                <a href="/" id="logo">
                <img src="img/logo.png" width="190" height="23" alt="" data-retina="true" class="hidden-xs">
                <img src="img/logo_mobile.png" width="59" height="23" alt="" data-retina="true" class="hidden-lg hidden-md hidden-sm">
                </a>
            </div>
            <nav class="col--md-8 col-sm-8 col-xs-8">
            <a class="cmn-toggle-switch cmn-toggle-switch__htx open_close" href="javascript:void(0);"><span>모바일 메뉴</span></a>
            <div class="main-menu">
                <div id="header_menu">
                    <img src="img/logo.png" width="190" height="23" alt="" data-retina="true">
                </div>
                <a href="#" class="open_close" id="close_in"><i class="icon_close"></i></a>
                 <ul>
                    <li class="submenu">
                    <a href="javascript:void(0);" class="show-submenu">Home<i class="icon-down-open-mini"></i></a>
                    </li>
                    <li class="submenu">
                    <a href="javascript:void(0);" class="show-submenu">Restaurants<i class="icon-down-open-mini"></i></a>
                    <ul>
                        <li><a href="list_page.html">Row listing</a></li>
                        <li><a href="grid_list.html">Grid listing</a></li>
                        <li><a href="map_listing.html">Map listing</a></li>
                        <li><a href="detail_page.html">Restaurant Menu</a></li>
                        <li><a href="submit_restaurant.html">Submit Restaurant</a></li>
                        <li><a href="cart.html">Order step 1</a></li>
                        <li><a href="cart_2.html">Order step 2</a></li>
                        <li><a href="cart_3.html">Order step 3</a></li>
                        <li><a href="cart_datepicker.html">Order Date/Time picker</a></li>
                    </ul>
                    </li>
                    <li><a href="about.html">About us</a></li>
                    <li><a href="faq.html">Faq</a></li>
                    <li class="submenu">
                    <a href="javascript:void(0);" class="show-submenu">Pages<i class="icon-down-open-mini"></i></a>
                    <ul>
                        <li><a href="RTL_version//">RTL version</a></li>
                        <li><a href="admin.html">Admin section</a></li>
                        <li><a href="submit_driver.html">Submit Driver</a></li>
                        <li><a href="#0" data-toggle="modal" data-target="#login_2">User Login</a></li>
                        <li><a href="#0" data-toggle="modal" data-target="#register">User Register</a></li>
                        <li><a href="detail_page_2.html">Restaurant detail page</a></li>
                        <li><a href="blog.html">Blog</a></li>
                        <li><a href="contacts.html">Contacts</a></li>
                        <li><a href="coming_soon//">Coming soon page</a></li>
                        <li><a href="shortcodes.html">Shortcodes</a></li>
                        <li><a href="icon_pack_1.html">Icon pack 1</a></li>
                        <li><a href="icon_pack_2.html">Icon pack 2</a></li>
                    </ul>
                    </li>
                    <li><a href="#0" data-toggle="modal" data-target="#login_2">Login</a></li>
                    <li><a href="#0">Purchase this template</a></li>
                </ul>
            </div><!-- End main-menu -->
            </nav>
        </div><!-- End row -->
    </div><!-- End container -->
    </header>
    <!-- End Header =============================================== -->

<!-- SubHeader =============================================== -->
<section class="parallax-window" data-parallax="scroll" data-image-src="img/sub_header_2.jpg" data-natural-width="1400" data-natural-height="470">
    <div id="subheader">
	<div id="sub_content">
    	<div id="thumb"><img src="img/thumb_restaurant.jpg" alt=""></div>
                     <div class="rating"><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i> (<small><a href="detail_page_2.html">Read 98 reviews</a></small>)</div>
                    <h1>Mexican TacoMex</h1>
                    <div><em>Mexican / American</em></div>
                    <div><i class="icon_pin"></i> 135 Newtownards Road, Belfast, BT4 1AB - <strong>Delivery charge:</strong> $10, free over $15.</div>
    </div><!-- End sub_content -->
</div><!-- End subheader -->
</section><!-- End section -->
<!-- End SubHeader ============================================ -->

    <div id="position">
        <div class="container">
            <ul>
                <li><a href="#0">Home</a></li>
                <li><a href="#0">Category</a></li>
                <li>Page active</li>
            </ul>
            <a href="#0" class="search-overlay-menu-btn"><i class="icon-search-6"></i> Search</a>
        </div>
    </div><!-- Position -->

<!-- Content ================================================== -->
<div class="container margin_60_35">
		<div class="row">
        
			<div class="col-md-3">
            	<p><a href="list_page.html" class="btn_side">Back to search</a></p>
				<div class="box_style_1">
					<ul id="cat_nav">
						<li><a href="#starters" class="active">Starters <span>(141)</span></a></li>
						<li><a href="#main_courses">Main Courses <span>(20)</span></a></li>
						<li><a href="#beef">Beef <span>(12)</span></a></li>
						<li><a href="#desserts">Desserts <span>(11)</span></a></li>
						<li><a href="#drinks">Drinks <span>(20)</span></a></li>
					</ul>
				</div><!-- End box_style_1 -->
                
				<div class="box_style_2 hidden-xs" id="help">
					<i class="icon_lifesaver"></i>
					<h4>Need <span>Help?</span></h4>
					<a href="tel://004542344599" class="phone">+45 423 445 99</a>
					<small>Monday to Friday 9.00am - 7.30pm</small>
				</div>
			</div><!-- End col-md-3 -->
            
			<div class="col-md-6">
				<div class="box_style_2" id="main_menu">
					<h2 class="inner">Menu</h2>
					<h3 class="nomargin_top" id="starters">Starters</h3>
					<p>
						Te ferri iisque aliquando pro, posse nonumes efficiantur in cum. Sensibus reprimique eu pro. Fuisset mentitum deleniti sit ea.
					</p>
					<table class="table table-striped cart-list">
					<thead>
					<tr>
						<th>
							 Item
						</th>
						<th>
							 Price
						</th>
						<th>
							 Order
						</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-1.jpg" alt="thumb"></figure>
							<h5>1. Mexican Enchiladas</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 9,40</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_1" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_1" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_1" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-2.jpg" alt="thumb"></figure>
							<h5>2. Fajitas</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 6,80</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_2" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_2" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_2" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-3.jpg" alt="thumb"></figure>
							<h5>3. Royal Fajitas</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 5,70</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_3" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_3" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_3" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-4.jpg" alt="thumb"></figure>
							<h5>4. Chicken Enchilada Wrap</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 5,20</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_4" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_4" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_4" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					</tbody>
					</table>
					<hr>
					<h3 id="main_courses">Main courses</h3>
					<p>
						Te ferri iisque aliquando pro, posse nonumes efficiantur in cum. Sensibus reprimique eu pro. Fuisset mentitum deleniti sit ea.
					</p>
					<table class="table table-striped cart-list ">
					<thead>
					<tr>
						<th>
							 Item
						</th>
						<th>
							 Price
						</th>
						<th>
							 Order
						</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-5.jpg" alt="thumb"></figure>
							<h5>5. Cheese Quesadilla</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 12,00</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_5" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_5" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_5" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-6.jpg" alt="thumb"></figure>
							<h5>6. Chorizo & Cheese</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 24,71</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_6" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_6" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_6" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-7.jpg" alt="thumb"></figure>
							<h5>7. Beef Taco</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 8,70</strong>
						</td>
						<td class="options">
							<a href="#0"><i class="icon_plus_alt2"></i></a>
						</td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-8.jpg" alt="thumb"></figure>
							<h5>8. Minced Beef Double Layer</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 6,30</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_7" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_7" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_7" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-9.jpg" alt="thumb"></figure>
							<h5>9. Piri Piri Chicken</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 7,40</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_8" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_8" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_8" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-10.jpg" alt="thumb"></figure>
							<h5>10. Burrito Al Pastor</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 7,70</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_9" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_9" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_9" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					</tbody>
					</table>
					<hr>
					<h3 id="beef">Beef</h3>
					<p>
						Te ferri iisque aliquando pro, posse nonumes efficiantur in cum. Sensibus reprimique eu pro. Fuisset mentitum deleniti sit ea.
					</p>
					<table class="table table-striped cart-list ">
					<thead>
					<tr>
						<th>
							 Item
						</th>
						<th>
							 Price
						</th>
						<th>
							 Order
						</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-11.jpg" alt="thumb"></figure>
							<h5>11. Beef Enchilada Wrap</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 11,70</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_10" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_10" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_10" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-12.jpg" alt="thumb"></figure>
							<h5>12. Chicken Fillet Taco</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 12,40</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_11" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_11" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_11" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-13.jpg" alt="thumb"></figure>
							<h5>13. Tiger Prawn & Chorizo</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 24,71</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_12" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_12" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_12" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-14.jpg" alt="thumb"></figure>
							<h5>14. Fillet Steak & Chorizo</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 15,30</strong>
						</td>
						<td class="options">
							<a href="#0"><i class="icon_plus_alt2"></i></a>
						</td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-15.jpg" alt="thumb"></figure>
							<h5>15. Burrito's with Rice</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 9,70</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_13" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_13" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_13" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-16.jpg" alt="thumb"></figure>
							<h5>16. Mexican Burger</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 8,30</strong>
						</td>
						<td class="options">
                        <div class="dropdown dropdown-options">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="icon_plus_alt2"></i></a>
                            <div class="dropdown-menu">
                                <h5>Select an option</h5>
                                <label>
                                <input type="radio" value="option1" name="options_14" checked>Medium <span>+ $3.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option2" name="options_14" >Large <span>+ $5.30</span>
                                </label>
                                <label>
                                <input type="radio" value="option3" name="options_14" >Extra Large <span>+ $8.30</span>
                                </label>
                                <h5>Add ingredients</h5>
                                <label>
                                <input type="checkbox" value="">Extra Tomato <span>+ $4.30</span>
                                </label>
                                <label>
                                <input type="checkbox" value="">Extra Peppers <span>+ $2.50</span>
                                </label>
                                <a href="#0" class="add_to_basket">Add to cart</a>
                            </div>
                        </div>
                    </td>
					</tr>
					</tbody>
					</table>
					<hr>
					<h3 id="desserts">Desserts</h3>
					<p>
						Te ferri iisque aliquando pro, posse nonumes efficiantur in cum. Sensibus reprimique eu pro. Fuisset mentitum deleniti sit ea.
					</p>
					<table class="table table-striped cart-list ">
					<thead>
					<tr>
						<th>
							 Item
						</th>
						<th>
							 Price
						</th>
						<th>
							 Order
						</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-17.jpg" alt="thumb"></figure>
							<h5>17. Chocolate Fudge Cake</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 24,71</strong>
						</td>
						<td class="options">
							<a href="#0"><i class="icon_plus_alt2"></i></a>
						</td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-18.jpg" alt="thumb"></figure>
							<h5>18. Cheesecake</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 7,50</strong>
						</td>
						<td class="options">
							<a href="#0"><i class="icon_plus_alt2"></i></a>
						</td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-19.jpg" alt="thumb"></figure>
							<h5>19. Apple Pie & Custard</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 9,70</strong>
						</td>
						<td class="options">
							<a href="#0"><i class="icon_plus_alt2"></i></a>
						</td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-20.jpg" alt="thumb"></figure>
							<h5>20. Profiteroles</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 12,00</strong>
						</td>
						<td class="options">
							<a href="#0"><i class="icon_plus_alt2"></i></a>
						</td>
					</tr>
					</tbody>
					</table>
					<hr>
					<h3 id="drinks">Drinks</h3>
					<p>
						Te ferri iisque aliquando pro, posse nonumes efficiantur in cum. Sensibus reprimique eu pro. Fuisset mentitum deleniti sit ea.
					</p>
					<table class="table table-striped cart-list ">
					<thead>
					<tr>
						<th>
							 Item
						</th>
						<th>
							 Price
						</th>
						<th>
							 Order
						</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-21.jpg" alt="thumb"></figure>
							<h5>21. Coke 0.33L</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 5,70</strong>
						</td>
						<td class="options">
							<a href="#0"><i class="icon_plus_alt2"></i></a>
						</td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-22.jpg" alt="thumb"></figure>
							<h5>2. Diet Coke 0.33L</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 2,70</strong>
						</td>
						<td class="options">
							<a href="#0"><i class="icon_plus_alt2"></i></a>
						</td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-23.jpg" alt="thumb"></figure>
							<h5>3. Diet Coke 1L</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 5,70</strong>
						</td>
						<td class="options">
							<a href="#0"><i class="icon_plus_alt2"></i></a>
						</td>
					</tr>
					<tr>
						<td>
                        	<figure class="thumb_menu_list"><img src="img/menu-thumb-24.jpg" alt="thumb"></figure>
							<h5>4. Fanta Orange 0.33L</h5>
							<p>
								Fuisset mentitum deleniti sit ea.
							</p>
						</td>
						<td>
							<strong>€ 2,70</strong>
						</td>
						<td class="options">
							<a href="#0"><i class="icon_plus_alt2"></i></a>
						</td>
					</tr>
					</tbody>
					</table>
				</div><!-- End box_style_1 -->
			</div><!-- End col-md-6 -->
            
			<div class="col-md-3" id="sidebar">
            <div class="theiaStickySidebar">
				<div id="cart_box" >
					<h3>Your order <i class="icon_cart_alt pull-right"></i></h3>
					<table class="table table_summary">
					<tbody>
					<tr>
						<td>
							<a href="#0" class="remove_item"><i class="icon_minus_alt"></i></a> <strong>1x</strong> Enchiladas
						</td>
						<td>
							<strong class="pull-right">$11</strong>
						</td>
					</tr>
					<tr>
						<td>
							<a href="#0" class="remove_item"><i class="icon_minus_alt"></i></a> <strong>2x</strong> Burrito
						</td>
						<td>
							<strong class="pull-right">$14</strong>
						</td>
					</tr>
					<tr>
						<td>
							<a href="#0" class="remove_item"><i class="icon_minus_alt"></i></a> <strong>1x</strong> Chicken
						</td>
						<td>
							<strong class="pull-right">$20</strong>
						</td>
					</tr>
					<tr>
						<td>
							<a href="#0" class="remove_item"><i class="icon_minus_alt"></i></a> <strong>2x</strong> Corona Beer
						</td>
						<td>
							<strong class="pull-right">$9</strong>
						</td>
					</tr>
					<tr>
						<td>
							<a href="#0" class="remove_item"><i class="icon_minus_alt"></i></a> <strong>2x</strong> Cheese Cake
						</td>
						<td>
							<strong class="pull-right">$12</strong>
						</td>
					</tr>
					</tbody>
					</table>
					<hr>
					<div class="row" id="options_2">
						<div class="col-lg-6 col-md-12 col-sm-12 col-xs-6">
							<label><input type="radio" value="" checked name="option_2" class="icheck">Delivery</label>
						</div>
						<div class="col-lg-6 col-md-12 col-sm-12 col-xs-6">
							<label><input type="radio" value="" name="option_2" class="icheck">Take Away</label>
						</div>
					</div><!-- Edn options 2 -->
                    
					<hr>
					<table class="table table_summary">
					<tbody>
					<tr>
						<td>
							 Subtotal <span class="pull-right">$56</span>
						</td>
					</tr>
					<tr>
						<td>
							 Delivery fee <span class="pull-right">$10</span>
						</td>
					</tr>
					<tr>
						<td class="total">
							 TOTAL <span class="pull-right">$66</span>
						</td>
					</tr>
					</tbody>
					</table>
					<hr>
					<a class="btn_full" href="cart.html">Order now</a>
				</div><!-- End cart_box -->
                </div><!-- End theiaStickySidebar -->
			</div><!-- End col-md-3 -->
            
		</div><!-- End row -->
</div><!-- End container -->
<!-- End Content =============================================== -->

<!-- Footer ================================================== -->
	<footer>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-sm-3">
                  	<h3>Secure payments with</h3>
                    <p><img src="img/cards.png" alt="" class="img-responsive"></p>
                    
                </div>
                <div class="col-md-3 col-sm-3">
                    <h3>About</h3>
                    <ul>
                        <li><a href="about.html">About us</a></li>
                        <li><a href="faq.html">Faq</a></li>
                         <li><a href="contacts.html">Contacts</a></li>
                        <li><a href="#0" data-toggle="modal" data-target="#login_2">Login</a></li>
                        <li><a href="#0" data-toggle="modal" data-target="#register">Register</a></li>
                        <li><a href="#0">Terms and conditions</a></li>
                    </ul>
                </div>
                <div class="col-md-3 col-sm-3"  id="newsletter">
                    <h3>Newsletter</h3>
                    <p>Join our newsletter to keep be informed about offers and news.</p>
					<div id="message-newsletter_2"></div>
						<form method="post" action="assets/newsletter.php" name="newsletter_2" id="newsletter_2">
                        <div class="form-group">
                            <input name="email_newsletter_2" id="email_newsletter_2"  type="email" value=""  placeholder="Your mail" class="form-control">
                          </div>
                            <input type="submit" value="Subscribe" class="btn_1" id="submit-newsletter_2">
                    	</form>
                </div>
                <div class="col-md-2 col-sm-3">
                    <h3>Settings</h3>
                    <div class="styled-select">
                        <select class="form-control" name="lang" id="lang">
                            <option value="English" selected>English</option>
                            <option value="French">French</option>
                            <option value="Spanish">Spanish</option>
                            <option value="Russian">Russian</option>
                        </select>
                    </div>
                    <div class="styled-select">
                        <select class="form-control" name="currency" id="currency">
                            <option value="USD" selected>USD</option>
                            <option value="EUR">EUR</option>
                            <option value="GBP">GBP</option>
                            <option value="RUB">RUB</option>
                        </select>
                    </div>
                </div>
            </div><!-- End row -->
            <div class="row">
                <div class="col-md-12">
                    <div id="social_footer">
                        <ul>
                            <li><a href="#0"><i class="icon-facebook"></i></a></li>
                            <li><a href="#0"><i class="icon-twitter"></i></a></li>
                            <li><a href="#0"><i class="icon-google"></i></a></li>
                            <li><a href="#0"><i class="icon-instagram"></i></a></li>
                            <li><a href="#0"><i class="icon-pinterest"></i></a></li>
                            <li><a href="#0"><i class="icon-vimeo"></i></a></li>
                            <li><a href="#0"><i class="icon-youtube-play"></i></a></li>
                        </ul>
                        <p>© Quick Food 2015</p>
                    </div>
                </div>
            </div><!-- End row -->
        </div><!-- End container -->
    </footer>
<!-- End Footer =============================================== -->

<div class="layer"></div><!-- Mobile menu overlay mask -->
    
<!-- Login modal -->   
<div class="modal fade" id="login_2" tabindex="-1" role="dialog" aria-labelledby="myLogin" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content modal-popup">
				<a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
				<form action="#" class="popup-form" id="myLogin">
                	<div class="login_icon"><i class="icon_lock_alt"></i></div>
					<input type="text" class="form-control form-white" placeholder="Username">
					<input type="text" class="form-control form-white" placeholder="Password">
					<div class="text-left">
						<a href="#">Forgot Password?</a>
					</div>
					<button type="submit" class="btn btn-submit">Submit</button>
				</form>
			</div>
		</div>
	</div><!-- End modal -->   
    
<!-- Register modal -->   
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myRegister" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content modal-popup">
				<a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
				<form action="#" class="popup-form" id="myRegister">
                	<div class="login_icon"><i class="icon_lock_alt"></i></div>
					<input type="text" class="form-control form-white" placeholder="Name">
					<input type="text" class="form-control form-white" placeholder="Last Name">
                    <input type="email" class="form-control form-white" placeholder="Email">
                    <input type="text" class="form-control form-white" placeholder="Password"  id="password1">
                    <input type="text" class="form-control form-white" placeholder="Confirm password"  id="password2">
                    <div id="pass-info" class="clearfix"></div>
					<div class="checkbox-holder text-left">
						<div class="checkbox">
							<input type="checkbox" value="accept_2" id="check_2" name="check_2" />
							<label for="check_2"><span>I Agree to the <strong>Terms &amp; Conditions</strong></span></label>
						</div>
					</div>
					<button type="submit" class="btn btn-submit">Register</button>
				</form>
			</div>
		</div>
	</div><!-- End Register modal -->
    
    <!-- Search Menu -->
	<div class="search-overlay-menu">
		<span class="search-overlay-close"><i class="icon_close"></i></span>
		<form role="search" id="searchform" method="get">
			<input value="" name="q" type="search" placeholder="Search..." />
			<button type="submit"><i class="icon-search-6"></i>
			</button>
		</form>
	</div>
	<!-- End Search Menu -->
    
<!-- COMMON SCRIPTS -->
<script src="js/jquery-2.2.4.min.js"></script>
<script src="js/common_scripts_min.js"></script>
<script src="js/functions.js"></script>
<script src="assets/validate.js"></script>

<!-- SPECIFIC SCRIPTS -->
<script  src="js/cat_nav_mobile.js"></script>
<script>$('#cat_nav').mobileMenu();</script>
<script src="js/ResizeSensor.min.js"></script>
<script src="js/theia-sticky-sidebar.min.js"></script>
<script>
    jQuery('#sidebar').theiaStickySidebar({
      additionalMarginTop: 80
    });
</script>
<!-- SMOOTH SCROLL -->
<script>
	$('#cat_nav a[href^="#"]').click(function() {
		if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') 
			|| location.hostname == this.hostname) {
			var target = $(this.hash);
			target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
			   if (target.length) {
				 $('html,body').animate({
					 scrollTop: target.offset().top -75
				}, 800);
				return false;
			}
		}
	});
</script>
</body>
</html>