<#import "temp/templ.ftl" as p>
<@p.pages>

<h2>Category</h2>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>



<div class="row">
    <div class="col-4 col-4">гриша</div>
    <div class="col-4">миша</div>
    <div class="col-4">алег</div>
</div>

<div class="row row-cols-1 row-cols-md-3 g-4">
    <div class="col">
        <div class="card">
            <img src="img/fon.png" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Фон гриши</h5>
                <p class="card-text"> осторожно с желаниями</p>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card">
            <img src="img/fon.png" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Фон миши</h5>
                <p class="card-text">ты ыфваыфва</p>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card">
            <img src="img/fon.png" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Фон олега</h5>
                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card">
            <img src="img/fon.png" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">фон фени</h5>
                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
            </div>
        </div>
    </div>
</div>
</@p.pages>