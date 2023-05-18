<#import "parts/templ.ftl" as p>
<@p.pages>
<link rel="stylesheet" href="/static/css/cards.css">

    <#if allCard?has_content>
        <div class="card-list">
            <#list allCard as card>
                <div class="card" onclick="flipCard(this)">
                    <div class="card-inner">
                        <div class="card-front">
                            <p class="card-number">${card.number}</p>
                            <p class="card-month-year">${card.month?string('00')}/${card.year?string('00')}</p>
                        </div>
                        <div class="card-back">
                            <p class="card-cvc">${card.cvc}</p>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </#if>
    <script src="/static/scripts/animFlip.js"></script>
</@p.pages>
