<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Каталог</h2>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="show_cart"/>
		<input type="submit" value="Просмотреть корзину"/>
	</form>
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="goClientPage"/>
		<input type="submit" value="Профиль пользователя"/>
	</form>
<c:forEach items="${catalog}" var="item">
<h3>${item.name}</h3>
<p>${item.itemInfo}</p>
<h4>${item.price}</h4>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="add_to_cart"/>
		<input type="hidden" name="itemId" value="2"/>
		<input type="hidden" name="itemName" value="House"/>
		<input type="hidden" name="itemInfo" value="Good house"/>
		<input type="hidden" name="itemPrice" value="1000000"/>
		<input type="submit" value="Добавить в корзину"/>
	</form>
</c:forEach>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="add_to_cart"/>
		<input type="hidden" name="itemId" value="3"/>
		<input type="hidden" name="itemName" value="Airplane"/>
		<input type="hidden" name="itemInfo" value="Good airplane"/>
		<input type="hidden" name="itemPrice" value="100000"/>
		<input type="submit" value="Добавить в корзину"/>
	</form>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="add_to_cart"/>
		<input type="hidden" name="itemId" value="4"/>
		<input type="hidden" name="itemName" value="Car"/>
		<input type="hidden" name="itemInfo" value="Good car"/>
		<input type="hidden" name="itemPrice" value="10000"/>
		<input type="submit" value="Добавить в корзину"/>
	</form>
</body>
</html>