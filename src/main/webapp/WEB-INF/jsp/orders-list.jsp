<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   #footer {
    position: static; /* Фиксированное положение */
    left: 0; bottom: 0; /* Левый нижний угол */
    padding: 10px; /* Поля вокруг текста */
    background: #0000FF; /* Цвет фона */
    color: #FFFFFF; /* Цвет текста */
    width: 100%; /* Ширина слоя */
   }
   #button {
    position: static; /* Фиксированное положение */
    left: 0; bottom: 0; /* Левый нижний угол */
    padding: 10px; /* Поля вокруг текста */
    background: #0000FF; /* Цвет фона */
    color: #FFFFFF; /* Цвет текста */
    width: 100%; /* Ширина слоя */
   }
   #orders {
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
Заказы
</div>
<div id="button">
<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="go_client_profile"/>
		<input type="submit" value="Профиль"/>
</form>
</div>
<c:forEach items="${orders}" var="order">
<h3>Статус заказа (false - не оплачен, true - оплачен): ${order.orderStatus}</h3>
<p>Сумма заказа: ${order.payment.paymentSum}</p>
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="go_pay"/>
		<input type="submit" value="Оплатить заказ"/>
	</form>
</c:forEach>
<div id="footer">Интернет-магазин E-SHOP-SFIA®</div>
</body>
</html>