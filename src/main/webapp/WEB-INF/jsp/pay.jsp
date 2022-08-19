<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Оплата заказа</h2>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="make_payment"/>
		<h3>Введите номер банковской карты:</h3>
		<input type="hidden" name="orderId" value="7"/>
		<input type="text" name="bankCardNum" value=""/>
		<h3>Введите дату окончания действия банковской карты:</h3>
		<input type="text" name="expiringDate" value=""/>
		<br>
		<br>
		<input type="submit" value="Оплатить"/>
	</form>
</body>
</html>