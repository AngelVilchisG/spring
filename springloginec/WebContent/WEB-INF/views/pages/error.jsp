<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Standard Login</title>
</head>
<body>
	<h2>Error Page</h2>
	<c:if test="${ message != null || !message.isEmpty() }">
		<div>
			<h1>${message}</h1>
		</div>
	</c:if>
</body>
</html>