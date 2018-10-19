<%-- 
    Document   : login
    Created on : oct 17, 2018, 12:38:05 p.m.
    Author     : avilchis
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Standard NetBeans</title>
        <script>
            var ctx = "${pageContext.request.contextPath}";
            var message;
        </script>
    </head>
    
    <body>
        <h2>Login page</h2>
        <p>Ingresa tu usuario y contraseña para iniciar sesión</p>
        <div id="formLoginId" class="form-login">
            <form action="" id="login" name="login" method="POST">
                <label for="userName">Usuario:</label>
                <input id="userName" name="userName" type="text" onkeypress="return validaUsuario(event)">
                <label for="passwd">Contraseña:</label>
                <input id="passwd" name="passwd" type="password"  onkeypress="return validaPassword(event)">
            </form>
             <input type="submit" value="Iniciar sesión" onclick="javascript:validateLogin();">
        </div>
            <p id="message"></p>
            <c:if test="${ message != null || !message.isEmpty() }">
                <div>
                    <h1>${message}</h1>
                </div>
            </c:if>
           
    </body>
</html>
