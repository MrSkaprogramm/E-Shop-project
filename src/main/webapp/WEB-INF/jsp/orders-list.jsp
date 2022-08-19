<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Заказы</h2>
<c:forEach items="${orders}" var="order">
<h3>${order.orderStatus}</h3>
<p>${order.payment.paymentSum}</p>
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="goPay"/>
		<input type="submit" value="Оплатить заказ"/>
	</form>
</c:forEach>
</body>
</html>