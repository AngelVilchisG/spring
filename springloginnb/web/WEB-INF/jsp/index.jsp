<%-- 
    Document   : JSP de index
    Created on : oct 17, 2018, 12:38:05 p.m.
    Author     : avilchis
--%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
        <p>Spring Web MVC project: Login Example</p>
        <a style="cursor: pointer;" href="${pageContext.request.contextPath}/login.htm">Login</a>
    </body>
</html>
