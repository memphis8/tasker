<#import "parts/page.ftl" as p>

<@p.page>
    <div>
        <form method="post" action="add_reminder">
            <div><input type="text" name="name" placeholder="Введите название напоминания" /></div>
            <div><input type="text" name="tag" placeholder="Тэг(Без тега, обычно, важно)"></div>
            <div><input type="text" name="text" placeholder="Что именно вам напомнить"></div>
            <!--<input type="hidden" name="_csrf" value="${_csrf.token}">-->
            <input class="btn btn-primary" type="submit" value="Submit">
        </form>
    </div>
</@p.page>