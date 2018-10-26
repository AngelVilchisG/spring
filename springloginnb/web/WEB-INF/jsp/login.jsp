<%-- 
    Document   : JSP de login
    Created on : oct 17, 2018, 12:38:05 p.m.
    Author     : avilchis
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <title>Spring Standard NetBeans</title>
        <script>
            var ctx = "${pageContext.request.contextPath}";
        </script>
    </head>

    <body>
        <h2>Login page</h2>
        <p>Ingresa tu usuario y contraseña para iniciar sesión</p>
        <div id="formLogin" class="form-login">
            
            <form id="form" action="login.htm" method="POST" >
                
                <div style="display: flex; align-content: flex-start; flex-direction: column; margin: 10px 0;">
                    <span id="userMessage"></span>
                    <label for="userName" style="width: 90px; margin: 10px;" >
                        Usuario:
                    </label>
                    <input style="width: 120px;" id="userName" name="userName" type="text" size="12" 
                           required onkeyup="toMayus(this);" onkeypress="return validaUsuario(event);" >
                </div>
                
                <div style="display: flex; align-content: flex-start; flex-direction: column; margin: 10px 0;" >
                    <span id="userPassword"></span>
                    <label for="passwd" style="width: 90px; margin: 10px;" >
                        Contraseña:
                    </label>
                    <input style="width: 120px;" id="passwd" name="passwd" type="text" size="16" 
                           required onkeypress="return validaPassword(event);">
                </div>
                
                <div>
                    <span id="message" style="color: rgb(229, 115, 115);"></span>
                </div>
                
                <input id="btnLogin" type="submit" value="Iniciar sesión" onclick="validateLogin();" >
            
            </form>
            <!--
            <input id="btnLogin" type="submit" value="Iniciar sesión" type="submit" 
            onclick="validateLogin();">
            -->
            <div>
                <c:if test="${ message != null || !message.isEmpty() || !message == '' }">
                    <div id="error"style="color: rgb(229, 115, 115);">
                        ${message}
                    </div>
                </c:if>
            </div>
        </div>
        
        <script type="text/javascript" src="<c:url value='/js/validateLogin.js' />" ></script>
    </body>
</html>
