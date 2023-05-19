<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <style>
        .center-items {
            align-items: center;
            text-align: center;
        }

        .center-title {
            text-align: center;
        }

        .content-center {
            display: flex;
            align-content: center;
            justify-content: center;
        }
    </style>
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
                        <a class="nav-link" href="/info">Про нас</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>

<div class="container-fluid">
    <div class="row content-center">
        <div class="col-xl-4 col-lg-6 col-sm-10 center-items container my-5">
            <div class="shadow p-3 mb-5 bg-body-tertiary rounded">
                <div class="fw-bolder fs-1 center-title">Авторизація</div>
                <form action="/login" method="post" class="mx-5 mb-3 center-items">
                    <div class="mb-4">
                        <span>Логін</span>
                        <input type="text" class="form-control" id="username" name="username"
                               placeholder="Свій логін">
                    </div>
                    <div class="mb-4">
                        <span>Пароль</span>
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="Пароль">
                    </div>
                    <button type="submit" class="btn btn-outline-secondary">Підтвердити</button>
                    <a class="btn btn-outline-primary" role="button" href="/register">Реєстрація</a>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="/static/scripts/boodstrap.js"></script>
</body>
</html>
