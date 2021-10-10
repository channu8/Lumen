<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.html" %>
<%= session.isNew() %>
<%= session.getId() %>
<h2>List of Names</h2>
<c:out value="${name } ${Location }"/>

<% session.invalidate(); %>

<a href="fourth.jsp">Next</a>
</body>
</html>