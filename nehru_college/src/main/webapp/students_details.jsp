<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>student_details</title>
<style>
table{
border:2px solid blue;
margin-left:auto;
nargin-right:auto;
align:center;

border-collapse:collapse;
}

tr,td,th{
border: 2px solid blue;
}
</style>
</head>
<body>
<h1 align="center">Student details</h1>
<table>
	<tr>
		<th>Sl.No</th>
		<th>Name</th>
		<th>Mark Scored</th>
	</tr>
<c:forEach items="${foundStudent}" var="eachStudent">
	<tr>
		<td>${eachStudent.id}</td>
		<td>${eachStudent.name}</td>
	 <c:if test="${eachStudent.markscored<80}">
		<td style= "color:#ff0000">${eachStudent.markscored}</td>
	    </c:if>
	    
	 <c:if test="${eachStudent.markscored>=80}">
		<td >${eachStudent.markscored}</td>
	    </c:if>
	</tr>
	</c:forEach>
</table>
</body>
</html>