<#ftl encoding="UTF-8">
<#import "/spring.ftl" as spring>
<html>
<head>
    <title>Insert title here</title>
    <style>
        #map {
        height: 40%;
        width: 40%;
      }
    </style>
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
<!--                make if admin-->
                <a href="/admin/updateHotel/${hotel.id}"><@spring.message code="locale.edit"/></a>
            </td>
        </tr>
        </tbody>
    </table>
</ul>
<div id="map"></div>
<script>
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: ${hotel.lalitude}, lng: ${hotel.longitude}},
          zoom: 11
        });
      }
    </script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAHqTO5H2_1pGWJ48froeeqq9HmICNC4OM&callback=initMap"
        async defer></script>
<a href="/"><@spring.message code="locale.home"/></a>
<a href="/viewAllHotels"><@spring.message code="locale.all_hotels"/> </a>
</body>
</html>