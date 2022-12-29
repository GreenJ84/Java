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
<title>LogIn</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/form.css"/></head>
<body>
	<div>
		<a href="/user/register">Create new User</a>
		<h1>Welcome, back!</h1>
		<c:out value="${ errors }"/>
		<form:form modelAttribute="loginEvent" action="/user/login/check" method="post">
			<h2>Log In</h2>
			<form:errors path="email"/>
			<form:errors path="password"/>
			<div class="mb-3">
				<form:label path="email" class="form-label">Email address: </form:label>
				<form:input type="email" class="form-control" path="email" placeholder="name@example.com" required="true"/>
			</div>
			<div class="mb-3">
				<form:label path="password" class="form-label">Password: </form:label>
				<form:input type="password" class="form-control" path="password" placeholder="Password" required="true"/>
			</div>
			<input type="submit" value="Submit">
		</form:form>
	</div>
</body>
</html>