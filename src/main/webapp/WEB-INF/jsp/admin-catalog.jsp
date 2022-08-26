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
   #catalog {
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
<div id="button">
Каталог
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="go_admin_profile"/>
		<input type="submit" value="Профиль"/>
	</form>
</div>
<c:forEach items="${catalog}" var="item">
<h3>${item.name}</h3>
<p>${item.itemInfo}</p>
<h4>${item.price}</h4>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="delete_item"/>
		<input type="hidden" name="itemId" value="${item.itemId}"/>
		<input type="submit" value="Удалить товар"/>
	</form>
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="go_change_items_details"/>
		<input type="hidden" name="itemId" value="${item.itemId}"/>
		<input type="submit" value="Изменить товар"/>
	</form>
</c:forEach>
</body>
</html>