<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
  </head>
  <body>
     <div class="container">
     <c:if test="${not empty error}">
     <div class="alert alert-danger" ><c:out value="${error}"></c:out></div>
     </c:if>
     <br>
     <c:if test="${not empty logout}">
     <div class="alert alert-danger" ><c:out value="${logout}"></c:out></div>
     </c:if>
      <form class="form-signin" method="post" action="${pageContext.request.contextPath}/login">
        <h2 class="form-signin-heading">Entra a la app</h2>
        <p>
          <label for="username" class="sr-only">Usuario</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
        <p>
          <label for="password" class="sr-only">Contraseña</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Logueate</button>
      </form>
</div>

<div style="text-align: center;" >
<a href="${pageContext.request.contextPath}/createUserForm">Unregistered User Click Here</a>
</div>

</body></html>