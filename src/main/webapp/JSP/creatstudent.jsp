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
                <p>Для создания студента заполните все поля и нажмите кнопку "Создать".</p>
                <div class="blok1">
                    Фамилия <input  type="text" placeholder="фамилия" name="email" required> <br>
                    Имя <input  type="text" placeholder="имя" name="email" required> <br>
                    Группа <input  type="text" placeholder="группа" name="email" required> <br>
                    Дата поступления <input  type="text" placeholder="дата поступления" name="email" required> <br>
                </div>
                <button>Cоздать</button>
            </div>
        </div>
    </section>
</main>
<footer>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
