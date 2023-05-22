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
        <#if paymentHistory?has_content>
            <#list paymentHistory as history>
                <tr>
                    <td>${history.payment.id}</td>
                    <td>${history.payment.senderNumber}</td>
                    <td>${history.payment.recipientNumber}</td>
                    <td>${history.payment.amount}</td>
                    <td>${history.status}</td>
                </tr>
            </#list>
        <#else>
            <tr>
                <td colspan="5">Історія платежів відсутся</td>
            </tr>
        </#if>
    </table>
</@p.pages>
