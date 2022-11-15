<%--
  Created by IntelliJ IDEA.
  User: adobr
  Date: 31.10.2022
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="resources/css/styles.css?v126">
    <link rel="stylesheet" href="../resourse/styles/style.css">

</head>

<body>

<div class="flex">
    <div class="side"></div>
    <div class="header">
        <h1>Система управления студентами и их успеваемостью</h1>
    </div>
    <div class="side margin-top-auto">
        <div class="rigth-side"></div>
    </div>
</div>

<form method="post" action="/login">
    <div class="flex margin-left margin-top">
        <div class="nameText">
            <p>Логин:</p> <div class="inputText"><div>
            <input type="text" class="textInput" name="login">
        </div></div> <br>
            <p>Пароль:</p> <div class="inputText"><div>
            <input type="password" class="textInput" name="password">
        </div></div> <br>
            <p>Выберите пользователя:</p> <select class="margin-rigth" name="role">
            <c:forEach items="${allRoles}" var="r">
                <option value="${r.id}">${r.name}</option>
            </c:forEach>
        </select>
        </div>
        <div class="inputText">
            <div class="margin-bottom"></div>
            <input type="submit" class="button confirm" value="Войти">
        </div>
    </div>
</form>


<c:if test="${Error eq 1}">
    <div class="margin-left error">
        <p>Поля не должны быть пустыми!</p>
    </div>
</c:if>

<c:if test="${erro eq 1}">
    <div class="margin-left error">
        <p>Неверный логин или пароль или роль!</p>
    </div>
</c:if>

</body>

</html>