<#import "parts/login_or_reg.ftl" as lrg>
<#import  "parts/page.ftl" as p>

<@p.page>
    Страница регистрации:
    <@lrg.login_reg_form "/registration" />
</@p.page>