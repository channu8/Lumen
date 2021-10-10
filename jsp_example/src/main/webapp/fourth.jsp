<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>fourth</title>
</head>
<body>
<%@ include file="menu.html" %>
<%= session.isNew() %>
<%= session.getId() %>
<h4>List of Names - Fourth</h4>
<c:out value="${name } ${Location }"/>

</body>
</html>