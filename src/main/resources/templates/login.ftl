<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
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


<div class="row d-flex align-items-center justify-content-center">
    <div class="col-4" style="align-items: center">
        <div class="shadow p-3 mb-5 bg-body-tertiary rounded">
            <div class="fw-bolder fs-1 " style="text-align: center">Авторизація</div>
            <form action="/login" method="post">
                <div class="col-9 mb-3 center-input">
                    <label for="username" class="form-label">Логін</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Свій логін">
                </div>
                <div class="col-9 mb-3 center-input">
                    <label for="password" class="form-label">Пароль</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Пароль">
                </div>
                <button type="submit" class="btn btn-outline-secondary">Підтвердити</button>
                <a class="btn btn-outline-primary" role="button" href="/register">Реєстрація</a>
            </form>
        </div>
    </div>
</div>


</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
        integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
        integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
        crossorigin="anonymous"></script>
</body>
</html>