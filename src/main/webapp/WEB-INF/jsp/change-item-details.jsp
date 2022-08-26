<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
   #change-details {
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
<h2>Изменить данные товара</h2>
</div>
<div id="change-details">
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="change_item_details"/>
		<input type="hidden" name="itemId" value="${itemId}"/>
		<h3>Введите информацию о товаре:</h3>
		<input type="text" name="itemInfo" value=""/>
		<h3>Введите стоимость товара:</h3>
		<input type="text" name="itemPrice" value=""/>
		<br>
		<br>
		<input type="submit" value="Изменить данные о товаре"/>
	</form>
</div>
<div id="footer">Интернет-магазин E-SHOP-SFIA®</div>	
</body>
</html>