<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: timme
  Date: 13.12.2016
  Time: 21:23
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
    <form name="SigninForm" action="controller" method="POST" class="col s12 l8">
    <div style="margin-top: 30px;" class="row center">
        <div class="col s12 offset-l6  l6 ">
            <div class="card blue-grey">
                <div class="card-content black-text blue-grey lighten-5">

                    <input name="command" type="hidden" value="signin">
                    <div class="row">
                        <div class=" ">
                            <label>Имя</label>
                            <input required name="name" type="text" value="">
                            <label>Фамилия</label>
                            <input required name="surname" type="text" value="">
                        </div>
                        <div class=" ">
                            <label>Логин</label>
                            <input required name="username" type="text" class="validate">
                        </div>
                        <div class="col s4"><p>${errorInLogin}</p></div>
                    </div>
                    <div class="row">
                        <div class="input-field col l6">
                            <label for="password">Пароль</label>
                            <input required id="password" type="password" name="password" class="validate">

                        </div>
                        <div class="input-field col l6">
                            <label for="passwordRepeat">Повторите пароль</label>
                            <input required name="passwordRepeat" id="passwordRepeat" type="password" class="validate">
                        </div>
                        <div class="col l4"><p>${errorInPass}</p></div>
                        <div class="col l4"><p>${errorSIGNIN}</p></div>
                    </div>
                </div>
                <div class="card-action">
                    <button class="waves-effect waves-light btn blue lighten-2" type="submit" name="action">Зарегистрироваться</button>
                </div>
            </div>
        </div>
    </div>
    </form>

</div>

<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/materialize.js"></script>
</body>
</html>
