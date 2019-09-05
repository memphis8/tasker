<#import "parts/page.ftl" as p>

<@p.page>
    <!--Перебор всех напоминаний-->
    <#list reminders as reminder>
        <div>
            <b>${reminder.name}</b>
            <span>${reminder.tag}</span>
            <span>${reminder.text}</span>
            <!--<strong>${reminder}</strong>-->
        </div>
    <#else>
        Нету запланированых напоминаний
    </#list>
</@p.page>