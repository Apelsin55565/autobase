<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: timme
  Date: 17.12.2016
  Time: 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../css/materialize.css">
</head>
<body>
<c:import url="/navbar"/>
<h4>Панель пользователя ${user}</h4>

    <c:if test="${autos == null}">
        <div  class="col s12 l4">

                <h5>К сожалению у вас нету доступного автомобиля. </h5>

        </div>
    </c:if>

    <c:if test="${autos != null}">


        <table class="ilike-blue-container responsive-table bordered striped col s12 m12">
            <caption><h5>Доступный автомобиль</h5></caption>
            <thead>
            <tr>
                <th data-field="id">ID</th>
                <th data-field="mark">Марка</th>
                <th data-field="model">Модель</th>
                <th data-field="isOk">Состояние</th>
                <th data-field="quantity_auto">Вместимость (человек)</th>
                <th data-field="user_idUsers">Водитель</th>
            </tr>
            </thead>
            <tbody>

        <tr>
            <td>${autos.idAuto}</td>
            <td>${autos.mark}</td>
            <td>${autos.model}</td>
            <c:if test="${autos.isOk == true}">
                <th>Исправен</th>
            </c:if>

            <c:if test="${autos.isOk != true}">
                <th>Неисправен</th>
            </c:if>

            <td>${autos.quantity_auto}</td>
            <td>${user}</td>

        </tr>
    <tr>
        <th colspan="6">

        </th>

    </tr>

    </tbody>
</table>
<div class="row">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="UPDATEAUTOSTATUS">
        <div class="col l4 m3">
            <h5>Изменить состояние автомобиля:</h5>
        </div>
        <div class="col l3 m3">
            <select size="2" name="status"  required>
                <option disabled>Выберите состояние автомобиля</option>
                <option name="status" value="1">Исправен</option>
                <option name="status" value="0">Неисправен</option>
            </select>
        </div>
        <div class="col  s3 offset-s1">
            <input type="hidden" name="idUser" value="${currentUser.idUsers}">
            <input type="hidden" name="idAuto" value="${autos.idAuto}">
            <button style="margin-top: 5px;"   class="waves-effect waves-light btn blue lighten-2" type="submit" name="action">Обновить</button>
        </div>
    </form>
</div>

</c:if>

<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/materialize.js"></script>
<script>
    $(document).ready(function() {
        $('select').material_select();
    });
</script>

<jsp:include page="/footer"/>

</body>
</html>
