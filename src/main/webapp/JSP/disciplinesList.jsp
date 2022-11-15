
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
    <script src="../resourse/js/functions.js"></script>

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
                <p>Список дисциплин:</p>
                <div class="row" id="tabl2">
                    <div class="col-sm-5">

                        <table>
                            <tr>
                                <th class="z122"></th>
                                <th>Наименование дисциплины</th>

                            </tr>

                            <c:forEach items="${disciplins}" var="dis">
                                <tr>
                                    <td class="z123"><input name="idDisciplin" type="checkbox" class="checkbox" value="${dis.id}"></td>
                                    <td>${dis.name}</td>

                                </tr>
                            </c:forEach>
                            <tr>
<%--                                <td class="z123"><input type="checkbox" class="checkbox" ></td>--%>
<%--                                <td>Информатика</td>--%>

<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="z123"><input type="checkbox" class="checkbox" ></td>--%>
<%--                                <td>Системный Анализ</td>--%>

<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="z123"><input type="checkbox" class="checkbox" ></td>--%>
<%--                                <td>Управление Проектами</td>--%>

<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="z123"><input type="checkbox" class="checkbox" ></td>--%>
<%--                                <td>Основы Дискретной Математики</td>--%>

<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="z123"><input type="checkbox" class="checkbox" ></td>--%>
<%--                                <td>История</td>--%>

<%--                            </tr>--%>
                        </table>

                    </div>
                    <div class="col-sm-7">
                        <div class="blok7">
                            <form action="/creat-disciplines" target="_blank">
                                <button class="button5">Создать дисциплину...</button>
                            </form>
                            <input class="button6"  type="submit" onclick="modificationDisciplines()" value="Модифицировать выбранную дисциплину" >

                            <br>
                            <input class="button7"  type="submit" onclick="deleteDisciplines()" value="Удалить выбранную дисциплину" >

                        </div>

                    </div>

                </div>

            </div>
        </div>
    </section>
</main>

<form id="deleteDisciplinForm" action="/delete-disciplin" method="post">
    <input type="hidden" id="deleteDisciplinHidden" name="deleteDisciplinHidden">
</form>
<form id="modificationDisciplinForm" action="/disciplinModificationController" method="get">
    <input type="hidden" id="modificationDisciplinHidden" name="modificationDisciplinHidden">
</form>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
