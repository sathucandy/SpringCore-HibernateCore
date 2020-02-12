<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation Page</title>
</head>
<body>
	The student is confirmed: ${student.firstName} ${student.lastName}.
	<br>
	<br> You have selected ${student.country }
	<br> Favorite Language is ${student.favouriteLanguage }
	<br> Operating System selected is:
	<ul>
		<c:forEach var="tmp" items="${student.operatingSystems }">
			<li>${tmp}</li>
		</c:forEach>
	</ul>
</body>
</html>