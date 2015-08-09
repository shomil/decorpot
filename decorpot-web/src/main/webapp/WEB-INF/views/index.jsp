<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="decorpot">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>decorpot.com</title>
    <script type="text/javascript">
    var _contextPath = "${pageContext.request.contextPath}";
</script>
    <link href="resources/core/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/core/css/style.css" rel="stylesheet">
    <link href="resources/core/css/login.css" rel="stylesheet">
    <link href="resources/core/css/loginstyle.css" rel="stylesheet">
    <link href="resources/core/css/normalize.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/core/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="resources/core/css/carousel.css"> <!-- Resource style -->
    <script src="resources/core/js/modernizr.js"></script> <!-- Modernizr -->
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
    <link rel="stylesheet" href="resources/core/css/ion.rangeSlider.skinModern.css">
    <link rel="stylesheet" href="resources/core/css/normalize.css">
    <link rel="stylesheet" href="resources/core/css/ion.rangeSlider.css">
    <link rel="shortcut icon" href="http://i489.photobucket.com/albums/rr251/JokerKarimme/Icon/AdrianaLima.png">
    <c:forEach var="entry" items="${pageScripts}">
    <script src="resources/core/js/application/${entry}.js" ></script>
    </c:forEach>
    <link rel="stylesheet" href="resources/core/css/application/${css}.css">
  </head>
  <body>
    <div id="mainPage">
      <div id="header">
        <div id="top-bar" class="row"></div>
        <div class="row" style="margin-top: 1%;">
          <div id = "logo" class="col-md-6">DECORPOT.COM</div>
          <div class="col-xs-6 text-right pull-right text-muted"> care@decorpot.com | +91 8123029902</div>
        </div>
        
        <div class = "clearer"></div>
        <div class ="row navigation-bar">
          <div class = "col-md-8">
            <ul class = "primary-menu">
              <li class = "menudropdown">
                <a href="#/images">Themes</a>
                <ul class = "sub-menu">
                  <li><a href="#/classic">Classic</a></li>
                  <li><a href="#/contemporary">Contemporary</a></li>
                  <li><a href="#/minimalastic">Minimalastic</a></li>
                 <li><a href="#/modern">Modern</a></li>
                 <li><a href="#/fusion">Fusion</a></li>
                </ul>
              </li>
              <li class = "menudropdown">
                <a href="#imageListSpace">Space</a>
                <ul class = "sub-menu">
                 <li><a href="#imageListSpace/living">Living</a></li>
                  <li><a href="#imageListSpace/drawing">Drawing</a></li>
                  <li><a href="#imageListSpace/dining">Dining</a></li>
                  <li><a href="#/imageListSpace/kitchen">Kitchen</a></li>
                  <li><a href="#imageListSpace/materBedroom">Master Bedroom</a></li>
                  <li><a href="#imageListSpace/guestBedroom">Guest Bedroom</a></li>
                  <li><a href="#imageListSpace/kidsbedroom">Kids Bedroom</a></li>
                  
                </ul>
              </li>
              <li class = "menudropdown">
                <a href="#">BHK Type</a>
                <ul class = "sub-menu">
                  <li><a href="#">2 BHK</a></li>
                  <li><a href="#">3 BHK</a></li>
                </ul>
              </li>
              <li class = "menudropdown">
                <a href="#">Furnitures</a>
                <ul class = "sub-menu">
                  <li><a href="#">Table</a></li>
                  <li><a href="#">Bed</a></li>
                  <li><a href="#">Sofa</a></li>
                </ul>
              </li>
              <li class = "menudropdown">
                <a href="http://youtube.com">Profile</a>
              </li>
              <li class = "menudropdown">
                <a href="http://youtube.com">About us</a>
              </li>
            </ul>
          </div>
          <div class = "col-md-4">
            <ul class="nav navbar-nav navbar-right main-top-nav-right">
              
              <li class="dropdown main-top-nav-right-link login-signup">
                <a href="#modal" id="modal_trigger">
                  <i class="glyphicon glyphicon-search" aria-hidden="true"></i> Log in | Sign up
                </a>
              </li>
              <li class="dropdown main-top-nav-right-link cart" >
                <a rel="nofollow" id="login_link" class="login_link" href="#signin-panel" data-toggle="modal" data-target="#signIn">
                  <i class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></i> Cart(0)
                </a>
              </li>
            </ul>
          </div>
        </div>
        
      </div><!-- End of div = header-->
      <div class = "clearer"></div>
         <div ng-view="" class="row mid"></div>
    <footer>
      <div class = "container footer">
        <div class="row"></div>
      </div>
    </footer>
  </div><!--mainPage-->
    <!--Modal login Pop up Box -->
        <div id="modal" class="popupContainer" style="display:none;">
          <header class="popupHeader">
            <span class="header_title">Login</span>
            <span class="modal_close"><i class="fa fa-times"></i></span>
          </header>
          <section class="popupBody" ng-controller='LoginCtrl'>
            <!-- Social Login -->
            		<button class="btn btn-facebook" ng-click="authenticate('facebook')">Sign in with Facebook</button>


	            	<button class="btn btn-google-plus" ng-click="authenticate('google')">Sign in with Google</button>

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
                  <input id="remember" type="checkbox" />
                  <label for="remember">Remember me on this computer</label>
                </div>
                <div class="action_btns">
                  <div class="one_half">
                    <a href="#" class="btn back_btn">
                      <i class="fa fa-angle-double-left"></i> Back
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
            <div class="user_register">
              <form>
                <label>Full Name</label>
                <input type="text" /> <br />
                <label>Email Address</label>
                <input type="email" /> <br />
                <label>Password</label>
                <input type="password" /> <br />
                <div class="checkbox">
                  <input id="send_updates" type="checkbox" />
                  <label for="send_updates">Send me occasional email updates</label>
                </div>
                <div class="action_btns">
                  <div class="one_half">
                    <a href="#" class="btn back_btn">
                    <i class="fa fa-angle-double-left"></i> Back</a>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular-route.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/core/js/bootstrap.min.js"></script>
    <script src="resources/core/js/login.js"></script>
    <script src="resources/core/js/jquery.leanModal.min.js"></script>
    <script src="resources/core/js/masonry.pkgd.min.js"></script>
    <script src="resources/core/js/jquery.flexslider-min.js"></script>
    <script src="resources/core/js/application/app.js"></script>
    <script src="//cdn.jsdelivr.net/satellizer/0.11.3/satellizer.min.js"></script>
    <script src="resources/core/js/application/services.js"></script>
    <script src="resources/core/js/application/controllers.js"></script>
    <script src="resources/core/js/application/login.js"></script>
    <script src="resources/core/js/application/directives.js"></script>
    <script src="resources/core/js/ion-rangeSlider/ion.rangeSlider.min.js"></script>
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
  </body>
</html>
