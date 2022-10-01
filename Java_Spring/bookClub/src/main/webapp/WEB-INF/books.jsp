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
	<h1>Welcome, ${ userName }!</h1>
	<a href="/user/clear">Logout</a>
	<div>
		<p>Book's From Everyones Shelves</p>
		<div>
			<a href="/user/${ userId }/display">Check My Shelf</a>
			<a href="/books/new">+ Add to my shelf!</a>
		</div>
	</div>
	<table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Posted By</th>
		</tr>
		<c:forEach var="book" items="${ books }">
		<tr>
			<td><c:out value="${ book.id }"></c:out></td>
			<td><a href="/books/display/${ book.id }" ><c:out value="${ book.title }"></c:out></a></td>
			<td><c:out value="${ book.author }"></c:out></td>
			<td><c:out value="${ book.user.userName }"></c:out></td>
		</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>