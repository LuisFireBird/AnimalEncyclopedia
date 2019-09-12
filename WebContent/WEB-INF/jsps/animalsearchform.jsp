<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<sf:form action="${pageContext.request.contextPath}/SearchAnimalResult" method="POST" modelAttribute="animal" >
<table class="table table-striped table-dark" style="width: 600px;">
<tr><td>Animal Type</td><td><sf:input path="animalType" name="animalType"/>
<sf:errors path="animalType" cssClass="text-danger" ></sf:errors></td></tr>
<tr><td>Animal Color</td><td><sf:input path="animalColor" name="animalColor"/>
<sf:errors path="animalColor" cssClass="text-danger" ></sf:errors> </td></tr>
<tr><td>Animal Character</td><td><sf:input path="animalCharacter" name="animalCharacter" />
<sf:errors path="animalCharacter" cssClass="text-danger" ></sf:errors> </td></tr>
<tr><td> <input type="submit" value="searching..." > </td></tr>
</table>
</sf:form>
</body>
</html>