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
<title>Create New Book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body style="background-color: lightgrey;">
	<a href="/books">Back to the shelves</a>
	<h1>Add a Book to Your Shelf!</h1>
	<form:form modelAttribute="book" action="/books/create" method="post" class="row g-3">
		<input type="hidden" name="_method" value="put"/>
		<form:errors style="display: block" path="title"/>
		<form:errors style="display: block" path="author"/>
		<form:errors style="display: block" path="thoughts"/>
		<form:input type="hidden" class="form-control" path="id" required="true"/>
		<div class="mb-3">
  			<form:label path="title" class="form-label">Title: </form:label>
  			<form:input type="text" class="form-control" path="title" required="true"/>
		</div>
		<div class="mb-3">
  			<form:label path="author" class="form-label">Author: </form:label>
  			<form:input type="text" class="form-control" path="author" required="true"/>
		</div>
		<div class="mb-3">
  			<form:label path="thoughts" class="form-label">My Thoughts:</form:label>
 			<form:textarea class="form-control" path="thoughts" rows="3" required="true"></form:textarea>
		</div>
		<form:input type="hidden" class="form-control" path="user" value="${ userId }" required="true"/>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>