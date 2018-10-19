<%-- 
    Document   : error
    Created on : oct 17, 2018, 12:38:17 p.m.
    Author     : avilchis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Standard NetBeans</title>
    </head>
    <body>
        <h1>Error Page</h1>
        <c:if test="${ message != null || !message.isEmpty() }">
            <h2>${message}</h2>
        </c:if>
    </body>
</html>
