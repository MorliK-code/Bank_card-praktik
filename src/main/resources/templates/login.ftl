<#import "parts/templ.ftl" as p>
<@p.pages>
    
    <link rel="stylesheet" href="css/my.css">

    <div class="header">
    <div class="fw-bolder fs-1">Авторизація</div>

    <form action="@{/login}" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">Логін</label>
            <input type="text" class="form-control" id="username" aria-describedby="loginHelp">
            <div id="loginHelp" class="form-text">Тут ви повинні ввести свій логін</div>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Пароль</label>
            <input type="password" class="form-control" id="password" aria-describedby="passwordHelp">
            <div id="passwordHelp" class="form-text">Тут ви повинні ввести свій пароль</div>
        </div>
        <button type="button" class="btn btn-outline-secondary">Підтвердити</button>
    </form>

    </div>
    </form>
    <a href="/register">Регістрація</a>
    <a href="/">Головна</a>
    <a href="/work">Робоча частина</a>





    </div>
</@p.pages>