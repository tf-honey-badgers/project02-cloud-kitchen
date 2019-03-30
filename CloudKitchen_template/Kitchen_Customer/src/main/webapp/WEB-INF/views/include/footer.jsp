<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Search Menu ============================================ -->
	<div class="search-overlay-menu">
		<span class="search-overlay-close"><i class="icon_close"></i></span>
		<form role="search" id="searchform" method="get">
			<input value="" name="q" type="search" placeholder="Search..." />
			<button type="submit">
				<i class="icon-search-6"></i>
			</button>
		</form>
	</div>
<!-- End Search Menu ============================================ -->

<!-- Footer ================================================== -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-3">
                <h3>Secure payments with</h3>
                <p><img src="/customer/resources/img/cards.png" alt="" class="img-responsive"></p>
            </div>
            <div class="col-md-3 col-sm-3">
                <h3>About</h3>
                <ul>                    
                    <li><a href="faq.html">Faq</a></li>
                    <li><a href="contacts.html">Contacts</a></li>
                    <li><a href="#0" data-toggle="modal" data-target="#login_2">Login</a></li>
                    <li><a href="#0" data-toggle="modal" data-target="#register">Register</a></li>
                    <li><a href="#0">Terms and conditions</a></li>
                    <li><a href="about.html">About us</a></li>
                </ul>
            </div>
            <div class="col-md-3 col-sm-3" id="newsletter">
                <h3>Newsletter</h3>
                <p>Join our newsletter to keep be informed about offers and news.</p>
                <div id="message-newsletter_2"></div>
                <form method="post" action="assets/newsletter.php" name="newsletter_2" id="newsletter_2">
                    <div class="form-group">
                        <input name="email_newsletter_2" id="email_newsletter_2" type="email" value="" placeholder="Your mail" class="form-control">
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
        </div> <!-- End row -->
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
        </div> <!-- End row -->
    </div> <!-- End container -->
</footer> <!-- End Footer =============================================== -->

<!-- COMMON SCRIPTS -->
<script src="/customer/resources/js/jquery-2.2.4.min.js"></script>
<script src="/customer/resources/js/common_scripts_min.js"></script>
<script src="/customer/resources/js/functions.js"></script>
<script src="/customer/resources/assets/validate.js"></script>

<!-- Modernizr -->
<script src="/customer/resources/js/modernizr.js"></script>

<!-- Customer Member 관련 각종 JavaScript 함수 모음 -->
<script src="/customer/resources/js/member.js" type="text/javascript"></script>

<!-- SPECIFIC SCRIPTS -->
<script type="text/javascript">
	$(document).ready(function() { // makes sure the whole site is loaded
		$('#status').fadeOut(); // will first fade out the loading animation
		$('#preloader').delay(250).fadeOut('slow'); // will fade out the white DIV that covers the website.
		$('body').delay(250).css({
			'overflow' : 'visible'
		});
		$('#sub_content').addClass('animated zoomIn');
		$(window).scroll();
		$('.number').each(function() {
			$(this).prop('Counter', 0).animate({
				Counter : $(this).text()
			}, {
				duration : 2000,
				easing : 'swing',
				step : function(now) {
					$(this).text(Math.ceil(now));
				}
			});
		});
	});
</script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"
	integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>
<style>
	.ui-autocomplete-category {
		font-weight: bold;
		padding: .2em .4em;
		margin: .8em 0 .2em;
		line-height: 1.5;
	}
</style>
<script>
/* 검색 기능 */
$(document).ready(function() {
	let source = [];
	$.ajax({
		type : 'GET'
		, url : 'http://localhost:3001/customer/kitchen/lists.json'
		, contentType : 'application/json'
	 	, success : function(data) {
	 		let readList, category;
	 		for(let i = 0; i < 3; i++) {
 				if(i == 0) {
	 				readList = data.kitchenList;
	 				category = "지점";
			 		for(let j = 0; j < readList.length; j++) {
				 		let readLine = readList[j];
				 		source.push({label: readLine.kitchenname, category: category});				 		
			 		}
	 			}
 				if(i == 1) {
 					readList = data.bizList;
 					category = "가게";
			 		for(let j = 0; j < readList.length; j++) {
				 		let readLine = readList[j];
				 		source.push({label: readLine.bizName, category: category});				 		
			 		}
	 			}
	 			if(i == 2) {
	 				readList = data.menuList;
 					category = "메뉴";
			 		for(let j = 0; j < readList.length; j++) {
				 		let readLine = readList[j];
				 		source.push({label: readLine.mname, category: category});				 		
			 		}
 				}
 			}
	  	}
		, error : function(data) {
			console.log('ERRoR oCCURRED');
			console.log(data);
		}
	});

	$.widget( "custom.catcomplete", $.ui.autocomplete, {
		_create: function() {
    		this._super();
	        this.widget().menu( "option", "items", "> :not(.ui-autocomplete-category)" );
		},
		_renderMenu: function( ul, items ) {
    		var that = this, currentCategory = " ";
        	$.each( items, function( index, item ) {
	        	var li;
	        	if ( item.category != currentCategory ) {
	        		ul.append( "<li class='ui-autocomplete-category'>" + item.category + "</li>" );
    	    		currentCategory = item.category;
        		}
        		li = that._renderItemData( ul, item );
	        	if ( item.category ) {
	        		li.attr( "aria-label", item.category + " : " + item.label );
	        	}
    	    });
		}
	});

	$(".search-query").catcomplete({
		delay : 0
		, source : source
	});
	
/* 검색창에 입력 후 검색하기 클릭하면... */
	$('#searchBtn').on('click', () => {
		$.ajax({
			type : 'POST'
			, url : 'http://localhost:3001/customer/kitchen/search.json'
			, contentType : 'application/json'
			, data : {
				query : $('.search-query').val()
			}
		 	, success : function(data) {
		 		console.log(data);
		 		$('#searchResults').append('<div>' + data + '</div>');
		  	}
			, error : function(data) {
				console.log('ERRoR oCCURRED');
				console.log(data);
			}
		});
	});
});
</script>
