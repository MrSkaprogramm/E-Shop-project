<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Корзина</h2>
<c:forEach items="${cart}" var="item">
<h3>${item.name}</h3>
<p>${item.itemInfo}</p>
<h4>${item.price}</h4>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="delete_from_cart"/>
		<input type="hidden" name="itemId" value="2"/>
		<input type="submit" value="Удалить из корзины"/>
	</form>
</c:forEach>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="make_order"/>
		<input type="submit" value="Оформить заказ"/>
	</form>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="show_catalog"/>
		<input type="submit" value="Перейти к каталогу товаров"/>
	</form>
</body>
</html>