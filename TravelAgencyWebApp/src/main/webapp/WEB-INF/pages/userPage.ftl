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
    <li>${user.login} ${user.password}</li>
        <#list user.tours as tour>
            <li>${tour.cost} ${tour.description} ${tour.duration}</li>
        </#list>
        <#list user.reviews as review>
            <li>Text of review: ${review.text}</li>
        </#list>
</ul>
<a href="/">Home page</a>
</body>
</html>