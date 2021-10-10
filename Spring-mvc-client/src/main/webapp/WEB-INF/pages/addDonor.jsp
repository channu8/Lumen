<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor Registration</title>
</head>
<body>
<div>
   <form:form action="/addDonor" modelAttribute="command" method="post">
<div>
<label for="">Donor ID</label>
<form:input path="donorId"/>
<form:errors path="donorId" cssStyle="color:#ff0000;"/>
</div>
<div>
<label for="">Donor Name</label>
<form:input path="donorName" />
<form:errors path="donorName" cssStyle="color:#ff0000;"/>
</div>
<div>
<label for="">mobile Number</label>
<form:input path="mobileNumber"/>
<form:errors path="mobileNumber" cssStyle="color:#ff0000;"/>
</div>
<div>
<label for="">Blood Group</label>
<form:input path="bloodGroup"/>
<form:errors path="bloodGroup" cssStyle="color:#ff0000;"/>
</div>
<div>
<label for="">Last Donation Date</label>
<form:input type="date" path="lastDonationDate"/>
</div>
<div>
<label for="">Address</label>
<form:input  path="address"/>
</div>
<div>
<input type="submit" value="Add Donor">
</div>
</form:form>
</div>
</body>
</html>