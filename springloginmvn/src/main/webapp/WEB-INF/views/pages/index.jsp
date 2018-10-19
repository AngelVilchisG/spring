<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Maven NetBeans</title>
        <script>
            var ctx = "${pageContext.request.contextPath}";
        </script>
    </head>
    <body>
        <div id="goLogin" style="cursor: pointer">
            <a id="linkLogin">Ir a inicio de sesión</a>
        </div>
        <a href="${pageContext.request.contextPath}/login.htm">Clic para iniciar sesión</a>
       
        <script type="text/javascript" src="<c:url value='/resources/js/start.js' />" />
    </body>
</html>