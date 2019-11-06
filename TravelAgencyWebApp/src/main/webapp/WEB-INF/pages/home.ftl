<#ftl encoding="UTF-8">
<#import "/spring.ftl" as spring>
<html>
<head>
</head>
<body>
<div>
    <a href="/registration">
        <@spring.message code = "locale.registration"/>
    </a>
    <a href="/login">
        <@spring.message code = "locale.login"/>
    </a>
    <a href="/logout">
        <@spring.message code = "locale.logout"/>
    </a>
    <span style="float: right"></span>
    <a href="?lang=ru"> <@spring.message code = "locale.locale_button.ru"/></a>
    <a href="?lang=en"> <@spring.message code = "locale.locale_button.en"/></a>
    </span>

    <h3><@spring.message code = "locale.home"/></h3>
    <a href="/viewAllTours"><@spring.message code = "locale.all_tours"/></a>
    <a href="/viewAllHotels"><@spring.message code = "locale.all_hotels"/></a>
</div>
</body>
</html>