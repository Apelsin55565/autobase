<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: timme
  Date: 15.12.2016
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<nav>
    <div class="nav-wrapper blue-grey lighten-1">
        <a href="#" style="margin-left: 5%; tab-size: 20;" class="brand-logo">Система "Автобаза"</a>
        <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <c:if test="${isSignedIn == true}">

                <c:if test="${Role_idRole == 1}">
                    <li><a href="/admin">Список всех рейсов</a></li>
                    <li><a href="controller?command=AllDrivers">Список всех пользователей</a></li>
                    <li><a href="controller?command=AllAuto">Список всех автомобилей</a></li>
                </c:if>
                <c:if test="${Role_idRole != 1}">
                        <li><a href="/page">Мои рейсы</a></li>
                        <li><a  href="controller?command=USERAUTO&idUser=${currentUser.idUsers}">Мой автомобиль</a></li>
                </c:if>
                <li><a href="controller?command=logout">Выйти</a></li>
            </c:if>
        </ul>

        <ul class="side-nav" id="mobile-demo">
            <c:if test="${isSignedIn == true}">

                <c:if test="${Role_idRole == 1}">
                    <li><a href="/admin">Список всех рейсов</a></li>
                    <li><a href="controller?command=AllDrivers">Список всех пользователей</a></li>
                    <li><a href="controller?command=AllAuto">Список всех автомобилей</a></li>
                </c:if>
                <c:if test="${Role_idRole != 1}">
                    <li><a href="/page">Мои рейсы</a></li>
                    <li><a  href="controller?command=USERAUTO&idUser=${currentUser.idUsers}">Мой автомобиль</a></li>
                </c:if>
                <li><a href="controller?command=logout">Выйти</a></li>
            </c:if>
        </ul>
    </div>
</nav>

<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/materialize.js"></script>
<script>
    $(document).ready(function() {
        $(".button-collapse").sideNav();
    });
</script>

</body>
</html>
