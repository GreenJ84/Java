<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Fruity Loops</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="../css/fruityLoops.css">
</head>
<body>
	<h1 class="title">Fruit Store</h1>
	<table id="display" class="table table-dark table-hover">
		<tr>
			<th style="font-size: 25px;">Name</th>
			<th style="font-size: 25px;">Price</th>
		</tr>
	<c:forEach var="eachFruit" items="${ fruits }">
		<tr>
			<td><c:out value="${ eachFruit.name }"></c:out></td>
			<td><c:out value="${ eachFruit.price }"></c:out></td>
		</tr>
	</c:forEach>
		
	</table>
</body>
</html>