<#ftl encoding="UTF-8">
<#import "/spring.ftl" as spring>
<html>
<head>
    <meta charset="UTF-8" >
    <title>Create new tour</title>
</head>
<body>
<span style="float: right"></span>
<a href="?lang=ru"> <@spring.message code = "locale.locale_button.ru"/></a>
<a href="?lang=en"> <@spring.message code = "locale.locale_button.en"/></a>
</span>
<form method="post" action="/admin/updateTour">
    <h2><@spring.message code = "locale.tour"/></h2>
    <input type="hidden" name="id" value="${tour.id}">
    <input type="text" id="photo" name="photo" placeholder="<@spring.message code = "locale.photo"/>" value="${tour.photo}">
    <br><br>
    <input type="date" id="date" name="date" placeholder="<@spring.message code = "locale.date"/>" value="${tour.date}">
    <br><br>
    <input type="number" id="duration" name="duration" placeholder="<@spring.message code = "locale.duration"/>" value="${tour.duration}">
    <br><br>
    <input type="text" id="description" name="description" placeholder="<@spring.message code = "locale.description"/>" value="${tour.description}">
    <br><br>
    <input type="number" id="cost" name="cost" placeholder="<@spring.message code = "locale.cost"/>" value="${tour.cost}">
    <br><br>
    <input type="text" id="tourType" name="tourType" placeholder="<@spring.message code = "locale.tour_type"/>" value="${tour.tourType}">
    <br><br>
    <input type="hidden" id="hotel_id" name="hotel_id" value="${tour.hotel}">
    <input type="hidden" id="country_id" name="country_id" value="${tour.country}">
    <input type="submit" value="<@spring.message code = "locale.submit"/>">
</form>
<a href="/"><@spring.message code = "locale.home"/></a>
</body>
</html>