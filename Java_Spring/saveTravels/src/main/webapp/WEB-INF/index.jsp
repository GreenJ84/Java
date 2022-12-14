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
<title>Save Travels</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/index.css"/>
</head>
<body>
	<h1 class="title"">Save Travels</h1>
	<div class="expenseForm">
		<div class="top">
			<h1>Add an expense: </h1>
			<button class="button" onClick="addForm()">Click Here</button>
		</div>
		<form:form modelAttribute="expense" action="/expenses/new" method="post" class="form">
			<p><form:errors path="expenseName"></form:errors></p>
			<p><form:errors path="vendor"></form:errors></p>
			<p><form:errors path="amount"></form:errors></p>
			<p><form:errors path="description"></form:errors></p>
			<div class="mb-3">
 				 <form:label path="expenseName" class="form-label">Expense Name:</form:label>
 				 <form:input type="text" class="form-control" path="expenseName" placeholder="Name of Expense"/>
			</div>
			<div class="mb-3">
 				 <form:label path="vendor" class="form-label">Vendor</form:label>
 				 <form:input type="text" class="form-control" path="vendor" placeholder="Name of Vendor"/>
			</div>
			<div class="mb-3">
 				 <form:label path="amount" class="form-label">Amount Spent:</form:label>
 				 <form:input type="text" class="form-control" path="amount" placeholder="Total amount spent"/>
			</div>
			<div class="mb-3">
  				<form:label path="description" class="form-label">Expense Description:</form:label>
  				<form:textarea class="form-control" path="description" rows="3" placeholder="please add a short description of the expense"></form:textarea>
			</div>
			<div class="top">
				<a href='/expenses' class="button notLink"> Cancel </a>
				<input class="button" type="submit" value="Submit">
			</div>
		</form:form>
	</div>
	<div class="expenseList">
		<h1>Expenses: </h1>
		<table class="table table-hover">
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Actions</th>
		</tr>
			<c:forEach var="expense" items="${ expenses }">
			<tr>
				<td>
					<a class="button2 notLink" href="/expenses/display/${ expense.id }"><c:out value="${ expense.expenseName }"></c:out></a>
				</td>
				<td><c:out value="${ expense.vendor }"></c:out></td>
				<td><c:out value="${ expense.amount }"></c:out></td>
				<td>
					<div class="bottom">
						<a class="button2 notLink" href="/expenses/edit/${ expense.id }">Edit</a> 
						<form class="button2 delete" action="/expenses/delete/${expense.id}" method="post">
							<input type="hidden" name="_method" value="delete">
							<input class="notButton" type="submit" value="Delete">
						</form>
					</div>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	<script>
		function addForm(){
			document.getElementsByClassName("form")[0].style.display = "block"
			document.getElementsByClassName("button")[0].style.display = 'none'
		}
	</script>
</body>
</html>