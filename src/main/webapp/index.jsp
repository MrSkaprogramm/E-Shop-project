<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Добро пожаловать в интернет-магазин E-SHOP-SFIA</h2>
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="goAuthorization"/>
		<input type="submit" value="Авторизация"/>
	</form>
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="goRegistration"/>
		<input type="submit" value="Регистрация"/>
	</form>
		
</body>
</html>