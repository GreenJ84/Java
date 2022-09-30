<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Books</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/index.css"/>
</head>
<body>
	<a class="create" href="/books/new">Create a new Book</a>
	<h1 class="title">All Books</h1>
	<table class="table table-dark table-hover">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Language</th>
			<th># Pages</th>
		</tr>
		
		<c:forEach var="eachBook" items="${ allBooks }">
		<tr>
			<td><c:out value="${ eachBook.id }"></</c:out></td>
			<td><a href="/books/<c:out value="${ eachBook.id }"></</c:out>"><c:out value="${ eachBook.title }"></</c:out></a></td>
			<td><c:out value="${ eachBook.language }"></</c:out></td>
			<td><c:out value="${ eachBook.numberOfPages }"></</c:out></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>