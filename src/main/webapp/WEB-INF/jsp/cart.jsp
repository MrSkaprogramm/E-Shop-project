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
   #button {
    position: static; /* Фиксированное положение */
    left: 0; bottom: 0; /* Левый нижний угол */
    padding: 10px; /* Поля вокруг текста */
    background: #0000FF; /* Цвет фона */
    color: #FFFFFF; /* Цвет текста */
    width: 100%; /* Ширина слоя */
   }
   #cart {
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
<div id="header">Корзина</div>
<div id="button">
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="make_order"/>
		<input type="submit" value="Оформить заказ"/>
	</form>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="show_catalog"/>
		<input type="submit" value="Перейти к каталогу товаров"/>
	</form>
</div>
<div id="cart">
<c:forEach items="${cart}" var="item">
<h3>${item.name}</h3>
<h4>Описание: ${item.itemInfo}</h4>
<h4>Цена: ${item.price}</h4>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="delete_from_cart"/>
		<input type="hidden" name="itemId" value="${item.itemId}"/>
		<input type="submit" value="Удалить из корзины"/>
	</form>
</c:forEach>
</div>
<div id="footer">Интернет-магазин E-SHOP-SFIA®</div>
</body>
</html>