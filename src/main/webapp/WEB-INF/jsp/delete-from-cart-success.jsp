<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Вы удалили товар из корзины</h2>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="show_cart"/>
		<input type="submit" value="Вернуться в корзину товаров"/>
	</form>
</body>
</html>