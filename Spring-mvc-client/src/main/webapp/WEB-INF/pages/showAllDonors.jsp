<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donors List</title>
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
<h1>Donors Avaliable</h1>
<table>
	<tr>
		<td>Donor Id</td>
		<td>Donor Name</td>
		<td>Mobile Number</td>
		<td>Blood Group</td>
		<td>Last Donated Date</td>
		<td>Address</td>
	</tr>
<c:forEach items="${data}" var="eachItem">	
	<tr>
		<td>${eachItem.donorId }</td>
		<td>${eachItem.donorName }</td>
		<td>${eachItem.mobileNumber }</td>
		<td>${eachItem.bloodGroup}</td>
		<td>${eachItem.lastDonationDate }</td>
		<td>${eachItem.address}</td>
	</tr>
</c:forEach>	
</table>
</div>
</body>
</html>