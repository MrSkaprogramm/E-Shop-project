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
   #add-item {
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
<h2>Новый товар</h2>
</div>
<div id="add-item">
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="add_item"/>
		<h3>Введите название:</h3>
		<input type="text" name="itemName" value=""/>
		<h3>Введите информацию о товаре:</h3>
		<input type="text" name="itemInfo" value=""/>
		<h3>Введите стоимость товара:</h3>
		<input type="text" name="itemPrice" value=""/>
		<br>
		<br>
		<input type="submit" value="Добавить товар"/>
	</form>
</div>
<div id="footer">Интернет-магазин E-SHOP-SFIA®</div>
</body>
</html>