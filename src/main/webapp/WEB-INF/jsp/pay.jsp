<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   #header {
    position: static; /* Фиксированное положение */
    left: 0; bottom: 0; /* Левый нижний угол */
    padding: 10px; /* Поля вокруг текста */
    background: #0000cd; /* Цвет фона */
    color: #FFFFFF; /* Цвет текста */
    width: 100%; /* Ширина слоя */
   }
   #footer {
    position: fixed; /* Фиксированное положение */
    left: 0; bottom: 0; /* Левый нижний угол */
    padding: 10px; /* Поля вокруг текста */
    background: #0000FF; /* Цвет фона */
    color: #FFFFFF; /* Цвет текста */
    width: 100%; /* Ширина слоя */
   }
   #payment {
    position: static; /* Фиксированное положение */
    left: 0; bottom: 0; /* Левый нижний угол */
    padding: 10px; /* Поля вокруг текста */
    background: #FFFFFF; /* Цвет фона */
    color: #191970; /* Цвет текста */
    width: 100%; /* Ширина слоя */
   }
</style>
</head>
<body>
<div id="header">
<h2>Оплата заказа</h2>
</div>
<div id="payment">
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="make_payment"/>
		<h3>Введите номер банковской карты:</h3>
		<input type="hidden" name="orderId" value="7"/>
		<input type="text" name="bankCardNum" value=""/>
		<h3>Введите дату окончания действия банковской карты:</h3>
		<input type="text" name="expiringDate" value=""/>
		<br>
		<br>
		<input type="submit" value="Оплатить"/>
	</form>
</div>
<div id="footer">Ваши платёжные данные надёжно защищены современной защитой SSL Security
<br>
Visa Mastercard Maestro AmericanExpress
<br>
Интернет-магазин E-SHOP-SFIA®
</div>
</body>
</html>