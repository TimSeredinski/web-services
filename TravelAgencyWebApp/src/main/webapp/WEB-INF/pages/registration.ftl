<#ftl encoding="UTF-8">
<#import "/spring.ftl" as spring>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<span style="float: right"></span>
<a href="?lang=ru"> <@spring.message code = "locale.locale_button.ru"/></a>
<a href="?lang=en"> <@spring.message code = "locale.locale_button.en"/></a>
</span>
<form method="post" action="/registration">
    <h2><@spring.message code="locale.registration"/></h2>
    <input type="text" id="login" name="login" placeholder="<@spring.message code="locale.user_name"/>">
    <br><br>
    <input type="text" id="password" name="password" placeholder="<@spring.message code="locale.password"/>">
    <br><br>
    <input type="submit" value="<@spring.message code="locale.submit"/>">
</form>
<a href="/"><@spring.message code="locale.home"/></a>
</body>
</html>