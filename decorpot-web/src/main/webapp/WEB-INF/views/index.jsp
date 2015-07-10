<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>decorpot.com</title>

	<link href="resources/core/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/core/css/style.css" rel="stylesheet">
    <link href="resources/core/css/login.css" rel="stylesheet">
    <link href="resources/core/css/normalize.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/core/css/reset.css"> <!-- CSS reset -->
  <link rel="stylesheet" href="resources/core/css/carousel.css"> <!-- Resource style -->
  <script src="resources/core/js/modernizr.js"></script> <!-- Modernizr -->
  
  <c:forEach var="entry" items="${pageScripts}">
		<script src="resources/core/js/application/${entry}.js" ></script>
</c:forEach>
<link rel="stylesheet" href="resources/core/css/application/${css}.css">
</head>

<body>
    <div id="mainPage"> 
    <div id="header">
      <div id="top-bar" class="row"></div>
        <div class="row" style="
    margin-top: 1%;">
        <div id = "logo" class="col-md-6">DECORPOT.COM</div>

        <div class="col-xs-6 text-right pull-right text-muted"> care@decorpot.com | +91 8123029902</div>
        </div>
             
        <div class = "clearer"></div>
        <div class ="row navigation-bar">
          <div class = "col-md-8">
          <ul class = "primary-menu">
            <li class = "menudropdown">
              <a href="#">Themes</a>
              <ul class = "sub-menu">
                 <li><a href="#">Laptops</a></li>
                <li><a href="#">Monitors</a></li>
                <li><a href="#">Printers</a></li>
              </ul>
            </li>

            <li class = "menudropdown">
               <a href="#">Apparments</a>
               <ul class = "sub-menu">
                 <li><a href="#">Laptops</a></li>
                <li><a href="#">Monitors</a></li>
                <li><a href="#">Printers</a></li>
              </ul>
            </li>
            <li class = "menudropdown">
               <a href="http://youtube.com">Size</a>
               <ul class = "sub-menu">
                 <li><a href="#">Laptops</a></li>
                <li><a href="#">Monitors</a></li>
                <li><a href="#">Printers</a></li>
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
                    <a href="#modal-one" class="btn btn-big">
                      <i class="glyphicon glyphicon-search" aria-hidden="true"></i> Log in | Sign up</a>
                </li>
                <li class="dropdown main-top-nav-right-link cart" >
                  <a rel="nofollow" id="login_link" class="login_link" href="#signin-panel" data-toggle="modal" data-target="#signIn">
                    <i class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></i> Cart(0) </a>
                </li>
            </ul>
        </div>
        </div>
      </div>

        <div class="row mid">
          <div id="backgroundImage" class="left"></div>
          <div id="services">
            <hr>
            <div class = "titleText">Why Us</div>
              <ul>
                  <li class="service">
                      <img src="resources/core/img/furniture05.png" width="200" height="200" alt="" />
                      <h4>2 years for free service</h4>
                      <h2>lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum </h2>
                  </li>
                  <li class="service">
                      <img src="resources/core/img/furniture01.jpg" width="200" height="200" alt="" />
                      <h4>Easy customization</h4>
                      <h2>lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum </h2>
                  </li>
                  <li class="service">
                      <img src="resources/core/img/furniture02.jpg" width="200" height="200" alt="" />
                      <h4>10 years of garantee</h4>
                      <h2>lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum </h2>
                  </li>
                  <li class="service">
                      <img src="resources/core/img/furniture03.jpg" width="200" height="200" alt="" />
                      <h4>45 days completion&#42</h4>
                      <h2>lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum </h2>
                  </li>
                   <li class="service">
                      <img src="resources/core/img/furniture04.jpg" width="200" height="200" alt="" />
                      <h4>cheapest in market</h4>
                      <h2>lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum lorum ipsum totum ipsum </h2>
                  </li>
              </ul>
          </div>
          <div class = "imageMenus container">
              <div class = "image-tiles col-md-4">
                <a href="#">
                  <img class="imageMenu" src="resources/core/img/living.jpg" width="316" height="343">
                  <h3 class = "imageMenuCation">Living Room</h3>
                </a>
              </div>
              <div class = "image-tiles col-md-4">
                <a href="#">
                  <img class="imageMenu" src="resources/core/img/kitchen.jpg" width="316" height="343">
                  <h3 class = "imageMenuCation">Kitchen</h3>
                </a>
              </div>
              <div class = "image-tiles col-md-4">
                <a href="#">
                  <img class="imageMenu" src="resources/core/img/dining.jpg" width="316" height="343">
                  <h3 class = "imageMenuCation">Dining</h3>
                </a>
              </div>
              
              <div class = "image-tiles col-md-12">
                <a href="#">
                  <img class="imageMenu" src="resources/core/img/bedroom.jpg" width="1098" height="343">
                  <h3 class = "imageMenuCation">Bedroom</h3>
                </a>
              </div>
          </div>
          <div class="testimonial">
            <div class="cd-testimonials-wrapper cd-container">
              <ul class="cd-testimonials">
                <li>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                    <div class="cd-author">
                        <img src="resources/core/img/avatar-1.jpg" alt="Author image">
                            <ul class="cd-author-info">
                                <li>MyName</li>
                                <li>CEO, AmberCreative</li>
                            </ul>
                    </div>
                </li>
 
                <li>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                    <div class="cd-author">
                        <img src="resources/core/img/avatar-1.jpg" alt="Author image">
                            <ul class="cd-author-info">
                                <li>MyName</li>
                                <li>CEO, AmberCreative</li>
                            </ul>
                    </div>
                </li>
 
                <li>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                    <div class="cd-author">
                        <img src="resources/core/img/avatar-1.jpg" alt="Author image">
                            <ul class="cd-author-info">
                                <li>MyName</li>
                                <li>CEO, AmberCreative</li>
                            </ul>
                    </div>
                </li>
              </ul> <!-- cd-testimonials -->
 
            </div>
          </div>
        </div>

        <footer>
        <div class = "container footer">
          <div class="row"></div>
      </div>
      </footer>
      </div>
       
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/core/js/bootstrap.min.js"></script>
    <script src="resources/core/js/login.js"></script>
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
</script> 

</body>
</html>