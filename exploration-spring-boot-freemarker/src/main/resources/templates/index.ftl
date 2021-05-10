<#-- @ftlvariable name="message" type="java.lang.String" -->
<#-- @ftlvariable name="time" type="java.util.Date" -->
<!DOCTYPE html>

<html lang="en">

<body>
Date: ${time?date}
<br>
Time: ${time?time}
<br>
Message: ${message}
</body>

</html>