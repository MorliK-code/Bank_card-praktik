<#import "parts/templ.ftl" as p>
<@p.pages>
    <link rel="stylesheet" href="/static/css/work.css">
    <div class="fw-bolder fs-1">Ваші карти</div>
    <#if allCard?has_content>
        <div class="card-list">
            <#list allCard as card>
                <div class="card ${card.block?string('blocked', '')}" onclick="flipCard(this)">
                    <div class="card-inner">
                        <div class="card-front">
                            <p class="card-number">${card.number}</p>
                            <p class="card-month-year">${card.month?string('00')}/${card.year?string('00')}</p>
                            <#if !card.block>
                                <p class="card-balance">${card.account.balance?string('00')}</p>
                            </#if>
                            <#if card.block>
                                <button type="button" class="btn btn-outline-danger btn-blocked disabled">Blocked</button>
                            </#if>
                        </div>
                        <div class="card-back">
                            <p class="card-cvc">${card.cvc}</p>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </#if>
    <script src="/static/scripts/animFlip.js"/>
</@p.pages>
