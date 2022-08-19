<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Авторизация</h2>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="authorization"/>
		<h3>Введите логин:</h3>
		<input type="text" name="login" value=""/>
		<h3>Введите пароль:</h3>
		<input type="password" name="pass" value=""/>
		<br>
		<br>
		<input type="submit" value="Войти"/>
	</form>
</body>
</html>