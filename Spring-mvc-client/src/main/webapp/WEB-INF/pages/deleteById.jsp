<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete by Id</title>
<style>
body {
  border: 5px outset red;
  background-color: lightblue;
  text-align: center;
}
</style>
</head>
<body>
<h1>Unregister As a Donor</h1>.
<h2>Enter Donor Id to Delete</h2>
<form:form action="deleteDonorById" modelAttribute="data" method="delete">
<label for"">Delete By donor-Id</label>
<form:input path="donorId"/>
<input type="submit" value="Unregister donor">
</form:form>
</body>
</html>