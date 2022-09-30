<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Display</title>
<link rel="stylesheet" href="/css/index.css/">
</head>
<body class="body">
	<h1 class="bookTitle">${ thisBook.getTitle() }</h1>
		<p> Description: ${ thisBook.getDescription() }</p>
		<p> Language: ${ thisBook.getLanguage() }</p>
		<p> Number of Pages: ${ thisBook.getNumberOfPages() }</p>
</body>
</html>