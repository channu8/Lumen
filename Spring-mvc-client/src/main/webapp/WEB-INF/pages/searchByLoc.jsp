<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>donor by location</title>
<style>
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
<h1>Search Donor By Location</h1>
<h2>Enter Location</h2>
<form:form action="getDonorByLoc" modelAttribute="data" method="get">
<label for"">Search Donor's By Location(Enter location)</label>
<form:input path="address"/>
<input type="submit" value="Search donors">
</form:form>
</div>
</body>
</html>