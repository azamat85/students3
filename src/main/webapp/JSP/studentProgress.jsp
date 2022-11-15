<%--
  Created by IntelliJ IDEA.
  User: adobr
  Date: 23.10.2022
  Time: 16:43
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
    <script src="../resourse/js/functions.js"></script>
</head>
<body>
<header>
    <div class="container">
        <h1>Система управления студентами и их успеваемостью</h1>
        <a href="">
            Logout
        </a>
    </div>
</header>
<main>
    <section class="intro-section">
        <div class="row">
            <div class="col-sm-3">
                <a href="/">На главную</a>
                <a href="">Назад</a>
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

                    <c:forEach items="${students}" var="st1">
                        <tr>
                            <td> <input name="idStudent" type="checkbox" class="checkbox" value="${st1.id}"></td>
                            <td>${st1.surname}</td>
                            <td>${st1.name}</td>
                            <td><fmt:formatDate value="${st.date}" pattern="MM/dd/yyyy"></fmt:formatDate> </td>
                        </tr>
                    </c:forEach>

                </table>
                <div class="row" id="tabl2">
                    <div class="col-sm-5">

                        <table>
                            <tr>
                                <th>Дисциплина</th>
                                <th>Оценка</th>

                            </tr>
                            <tr>
                                <td>Информатика</td>
                                <td>5</td>

                            </tr>
                            <tr>
                                <td>Системный Анализ</td>
                                <td>4</td>

                            </tr>
                            <tr>
                                <td>Управление Проектами</td>
                                <td>5</td>

                            </tr>
                            <tr>
                                <td>Основы Дискретной Математики</td>
                                <td>5</td>

                            </tr>
                            <tr>
                                <td>История</td>
                                <td>5</td>

                            </tr>
                        </table>

                    </div>
                    <div class="col-sm-7">
                        <p class="text1">Выбрать семестр</p>
                        <section class="container1">

                            <div class="dropdown">
                                <select name="one" class="dropdown-select">
                                    <option value="">Выбери семестр</option>
                                    <option value="1"><a href="">Семестр 1</a></option>
                                    <option value="1"><a href="">Семестр 2</a></option>
                                    <option value="1"><a href="">Семестр 3</a></option>
                                </select>
                            </div>
                        </section>
                        <input  type="submit"value="Выбрать" class="button">
                        <p class="text2">Средняя оценка за семестр: 4.8 балла</p>
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
</html>
