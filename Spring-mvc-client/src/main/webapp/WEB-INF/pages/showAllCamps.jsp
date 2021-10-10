<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BloodCamps List</title>
</head>
<body>
<table>
	<tr>
		<td>Camp Id</td>
		<td>Camp Name</td>
		<td>Organisers</td>
		<td>Event Date</td>
		<td>Location</td>
		
	</tr>
<c:forEach items="${data}" var="eachItem">	
	<tr>
		<td>${eachItem.bloodCampId }</td>
		<td>${eachItem.bloodCampName }</td>
		<td>${eachItem.organisers }</td>
		<td>${eachItem.eventDate}</td>
		<td>${eachItem.location }</td>
		
	</tr>
</c:forEach>	
</table>
</body>
</html>