<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,models.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>See consoles by their companies</title>
</head>
<body>
	<form action="listCompanyConsole" method="post">
	  <select name="selectCompany" > 
	         <c:forEach var="list" items="${listAllCompany}">
		  		<option value="${list.id}">${list.name}</option>
	         </c:forEach>
	 </select>
	<input type="submit" value="See companies"/>
	</form>
	<form action="listByConsole" method="post">
	<input type="submit" value="show list"/>
		<table border="1">
			<thead>
				<tr>
					<td>Name</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listAllConsole" items="${listAllConsoleByCompany}">
					<tr>
						<td><c:out value="${listAllConsole.name}"/> </td>
			    	</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>