<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Animal Encyclopedia</title>
</head>
<body>
Welcome <b>${welcomeName}</b> You have a role of <sec:authentication property="principal.authorities"/>
<br>
<a href="${pageContext.request.contextPath}/" >this link will take you home</a>
</body>
</html>