<%--
  Created by IntelliJ IDEA.
  User: adobr
  Date: 31.10.2022
  Time: 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

</head>
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
<body>
<main>
    <section class="intro-section">
        <div class="row">
            <div class="col-sm-3">
                <a href="/">На главную</a>
                <a href="/">Назад</a>
            </div>
            <div class="col-sm-9">
                <form method="get">
                <p class="text1">Выбрать семестр</p>
                <section class="container1">

                    <div class="dropdown">
                        <select name="idSelectedTerm">
                            <c:forEach items="${allTerms}" var="t">
                                <option value="${t.id}"
                                        <c:if test="${t eq firstTerm}">
                                            selected
                                        </c:if>
                                >${t.name}</option>
                            </c:forEach>
                        </select>
<%--                        <select name="one" class="dropdown-select">--%>
<%--                            <option value="">Выбери семестр</option>--%>
<%--                            <option value="1"><a href="">Семестр 1</a></option>--%>
<%--                            <option value="1"><a href="">Семестр 2</a></option>--%>
<%--                            <option value="1"><a href="">Семестр 3</a></option>--%>
<%--                        </select>--%>
                    </div>
                </section>
                <input  type="submit"value="Выбрать" class="button">
                <input  type="submit"value="Удалить текущий семестр" class="button">
                </form>
                <p class="text2" >Длительность семестра:  24 недели</p>
                <p>Список дисциплин семестра</p>
                <div class="row" id="tabl2">
                    <div class="col-sm-5">

                        <table>
                            <tr>

                                <th class="tabl1">Наименование дисциплины</th>

                            </tr>
                            <c:forEach items="${allDisciplinsTerm}" var="d">
                                <tr>

                                    <td class="th2">${d.disciplineName}</td>

                                </tr>
                            </c:forEach>
                        </table>

                    </div>
                    <div class="col-sm-7">
                        <div class="blok7">
                            <form action="/creat-term" target="_blank">
                                <button class="button5">Создать семестр...</button>
                            </form>
                            <form action="student_Creating.html" target="_blank">
                                <button class="button6">Модифицировать текущий семестр</button>
                            </form><br>
<%--                            <form action="/termList" target="_blank">--%>
<%--                                <button class="button7">Удалить текущий семестр</button>--%>
<%--                            </form>--%>
                        </div>

                    </div>

                </div>

            </div>
        </div>
    </section>
</main>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
<form id="progresCheckStudentsForm" action="/termList" method="get">
    <input type="hidden" id="progresCheckStudentsHidden" name="idSelectedTerm">
</form>
<form id="deleteCheckTermForm" action="/delete-term" method="get">
    <input type="hidden" id="deleteCheckTermHidden" name="idSelectedTerm">
</form>
</html>
