<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Security Demo</title>
</head>
<body>
	<h2>Spring Security Demo</h2>
	<hr>
	<!-- display user name and role -->
	<p>
		User:
		<security:authentication property="principal.username" />

		Role(s):
		<security:authentication property="principal.authorities" />

	</p>
	<hr>
	<security:authorize access="hasRole('MANAGER')">
		<!-- Spring-security provides this JSP tag to restrict showing resources based on roles.
		 The html under this tag will be excluded when page is rendered if access is not allowed for that role-->
		
		<!-- Add a link to point to /leaders ... this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders"> Leadership
				Meeting</a> (Only for Manager peeps)
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		</p>
		<!-- Add a link to point to /systems ... this is for the admins -->
		<p>
			<a href="${pageContext.request.contextPath}/systems"> Systems
				Meeting</a> (Only for admin peeps)
		</p>
	</security:authorize>
	<!--  Add a logout button -->
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>