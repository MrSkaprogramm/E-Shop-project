<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Изменить данные товара</h2>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="change_item_details"/>
		<input type="hidden" name="itemId" value="3"/>
		<h3>Введите информацию о товаре:</h3>
		<input type="text" name="itemInfo" value=""/>
		<h3>Введите стоимость товара:</h3>
		<input type="text" name="itemPrice" value=""/>
		<br>
		<br>
		<input type="submit" value="Изменить данные о товаре"/>
	</form>
</body>
</html>