<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Spring rest demo</h1>
	<!--<a href="test/hello">Hello</a>  -->
	<a href="${pageContext.request.contextPath }/test/hello">Hello</a>
	<br>
	<hr>
	<br>
	<a href="${pageContext.request.contextPath }/api/students">Get All
		Students</a>
</body>
</html>