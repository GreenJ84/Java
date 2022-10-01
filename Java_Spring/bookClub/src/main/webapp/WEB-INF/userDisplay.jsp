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
<title>Display User</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/"/></head>
</head>
<body>
	<h1>Welcome back, ${ userName }!</h1>
	<a href="/user/clear">Logout</a>
	<a href="/books">Go Back</a>
		<p>Books From My Shelf</p>
	<table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
		</tr>
		<c:forEach var="book" items="${ user.books }">
		<tr>
			<td><c:out value="${ book.id }"></c:out></td>
			<td><c:out value="${ book.title }"></c:out></td>
			<td><c:out value="${ book.author }"></c:out></td>
		</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>