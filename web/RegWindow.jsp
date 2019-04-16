<%--
  Created by IntelliJ IDEA.
  User: Юля
  Date: 20.03.2019
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h1>Lima, you should translate all text cause I'm lazy to switch keyboard ;D </h1>
    <form action="/registration" method="post">
        <label for="login">Login<input type="text" id="login" name="login"></label>
        <label for="password">Password<input type="password" id="password" name="password"></label>
        <label for="username">Userame<input type="text" id="username" name="username"></label>
        <label for="age">Age<input type="number" id="age" name="age"></label>
        <label for="email">Email<input type="email" id="email" name="email"></label>
        <label for="height">Heigh<input type="number" id="height" name="height"></label>
        <label for="weight">Weight<input type="number" id="weight" name="weight"></label>
        <input type="submit" value="Registration">
    </form>
    <h2>${requestScope.usernameAlreadyExists}</h2>
</body>
</html>
