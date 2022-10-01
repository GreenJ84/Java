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
<title>Display Book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<h1>${ thisBook.title }</h1>
	<a href="/books">Back to shelves</a>
	<c:choose>
		<c:when test="${ thisBook.user.id == userId }">
			<p>You have read ${ thisBook.title } 
			by ${ thisBook.author }.</p>
			<br>
			<p>Here are your Thoughts</p>
		</c:when>
		<c:otherwise>
			<p>${ thisBook.user.userName } read ${ thisBook.title } 
			by ${ thisBook.author }.</p>
			<br>
			<p>Here are ${ thisBook.user.userName }'s Thoughts</p>
		</c:otherwise>
	</c:choose>
	<div>
		<p>${ thisBook.thoughts }</p>
	</div>
	
	<c:choose>
		<c:when test="${ thisBook.user.id == userId }">
			<a href="/books/${ thisBook.id }/edit"> Edit </a>
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
	</c:choose>
</body>
</html>