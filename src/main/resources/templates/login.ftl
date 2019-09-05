<#import "parts/login_or_reg.ftl" as lrg>
<#import  "parts/page.ftl" as p>

<@p.page>
    Страница авторизации:
    <@lrg.login_reg_form "/login" />
    <a href="/registration"><button>Регистрация</button></a>
</@p.page>