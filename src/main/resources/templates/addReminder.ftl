<#import "parts/page.ftl" as p>

<@p.page>
    <div>
        <form method="post" action="add_reminder">
            <input type="text" name="name" placeholder="Введите название напоминания" />
            <input type="text" name="tag" placeholder="Тэг(важно,очень важно,не очень важно,список покупок)">
            <input type="text" name="text" placeholder="Что именно вам напомнить">
            <!--<input type="hidden" name="_csrf" value="${_csrf.token}"> токен для спринг сесюрити-->
            <button type="submit">Добавить</button>
        </form>
    </div>
</@p.page>