<link rel="stylesheet" href="/static/css/leftbar.css">
<nav class="navbar navbar-light bg-light">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#navbarMenu"
                aria-controls="navbarMenu" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="offcanvas offcanvas-start" tabindex="-1" id="navbarMenu" aria-labelledby="navbarMenuLabel">
            <div class="offcanvas-header">
                <div class="d-flex justify-content-center">
                    <button class="btn btn-outline-dark btn-lg offcanvas-title">MyBANK</button>
                </div>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <ul class="list-group mt-5">
                    <li class="list-group-item">
                        <button type="button" onclick="redirectTo('/')">Головна</button>
                    </li>
                    <li class="list-group-item">
                        <button type="button" onclick="redirectTo('/work')">Робоча частина</button>
                    </li>
                    <li class="list-group-item">
                        <button type="button" onclick="redirectTo('/editcards')">Редагування карт</button>
                    </li>
                    <li class="list-group-item">
                        <button type="button" onclick="redirectTo('/login')">Авторизація</button>
                    </li>
                    <li class="list-group-item">
                        <button type="button" onclick="redirectTo('/register')">Реестрування</button>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<script src="/static/scripts/leftbar.js"></script>
