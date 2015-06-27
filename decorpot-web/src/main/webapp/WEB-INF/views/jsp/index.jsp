<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Gradle + Spring MVC</title>

	<link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/core/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/core/css/normalize.css" />" rel="stylesheet">

</head>

<body>
    <div id="mainPage"> 
      <div id="top-bar"></div>
      <div id="header">
        <div class="page-header">
          <div class="row">
            <div class = "logo ">decorpot.com</div>
            
            <div id="login">
               <div class="row">
                <div class="col-xs-12 text-right pull-right text-muted" style="margin-right:0px;padding-right:4px"> care@decorpot.com | +91 8123029902</div>
             </div>
            <div class="row">
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
        </div>
      </div>
      <div class="clearer"></div>
      <div id="mid">
        <div class ="imageCenter row">
          <div type="button" class="button left-button btn btn-default" style="">Design my house</div>

          <div type="button" class="button right-button btn btn-default" style="">Design my plot</div>
        <div id="backgroundImage" class="left">
        </div>
        

        
        
        
      </div>
      
        <div class = "services row">
            

            
            <div class ="service col-md-2">
                <img src="/Users/ssaurav/Desktop/decorpot/img/images.jpeg">
                <span> 5 yrs of warranty</span>
            </div>
            <div class ="service col-md-2">
                <img src="/Users/ssaurav/Desktop/decorpot/img/images.jpeg">
                <span> 5 yrs of warranty</span>
            </div>
            <div class ="service col-md-2">
                <img src="/Users/ssaurav/Desktop/decorpot/img/images.jpeg">
                <span> 5 yrs of warranty</span>
            </div>
             <div class ="service col-md-2">
                <img src="/Users/ssaurav/Desktop/decorpot/img/images.jpeg">
                <span> 5 yrs of warranty</span>
            </div>
            <div class ="service col-md-2">
                <img src="/Users/ssaurav/Desktop/decorpot/img/images.jpeg">
                <span> 5 yrs of warranty</span>
            </div>
            <div class ="service col-md-2">
            
                
            
      </div>
      </div>
      
      
      
      
      
      
      
      
    </div>
<div class="container"><div class="row"><div class="col-xs-12 hide"> <img src="/img/banners/banner-16-09/footer-top.jpg" width="1200" height="56"></div></div></div>
      <footer>
        <div class = "container footer">
          <div class="row"></div>
      </div>
      </footer>
    </div>
  </body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="<c:url value="/resources/core/js/bootstrap.min.js" />"></script>


</body>
</html>