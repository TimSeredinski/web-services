<#ftl encoding="UTF-8">
<#import "/spring.ftl" as spring>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create new hotel</title>
</head>
<body>
<span style="float: right"></span>
<a href="?lang=ru"> <@spring.message code = "locale.locale_button.ru"/></a>
<a href="?lang=en"> <@spring.message code = "locale.locale_button.en"/></a>
</span>
<form method="post" action="/admin/createHotel">
    <h2><@spring.message code = "locale.hotel"/></h2>
    <input type="text" id="name" name="name" placeholder="<@spring.message code = "locale.name"/>">
    <br><br>
    <input type="number" id="stars" name="stars" placeholder="<@spring.message code = "locale.stars"/>">
    <br><br>
    <input type="text" id="website" name="website" placeholder="<@spring.message code = "locale.website"/>">
    <br><br>
    <input type="number" id="lalitude" name="lalitude" placeholder="<@spring.message code = "locale.lalitude"/>">
    <br><br>
    <input type="number" id="longitude" name="longitude" placeholder="<@spring.message code = "locale.longitude"/>">
    <br><br>
    <p><b><@spring.message code = "locale.choose_features"/></b></p>
    <input type="checkbox" name="feature" value="POOL"><@spring.message code = "locale.pool"/><Br>
    <input type="checkbox" name="feature" value="BAR"><@spring.message code = "locale.bar"/><Br>
    <input type="checkbox" name="feature" value="GYM"><@spring.message code = "locale.gym"/><Br>
    <br>
    <input type="submit" value="<@spring.message code = "locale.submit"/>">
</form>
<a href="/"><@spring.message code = "locale.home"/></a>
</body>
</html>