<%-- 
    Document   : login
    Created on : oct 18, 2018, 12:35:13 p.m.
    Author     : avilchis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Maven NetBeans</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script>
            var ctx = "${pageContext.request.contextPath}";
            var message;
        </script>
    </head>
    <body>
        <h2>Inicio de sesión</h2>
        <div id="formLogin" class="form-login">
            <form id="form" action="" method="POST">
                <label for="userName">Usuario:</label>
                <input id="userName" type="text" onkeypress="return validaUsuario(event);">
                <label for="passwd">Contraseña:</label>
                <input id="passwd" type="password" onkeypress="return validaPassword(event);">
            </form>
            <div >
                <p id="message"></p>
            </div>
            <input type="submit" value="Iniciar sesión" onclick="validateLogin();">
        </div>

        <c:if test="${ message != null || !message.isEmpty() } ">
            <div id="error">
                <h1>${message}</h1>
            </div>
        </c:if>
        <%-- <c:url value='/resources/js/validate.js' /> --%>
        <!-- <script type="text/javascript" src="/resources/js/validate.js" ></script> -->
        <script>

            var usrnm = document.getElementById('userName');
            var usrpsw = document.getElementById('passwd');
            var message = document.getElementById('message');

            function validateLogin() {
                console.log('VALIDATE');
                console.log('usrnm', usrnm.value);
                console.log('usrpsw', usrpsw.value);
                if ( usrnm.value == null || usrnm.value == '' ) {
                    usrnm.style.borderStyle = "1px solid rgb(229, 115, 115)";
                    message.innerHTML = "Este campo no debe quedar vació";
                    if ( usrpsw.value == null || usrpsw.value =='' ) {
                    usrpsw.style.borderStyle = "1px solid rgb(229, 115, 115)";
                    message.innerHTML = "Este campo no debe quedar vació";
                }
                    message.innerHTML = "Los campos no debe quedar vaciós";
                } else {
                    loginPost();
                }
            }
            function validaUsuario(event) {
                var unicode = event.charCode ? event.charCode : event.keyCode;
                if (unicode == 8 || unicode == 13)
                    return true;
                if (unicode >= 65 && unicode <= 90 || unicode >= 97 && unicode <= 122) {
                    return true;
                } else {
                    return false;
                }
            }

            function validaPassword(event) {
                var unicode = event.charCode ? event.charCode : event.keyCode;
                if (unicode === 8 || unicode === 13)
                    return true;
                if (unicode == 64 || unicode == 45 || unicode == 46 || unicode == 95 ||
                        ((unicode >= 48) && (unicode <= 57)) ||
                        ((unicode >= 65) && (unicode <= 90)) ||
                        ((unicode >= 97) && (unicode <= 122)))
                    return true;
                else
                    return false;
            }

            function loginPost() {
                console.log('loginPOST');
                $.ajax({
                    type: 'POST',
                    data: {
                        userName: usrnm.value,
                        passwd: usrpsw.value
                    },
                    url: ctx + '/login.htm',
                    beforeSend: function () {
                    },
                    success: function (data) {
                    },
                    error: function (xhr, status, error) {
                        //message.innerHTML = ('Error: ', error)
                    }
                });
            }
        </script>
    </body>
</html>
