<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   #footer {
    position: fixed; /* Фиксированное положение */
    left: 0; bottom: 0; /* Левый нижний угол */
    padding: 10px; /* Поля вокруг текста */
    background: #0000FF; /* Цвет фона */
    color: #FFFFFF; /* Цвет текста */
    width: 100%; /* Ширина слоя */
   }
   #page-info {
    position: static; /* Фиксированное положение */
    left: 0; bottom: 0; /* Левый нижний угол */
    padding: 10px; /* Поля вокруг текста */
    background: #0000FF; /* Цвет фона */
    color: #FFFFFF; /* Цвет текста */
    width: 100%; /* Ширина слоя */
   }
   #authorization {
    position: static; /* Фиксированное положение */
    left: 0; bottom: 0; /* Левый нижний угол */
    padding: 10px; /* Поля вокруг текста */
    background: #FFFFFF; /* Цвет фона */
    color: #191970; /* Цвет текста */
    width: 100%; /* Ширина слоя */
   }
   #header {
    position: static; /* Фиксированное положение */
    left: 0; bottom: 0; /* Левый нижний угол */
    padding: 10px; /* Поля вокруг текста */
    background: #0000cd; /* Цвет фона */
    color: #FFFFFF; /* Цвет текста */
    width: 100%; /* Ширина слоя */
   }
</style>
</head>
<body>
<div id="header">
<h2>E-SHOP-SFIA</h2>
</div>
<div id="page-info">
Авторизация
</div>
<div id="authorization">
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
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="go_registration"/>
		<input type="submit" value="У вас нет аккаунта? Зарегистрироваться"/>
	</form>
</div>
<div id="footer">Интернет-магазин E-SHOP-SFIA®</div>
</body>
</html>