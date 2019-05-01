<%--
  Created by IntelliJ IDEA.
  User: Юля
  Date: 01.05.2019
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>
            <h2>Информация о Вас</h2>
            ${requestScope.userData}
        </td>
        <td>
            <h2>Здесь вы можете изменить данные о себе</h2>
            <form action="/change" method="post">
                <p><label for="login">Login<input type="text" id="login" name="login"></label></p>
                <p><label for="password">Password<input type="password" id="password" name="password"></label></p>
                <p><label for="username">Userame<input type="text" id="username" name="username"></label></p>
                <p><label for="age">Age<input type="number" id="age" name="age"></label></p>
                <p><label for="email">Email<input type="email" id="email" name="email"></label></p>
                <p><label for="height">Height<input type="number" id="height" name="height"></label></p>
                <p><label for="weight">Weight<input type="number" id="weight" name="weight"></label></p>
                <p><input type="submit" value="Change"></p>
            </form>
            ${requestScope.erroCannotSaveChanges}
        </td>
    </tr>
</table>
</body>
</html>
