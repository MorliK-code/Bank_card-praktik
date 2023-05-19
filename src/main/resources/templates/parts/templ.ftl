<#macro pages>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MyBank</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>

<#include "navbar.ftl">

<div class="container-fluid">
    <div class="row">
        <div class="col-auto">
            <#include "leftbar.ftl">
        </div>
        <div class="col-11">
            <#nested>
        </div>
    </div>
</div>

<script src="/static/scripts/boodstrap.js"></script>
</body>
</html>

</#macro>