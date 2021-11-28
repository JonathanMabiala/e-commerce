<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="Start your development with a Dashboard for Bootstrap 4.">
  <meta name="author" content="Creative Tim">
  <title>Argon Dashboard - Free Dashboard for Bootstrap 4</title>
  <!-- Favicon -->
  <link rel="icon" href="${pageContext.request.contextPath}/resource/assets/img/brand/favicon.png" type="image/png">
  <!-- Fonts -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
  <!-- Icons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/vendor/nucleo/css/nucleo.css" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css" type="text/css">
  <!-- Page plugins -->
  <!-- Argon CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/argon.css?v=1.2.0" type="text/css">
</head>
<body>
  <!-- Sidenav -->
  <nav class="sidenav navbar navbar-vertical  fixed-left  navbar-expand-xs navbar-light bg-white" id="sidenav-main">
    <div class="scrollbar-inner">
      <!-- Brand -->
      <div class="sidenav-header  align-items-center">
        <a class="navbar-brand" href="javascript:void(0)">
          <img src="${pageContext.request.contextPath}/resource/assets/img/brand/blue.png" class="navbar-brand-img" alt="...">
        </a>
      </div>
      <div class="navbar-inner">
        <!-- Collapse -->
        <div class="collapse navbar-collapse" id="sidenav-collapse-main">
          <!-- Nav items -->
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="/e-commerce">
                <i class="ni ni-tv-2 text-primary"></i>
                <span class="nav-link-text">Home</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/e-commerce/shoe/kids">
                <i class="ni ni-planet text-orange"></i>
                <span class="nav-link-text">Kids</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/e-commerce/shoe/men">
                <i class="ni ni-pin-3 text-primary"></i>
                <span class="nav-link-text">Men</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/e-commerce/shoe/women">
                <i class="ni ni-pin-3 text-primary"></i>
                <span class="nav-link-text">Women</span>
              </a>
            </li>
         	    <security:authorize  access="hasAnyAuthority('ADMIN_USER')">
	             <li class="nav-item">
	            
	              <a class="nav-link" href="/e-commerce/shoe/shoes">
	                <i class="ni ni-pin-3 text-primary"></i>
	                <span class="nav-link-text">Manage Products</span>
	              </a>
	             
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="/e-commerce/customer/list">
	                <i class="ni ni-pin-3 text-primary"></i>
	                <span class="nav-link-text">Customers</span>
	              </a>
	            </li>
	            
	             <li class="nav-item">
	              <a class="nav-link" href="/e-commerce/purchase/show">
	                <i class="ni ni-pin-3 text-primary"></i>
	                <span class="nav-link-text">Sales</span>
	              </a>
	            </li>
	            
	              <li class="nav-item">
	              <a class="nav-link" href="/e-commerce/customer/admins">
	                <i class="ni ni-pin-3 text-primary"></i>
	                <span class="nav-link-text">admin</span>
	              </a>
	            </li>
   			 </security:authorize>
          </ul>
          <!-- Divider -->
          <hr class="my-3"/>
          
        </div>
      </div>
    </div>
  </nav>
  <!-- Main content -->
  <div class="main-content" id="panel">
    <!-- Topnav -->
    <nav class="navbar navbar-top navbar-expand navbar-dark bg-default border-bottom">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <!-- Search form -->
         
          <!-- Navbar links -->
          <ul class="navbar-nav align-items-center  ml-md-auto ">

          </ul>
          <ul class="navbar-nav align-items-center  ml-auto ml-md-0 ">
            <li class="nav-item dropdown">
              <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <div class="media align-items-center">
                  <span class="avatar avatar-sm rounded-circle">
                    <img alt="Image placeholder" src="${pageContext.request.contextPath}/resource/assets/img/theme/team-4.jpg">
                  </span>
                 
                  <div class="media-body  ml-2  d-none d-lg-block">
                    <span class="mb-0 text-sm  font-weight-bold">
                    
                     <c:if test="${logged}">		
								User: <security:authentication property="principal.username" /> <br>
								Role(s) : <security:authentication property="principal.authorities"/>
						</c:if>
						
						<c:if test="${!logged}">		
								Sign in
						</c:if>
                    
                   </span>
                  </div>
                </div>
              </a>
              <div class="dropdown-menu  dropdown-menu-right ">
                <div class="dropdown-header noti-title">
                  <h6 class="text-overflow m-0">Welcome!</h6>
                </div>
                
                <div class="dropdown-divider"></div>
                
                 <c:if test="${logged}">		
					<a href="${pageContext.request.contextPath}/logout" class="dropdown-item">
	                  <i class="ni ni-user-run"></i>
	                  <span>Logout</span>
	                </a>
				</c:if>
						
						
                <c:if test="${!logged}">		
						<a href="${pageContext.request.contextPath}/login" class="dropdown-item">
		               
		                  <span>Login</span>
		                </a>
				</c:if>
                 <c:if test="${!logged}">		
						<a href="${pageContext.request.contextPath}/register" class="dropdown-item">
		               
		                  <span>Sign up</span>
		                </a>
				</c:if>
               
                  
              
              </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- Header -->
    <!-- Header -->
    <div class="header pb-6 d-flex align-items-center" style="min-height: 500px; background-image: url(${pageContext.request.contextPath}/resource/assets/img/theme/profile-cover.jpg); background-size: cover; background-position: center top;">
      <!-- Mask -->
      <span class="mask bg-gradient-default opacity-8"></span>
      <!-- Header container -->
      <div class="container-fluid d-flex align-items-center">
        <div class="row">
          <div class="col-lg-7 col-md-10">
            <h1 class="display-2 text-white">Welcome to Sporty Shoes</h1>
            <p class="text-white mt-0 mb-5">Where you find the best deals on shoes</p>
          </div>
        </div>
      </div>
    </div>
    <!-- Page content -->
    <div class="container-fluid mt--6">
      <div class="row">
       
      <c:forEach var="shoe" items="${shoe}">
      <!-- construct a "Buy" link with course id -->
						<c:url var="buyLink" value="/purchase/buy">
							<c:param name = "id" value="${shoe.id}"/>
							<c:param name = "category" value="${shoe.category}"/>
							
						</c:url>
        <div class="col-xl-4 order-xl-2">
       
          <div class="card card-profile">
            <img src="${pageContext.request.contextPath}/resource/assets/img/theme/img-1-1000x600.jpg" alt="Image placeholder" class="card-img-top">
          
          
            <div class="card-body pt-0">
              <div class="row">
                <div class="col">
                
	                <div class="text-left">
	                
	                <h5 class="h3">
	                 
	                </h5>
	                
	                	<div class="h3 ">
		                 ${shoe.brand}
		                </div >
		                
		                <div class="h5 ">
		                 Model: ${shoe.name}
		                </div >
		               
		                <div class="h3 ">
		                 For ${shoe.category}
		                </div >
		                <div class="">
		                 ${shoe.description}
		                </div>
	              </div>
                  <div class="card-profile-stats d-flex justify-content-center">
                  
                    <div>
                      <span class="heading">${shoe.quantity}</span>
                      <span class="description">In Stock</span>
                    </div>
                     <div>
                      <span class="heading">${shoe.shoeSize}</span>
                      <span class="description">Shoe Size</span>
                    </div>
                    <div>
                      <span class="heading">${shoe.price}</span>
                      <span class="description"> $ </span>
                    </div>
                    
                  </div>
                </div>
              </div>
              <div class="card-header text-center border-0 pt-4 pt-md-1 pb-0 pb-md-4">
             
	              <div class="d-flex justify-content-center">
	                <!-- Display the Buy link-->
					<a class="btn btn-md btn-primary" href="${buyLink}" onclick="if (!(confirm('Are you sure you want to Buy this shoe?'))) return false">Buy</a>
	                
	              </div>
            </div>
            </div>
          </div>
          
          
        </div>
        </c:forEach>
        </div>
       
  </div>
   <div class="col-xl-8 order-xl-1">
          
      <!-- Footer -->
      <footer class="footer pt-0">
        <div class="row align-items-center justify-content-lg-between">
          
        </div>
      </footer>
    </div>
  <!-- Argon Scripts -->
  <!-- Core -->
  <script src="${pageContext.request.contextPath}/resource/assets/vendor/jquery/dist/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resource/assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resource/assets/vendor/js-cookie/js.cookie.js"></script>
  <script src="${pageContext.request.contextPath}/resource/assets/vendor/jquery.scrollbar/jquery.scrollbar.min.js"></script>
  <script src="${pageContext.request.contextPath}/resource/assets/vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js"></script>
  <!-- Argon JS -->
  <script src="${pageContext.request.contextPath}/resource/assets/js/argon.js?v=1.2.0"></script>
</body>

</html>