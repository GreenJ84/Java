<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
<link rel="stylesheet" href="/css/main.css"/>
</head>
<body>
	<div class="scoreDisplay">
	<p>Your Gold: </p><p class="score"><c:out value="${ score }"></c:out></p>
	</div>
	<a class="reset button" href="/reset">Reset Score</a>
	<div class="optionHolder">
		<div class="gameOption">
			<p class="title">Farm</p>
			<p>(earns 10 - 20 gold)</p>
			<a class="button" href="/farm"> Find Gold! </a>
		</div>
		<div class="gameOption">
			<p class="title">Cave</p>
			<p>(earns 5 - 30 gold)</p>
			<a class="button" href="/cave"> Find Gold! </a>
		</div>
		<div class="gameOption">
			<p class="title">House</p>
			<p>(earns 0 - 40 gold)</p>
			<a class="button" href="/house"> Find Gold! </a>
		</div>
		<div class="gameOption">
			<p class="title">Quest</p>
			<p>(earns 10 - 50 gold)</p>
			<a class="button" href="/quest"> Find Gold! </a>
		</div>
	</div>
	
	<p>Activities:</p>
	<div class="output">
		<c:forEach var="statement" items="${events}">
			<c:choose>
			<c:when test="${statement.getEarned()== false}" >
        		<p class="bad"><c:out value="${statement.getStatement()}"></c:out></p>
       		</c:when>
       		<c:otherwise>
       			<p class="good"><c:out value="${statement.getStatement()}"></c:out></p>
       		</c:otherwise>
       		</c:choose>
    	</c:forEach>
	</div>
</body>
</html>