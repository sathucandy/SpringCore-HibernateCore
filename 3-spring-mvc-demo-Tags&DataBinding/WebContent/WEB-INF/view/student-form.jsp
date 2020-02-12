<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student registeration form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	First Name: <form:input path="firstName" />
		<br>
		<br>
	Last Name: <form:input path="lastName" />
		<br>
		<br>
		<form:select path="country">
			<!--<form:option value="Brazil" label="Brazil" />
			<form:option value="France" label="France" />
			<form:option value="Germany" label="Germany" />
			<form:option value="India" label="India" />-->
			<form:options items="${student.countryOptions }" />
		</form:select>
		<br>
		<br>
		Java <form:radiobutton path="favouriteLanguage" value="Java" />
		c# <form:radiobutton path="favouriteLanguage" value="C#" />
		Ruby <form:radiobutton path="favouriteLanguage" value="Ruby" />
		PHP <form:radiobutton path="favouriteLanguage" value="PHP" />
		<br>
		<br>
		Operatiing Systems : 
		Linux <form:checkbox path="operatingSystems" value="linux" />
		Mac <form:checkbox path="operatingSystems" value="mac" />
		Windows <form:checkbox path="operatingSystems" value="windows" />
		<br>
		<br>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>