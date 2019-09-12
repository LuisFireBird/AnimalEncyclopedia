<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Animal Type</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<sf:form action="${pageContext.request.contextPath}/updateAnimalType" method="GET" modelAttribute="animal" >
<h3>New Animal Type for ${oldAnimalType} : </h3> 
<sf:input path="animalType"/>
<sf:errors path="animalType" cssClass="text-danger" ></sf:errors>
<input type="hidden" value="${oldAnimalType}" name="animalColor" id="animalColor">
<input type="submit" value="Update" class="btn btn-primary">
</sf:form>
</body>
</html>