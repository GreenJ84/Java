<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1> ${ dojoDetails.name }  Location Ninjas</h1>
	<table class="table table-success table-hover">
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Age</th>
	</tr>
	<c:forEach var="ninja" items="${ dojoDetails.ninjas }">
	<tr>
		<td><c:out value="${ ninja.firstName }"></c:out></td>
		<td><c:out value="${ ninja.lastName }"></c:out></td>
		<td><c:out value="${ ninja.age }"></c:out></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>