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
    <link rel="stylesheet" href="../resourse/styles/style1.css">
    <script src="../resourse/js/functions.js"></script>
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
            <div class="col-sm-2">
                <a href="/">На главную</a>
                <a href="/">Назад</a>
            </div>
            <div class="col-sm-10">
                <div class="button1">
                    <input class="button11" type="submit" onclick="progresStudents()" value="Посмотреть успеваемость выбранных студентов">
                    <c:choose>
                        <c:when test="${role eq 1}">
                            <form action="/creat-student" target="_blank">
                                <button class="button12">Cоздать студента...</button>
                            </form>
                            <br>
                            <input class="button13"  type="submit" onclick="deleteStudents()" value="Удалить выбранного студента" >
                            <input class="button14"  type="submit" onclick="modificationStudents()" value="Модифицировать выбранног студента..." >
                        </a></c:when>
                    </c:choose>
<%--                    <form action="/creat-student" target="_blank">--%>
<%--                        <button class="button12">Cоздать студента...</button>--%>
<%--                    </form>--%>
<%--                    <br>--%>
<%--                    <input class="button13"  type="submit" onclick="deleteStudents()" value="Удалить выбранного студента" >--%>
<%--                    <input class="button14"  type="submit" onclick="modificationStudents()" value="Модифицировать выбранног студента..." >--%>
                </div>
                <h2>Cписок студентов</h2>
                <table>
                    <tr>
                        <th class="th1"> </th>
                        <th class="th2">Фамилия</th>
                        <th class="th3">Имя</th>
                        <th class="th4">Группа</th>
                        <th class="th5">Дата поступления</th>
                    </tr>
                    <c:forEach items="${students}" var="st">
                        <tr>
                            <td class="th1"> <input name="idStudent" type="checkbox" class="checkbox" value="${st.id}"></td>
                            <td class="th2">${st.surname}</td>
                            <td class="th3">${st.name}</td>
                            <td class="th4">${st.group}</td>
                            <td class="th5"><fmt:formatDate value="${st.date}" pattern="MM/dd/yyyy"></fmt:formatDate> </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </section>
</main>
<footer>
</footer>
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script> -->
</body>
<form id="deleteStudentForm" action="/delete-student" method="post">
    <input type="hidden" id="deleteStudentHidden" name="deleteStudentHidden">
</form>
<form id="modificationStudentsForm" action="/modificationStudent" method="get">
    <input type="hidden" id="modificationStudentsHidden" name="modificationStudentsHidden">
</form>
<form id="studentProgressForm" action="/studentProgress" method="get">
    <input type="hidden" id="studentProgressHidden" name="studentProgressHidden">
</form>
<form id="progressStudentForm" action="/student-progress" method="get">
    <input type="hidden" id="progressStudentHidden" name="progressStudentHidden">
</form>
</html>
