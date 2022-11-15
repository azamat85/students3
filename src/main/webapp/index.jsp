<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Система_управления_студентами_и_их_успеваемостью</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="../resourse/styles/style.css">
</head>
<body>
<header>
    <div class="container">
        <h1>Система управления студентами и их успеваемостью</h1>
        <c:choose>
            <c:when test="${isLogin eq 1}"><a href="/logout">
                Logout
            </a></c:when>
            <c:otherwise><a href="/login">
                Loging
            </a></c:otherwise>
        </c:choose>
<%--        <a href="/logout">--%>
<%--            Logout--%>
<%--        </a>--%>
<%--        <a href="/login">--%>
<%--            Loging--%>
<%--        </a>--%>
    </div>
</header>
<main>
    <section class="intro-section a">
        <div class="row">
            <div class="col-sm-4">
                <a href="/students">Студенты</a>
            </div>
            <div class="col-sm-4">
                <a href="/disciplins">Дисциплины</a>
            </div>
            <div class="col-sm-4">
                <a href="/termList">Семестры</a>
            </div>
        </div>
    </section>
</main>
<footer>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>