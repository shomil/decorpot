<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="decorpot">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="resources/core/img/1a.png" type="image/x-icon">

<title>decorpot.com</title>
<script type="text/javascript">
    var _contextPath = "${pageContext.request.contextPath}";
</script>
<link href="resources/core/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/core/css/style.css" rel="stylesheet">
<!-- CSS reset -->
<!-- Resource style -->
<!-- Modernizr -->
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="resources/core/css/ion.rangeSlider.skinModern.css">
<link rel="stylesheet" href="resources/core/css/ion.rangeSlider.css">
<link rel="stylesheet" href="resources/core/css/ngGallery.css">
<link rel="stylesheet" href="resources/core/css/angular-responsive-tables.css"></script>
<c:forEach var="entry" items="${pageScripts}">
	<script src="resources/core/js/application/${entry}.js"></script>
</c:forEach>
<link rel="stylesheet" href="resources/core/css/application/${css}.css">

</head>
<div id="mydiv">
    <div class="cssload-loading">Loading...</div>
</div>
	<div id="mainPage">
		<div id="header" ng-controller="DecorpotCtrl">
			<div id="top-bar" class="row"></div>
			<div class="row" style="margin-top: 1%;">
				<div id="logo" class="col-md-3"><a href="#/" ><img src="resources/core/img/1.png" width="300" height="43" alt="" /></a></div>
				<div class=" navigation-bar col-md-9">
				
				<div class="col-md-12 right">
					<ul class="contactHeader">
						<li><span style="margin-right: 8px;" ><i class="fa fa-envelope-o"></i></span><span>sales@decorpot.com</span></li>
						<li><span style="margin-right: 8px;" ><i class="fa fa-phone"></i></span><span>+91 9986076761 | +91 9986076762</span></li>
					</ul>
				<div class="col-md-10 right">
					<ul class="primary-menu">
						<li class="menudropdown"><a ui-sref="apartments">Apartments
								</a></li>
						<li class="menudropdown hide"><a href="">Themes</a>
							<ul class="sub-menu">
								<li><a ui-sref="#/imageListTheme/classic">Classic</a></li>
								<li><a ui-sref="#/imageListTheme/contemporary">Contemporary</a></li>
								<li><a ui-sref="#/imageListTheme/minimalistic">Minimalistic</a></li>
								<li><a ui-sref="#/imageListTheme/modern">Modern</a></li>
								<li><a ui-sref="#/imageListTheme/fusion">Fusion</a></li>
							</ul></li>
						<li class="menudropdown"><a ui-sref="imageList({param : 'looks'})">Looks</a>
							<ul class="sub-menu">
								<li><a ui-sref="imageList({param : 'living'})">Living</a></li>
								<li><a ui-sref="imageList({param : 'dining'})">Dining</a></li>
								<li><a ui-sref="imageList({param : 'kitchen'})">Kitchen</a></li>
								<li><a ui-sref="imageList({param : 'master_Bedroom'})">Master
										Bedroom</a></li>
								<li><a ui-sref="imageList({param : 'guest_Bedroom'})">Guest
										Bedroom</a></li>
								<li><a ui-sref="imageList({param : 'kids_bedroom'})">Kids Bedroom</a></li>

							</ul></li>
						<li class="menudropdown hide"><a href="#">Apartment Types</a>
							<ul class="sub-menu">
								<li><a ui-sref="#">2 BHK</a></li>
								<li><a ui-sref="#">3 BHK</a></li>
							</ul></li>
						<li class="menudropdown hide"><a href="#">Furnitures</a>
							<ul class="sub-menu">
								<li><a ui-sref="#">Table</a></li>
								<li><a ui-sref="#">Bed</a></li>
								<li><a ui-sref="#">Sofa</a></li>
							</ul></li>
						<li class="menudropdown"><a ui-sref="projects">Completed Projects</a>
						</li>
						<li class="menudropdown"><a ui-sref="about">About
								us</a></li>
					</ul>
				</div>
				<div class="col-md-2 hide">
					<ul class="nav navbar-nav navbar-right main-top-nav-right">
						<li ng-hide="isAuthenticated"
							class="dropdown main-top-nav-right-link login-signup"><a
							href="#modal" id="modal_trigger"> <i
								class="glyphicon glyphicon-search" aria-hidden="true"></i> Log
								in | Sign up
						</a></li>
						<li ng-show="isAuthenticated"
							class="dropdown main-top-nav-right-link login-signup"><a>
								Hi {{name}}! </a></li>

						<li ng-show="isAuthenticated"
							class="dropdown main-top-nav-right-link login-signup"><a
							href="#"> Logout </a></li>


						<li class="dropdown main-top-nav-right-link cart"><a
							rel="nofollow" id="login_link" class="login_link"
							href="#/checkout" data-toggle="modal" data-target="#signIn">
								<i class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></i>
								Cart({{getCartCounter()}})
						</a></li>
					</ul>
				</div>
			</div>
			</div>

			<div class="clearer"></div>
			

		</div>
		<!-- End of div = header-->
		<div class="clearer"></div>
		<div ui-view class="mid"></div>
		<div class = "clearer"></div>
		<footer>
			<div class="container footer">
				<div class="col-md-4">
					<h4>decorpot.com</h4>
					<p>#799,
						19th Main, 23rd Cross, 2nd floor, Sector 2 Near HSR club,
						Bangalore 560102</p>
				</div>
				<div class="col-md-4">
					<h4>email : </h4>
					<p>sales@decorpot.com</p>
				</div>
				<div class="col-md-4">
					<h4>phone : </h4>
					<p>(o) +91 9986076761</p>
					<p>(o) +91 9986076762</p>
				</div>
			</div>
		</footer>
	<!--mainPage-->
	<!--Modal login Pop up Box -->
	<div id="modal" class="popupContainer hide" style="display: none;">
		<header class="popupHeader">
			<span class="header_title">Login</span> <span class="modal_close"><i
				class="fa fa-times"></i></span>
		</header>
		<section class="popupBody" ng-controller='LoginCtrl'>
			<!-- Social Login -->
			<button class="btn btn-facebook" ng-click="authenticate('facebook')">Sign
				in with Facebook</button>


			<button class="btn btn-google-plus" ng-click="authenticate('google')">Sign
				in with Google</button>

			<div class="centeredText">
				<span>Or use your Email address</span>
			</div>
			<div class="action_btns">
				<div class="one_half">
					<a href="#" id="login_form" class="btn">Login</a>
				</div>
				<div class="one_half last">
					<a href="#" id="register_form" class="btn">Sign up</a>
				</div>
			</div>
	</div>
	<!-- Username & Password Login form -->
	<div class="user_login hide">
		<form>
			<label>Email / Username</label> <input type="text" /> <br /> <label>Password</label>
			<input type="password" /> <br />
			<div class="checkbox">
				<input id="remember" type="checkbox" /> <label for="remember">Remember
					me on this computer</label>
			</div>
			<div class="action_btns">
				<div class="one_half">
					<a href="#" class="btn back_btn"> <i
						class="fa fa-angle-double-left"></i> Back
					</a>
				</div>
				<div class="one_half last">
					<a href="#" class="btn btn_red">Login</a>
				</div>
			</div>
		</form>
		<a href="#" class="forgot_password">Forgot password?</a>
	</div>
	<!-- Register Form -->
	<div class="user_register hide">
		<form>
			<label>Full Name</label> <input type="text" /> <br /> <label>Email
				Address</label> <input type="email" /> <br /> <label>Password</label> <input
				type="password" /> <br />
			<div class="checkbox">
				<input id="send_updates" type="checkbox" /> <label
					for="send_updates">Send me occasional email updates</label>
			</div>
			<div class="action_btns">
				<div class="one_half">
					<a href="#" class="btn back_btn"> <i
						class="fa fa-angle-double-left"></i> Back
					</a>
				</div>
				<div class="one_half last">
					<a href="#" class="btn btn_red">Register</a>
				</div>
			</div>
		</form>
	</div>
	</section>
	</div>
	<!-- End of Modal Login Box-->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.15/angular-ui-router.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.0/angular-messages.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/core/js/bootstrap.min.js"></script>
	
	<script src="resources/core/js/application/app.js"></script>
	<script src="resources/core/js/application/factory.js"></script>
	<script src="resources/core/js/application/satellizer.js"></script>
	<script src="resources/core/js/angularytics.js"></script>
	
	<script src="resources/core/js/application/services.js"></script>
	<script src="resources/core/js/application/controllers.js"></script>
	<script src="resources/core/js/application/directives.js"></script>
	<script src="resources/core/js/ion-rangeSlider/ion.rangeSlider.min.js"></script>
	<script src="resources/core/js/ngGallery.js"></script>
	<script src="resources/core/js/jquery.infinitecarousel3.min.js"></script>
	<script src="resources/core/js/angular-responsive-tables.js"></script>
	<script type="text/javascript">
    
					jQuery(document).ready(function($) {
						
						//create the slider
						$('.cd-testimonials-wrapper').flexslider({
							selector : ".cd-testimonials > li",
							animation : "slide",
							controlNav : false,
							slideshow : false,
							smoothHeight : true,
							start : function() {
								$('.cd-testimonials').children('li').css({
									'opacity' : 1,
									'position' : 'relative'
								});
							}
						});
					});
					$("#modal_trigger").leanModal({
						top : 200,
						overlay : 0.6,
						closeButton : ".modal_close"
					});
					$(function() {
						// Calling Login Form
						$("#login_form").click(function() {
							$(".social_login").hide();
							$(".user_login").show();
							return false;
						});
						// Calling Register Form
						$("#register_form").click(function() {
							$(".social_login").hide();
							$(".user_register").show();
							$(".header_title").text('Register');
							return false;
						});
						// Going back to Social Forms
						$(".back_btn").click(function() {
							$(".user_login").hide();
							$(".user_register").hide();
							$(".social_login").show();
							$(".header_title").text('Login');
							return false;
						});
					});
					
				</script>
	<script>
					  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
					  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
					  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
					  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

					  ga('create', 'UA-66374032-1', 'auto');
					  ga('send', 'pageview');
					  ga('set', '&uid', ""); // Set the user ID using signed-in user_id.
					</script>

</body>
</html>
