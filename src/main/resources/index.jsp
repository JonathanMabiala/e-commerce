<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Hello World</h1>
	
	
	
	<!-- Add a logout button -->
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
	
	<hr>
	
	<!-- Display User Name and Role -->
	
	<p>
		User: <security:authentication property="principal.username" />
			<br><br>
		Role(s) : <security:authentication property="principal.authorities"/>
	</p>
	
	
	<!-- Only show this for admin -->
		<security:authorize access="hasRole('MANAGER')">
		<hr>
		<!-- Add a link to a specific restricted page -->
		
			<p>
				<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting (Only for Manager peeps)</a>
			</p>
		<hr>
		</security:authorize>
	
	 
	
	
	<!-- Only show this for admin -->
	<security:authorize access="hasRole('ADMIN')">
		<!-- Add a link to systems page -->
		
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT systems Meeting (only for admins)</a>
		</p>
		<table>
		<c:forEach var="shoe" items="${shoe}">
					
						<!-- construct an "update" link with customer id -->
						<c:url var="updateLink" value="/shoe/showFormForUpdate">
							<c:param name = "shoeId" value="${shoe.id}"/>
						</c:url>
						
						<!-- construct a "Delete" link with customer id -->
						<c:url var="deleteLink" value="/shoe/delete">
							<c:param name = "shoeId" value="${shoe.id}"/>
						</c:url>
						<tr>
							<td>${shoe.brand}</td>
							<td>${shoe.description}</td>
							<td>${shoe.shoeSize}</td>
							<td>${shoe.category}</td>
							
							<td>
								<!-- Display the update link-->
								<a href="${updateLink}">Update</a>
								|
								<!-- Display the Delete link-->
								<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this shoe?'))) return false">Delete</a>
							
							</td>
						
						</tr>
						
					</c:forEach>
	<hr>
	</security:authorize>
	
	
	
</body>
</html>