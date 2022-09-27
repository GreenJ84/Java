<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Display</title>
<link rel="stylesheet" href="/css/omikuji.css"/>
</head>
<body>
	<h1 class="title">Here's Your Omikuji!</h1>
	
	<div class="display">
		<p>
			In <c:out value="${ number }"></c:out> years, you will live in 
			<c:out value="${ city }"></c:out> with <c:out value="${ person }"></c:out>
			as your room-mate, as a <c:out value="${ hobby }"></c:out> for a living. The 
			next time you see a <c:out value="${ livingThing }"></c:out>, you will 
			have good luck. Also, <c:out value="${ nice }"></c:out>
		</p>
	</div>
	
	<a class="link" href="/omikuji">Go Back</a>
</body>
</html>