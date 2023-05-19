<#import "parts/templ.ftl" as p>
<@p.pages>
    <link rel="stylesheet" href="/static/css/editcards.css">
    <div class="row content-center">
        <div class="col-xl-5 col-lg-8 col-sm-10 center-items">
            <div class="shadow bg-body-tertiary rounded">
                <div class="fw-bolder fs-1 center-title">Додати карту</div>
                <form action="addCards" method="post" class="mx-auto center-items">
                    <div class="mb-2">
                        <label for="numbers" class="form-label">16-ти значний номер карти</label>
                        <input type="text" class="form-control" id="numbers" name="number"
                               pattern="\d{4} \d{4} \d{4} \d{4}"
                               placeholder="Приклад: 0000 0000 0000 0000" required maxlength="19">
                    </div>
                    <div class="mb-2">
                        <label for="cvc" class="form-label">CVC карти</label>
                        <input type="text" class="form-control" id="cvc" name="cvc"
                               placeholder="Приклад: 000" required maxlength="3">
                    </div>
                    <div class="form-group mb-3">
                        <label for="expiry">Термін дії</label>
                        <div class="input-group">
                            <input type="number" class="form-control" id="month" name="month" placeholder="Місяць"
                                   required min="1" max="12" maxlength="2" title="Введіть число від 1 до 12">
                            <div class="input-group-text">/</div>
                            <input type="text" class="form-control" id="year" name="year"
                                   placeholder="Рік (останні 2 цифри)" required maxlength="2"
                                   title="Введіть число від 0 до 99">
                        </div>

                    </div>
                    <button type="submit" class="btn btn-outline-success">Додати карту</button>
                </form>
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <table class="table">
            <thead>
            <tr>
                <th>Номер карти</th>
                <th>CVC</th>
                <th>Термін дії</th>
                <th>Баланс</th>
                <th>Стан карти</th>
                <th>Редагування стану карти</th>
                <th>Видалення карти</th>
            </tr>
            </thead>
            <tbody>
            <#if allCard?has_content>
                <#list allCard as card>
                    <tr>
                        <td>${card.number}</td>
                        <td>${card.cvc}</td>
                        <td>${card.month?string('00')}/${card.year?string('00')}</td>
                        <td>
                            <div class="content-center">
                                <form class="col-8 center-items" id="balanceForm-${card.id}" action="updateBalance" method="post">
                                    <div class="input-group mb-3">
                                        <input type="hidden" name="cardId" value="${card.id}">
                                        <span class="input-group-text" id="balance">${card.account.balance?string('00.00')}</span>
                                        <input type="number" class="form-control" name="newBalance" aria-describedby="balance" step="0.01">
                                        <button type="submit" class="btn btn-outline-primary">Оновити</button>
                                    </div>
                                </form>
                            </div>
                        </td>
                        <td><#if card.block>Заблокована<#else>Активна</#if></td>
                        <td>
                            <form id="blockForm-${card.id}" action="updateCardState" method="post">
                                <input type="hidden" name="cardId" value="${card.id}">
                                <input type="hidden" name="accountId" value="${card.account.id}">
                                <button type="submit" class="btn btn-outline-primary">
                                    <#if card.block>Розблокувати<#else>Заблокувати</#if>
                                </button>
                            </form>
                        </td>
                        <td>
                            <form action="deleteCard" method="post">
                                <input type="hidden" name="id" value="${card.id}">
                                <button type="submit" class="btn btn-outline-danger">Видалити</button>
                            </form>
                        </td>
                    </tr>
                </#list>
            <#else>
                <tr>
                    <td colspan="7">Немає доступних карт</td>
                </tr>
            </#if>
            </tbody>
        </table>
    </div>
    <script src="/static/scripts/editcards.js"></script>
</@p.pages>
