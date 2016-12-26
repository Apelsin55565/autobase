<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: timme
  Date: 12.12.2016
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../../css/materialize.css">
</head>
<body>
<c:import url="/navbar"/>
<form class="center">

    <div style="margin-top: 30px;" class="row center">
        <div class=" col s12 offset-l3 l6 ">
            <div class="card blue-grey">
                <div class="card-content white-text">
                    <span class="card-title">Здравствуйте</span>
                    <p>Для того, чтобы войти в систему воспользуйтесь своим логином и паролем или зарегистрируйтесь.</p>
                </div>
                <div class="card-action">
                    <a style="margin-right: 10px;" class="waves-effect waves-light btn blue lighten-3"  href="logination">Вход</a>
                    <a style="margin-left: 10px;" class="waves-effect waves-light btn  teal lighten-2" href="signin">Регистрация</a>
                </div>
            </div>
        </div>
    </div>

</form>
</body>
</html>
