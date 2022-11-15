<%--
  Created by IntelliJ IDEA.
  User: adobr
  Date: 27.10.2022
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <p>Отображена успеваемость для следующего студента:</p>
                <table>
                    <tr>
                        <th>Фамилия</th>
                        <th>Имя</th>
                        <th>Группа</th>
                        <th>Дата поступления</th>
                    </tr>

                        <tr>

                            <td class="th2">${student.surname}</td>
                            <td class="th3">${student.name}</td>
                            <td class="th4">${student.group}</td>
                            <td class="th5"><fmt:formatDate value="${student.date}" pattern="MM/dd/yyyy"></fmt:formatDate> </td>
                        </tr>

                </table>
                <div class="row" id="tabl2">
                    <div class="col-sm-5">

                        <table>
                            <tr>
                                <th>Дисциплина</th>
                                <th>Оценка</th>

                            </tr>
                            <c:forEach items="${allDisciplinsMark}" var="dm">
                                <tr>

                                    <td class="th2">${dm.disciplineName}</td>
                                    <td class="th3">${dm.markName}</td>

                                </tr>
                            </c:forEach>
                        </table>

                    </div>
                    <div class="col-sm-7">
                        <form method="get">
                        <p class="text1">Выбрать семестр</p>
                            <input type="hidden" name="progressStudentHidden" value="${student.id}">
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

                            </div>
                        </section>
                        <input class="button"  type="submit"  value="Выбрать" >
<%--                            onclick="progresCheckStudents()"--%>
                        </form>
                        <p class="text2">Средняя оценка за семестр: <f:formatNumber type = "number"
                                                                                      maxIntegerDigits = "3" value = "${aMark}" /> балла</p>
                    </div>

                </div>

            </div>
        </div>
    </section>
</main>
<footer>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
<form id="progresCheckStudentsForm" action="/student-progress" method="get">
    <input type="hidden" id="progresCheckStudentsHidden" name="idSelectedTerm">
</form>
</html>
