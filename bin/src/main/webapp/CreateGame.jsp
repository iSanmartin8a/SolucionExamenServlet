<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert games here.</title>
	</head>
	<body>
		<form action="createVideogame" method="post">
		<span>Title:</span>

		<input type="text" name="title"> <br/>
		<span>Recommended Age:</span>

		<input type="text" name="recommendedAge"><br/>
		<span>Release Date:</span>

		<input type="date" name="releaseDate"><br/>

		<input type="submit">
	</form>
	</body>
</html>