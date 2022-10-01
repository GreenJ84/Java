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
<title>Create a Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/dojos/new/create" method="post" modelAttribute="dojoModel" class="row g-3">
		<div class="mb-3">
  			<form:label path="name" class="form-label">Name: </form:label>
  			<form:input type="text" class="form-control" path="name" placeholder="New Dojo's Name" required="true"/>
		</div>
		<input type="submit" value="Create">
	</form:form>
</body>
</html>