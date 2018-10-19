<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Spring Standard Login</title>
	</head>
		<body>
			<h2>Login Page</h2>
			<div id="formLogin" class="form-login">
				<form action="" method="POST" id="form">
					<label for="userName">Usuario:</label>
					<input type="text" id="userName" name="userName" onkeypress="return validaUsuario(event)">
					<label for="passwd">Contraseña:</label>
					<input type="password" id="passwd" name="passwd" onkeypress="return validaPassword(event)">
				</form>
				<input type="submit" value="Iniciar sesión" onclick="javascript:validateLogin();">
			</div>
			<c:if test="${ message != null || !message.isEmpty() } ">
		            <div>
		                <h1>${message}</h1>
		            </div>
		    </c:if>
		</body>
</html>