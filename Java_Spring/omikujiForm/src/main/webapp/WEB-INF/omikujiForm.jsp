<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/omikuji.css"/>
</head>
<body>
	<h1 class="title">Send a Omikuji!</h1>
	
	<div class="content">
		<form action="/omikuji/submit" method="POST">
			<div class="mb-3 num">
				<label for="number">Pick any number from 5 and 25:</label>
  				<input class="numBox" type="number" id="number" name="number" min="5" max="25" required>
			</div>
			<div class="mb-3">
  				<label for="cityName" class="form-label">Enter the name of any city.</label>
  				<input type="text" class="form-control inputBox" name="nameCity" id="nameCity" placeholder="i.e. Dubai" required>
			</div>
			<div class="mb-3">
  				<label for="namePerson" class="form-label">Enter the name of any real person.</label>
  				<input type="text" class="form-control inputBox" name="namePerson" id="namePerson" placeholder="i.e. Bob Ross" required>
			</div>
			<div class="mb-3">
  				<label for="endeavorHobby" class="form-label">Enter professional endeavor or hobby:</label>
  				<input type="text" class="form-control inputBox" name="endeavorHobby" id="endeavorHobby" placeholder="i.e. Origamis creator" required>
			</div>
			<div class="mb-3">
  				<label for="livingThing" class="form-label">Enter any type of living thing.</label>
  				<input type="text" class="form-control inputBox" name="livingThing" id="livingThing" placeholder="i.e. ferret" required>
			</div>
			<div class="mb-3">
  				<label for="somethingNice" class="form-label">Say something nice to someone:</label>
  				<textarea class="form-control" name="somethingNice" id="somethingNice" rows="6" required></textarea>
			</div>
			
			<p><em>Send and show a friend</em></p>
			<input class="button" type="submit" value="Send">
		</form>
	</div>
</body>
</html>