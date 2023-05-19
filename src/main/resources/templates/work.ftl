<#import "parts/templ.ftl" as p>
<@p.pages>
<link rel="stylesheet" href="/static/css/work.css">
<div class="container-fluid">
    <div class="shadow bg-body-tertiary rounded">
        <div class="fw-bolder fs-1 title-text">Ваші карти</div>
        <#if allCard?has_content>
            <div class="card-list">
                <#list allCard as card>
                    <div class="card ${card.block?string('blocked', '')}" onclick="flipCard(this)">
                        <div class="card-inner">
                            <div class="card-front">
                                <p class="card-number">${card.number}</p>
                                <p class="card-month-year">${card.month?string('00')}/${card.year?string('00')}</p>
                                <#if !card.block>
                                    <p class="card-balance">${card.account.balance?string('00')} ₴</p>
                                </#if>
                                <#if card.block>
                                    <button type="button" class="btn btn-outline-danger btn-blocked disabled">
                                        Blocked
                                    </button>
                                </#if>
                            </div>
                            <div class="card-back">
                                <p class="card-cvc">${card.cvc}</p>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        <#else>
            <div class="card" onclick="flipCard(this)">
                <div class="card-inner">
                    <div class="card-front">
                        <p class="card-number">XXXX XXXX XXXX XXXX</p>
                        <p class="card-month-year">XX/XX</p>
                        <p class="card-balance">00 ₴</p>
                    </div>
                    <div class="card-back">
                        <p class="card-cvc">XXX</p>
                    </div>
                </div>
            </div>
        </#if>


        <div class="container-fluid">
            <div class="shadow bg-body-tertiary rounded">
                <div class="row content-center">
                    <div class="col-xl-5 col-lg-8 col-sm-10 center-items">
                        <div class="fw-bolder fs-1 title-text">Зробити переказ</div>
                        <form action="payments" method="post" class="mx-auto center-items">
                            <div class="mb-2">
                                <label for="senderNumber" class="form-label">Номер карти відправника</label>
                                <input type="text" class="form-control" id="senderNumber" name="senderNumber"

                                       placeholder="Приклад: 0000 0000 0000 0000" required maxlength="19">
                            </div>
                            <div class="mb-2">
                                <label for="recipientNumber" class="form-label">Номер карти отримувача</label>
                                <input type="text" class="form-control" id="recipientNumber" name="recipientNumber"

                                       placeholder="Приклад: 0000 0000 0000 0000" required maxlength="19">
                            </div>
                            <div class="mb-3">
                                <label for="amount" class="form-label">Сума переказу</label>
                                <input type="number" class="form-control" id="amount" name="amount" placeholder="Сума"
                                       required min="0" step="0.01">
                            </div>
                            <button type="submit" class="btn btn-outline-success mb-4">Зробити переказ</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="/static/scripts/animFlip.js"></script>
        <script src="/static/scripts/work.js"></script>
</@p.pages>
