<#import "parts/page.ftl" as p>

<@p.page>
    <div>
        <form method="post" action="add_reminder">
            <input type="text" name="name" placeholder="Введите название напоминания" />
            <input type="text" name="tag" placeholder="Тэг(Без тега, обычно, важно)">
            <input type="text" name="text" placeholder="Что именно вам напомнить">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div><input type="submit" class="btn btn-outline-success" value="Добавить напоминание"/></div>
        </form>
    </div>
</@p.page>