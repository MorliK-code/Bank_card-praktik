<#import "../templ/templ.ftl" as p>
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



<div class="row row-cols-2 row-cols-md-4 g-4">

    <#if allCard??>
    <#list allCard as card>
    <div class="col">
        <div class="card">
            <a href="/card/${card.id}">
            <img src="/static/images/cards/fons.png" class="card-img-top" alt="${card.id}">
            </a>
            <div class="card-body">
                <h5 class="card-title">${card.number}</h5>
                <p class="card-text"> ${card.month}/${card.year}<br>${card.cvv}</p>
            </div>
        </div>
    </div>
    </#list>
    </#if>


</div>
</@p.pages>