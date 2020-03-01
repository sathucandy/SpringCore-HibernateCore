<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>Sarthak Company Home Page</title>
</head>

<body>
	<h2>Sarthak Company Home Page</h2>
	<hr>
	<p>Welcome to the Sarthak company home page!</p>

	<!-- Add log out button -->
	<form:form action="${pageContext.request.contextPath }/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>

</body>

</html>