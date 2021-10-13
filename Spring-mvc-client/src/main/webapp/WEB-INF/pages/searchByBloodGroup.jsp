<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>donor by bloodgroup</title>
<style>
.frame {
  border: 5px outset red;
  background-color: lightblue;
  text-align: center;
}
input{
  border: 2px solid red;
  border-radius: 4px;
}
body{
 background-color: lightblue;
 text-align: center;
}

</style>
</head>
<body>
<div class="frame">
<h1>Search Donors By BloodGroup</h1>
<h2>Enter the BloodGroup</h2>
<form:form action="getDonorByBloodGroup" modelAttribute="data" method="get">
<label for"">Search Donor's By BloodGroup(Enter BloodGroup)</label>
<form:input path="bloodGroup"/>
<input type="submit" value="Search donors">
</form:form>
</div>
</body>
</html>