<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Case Study</title>
</head>
<body>
<c:set var="message" value="${'From JSP'}" scope="session"/>

<a href="InfoServlet">Continue</a>
</body>
</html>