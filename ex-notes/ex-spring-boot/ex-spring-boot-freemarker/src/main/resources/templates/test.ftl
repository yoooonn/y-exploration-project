<#-- @ftlvariable name="message" type="java.lang.String" -->
<#-- @ftlvariable name="time" type="java.util.Date" -->
<!DOCTYPE html>

<html lang="en">

<body>

{
"params": {
"code": "${code}",
"city_id": "${cityId}",
"status": 1
"bikes": [
<#list bikeList>
    <#items as bike>
        {
        "id": ${bike.id},
        "sn": "${bike.id}"
        }
    </#items>
</#list>
]
}
}

</body>

</html>