<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Вы добавили клиента в чёрный список</h2>
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="goAdminPage"/>
		<input type="submit" value="Перейти в меню администратора"/>
	</form>
</body>
</html>