<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Confirmation</title>
</head>
<body>
	The Customer confirmed is: ${customer.firstName } ${customer.lastName }
	<br> Free passes are: ${customer.freePasses}
	<br> Postal Code: ${customer.postalCode }
	<br> Course Code: ${customer.courseCode }
</body>
</html>