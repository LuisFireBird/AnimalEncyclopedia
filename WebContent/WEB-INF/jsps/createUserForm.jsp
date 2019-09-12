<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Animal Creation Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>

<h1>User Creation Form</h1>

<hr>

<sf:form action="${pageContext.request.contextPath}/createUser" name="userForm" method="POST" modelAttribute="user">
<table  class="table table-striped table-dark"  style="width: 600px;">
<tr><td>
User Name</td><td>
<sf:input path="userName" name="userName"/>
<br><sf:errors path="userName" cssClass="text-danger"></sf:errors>
</td></tr>
<tr><td>
Password</td><td>
<sf:input path="passWord" name="passWord"/>
<br><sf:errors path="passWord" cssClass="text-danger"></sf:errors>
</td></tr>
<tr><td>
<input type="submit" value="sending..."/>
</td></tr>
</table>
</sf:form>

</body>
</html>