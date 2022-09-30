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
<title>Edit Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/index.css"/>
</head>
<body>
	<a href="/expenses">Go Back</a>
	<h1>Edit Expense</h1>
	<div>
		<h1>Add an expense:</h1>
		<form:form modelAttribute="expense" action="/expenses/${ expense.id }" method="post">
			<input type="hidden" name="_method" value="put"/>
			<p><form:errors path="expenseName"></form:errors></p>
			<p><form:errors path="vendor"></form:errors></p>
			<p><form:errors path="amount"></form:errors></p>
			<p><form:errors path="description"></form:errors></p>
			<div class="mb-3">
 				 <form:label path="expenseName" class="form-label">Expense Name:</form:label>
 				 <form:input type="text" class="form-control" path="expenseName"/>
			</div>
			<div class="mb-3">
 				 <form:label path="vendor" class="form-label">Vendor</form:label>
 				 <form:input type="text" class="form-control" path="vendor"/>
			</div>
			<div class="mb-3">
 				 <form:label path="amount" class="form-label">Amount Spent:</form:label>
 				 <form:input type="text" class="form-control" path="amount"/>
			</div>
			<div class="mb-3">
  				<form:label path="description" class="form-label">Expense Description:</form:label>
  				<form:textarea class="form-control" path="description" rows="3"></form:textarea>
			</div>
			<input type="submit" value="Submit">
		</form:form>
	</div>
</body>
</html>