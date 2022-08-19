<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Новый товар</h2>
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
</body>
</html>