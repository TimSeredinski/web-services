<#ftl encoding="UTF-8">
<#import "/spring.ftl" as spring>
<html>
<head>
    <meta charset="UTF-8" >
</head>
<body>
<span style="float: right"></span>
<a href="?lang=ru"> <@spring.message code = "locale.locale_button.ru"/></a>
<a href="?lang=en"> <@spring.message code = "locale.locale_button.en"/></a>
</span>
<form method="post" action="/admin/createTour">
    <h2><@spring.message code = "locale.tour"/></h2>
    <input type="text" id="photo" name="photo" placeholder="<@spring.message code = "locale.photo"/>">
    <br><br>
    <input type="date" id="date" name="date" placeholder="<@spring.message code = "locale.date"/>">
    <br><br>
    <input type="number" id="duration" name="duration" placeholder="<@spring.message code = "locale.duration"/>">
    <br><br>
    <input type="text" id="description" name="description" placeholder="<@spring.message code = "locale.description"/>">
    <br><br>
    <input type="number" id="cost" name="cost" placeholder="<@spring.message code = "locale.cost"/>">
    <br><br>
    <input type="text" id="tourType" name="tourType" placeholder="<@spring.message code = "locale.tour_type"/>">
    <br><br>
    <input type="submit" value="<@spring.message code = "locale.submit"/>">
</form>
<a href="/"><@spring.message code = "locale.home"/></a>
</body>
</html>