<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Standard Login</title>
</head>
<body>
	<h2>User Page</h2>
    <c:if test="${ user != null || !user.isEmpty()}">
        <div>
            <h1>Bienvenido ${user}</h1>
        </div>
    </c:if>
</body>
</html>