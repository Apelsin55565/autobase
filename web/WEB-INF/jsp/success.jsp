<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: timme
  Date: 13.12.2016
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../css/materialize.css">
    <title>Title</title>

</head>
<body>
<c:import url="/navbar"/>

<div class="row">
    <div class="col l9">
        <h5>Спасибо за регистрацию,  ${username}.</h5><br/>
        <h6>Для подтверждения логина и пароля, перейдите на страницу входа.</h6>
    </div>
    <div class="col l2" style="margin-top: 30px;">
        <a class="waves-effect waves-light btn blue lighten-2" href="/logination">Вход</a>
    </div>
</div>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/materialize.js"></script>
<jsp:include page="/footer"/>
</body>
</html>
