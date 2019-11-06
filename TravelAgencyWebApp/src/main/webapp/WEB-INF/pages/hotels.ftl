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
<ul>
    <table>
        <thead>
        <tr>
            <th><@spring.message code="locale.name"/></th>
            <th><@spring.message code="locale.stars"/></th>
            <th><@spring.message code="locale.website"/></th>
            <th><@spring.message code="locale.features"/></th>
        </tr>
        </thead>
        <tbody>
        <#list hotels as hotel>
        <tr>
            <td>${hotel.name}</td>
            <td>${hotel.stars}</td>
            <td>${hotel.website}</td>
            <td>
                <#list hotel.features as feature>
                    ${feature}
                </#list>
            </td>
            <td>
                <a href="/admin/updateHotel/${hotel.id}"><@spring.message code="locale.edit"/></a>
            </td>
            <td>
                <a href="/viewHotelById/${hotel.id}"><@spring.message code="locale.view_info"/></a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</ul>
<a href="/"><@spring.message code="locale.home"/></a>
<a href="/admin/createHotel"><@spring.message code="locale.create_hotel"/></a>
</body>
</html>