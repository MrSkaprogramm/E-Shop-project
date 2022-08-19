<%@page import="by.epam.tr.bean.User"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Добрый день,</h2>
<%	User user;
user = (User)request.getAttribute("user");
out.print(user.getFio());
%>
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="goAddItem"/>
		<input type="submit" value="Добавить товар"/>
	</form>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="show_pay_evaders_list"/>
		<input type="submit" value="Показать список неплательщиков"/>
	</form>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="show_catalog"/>
		<input type="submit" value="Перейти к каталогу товаров"/>
	</form>
	<form action="/E-Shop-Sfia/controller" method="post">
		<input type="hidden" name="command" value="exit"/>
		<input type="submit" value="Выйти"/>
	</form>
</body>
</html>