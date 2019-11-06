<#ftl encoding="UTF-8">
<#import "/spring.ftl" as spring>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<span style="float: right"></span>
<a href="?lang=ru"> <@spring.message code = "locale.locale_button.ru"/></a>
<a href="?lang=en"> <@spring.message code = "locale.locale_button.en"/></a>
</span>
<table>
    <thead>
    <tr>
        <th><@spring.message code ="locale.photo"/></th>
        <th><@spring.message code ="locale.date"/></th>
        <th><@spring.message code ="locale.duration"/></th>
        <th><@spring.message code ="locale.description"/></th>
        <th><@spring.message code ="locale.cost"/></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${tour.photo}</td>
        <td>${tour.date}</td>
        <td>${tour.duration}</td>
        <td>${tour.description}</td>
        <td>${tour.cost}</td>
        <td>
            <a href="/admin/updateTour/${tour.id}"><@spring.message code="locale.edit"/></a>
        </td>
    </tr>
    </tbody>
</table>
<div>
    <table>
        <thead>
        <tr>
            <th><@spring.message code="locale.user_name"/></th>
            <th><@spring.message code="locale.review"/></th>
            <th><@spring.message code="locale.date"/></th>
        </tr>
        </thead>
        <tbody>
        <#list tour.reviews as review>
        <tr>
            <td>${review.user.login}</td>
            <td>${review.text}</td>
            <td>${review.date}</td>
        </tr>
        </#list>
        </tbody>
    </table>
    <form method="post" action="/createReview">
        <h2><@spring.message code="locale.make_review"/></h2>
        <input type="text" id="text" name="text" placeholder="<@spring.message code="locale.review"/>">
        <input type="hidden" id="tour" name="tour" value="${tour}">
        <br><br>
        <input type="submit" value="<@spring.message code="locale.submit"/>">
    </form>
</div>
<a href="/"><@spring.message code="locale.home"/></a>
<a href="/viewAllTours"><@spring.message code="locale.all_tours"/></a>
</body>
</html>