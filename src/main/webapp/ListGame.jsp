<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, models.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>See games here.</title>
</head>
<body>

	<form action="listGame" method="post">
		<input type="submit" value="see list">
	</form>
	
	<form action="orderByTitle" method="post">
		<input type="submit" value="order list by title" >
	</form>
	
	<form action="orderByReleaseDate" method="post">
		<input type="submit" value="order list by release date" >
	</form>
	
	<table border="1">
		<thead>
			<tr>
				<td>Title</td>
				<td>Age</td>
				<td>Release Date</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="videogame" items="${listAllVideoGames}">
				<tr>
					<td><c:out value="${videogame.title}"/> </td>
					<td><c:out value="${videogame.age}"/> </td>
					<td><c:out value="${videogame.releaseDate}"/> </td>
					<td><a href="/deleteVG?title=${videogame.title}">Delete</a></td>
					
		    	</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>