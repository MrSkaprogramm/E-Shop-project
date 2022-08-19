<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Регистрация</h2>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="registration"/>
		<h3>Введите логин:</h3>
		<input type="text" name="login" value=""/>
		<h3>Введите пароль:</h3>
		<input type="password" name="pass" value=""/>
		<h3>Введите фамилию, имя и отчество:</h3>
		<input type="text" name="fio" value=""/>
		<h3>Введите e-mail:</h3>
		<input type="text" name="email" value=""/>
		<h3>Введите номер телефона:</h3>
		<input type="text" name="phoneNumber" value=""/>
		<h3>Введите адрес доставки:</h3>
		<input type="text" name="address" value=""/>
		<h3>Роль? 1 - клиент 2 - админ:</h3>
		<input type="text" name="role" value=""/>
		<input type="submit" value="Зарегистрироваться"/>
	</form>
</body>
</html>