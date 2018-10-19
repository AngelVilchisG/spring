<%-- 
    Document   : user
    Created on : oct 18, 2018, 12:46:48 p.m.
    Author     : avilchis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Standard NetBeans</title>
    </head>
    <body>
        <h1>User Page</h1>
        <c:if test="${ user != null || !user.isEmpty() }">
            <div>
                <h2>Welcome ${user}</h2>
            </div>
        </c:if>

</body>
</html>
