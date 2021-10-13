<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update by Id</title>
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
<h1>Update Donor Details</h1>
<h2>Use Donor-Id to Update</h2>
<form:form action="getUpdatedDonorById" modelAttribute="data" method="put">
<label for"">Enter donor-Id</label>
<form:input path="donorId"/><br>
<label for"">donor-Name</label>
<form:input path="donorName"/><br>
<label for"">Mobile-Number</label>
<form:input path="mobileNumber"/><br>
<label for"">Blood-Group</label>
<form:input path="bloodGroup"/><br>
<label for"">Address</label>
<form:input path="address"/><br>
<input type="submit" value="Update">
</form:form>
</div>
</body>
</html>