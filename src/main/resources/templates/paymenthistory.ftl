<#import "parts/templ.ftl" as p>
<@p.pages>
    <table class="table">
        <tr>
            <th>ID платежа</th>
            <th>Номер отправителя</th>
            <th>Номер получателя</th>
            <th>Сумма</th>
            <th>Статус</th>
        </tr>
        <#list paymentHistory as history>
            <tr>
                <td>${history[0].id}</td>
                <td>${history[0].senderNumber}</td>
                <td>${history[0].recipientNumber}</td>
                <td>${history[0].amount}</td>
                <td>
                    <#if history[1] == "Completed">
                        Успішно
                    <#else>
                        Без успішно
                    </#if>
                </td>
            </tr>
        </#list>
    </table>
</@p.pages>
