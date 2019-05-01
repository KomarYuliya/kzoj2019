<%--
  Created by IntelliJ IDEA.
  User: Юля
  Date: 21.03.2019
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome, ${requestScope.userName}!</h1>
<nav class="four">
    <ul>
        <li><a href="#"><i class="fa fa-home fa-fw"></i>Главная</a></li>
        <li><a href="#">Дневник</a></li>
        <li><a href="#">Статистика</a></li>
        <li><a href="/change">Личный кабинет</a></li>
        <li><a href="#">Фичи разные</a></li>
        <li><a href="/">Выйти</a></li>
    </ul>
</nav>
</body>
</html>
