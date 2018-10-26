<%-- 
    Document   : JSP de user
    Created on : oct 18, 2018, 12:46:48 p.m.
    Author     : avilchis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1>User Page</h1>
        <c:if test="${ user != null || !user.isEmpty() || !user == '' }">
            <div>
                <h2 style="color: blue;">Welcome ${user}</h2>
            </div>
        </c:if>

</body>
</html>
