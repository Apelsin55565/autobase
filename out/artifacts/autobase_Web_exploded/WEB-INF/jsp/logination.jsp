<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: timme
  Date: 13.12.2016
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../css/materialize.css">
    <title>Войти</title>
</head>

<body>
<c:import url="/navbar"/>

<form name="LoginForm" method="POST" action="controller" class="center-block center col s12">

    <div style="margin-top: 30px;" class="row center">
        <div class="col s12 offset-l3 l6">
            <div class="card blue-grey">
                <div class="card-content black-text blue-grey lighten-5">

                <input required name="command" type="hidden" value="Login">
                <div class="row">
                    <div class="input-field col s6">
                        <label>Логин</label>
                        <input required  name="username"  value="" type="text">
                    </div>
                    <div class="input-field col s6">
                        <label>Пароль</label>
                        <input required name="password" class="validate"  value="" type="password">
                    </div>
                </div>
                ${errorLoginOrPassMessage}
                ${wrongAction}
                ${nullPage}
                </div>
                <div class="card-action">
                    <button class="waves-effect waves-light btn blue lighten-2" type="submit" name="action">Войти</button>
                </div>
            </div>
        </div>
    </div>


</form>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/materialize.js"></script>
</body>
</html>
