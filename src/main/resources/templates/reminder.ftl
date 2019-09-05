<#import "parts/page.ftl" as p>

<@p.page>
    <!--Перебор всех напоминаний-->
    <#list reminders as reminder>
        <div>
            <b>${reminder}</b>
            <span>${reminder}</span>
            <span>${reminder}</span>
            <strong>${reminder}</strong>
        </div>
    <#else>
        No reminders
    </#list>
</@p.page>