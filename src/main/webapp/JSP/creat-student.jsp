<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adobr
  Date: 06.10.2022
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Система_управления_студентами_и_их_успеваемостью</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="../resourse/styles/style.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>
</head>
<body>
<header>
    <div class="container">
        <h1>Система управления студентами и их успеваемостью</h1>
        <p>${login}</p>
        <p><c:choose>
            <c:when test="${role eq 1}">Администратор
            </c:when>
            <c:when test="${role eq 2}">Преподователь
            </c:when>
            <c:otherwise>студент
                </a></c:otherwise>
        </c:choose></p>
        <c:choose>
            <c:when test="${isLogin eq 1}"><a href="/logout">
                Logout
            </a></c:when>
            <c:otherwise><a href="/login">
                Loging
            </a></c:otherwise>
        </c:choose>
    </div>
</header>
<main>
    <section class="intro-section">
        <div class="row">
            <div class="col-sm-3">
                <a href="/">На главную</a>
                <a href="/students">Назад</a>
            </div>
            <div class="col-sm-9">
                <p>Для создания студента заполните все поля и нажмите кнопку "Создать".</p>
                <div class="blok1">
                    <form action="/creat-student" method="post">
                        Фамилия <input  type="text" placeholder="фамилия" name="surname"  value="${surname}"> <br>
                        Имя <input  type="text" placeholder="имя" name="name"value="${name}" > <br>
                        Группа <input  type="text" placeholder="группа" name="group" value="${group}" > <br>
                        Дата поступления <input type="text"  placeholder="дата поступления" name="date" id="datepicker" value="${date}" > <br>

                        <input  type="submit" value="создать" class="button">
                    </form>
                    <br>
                </div>
            </div>
        </div>
<%--        required--%>
    </section>
    <c:if test="${erro==1}"><h6>ПОЛЯ НЕ ДОЛЖНЫ БЫТЬ ПУСТЫМИ</h6></c:if>

</main>
<footer>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
