<%@page import="by.epam.tr.bean.User"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   BODY { 
   	background: #FFFFFF;
   	margin-bottom: 50px; 
   }
   #footer {
    position: fixed; /* Фиксированное положение */
    left: 0; bottom: 0; /* Левый нижний угол */
    padding: 10px; /* Поля вокруг текста */
    background: #0000FF; /* Цвет фона */
    color: #FFFFFF; /* Цвет текста */
    width: 100%; /* Ширина слоя */
   }
   #client {
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
   #welcome-text {
    position: static; /* Фиксированное положение */
    left: 0; bottom: 0; /* Левый нижний угол */
    padding: 10px; /* Поля вокруг текста */
    background: #0000FF; /* Цвет фона */
    color: #FFFFFF; /* Цвет текста */
    width: 100%; /* Ширина слоя */
   }
</style>
</head>
<body>
<div id="header">Профиль</div>
<div id="welcome-text">
<h2>Добрый день, <c:out value="${user.fio}"/></h2>
</div>
<div id="client">
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="show_order_list"/>
		<input type="submit" value="Просмотреть список моих заказов"/>
	</form>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="show_catalog"/>
		<input type="submit" value="Перейти к каталогу товаров"/>
	</form>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="exit"/>
		<input type="submit" value="Выйти"/>
	</form>
</div>
<div id="footer">Интернет-магазин E-SHOP-SFIA®</div>
</body>
</html>