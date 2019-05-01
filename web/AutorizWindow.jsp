<%--
  Created by IntelliJ IDEA.
  User: Юля
  Date: 20.03.2019
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Lima, you should translate all text cause I'm lazy to switch keyboard ;D </h1>
<form action="/" method="post">
    <label for="login">Login<input type="text" id="login" name="login"></label>
    <label for="password">Password<input type="password" id="password" name="password"></label>
    <input type="submit" value="Autorisation">
</form>
<p>${requestScope.errorUserNotFound}</p>
<form action="/registration" method="get">
    <input type="submit" value="Registration">
</form>
</body>
</html>
