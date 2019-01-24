<%-- 
    Document   : showLogin
    Created on : Jan 16, 2019, 10:27:05 PM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Аутентификация</title>
    </head>
    <body>
        <h1>Войдите!</h1>
        <form action="login" methid="POST">
            Логин:<br>
            <input type="text" name="login">
            <br>
            Пароль:<br>
            <input type="password" name="password">
            <br>
            <input type="submit" value="Войти">
        </form>
    </body>
</html>
