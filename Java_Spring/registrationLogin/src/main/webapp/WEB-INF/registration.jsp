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
<title>Registration</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/form.css"/></head>
</head>
<body>
	<div>
		<a href="/user/login">Already Registered?</a>
		<h1>Welcome!</h1>
		<p>Join our growing community now!</p>
		<c:out value="${ errors }"/>
		<form:form modelAttribute="newUser" action="/user/register/createUser" method="post" class="row g-3">
			<h2>Register</h2>
			<form:errors style="display: block" path="userName"/>
			<form:errors style="display: block" path="email"/>
			<form:errors style="display: block" path="password"/>
			<form:errors style="display: block" path="confirmPassword"/>
			<div class="mb-3">
				<form:label path="userName" class="form-label">User Name: </form:label>
				<form:input type="text" class="form-control" path="userName" placeholder="Account Username" required="true"/>
			</div>
			<div class="mb-3">
				<form:label path="email" class="form-label">Email address: </form:label>
				<form:input type="email" class="form-control" path="email" placeholder="name@example.com" required="true"/>
			</div>
			<div class="mb-3">
				<form:label path="password" class="form-label">Password: </form:label>
				<form:input type="password" class="form-control" path="password" placeholder="Password" required="true"/>
			</div>
			<div class="mb-3">
				<form:label path="confirmPassword" class="form-label">Confirm Password: </form:label>
				<form:input type="password" class="form-control" path="confirmPassword" placeholder="Confirm Password" required="true"/>
			</div>
		<input type="submit" value="Submit">
		</form:form>
	</div>
</body>
</html>