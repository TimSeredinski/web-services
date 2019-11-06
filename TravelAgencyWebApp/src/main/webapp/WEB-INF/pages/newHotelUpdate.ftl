<#ftl encoding="UTF-8">
<#import "/spring.ftl" as spring>
<html>
<head>
    <meta charset="UTF-8" >
    <title>Update hotel</title>
</head>
<body>
<span style="float: right"></span>
<a href="?lang=ru"> <@spring.message code = "locale.locale_button.ru"/></a>
<a href="?lang=en"> <@spring.message code = "locale.locale_button.en"/></a>
</span>
<form method="post" action="/admin/updateHotel">
    <h2><@spring.message code = "locale.hotel"/></h2>
    <input type="hidden" name="id" value="${hotel.id}">
    <input type="text" id="name" name="name" placeholder="<@spring.message code="locale.name"/>" value="${hotel.name}">
    <br><br>
    <input type="number" id="stars" name="stars" placeholder="<@spring.message code="locale.stars"/>" value="${hotel.stars}">
    <br><br>
    <input type="text" id="website" name="website" placeholder="<@spring.message code="locale.website"/>" value="${hotel.website}">
    <br><br>
    <input type="number" id="lalitude" name="lalitude" placeholder="<@spring.message code="locale.lalitude"/>" value="${hotel.lalitude}">
    <br><br>
    <input type="number" id="longitude" name="longitude" placeholder="<@spring.message code="locale.longitude"/>" value="${hotel.longitude}">
    <br><br>
    <#list hotel.features as feature>
        <input type="hidden" name="features" value="${feature}">
    </#list>
    <!--    <p><b>Choose right features</b></p>-->
    <!--    <p><input type="checkbox" name="feature" value="POOL">Pool<Br>-->
    <!--        <input type="checkbox" name="feature" value="BAR">Bar<Br>-->
    <!--        <input type="checkbox" name="feature" value="GYM">Gym<Br>-->
        <input type="submit" value="<@spring.message code = "locale.submit"/>">
</form>
<a href="/"><@spring.message code = "locale.home"/></a>
</body>
</html>