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
<title>Display User</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/"/></head>
</head>
<body>
	<h1>Welcome back, ${ userName }!</h1>
	<p>This is your Dashboard. Nothing to see here yet!</p>
	<a href="/user/clear">Logout</a>
</body>
</html>