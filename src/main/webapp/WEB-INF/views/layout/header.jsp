<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="images/favicon.png">
<title>saveME</title>
<!-- CSS FILES START -->
<link href="css/custom.css" rel="stylesheet">
<link href="css/color.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<link href="css/owl.carousel.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/all.min.css" rel="stylesheet">
<!-- CSS FILES End -->
<!--   JS Files Start  --> 
<script src="js/jquery-3.3.1.min.js"></script> 
<script src="js/jquery-migrate-1.4.1.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/owl.carousel.min.js"></script> 
<script src="js/jquery.prettyPhoto.js"></script> 
<script src="js/isotope.min.js"></script> 
<script src="js/custom.js"></script>

</head>
<body>

         <!--Header Start-->
         <header class="header-style-2">
            <nav class="navbar navbar-expand-lg">
               <a class="navbar-brand" href="/saveME"></a>
               <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <i class="fas fa-bars"></i> </button>
               <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav mr-auto">
                     <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="index-2.html"  role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Home </a>
                        <ul class="dropdown-menu" >
                           <li><a href="index-2.html">Home One</a></li>
                           <li><a href="home-two.html">Home Two</a></li>
                           <li><a href="home-three.html">Home Three</a></li>
                        </ul>
                     </li>
                     <li class="nav-item"> <a class="nav-link" href="#">About</a> </li>
                     <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="events-grid.html"  role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Events </a>
                        <ul class="dropdown-menu" >
                           <li><a href="events-grid.html">Events Grid</a></li>
                           <li><a href="events-grid-2.html">Events Grid Two</a></li>
                           <li><a href="events-grid-3.html">Events Grid Three</a></li>
                           <li><a href="events-list.html">Events List</a></li>
                           <li><a href="events-list-two.html">Events List Two</a></li>
                           <li><a href="event-details.html">Event Details</a></li>
                        </ul>
                     </li>
                     <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="causes.html"  role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Causes </a>
                        <ul class="dropdown-menu" >
                           <li><a href="causes.html">Causes Grid</a></li>
                           <li><a href="causes-list.html">Causes List</a></li>
                           <li><a href="causes-details.html">Causes Details</a> </li>
                        </ul>
                     </li>
                     <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="blog.html"  role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Blogs </a>
                        <ul class="dropdown-menu" >
                           <li><a href="blog.html">Blog Default</a></li>
                           <li><a href="blog-list.html">Blog List</a> </li>
                           <li><a href="blog-grid.html">Blog Grid</a></li>
                           <li><a href="blog-two-col.html">Blog Two Columns</a> </li>
                           <li><a href="blog-three-col.html">Blog Three Columns</a></li>
                           <li><a href="blog-details.html">Blog Details</a></li>
                        </ul>
                     </li>
                     <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#"  role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Pages </a>
                        <ul class="dropdown-menu" >
                           <li>
                              <a href="#">Projects</a>
                              <ul class="dropdown-menu" >
                                 <li><a href="projects.html">Projects</a> </li>
                                 <li><a href="projects-grid.html">Projects Grid</a> </li>
                                 <li><a href="projects-grid-two.html">Projects Grid Two</a> </li>
                                 <li><a href="projects-list.html">Projects List</a> </li>
                                 <li><a href="projects-details.html">Project Details</a> </li>
                              </ul>
                           </li>
                           <li>
                              <a href="#">Shop</a>
                              <ul class="dropdown-menu" >
                                 <li><a href="shop.html">Shop</a> </li>
                                 <li><a href="shop-two.html">Shop Two</a> </li>
                                 <li><a href="shop-details.html">Shop Details</a> </li>
                              </ul>
                           </li>
                           <li>
                              <a href="team.html">Team</a>
                              <ul class="dropdown-menu" >
                                 <li><a href="team.html">Team One</a> </li>
                                 <li><a href="team-two.html">Team Two</a> </li>
                                 <li><a href="team-details.html">Team Details</a> </li>
                              </ul>
                           </li>
                           <li>
                              <a href="#">Gallery</a>
                              <ul class="dropdown-menu" >
                                 <li><a href="gallery-grid.html">Gallery Grid</a> </li>
                                 <li><a href="gallery-full.html">Gallery Full</a> </li>
                                 <li><a href="gallery-masonry.html">Gallery Masonry</a> </li>
                              </ul>
                           </li>
                           <li><a href="testimonials.html">Testimonials</a> </li>
                           <li><a href="donation.html">Donation</a> </li>
                           <li><a href="my-account.html">My Account</a> </li>
                           <li><a href="coming-soon.html">Coming Soon</a> </li>
                           <li><a href="page-404.html">404 Error</a> </li>
                        </ul>
                     </li>
                     <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="contact.html"  role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Contact </a>
                        <ul class="dropdown-menu" >
                           <li><a href="contact-one.html">Contact One</a> </li>
                           <li><a href="contact-two.html">Contact Two</a> </li>
                        </ul>
                     </li>
                  </ul>
                  <ul class="topnav-right">
                     <li> <a class="mdonate" href="donation.html"><span>Make a Donation</span></a> </li>
                     <li> <a class="search-icon" href="#search"> <i class="fas fa-search"></i> </a> </li>
                     <li class="dropdown">
                        <a class="cart-icon" href="#" role="button" id="cartdropdown" data-toggle="dropdown"> <i class="fas fa-shopping-cart"></i></a>
                        <div class="dropdown-menu cart-box" aria-labelledby="cartdropdown">
                           Recently added item(s)
                           <ul class="list">
                              <li class="item">
                                 <a href="#" class="preview-image"><img class="preview" src="images/pro.jpg" alt=""></a>
                                 <div class="description"> <a href="#">Sample Course</a> <strong class="price">1 x $44.95</strong> </div>
                              </li>
                              <li class="item">
                                 <a href="#" class="preview-image"><img class="preview" src="images/pro.jpg" alt=""></a>
                                 <div class="description"> <a href="#">Sample Course</a> <strong class="price">1 x $44.95</strong> </div>
                              </li>
                           </ul>
                           <div class="total">Total: <strong>$44.95</strong></div>
                           <div class="view-link"><a href="#">Proceed to Checkout</a> <a href="#">View cart </a></div>
                        </div>
                     </li>
                     <c:choose>
                     	<c:when test="${empty principal}">
                  		   <li class="login-reg"><a href="/saveME/auth/loginForm">?????????</a> | <a href="/saveME/auth/joinSelect">????????????</a> </li>
                     	</c:when>
                     	<c:otherwise>
                  		   <li class="login-reg"><a href="/saveME/user/updateForm">????????????</a> | <a href="/saveME/logout">????????????</a> </li>
                     	</c:otherwise>
                     </c:choose>
                  </ul>
               </div>
            </nav>
         </header>
         <div id="search">
            <button type="button" class="close">??</button>
            <form class="search-overlay-form">
               <input type="search" value="" placeholder="type keyword(s) here" />
               <button type="submit" class="btn btn-primary"><i class="fas fa-search"></i></button>
            </form>
         </div>
         <!--Header End--> 