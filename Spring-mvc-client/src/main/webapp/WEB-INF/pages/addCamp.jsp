<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BloodCamp Registration</title>
</head>
<body>
<div>
   <form:form action="/addCamp" modelAttribute="command" method="post">
<div>
<label for="">camp ID</label>
<form:input path="bloodCampId"/>
<form:errors path="bloodCampId" cssStyle="color:#ff0000;"/>
</div>
<div>
<label for="">BloodCamp Name</label>
<form:input path="bloodCampName"/>
<form:errors path="bloodCampName" cssStyle="color:#ff0000;"/>
</div>
<div>
<label for="">Event Date</label>
<form:input type="date" path="eventDate"/>
</div>
<div>
<label for="">Organisers</label>
<form:input  path="organisers"/>
</div>
<div>
<label for="">Location</label>
<form:input path="location" />
<form:errors path="location" cssStyle="color:#ff0000;"/>
</div>
<div>
<input type="submit" value="Add BloodCamp">
</div>
</form:form>
</div>
</body>
</html>