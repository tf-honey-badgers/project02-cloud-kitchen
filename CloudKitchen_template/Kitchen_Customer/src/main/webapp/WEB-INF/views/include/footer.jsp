<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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