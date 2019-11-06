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
        <#list tours as tour>
        <tr>
            <td>${tour.photo}</td>
            <td>${tour.date}</td>
            <td>${tour.duration}</td>
            <td>${tour.description}</td>
            <td>${tour.cost}</td>
            <td>
                <a href="/viewTourById/${tour.id}"><@spring.message code="locale.view_info"/></a>
            </td>
            <td>
                <a href="/admin/updateTour/${tour.id}"><@spring.message code="locale.edit"/></a>
            </td>
            <td>
                <a href="/admin/deleteTour/${tour.id}"><@spring.message code="locale.delete"/></a>
            </td>
        </tr>
        </#list>
    </tbody>
</table>
<br>
    <#list pages as page>
        <a href="/viewAllTours/${page.firstElementOfPage}">${page.numOfPage}</a>
    </#list>
<br>
<br>
</ul>
<a href="/"><@spring.message code="locale.home"/></a>
<a href="/admin/createTour"><@spring.message code="locale.create_tour"/></a>
</body>
</html>