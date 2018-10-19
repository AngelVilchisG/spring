<%-- 
    Document   : error
    Created on : oct 18, 2018, 12:35:05 p.m.
    Author     : avilchis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Maven NetBeans</title>
    </head>
    <body>
        <h2>Error Page</h2>
        
        <c:if test="${ message != null || !message.isEmpty() }">
            <h1>${message}</h1>
        </c:if>
        
    </body>
</html>
