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
	        <security:authorize access="hasAnyAuthority('ADMIN_USER')">     
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
    <nav class="navbar navbar-top navbar-expand navbar-dark bg-primary border-bottom">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <!-- Search form -->
        
          <form:form action= "${pageContext.request.contextPath}/customer/search" modelAttribute="searchCustomer" class="navbar-search navbar-search-light form-inline mr-sm-3" id="navbar-search-main">
            <div class="form-group mb-0">
              <div class="input-group input-group-alternative input-group-merge">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-search"></i></span>
                </div>
                <form:input path="name" type="text" id="input-brand" class="form-control" placeholder="search" />
              </div>
            </div>
            <button type="button" class="close" data-action="search-close" data-target="#navbar-search-main" aria-label="Close">
              <span aria-hidden="true">??</span>
            </button>
          </form:form>
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
								<security:authentication property="principal.username" />
						</c:if>
						
						<c:if test="${!logged}">		
								Sign in
						</c:if>
						
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
    <div class="header bg-primary pb-6">
      <div class="container-fluid">
        <div class="header-body">
          <div class="row align-items-center py-4">
            <div class="col-lg-6 col-7">
             
            </div>
            <div class="col-lg-6 col-5 text-right">
              <a href="/e-commerce/customer/add_admin" class="btn btn-sm btn-neutral">Register</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page content -->
    <div class="container-fluid mt--6">
      <div class="row">
        <div class="col">
          <div class="card">
            <!-- Card header -->
            <div class="card-header border-0">
              <h3 class="mb-0">Admins</h3>
            </div>
            <!-- Light table -->
            <div class="table-responsive">
              <table class="table align-items-center table-flush">
                <thead class="thead-light">
                  <tr>
                    <th scope="col" class="sort" data-sort="name">First Name</th>
                    <th scope="col" class="sort" data-sort="budget">Last Name</th>
                    <th scope="col" class="sort" data-sort="status">Email</th>
                    
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody class="list">
                
                 <c:forEach var="admin" items="${user}">
                 		<!-- construct an "update" link with customer id -->
						<c:url var="updateLink" value="/customer/update_admin">
							<c:param name = "id" value="${admin.id}"/>
						</c:url>
						
						<!-- construct an "update" link with admin id -->
						<c:url var="updatePasswordLink" value="/customer/update_admin_password">
							<c:param name = "id" value="${admin.id}"/>
						</c:url>
						
						<!-- construct a "Delete" link with shoe id -->
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name = "id" value="${admin.id}"/>
						</c:url>
						<!-- construct a "Buy" link with course id -->
						<c:url var="buyLink" value="/customer/buy">
							<c:param name = "id" value="${admin.id}"/>
						</c:url>
						
                  <tr>
                     <th scope="row">
                      <div class="media align-items-center">
                        <a href="#" class="avatar rounded-circle mr-3">
                          <img alt="Image placeholder" src="${pageContext.request.contextPath}/resource/assets/img/theme/bootstrap.jpg">
                        </a>
                        <div class="media-body">
                          <span class="name mb-0 text-sm">${admin.name}</span>
                        </div>
                      </div>
                    </th>
                 
                    <td class="lastName">
                      ${admin.lastName}
                    </td>
                    <td>
                     
                      ${admin.email}
                  
                    </td>
                 
                    <td class="text-right">

								<!-- Display the Manage link-->
								<a class="btn btn-sm btn-primary" href="${updateLink}">Update</a>
								
								<!-- Display the Change password link-->
								<a class="btn btn-sm btn-primary" href="${updatePasswordLink}">change password</a>
								
								<!-- Display the Delete link-->
								<a class="btn btn-sm btn-danger" href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								
								
                    </td>
                  </tr>
                  </c:forEach>

                </tbody>
              </table>
            </div>
         
          </div>
        </div>
      </div>
      
      <!-- Footer -->
      <footer class="footer pt-0">
        <div class="row align-items-center justify-content-lg-between">
         
        </div>
      </footer>
    </div>
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