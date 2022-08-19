<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Каталог</h2>
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="goAdminPage"/>
		<input type="submit" value="Профиль администратора"/>
	</form>
<c:forEach items="${catalog}" var="item">
<h3>${item.name}</h3>
<p>${item.itemInfo}</p>
<h4>${item.price}</h4>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="delete_item"/>
		<input type="hidden" name="itemId" value="5"/>
		<input type="submit" value="Удалить товар"/>
	</form>
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="goChangeItemsDetails"/>
		<input type="submit" value="Изменить товар"/>
	</form>
</c:forEach>
</body>
</html>