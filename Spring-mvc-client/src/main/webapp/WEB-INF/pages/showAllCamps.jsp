<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BloodCamps List</title>
<style>
table {
  border-collapse: collapse;
  border: 1px solid black;
   width: 100%;
}
tr, td {
  border-bottom: 1px solid #ddd;
}

.frame {
  border: 5px outset red;
  background-color: lightblue;
  text-align: center;
}
body{
 background-color: lightblue;
 text-align: center;
}

</style>
</head>
<body>
<div class="frame">
<h1>Donation Camps Avliable</h1>

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
</div>
</body>
</html>