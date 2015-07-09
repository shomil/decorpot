<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gradle + Spring MVC</title>

<link href="resources/core/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/core/css/style.css" rel="stylesheet">
<link href="resources/core/css/login.css" rel="stylesheet">
<link href="resources/core/css/loginstyle.css" rel="stylesheet">
<link href="resources/core/css/normalize.css" rel="stylesheet">
<link rel="stylesheet" href="resources/core/css/reset.css">
<!-- CSS reset -->
<link rel="stylesheet" href="resources/core/css/carousel.css">
<!-- Resource style -->
<script src="resources/core/js/modernizr.js"></script>
<!-- Modernizr -->
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />

</head>

<body>
	<div id="mainPage">
		<div id="top-bar" class="row"></div>
		<div class="row" style="margin-top: 1%;">
			<div id="logo" class="col-md-6">DECORPOT.COM</div>

			<div class="col-xs-6 text-right pull-right text-muted">
				care@decorpot.com | +91 8123029902</div>
		</div>

		<div class="clearer"></div>
		<div class="row navigation-bar">
			<div class="col-md-8">
				<ui class="primary-menu">
				<li class="menudropdown"><a href="#">Themes</a>
					<ul class="sub-menu">
						<li><a href="#">Laptops</a></li>
						<li><a href="#">Monitors</a></li>
						<li><a href="#">Printers</a></li>
					</ul></li>

				<li class="menudropdown"><a href="#">Apparments</a>
					<ul class="sub-menu">
						<li><a href="#">Laptops</a></li>
						<li><a href="#">Monitors</a></li>
						<li><a href="#">Printers</a></li>
					</ul></li>
				<li class="menudropdown"><a href="http://youtube.com">Size</a>
					<ul class="sub-menu">
						<li><a href="#">Laptops</a></li>
						<li><a href="#">Monitors</a></li>
						<li><a href="#">Printers</a></li>
					</ul></li>
				<li class="menudropdown"><a href="http://youtube.com">Profile</a>
				</li>
				<li class="menudropdown"><a href="http://youtube.com">About
						us</a></li>

				</ui>
			</div>
			<div class="col-md-4">
				<ul class="nav navbar-nav navbar-right main-top-nav-right">

					<li class="dropdown main-top-nav-right-link login-signup"><a
						href="#modal" class="btn " id="modal_trigger">
							<i class="glyphicon glyphicon-search" aria-hidden="true"></i> Log
							in | Sign up
					</a></li>
					<li class="dropdown main-top-nav-right-link cart"><a
						rel="nofollow" id="login_link" class="login_link"
						href="#signin-panel" data-toggle="modal" data-target="#signIn">
							<i class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></i>
							Cart(0)
					</a></li>
				</ul>
			</div>
		</div>


		<div class="row mid">
			<div id="backgroundImage" class="left"></div>
			<div id="services">
				<hr>
				<div class="titleText">Why Us</div>
				<ul>
					<li class="service"><img
						src="resources/core/img/furniture05.png" width="200" height="200"
						alt="" />
						<h4>2 years for free service</h4>
						<h2>lorum ipsum totum ipsum lorum ipsum totum ipsum lorum
							ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum
							lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum
							ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum
							totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum
							ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum
							lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum
							ipsum lorum ipsum totum ipsum</h2></li>
					<li class="service"><img
						src="resources/core/img/furniture01.jpg" width="200" height="200"
						alt="" />
						<h4>Easy customization</h4>
						<h2>lorum ipsum totum ipsum lorum ipsum totum ipsum lorum
							ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum
							lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum
							ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum
							totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum
							ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum
							lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum
							ipsum lorum ipsum totum ipsum</h2></li>
					<li class="service"><img
						src="resources/core/img/furniture02.jpg" width="200" height="200"
						alt="" />
						<h4>10 years of garantee</h4>
						<h2>lorum ipsum totum ipsum lorum ipsum totum ipsum lorum
							ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum
							lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum
							ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum
							totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum
							ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum
							lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum
							ipsum lorum ipsum totum ipsum</h2></li>
					<li class="service"><img
						src="resources/core/img/furniture03.jpg" width="200" height="200"
						alt="" />
						<h4>45 days completion&#42</h4>
						<h2>lorum ipsum totum ipsum lorum ipsum totum ipsum lorum
							ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum
							lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum
							ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum
							totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum
							ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum
							lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum
							ipsum lorum ipsum totum ipsum</h2></li>
					<li class="service"><img
						src="resources/core/img/furniture04.jpg" width="200" height="200"
						alt="" />
						<h4>cheapest in market</h4>
						<h2>lorum ipsum totum ipsum lorum ipsum totum ipsum lorum
							ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum
							lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum
							ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum
							totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum
							ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum
							lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum
							ipsum lorum ipsum totum ipsum</h2></li>
				</ul>
			</div>
			<div class="imageMenus container">
				<div class="image-tiles col-md-4">
					<a href="#"> <img class="imageMenu"
						src="resources/core/img/living.jpg" width="316" height="343">
						<h3 class="imageMenuCation">Living Room</h3>
					</a>
				</div>
				<div class="image-tiles col-md-4">
					<a href="#"> <img class="imageMenu"
						src="resources/core/img/kitchen.jpg" width="316" height="343">
						<h3 class="imageMenuCation">Kitchen</h3>
					</a>
				</div>
				<div class="image-tiles col-md-4">
					<a href="#"> <img class="imageMenu"
						src="resources/core/img/dining.jpg" width="316" height="343">
						<h3 class="imageMenuCation">Dining</h3>
					</a>
				</div>

				<div class="image-tiles col-md-12">
					<a href="#"> <img class="imageMenu"
						src="resources/core/img/bedroom.jpg" width="1098" height="343">
						<h3 class="imageMenuCation">Bedroom</h3>
					</a>
				</div>
			</div>
			<div class="testimonial">
				<div class="cd-testimonials-wrapper cd-container">
					<ul class="cd-testimonials">
						<li>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua.</p>
							<div class="cd-author">
								<img src="resources/core/img/avatar-1.jpg" alt="Author image">
								<ul class="cd-author-info">
									<li>MyName</li>
									<li>CEO, AmberCreative</li>
								</ul>
							</div>
						</li>

						<li>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua.</p>
							<div class="cd-author">
								<img src="resources/core/img/avatar-1.jpg" alt="Author image">
								<ul class="cd-author-info">
									<li>MyName</li>
									<li>CEO, AmberCreative</li>
								</ul>
							</div>
						</li>

						<li>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua.</p>
							<div class="cd-author">
								<img src="resources/core/img/avatar-1.jpg" alt="Author image">
								<ul class="cd-author-info">
									<li>MyName</li>
									<li>CEO, AmberCreative</li>
								</ul>
							</div>
						</li>
					</ul>
					<!-- cd-testimonials -->

				</div>
			</div>
		</div>
		<div id="modal" class="popupContainer" style="display:none;">
			<header class="popupHeader">
				<span class="header_title">Login</span> <span class="modal_close"><i
					class="fa fa-times"></i></span>
			</header>

			<section class="popupBody">
				<!-- Social Login -->
				<div class="social_login">
					<div class="">
						<a href="#" class="social_box fb"> <span class="icon"><i
								class="fa fa-facebook"></i></span> <span class="icon_title">Connect
								with Facebook</span>

						</a> <a href="#" class="social_box google"> <span class="icon"><i
								class="fa fa-google-plus"></i></span> <span class="icon_title">Connect
								with Google</span>
						</a>
					</div>

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
				<div class="user_login">
					<form>
						<label>Email / Username</label> <input type="text" /> <br /> <label>Password</label>
						<input type="password" /> <br />

						<div class="checkbox">
							<input id="remember" type="checkbox" /> <label for="remember">Remember
								me on this computer</label>
						</div>

						<div class="action_btns">
							<div class="one_half">
								<a href="#" class="btn back_btn"><i
									class="fa fa-angle-double-left"></i> Back</a>
							</div>
							<div class="one_half last">
								<a href="#" class="btn btn_red">Login</a>
							</div>
						</div>
					</form>

					<a href="#" class="forgot_password">Forgot password?</a>
				</div>

				<!-- Register Form -->
				<div class="user_register">
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
								<a href="#" class="btn back_btn"><i
									class="fa fa-angle-double-left"></i> Back</a>
							</div>
							<div class="one_half last">
								<a href="#" class="btn btn_red">Register</a>
							</div>
						</div>
					</form>
				</div>
			</section>
		</div>

		<footer>
			<div class="container footer">
				<div class="row"></div>
			</div>
		</footer>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/core/js/bootstrap.min.js"></script>
	<script src="resources/core/js/login.js"></script>
	<script src="resources/core/js/jquery.leanModal.min.js"></script>
	<script src="resources/core/js/masonry.pkgd.min.js"></script>
	<script src="resources/core/js/jquery.flexslider-min.js"></script>
	<script type="text/javascript">
jQuery(document).ready(function($){
  //create the slider
  $('.cd-testimonials-wrapper').flexslider({
    selector: ".cd-testimonials > li",
    animation: "slide",
    controlNav: false,
    slideshow: false,
    smoothHeight: true,
    start: function(){
      $('.cd-testimonials').children('li').css({
        'opacity': 1,
        'position': 'relative'
      });
    }
  });
});
$("#modal_trigger").leanModal({top : 200, overlay : 0.6, closeButton: ".modal_close" });

  $(function(){
    // Calling Login Form
    $("#login_form").click(function(){
      $(".social_login").hide();
      $(".user_login").show();
      return false;
    });

    // Calling Register Form
    $("#register_form").click(function(){
      $(".social_login").hide();
      $(".user_register").show();
      $(".header_title").text('Register');
      return false;
    });

    // Going back to Social Forms
    $(".back_btn").click(function(){
      $(".user_login").hide();
      $(".user_register").hide();
      $(".social_login").show();
      $(".header_title").text('Login');
      return false;
    });

  })
</script>
</body>
</html>