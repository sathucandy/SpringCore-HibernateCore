<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>Sarthak Company Home Page</title>
</head>

<body>
	<h2>Sarthak Company Home Page</h2>
	<hr>
	<p>Welcome to the Sarthak company home page!</p>

	<!-- Display username and role -->
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role(s):
		<security:authentication property="principal.authorities" />
	</p>
	<!-- Add log out button -->
	<form:form action="${pageContext.request.contextPath }/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>

</body>

</html>