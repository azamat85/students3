<%--
  Created by IntelliJ IDEA.
  User: adobr
  Date: 31.10.2022
  Time: 13:01
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
    <a href="">
      Logout
    </a>
  </div>
</header>
<body>
<main>
  <section class="intro-section">
    <div class="row">
      <div class="col-sm-3">
        <a href="/">На главную</a>
        <a href="">Назад</a>
      </div>
      <div class="col-sm-9">
        <p class="text1">Для создания семестра заполните следующие данные и нажмите кнопку "Создать".</p> <br>
        <form action="/creat-student" method="post">
          Длительность (в неделях)<input  type="text" placeholder="" name="surname" required> <br>
          <div class="text4">Дисциплины в семестре  </div>
          <div class="y">
            <form action="select1.php" method="post">
              <p><select size="7" multiple name="hero[]">
                <c:forEach items="${disciplins}" var="all">


<%--                  <input name="idStudent" type="checkbox" class="checkbox" value="${all.id}">--%>
                  <option value="Чебурашка">
                      ${all.name}</option>
                </c:forEach>

              </select></p>
              <p><input type="submit" value="Отправить"></p>
            </form>


          </div>
          <br>

          <input  type="submit"value="создать" class="button" id="butt1">
        </form>



      </div>
    </div>
  </section>
</main>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
