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
<title>Create a Ninjas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/new/create" method="post" modelAttribute="ninjaModel" class="row g-3">
		<form:select path="dojo" class="form-select">
  			<option selected disabled value="">Select your Dojo Location</option>
  			<c:forEach var="thisDojo" items="${ allDojos }">
  				<form:option path="dojo" value="${ thisDojo.getId() }">${ thisDojo.getName() }</form:option>
  			</c:forEach>
		</form:select>
		<div class="mb-3">
  			<form:label path="firstName" class="form-label">First Name: </form:label>
  			<form:input type="text" class="form-control" path="firstName" placeholder="New Ninja's First Name" required="true"/>
		</div>
		<div class="mb-3">
  			<form:label path="lastName" class="form-label">Last Name: </form:label>
  			<form:input type="text" class="form-control" path="lastName" placeholder="New Ninja's Last Name" required="true"/>
		</div>
		<div class="mb-3">
  			<form:label path="age" class="form-label">Age: </form:label>
  			<form:input type="text" class="form-control" path="age" placeholder="New Ninja's Age" required="true"/>
		</div>
		<input type="submit" value="Create">
	</form:form>
</body>
</html>