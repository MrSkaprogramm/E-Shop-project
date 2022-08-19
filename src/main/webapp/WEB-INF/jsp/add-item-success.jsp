<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Вы успешно добавили товар</h2>
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="goAdminPage"/>
		<input type="submit" value="Перейти в меню администратора"/>
	</form>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="show_catalog"/>
		<input type="submit" value="Перейти к каталогу товаров"/>
	</form>
</body>
</html>