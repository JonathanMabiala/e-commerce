<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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

<body class="bg-default">
  <!-- Navbar -->
  <nav id="navbar-main" class="navbar navbar-horizontal navbar-transparent navbar-main navbar-expand-lg navbar-light">
    <div class="container">
     
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse" aria-controls="navbar-collapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="navbar-collapse navbar-custom-collapse collapse" id="navbar-collapse">
        <div class="navbar-collapse-header">
          <div class="row">
            <div class="col-6 collapse-brand">
              
            </div>
            <div class="col-6 collapse-close">
              <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse" aria-controls="navbar-collapse" aria-expanded="false" aria-label="Toggle navigation">
                <span></span>
                <span></span>
              </button>
            </div>
          </div>
        </div>
        
        <hr class="d-lg-none" />
        <ul class="navbar-nav align-items-lg-center ml-lg-auto">
      
        </ul>
      </div>
    </div>
  </nav>
  <!-- Main content -->
  <div class="main-content">
    <!-- Header -->
    <div class="header bg-gradient-primary py-7 py-lg-8 pt-lg-9">
      <div class="container">
        <div class="header-body text-center mb-7">
          <div class="row justify-content-center">
            <div class="col-xl-5 col-lg-6 col-md-8 px-5">
              <h1 class="text-white">Welcome!</h1>
              
            </div>
          </div>
        </div>
      </div>
      <div class="separator separator-bottom separator-skew zindex-100">
        <svg x="0" y="0" viewBox="0 0 2560 100" preserveAspectRatio="none" version="1.1" xmlns="http://www.w3.org/2000/svg">
          <polygon class="fill-default" points="2560 0 2560 100 0 100"></polygon>
        </svg>
      </div>
    </div>
    <!-- Page content -->
    <div class="container mt--8 pb-5">
      <div class="row justify-content-center">
        <div class="col-lg-5 col-md-7">
          <div class="card bg-secondary border-0 mb-0">
            <div class="card-header bg-transparent pb-5">
              <div class="text-muted text-center mt-2 mb-3"><small>Sign in with</small></div>
              <div class="btn-wrapper text-center">
               
              </div>
            </div>
            <div class="card-body px-lg-5 py-lg-5">
              <div class="text-center text-muted mb-4">
                <small>Or sign in with credentials</small>
              </div>
              <form:form role="form" action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" >
               <!-- Place for messages: error, alert etc ... -->
					    <div class="form-group">
					        <div class="col-xs-15">
					            <div>
									<c:if test="${param.error !=null}">
								
										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											Invalid username and password.
										</div>
									
									
									</c:if>
								
									<c:if test="${param.logout !=null}">
									            
										<div class="alert alert-success col-xs-offset-1 col-xs-10">
											You have been logged out.
										</div>
										
								   </c:if>

					            </div>
					        </div>
					    </div>
                <div class="form-group mb-3">
                  <div class="input-group input-group-merge input-group-alternative">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="ni ni-email-83"></i></span>
                    </div>
                    <input type="text" name="email" placeholder="email" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <div class="input-group input-group-merge input-group-alternative">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                    </div>
                    <input type="password" name="password" placeholder="password" class="form-control" >
                  </div>
                </div>
               
                <div class="text-center">
                  <input type="submit" value="login" class="btn btn-primary my-4">
                </div>
              </form:form>
            </div>
          </div>
          <div class="row mt-3">
            <div class="col-6">
             
            </div>
            <div class="col-6 text-right">
              <a href="${pageContext.request.contextPath}/register" class="text-light"><small>Create new account</small></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Footer -->
  <footer class="py-5" id="footer-main">
    <div class="container">
     
    </div>
  </footer>
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