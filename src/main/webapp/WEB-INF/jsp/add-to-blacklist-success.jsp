<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   #footer {
    position: fixed;
    left: 0; bottom: 0;
    padding: 10px;
    background: #0000FF;
    color: #FFFFFF;
    width: 100%;
   }
   #success {
    position: static;
    left: 0; bottom: 0;
    padding: 10px;
    background: #FFFFFF;
    color: #191970;
    width: 100%;
   }
   #header {
    position: static;
    left: 0; bottom: 0;
    padding: 10px;
    background: #0000cd;
    color: #FFFFFF;
    width: 100%;
   }
  </style>
</head>
<body>
<div id="header">
Клиенты не оплатившие заказ
</div>
<div id="success">
<h2>Вы добавили клиента в чёрный список</h2>
	<form action="/E-Shop-Sfia/controller" method="get">
		<input type="hidden" name="command" value="go_admin_profile"/>
		<input type="submit" value="Перейти в меню администратора"/>
	</form>
</div>
<div id="footer">Интернет-магазин E-SHOP-SFIA®</div>
</body>
</html>