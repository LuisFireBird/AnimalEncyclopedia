<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Animal Results</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1>Animal Results</h1>
<hr>

<c:if test="${not empty animalDeletion}">
<div class="alert alert-success" ><c:out value="${animalDeletion}"></c:out></div>
</c:if> 


<c:if test="${not empty animalTypeUpdate}">
<div class="alert alert-success" ><c:out value="${animalTypeUpdate}"></c:out></div>
</c:if> 

<c:if test="${not empty duplicatedError}">
<div class="alert alert-danger" ><c:out value="${duplicatedError}"></c:out></div>
</c:if>

<table class="table table-striped" style="width: 600px">
<tr>
<th>
Animal Type
</th>
<th>
Animal Color
</th>
<th>
Animal Character
</th>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<th>
Animal Deletion
</th>
</sec:authorize>
</tr>
<c:forEach var="animalItem" items="${allanimals}" >
<tr><td>
<a href="${pageContext.request.contextPath}/updateAnimalTypeForm?animalType=${animalItem.animalType}">${animalItem.animalType}</a> 
</td>
<td>
<c:out value="${animalItem.animalColor}"></c:out>
</td>
<td>
<c:out value="${animalItem.animalCharacter}"></c:out>
</td>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<td>
<a href="${pageContext.request.contextPath}/deleteAnimalByName?animalName=${animalItem.animalType}">Delete Animal</a>
</td>
</sec:authorize>
</tr>
</c:forEach>
</table>
</body>

<a href="${pageContext.request.contextPath}/" >Go Back Home</a>
<br>
<form action="${pageContext.request.contextPath}/logout" method="post">
			<input type="submit" value="Log out" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>

</html>