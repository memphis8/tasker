<#import  "parts/page.ftl" as p>

<@p.page>
    Страница авторизации:
    <form action="/login" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <!--<input type="hidden" name="_csrf" value="${_csrf.token}">-->
        <div><input type="submit" class="btn btn-outline-success" value="Sign In"/></div>
    </form>
    <a href="/registration"><button>Регистрация</button></a>
</@p.page>