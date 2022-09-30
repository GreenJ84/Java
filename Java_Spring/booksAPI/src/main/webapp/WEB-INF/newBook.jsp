<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/index.css">
</head>
<body>
	<h1 class="title">Create a new Book</h1>
	<form:form action="/books/new/create" method="post" class="form" modelAttribute="book">
		<form:errors path="title"/>
		<form:errors path="description"/>
		<form:errors path="language"/>
		<form:errors path="numberOfPages"/>
		<div class="mb-3">
	  		<form:label path="title" class="form-label">Title:</form:label>
	  		<form:input type="text" class="form-control input" path="title" placeholder="Book Title"/>
		</div>
		<div class="mb-3">
	  		<form:label path="description" class="form-label">Description:</form:label>
	  		<form:textarea class="form-control" path="description" rows="5" placeholder="Short Book description"></form:textarea>
		</div>
		<div class="mb-3">
	  		<form:label path="language" class="form-label">Language</form:label>
	  		<form:input type="text" class="form-control input" path="language" placeholder="Language of Book"/>
		</div>
		<div class="mb-3">
	  		<form:label path="numberOfPages" class="form-label">Number of Pages</form:label>
	  		<form:input type="text" class="form-control input" path="numberOfPages" placeholder="Number of Pages"/>
		</div>
		<input class="button" type="submit" value="Create">
	</form:form>
</body>
</html>