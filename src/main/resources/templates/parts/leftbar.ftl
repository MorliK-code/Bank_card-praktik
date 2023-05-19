<style>
    .offcanvas {
        position: fixed;
        top: 0;
        left: 0;
        height: 100vh;
        width: 250px;
        background-color: rgb(255, 255, 255);
        transform: translateX(-100%);
        transition: transform 0.3s ease-in-out;
        z-index: 9999;
        overflow-y: auto;
        padding-top: 60px;
        padding-right: 30px;
    }

    .offcanvas.open {
        transform: translateX(0);
    }

    .offcanvas-header {
        display: flex;
        padding: 20px;
        border-bottom: none;
        position: relative;
    }

    .offcanvas-title {
        position: absolute;
        top: -20px;
        left: 50%;
        transform: translateX(-50%);
        font-weight: bold;
        font-size: 2rem;
        margin-bottom: 0;
    }

    .offcanvas-header .btn-close {
        position: absolute;
        top: -20px;
        right: -15px;
        transform: translateY(-50%);
        font-size: 1.5rem;
    }

    .offcanvas-body {
        padding: 1rem;
    }

    .offcanvas-body ul.list-group .list-group-item button {
        /* Стили для кнопок внутри list-group */
        display: block;
        width: 100%;
        text-align: left;
        padding: 0.5rem 1rem;
        border: none;
        background-color: transparent;
        cursor: pointer;
    }

    .navbar-light {
        background-color: transparent !important;
    }
</style>

<script>
    function redirectTo(url) {
        window.location.href = url;
    }
</script>

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
                        <button type="button" onclick="redirectTo('/register')">Реестрування</button>
                    </li>
                    <li class="list-group-item">
                        <button type="button" onclick="redirectTo('/login')">Авторизація</button>
                    </li>
                    <li class="list-group-item">
                        <button type="button" onclick="redirectTo('/editcards')">Редагування карт</button>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
