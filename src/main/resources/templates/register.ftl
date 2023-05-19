<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/register.css">
    </head>
<body>

<div class="shadow-lg p-3 mb-3 bg-body-tertiary rounded">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="btn btn-md btn-outline-dark" href="/">MyBANK</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" href="/">Головна</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Про нас</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container-fluid">
    <div class="row content-center">
        <div class="col-xl-4 col-lg-7 col-md-9 col-sm-11 center-items container my-2">
            <div class="shadow p-3 mb-4 bg-body-tertiary rounded">
                <div class="fw-bolder fs-1 center-title mb-3">Регістрація</div>
                <form action="/register" method="post" class="mx-4 mb-3 center-items text-center">
                    <div class="form-group mb-3">
                        <label for="username">Придумайте логін</label>
                        <input type="text" class="form-control" id="username" name="username" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="password">Придумайте пароль</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="firstName">Ваше ім'я</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="lastName">Ваше прізвище</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="fatherName">Ваше по батькові</label>
                        <input type="text" class="form-control" id="fatherName" name="fatherName" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="email">Ваша пошта</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="email@email"
                               required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="phone">Ваш номер телефону</label>
                        <input type="tel" class="form-control" id="phone" name="phone" placeholder="##########"
                               required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="age">Ваш вік</label>
                        <input type="number" class="form-control" id="age" name="age" placeholder="##" required>
                    </div>
                    <button type="submit" class="btn btn-outline-success">Зареєструватись</button>
                    <a type="button" class="btn btn-outline-secondary" href="/login">Увійти</a>
                </form>
            </div>
        </div>
    </div>
</div>


<script src="/static/scripts/boodstrap.js"></script>
</body>
</html>