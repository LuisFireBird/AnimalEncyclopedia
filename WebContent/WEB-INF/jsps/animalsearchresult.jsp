<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Animal Search Result</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1>Animal Search Result</h1>
<hr>
<table class="table-striped" >
<tr>
<th>Animal Type</th>
<th>Animal Color</th>
<th>Animal Character</th>
</tr>
<c:forEach items="${animalsearchresult}" var="animalItem" >
<tr>
<td><c:out value="${animalItem.animalType}"></c:out></td>
<td><c:out value="${animalItem.animalColor}"></c:out></td>
<td><c:out value="${animalItem.animalCharacter}"></c:out></td>
</tr>
</c:forEach>
</table>

<br>
<br>
<br>

<a href="${pageContext.request.contextPath}/" >Go Back Home</a>

</body>
</html>