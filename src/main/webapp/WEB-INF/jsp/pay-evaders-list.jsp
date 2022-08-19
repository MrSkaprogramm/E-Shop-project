<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Клиенты не оплатившие заказ</h2>
<c:forEach items="${paymentEvaders}" var="user">
<h3>${user.login}</h3>
<p>${user.fio}</p>
<h4>${user.status}</h4>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="add_to_blacklist"/>
		<input type="hidden" name="id" value="2"/>
		<input type="submit" value="Добавить в чёрный список"/>
	</form>
</c:forEach>
</body>
</html>