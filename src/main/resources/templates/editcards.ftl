<#import "parts/templ.ftl" as p>
<@p.pages>

    <div class="row d-flex align-items-center justify-content-center">
        <div class="col-5" style="align-items: center; text-align: center">
            <div class="shadow p-3 mb-5 bg-body-tertiary rounded">
                <div class="fw-bolder fs-1" style="text-align: center">Додати карту</div>
                <form action="addCards" method="post" class="mx-auto" style="align-items: center; text-align: center">
                    <div class="mb-2">
                        <label for="numbers" class="form-label">16-ти значний номер карти</label>
                        <input type="numbers" class="form-control" id="numbers" name="number"
                               pattern="\d{4} \d{4} \d{4} \d{4}"
                               placeholder="Приклад: 0000 0000 0000 0000" required>
                    </div>
                    <div class="mb-2">
                        <label for="cvc" class="form-label">CVC карти</label>
                        <input type="number" class="form-control" id="cvc" name="cvc"
                               placeholder="Приклад: 000" required min="0" max="999">
                    </div>
                    <div class="form-group mb-3">
                        <label for="expiry">Термін дії</label>
                        <div class="input-group">
                            <input type="number" class="form-control" id="month" name="month" placeholder="Місяць"
                                   min="1"
                                   max="12"
                                   required>
                            <div class="input-group-text">/</div>
                            <input type="number" class="form-control" id="year" name="year"
                                   placeholder="Рік(останні 2 цифри)" min="0" max="99"
                                   required>
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
                <th>Стан карти</th>
                <th>Редагування стану карти</th>
                <th>Видалення карти</th>
            </tr>
            </thead>

            <tbody>
            <#if allCard ??>
                <#list allCard as card>
                    <tr>
                        <td>${card.number}</td>
                        <td>${card.cvc}</td>
                        <td>${card.month?string('00')}/${card.year?string('00')}</td>
                        <td><#if card.block>Заблокована<#else>Активна</#if></td>
                        <td>
                            <form id="blockForm-${card.id}" action="updateCardState" method="post">
                                <input type="hidden" name="cardId" value="${card.id}">
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
            </#if>
            </tbody>
        </table>
    </div>





</@p.pages>