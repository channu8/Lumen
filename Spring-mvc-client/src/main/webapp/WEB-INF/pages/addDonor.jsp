<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor Registration</title>
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
   <form:form action="/addDonor" modelAttribute="command" method="post">
<div class="heading">
<h1>Blood Donor Registration</h1>
</div>
<div class="body">
<label for=""class="label">Donor ID</label>
<form:input path="donorId" class="input"/>
<form:errors path="donorId" cssStyle="color:#ff0000;"/>
</div>
<div>
<label for="" class="label">Donor Name</label>
<form:input path="donorName" class="input" />
<form:errors path="donorName" cssStyle="color:#ff0000;"/>
</div>
<div>
<label for="" class="label">mobile Number</label>
<form:input path="mobileNumber"/>
<form:errors path="mobileNumber" cssStyle="color:#ff0000;"/>
</div>
<div>
<label for="" class="label">Blood Group</label>
<form:select path="bloodGroup" class="input">
<form:option value="A+" label="A+"/>
				<form:option value="A-" label="A-"/>
				<form:option value="B+" label="B+"/>
				<form:option value="B-" label="B-"/>
				<form:option value="AB+" label="AB+"/>
				<form:option value="AB-" label="AB-"/>
				<form:option value="O+" label="O+"/>
				<form:option value="O-" label="O-"/>
</form:select>
<form:errors path="bloodGroup" cssStyle="color:#ff0000;"/>
</div>
<div>
<label for="" class="label">Last Donation Date</label>
<form:input type="date" path="lastDonationDate" class="input"/>
</div>
<div>
<label for="" class="label">Address</label>
<form:input  path="address" class="input"/>
</div>
<div>
<input type="submit" value="Add Donor">
</div>
</form:form>
</div>
<h2 >Thank You for Registring as a Donor </h2>
</body>
</html>