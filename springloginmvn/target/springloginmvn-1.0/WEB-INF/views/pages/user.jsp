<%-- 
    Document   : user
    Created on : oct 18, 2018, 12:35:22 p.m.
    Author     : avilchis
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Maven NetBeans</title>
        <script>
            var ctx = "${pageContext.request.contextPath}";
        </script>
    </head>
    <body>
        <h2>User Page</h2>
        <c:if test="${ user != null || !user.isEmpty()}">
            <div>
                <h1>Welcome ${user}</h1>
            </div>
        </c:if>
    </body>
</html>
