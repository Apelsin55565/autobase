<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: timme
  Date: 13.12.2016
  Time: 20:32
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

    <c:if test="${trips == null}">

            <div class="col s12 l4">
                <h5>К сожалению у вас нету доступных рейсов. </h5>
            </div>

    </c:if>

    <c:if test="${trips != null}">



        <table class="ilike-blue-container responsive-table bordered striped col s12 m12">
            <caption><h5>Доступные рейсы</h5></caption>
            <thead>
            <tr>
                <th data-field="idTrip">ID</th>
                <th data-field="date">Дата</th>
                <th data-field="idDriver_Users">Водитель</th>
                <th data-field="quantity_trip">Количество пассажиров</th>
                <th data-field="departure_from">Откуда</th>
                <th data-field="destination_to">Куда</th>
                <th data-field="idStatus">Состояние рейса</th>
            </tr>
            </thead>
            <tbody>
        <tr>
            <th>${trips.idTrip}</th>
            <th>${trips.date}</th>
            <th>${user}</th>
            <th>${trips.quantity_trip}</th>
            <th>${trips.departure_from}</th>
            <th>${trips.destination_to}</th>
            <c:if test="${trips.idStatus == 1}">
                <th colspan="2">Выполнен</th>
            </c:if>

            <c:if test="${trips.idStatus > 1}">
                <th colspan="2" >Не выполнен</th>
            </c:if>
        </tr>
        <tr>
            <th colspan="7">
            </th>

        </tr>

    </tbody>
</table>

<div class="row">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="UPDATETRIPSTATUS">
        <div class="col l3 m3">
            <h5>Изменить статус рейса:</h5>
        </div>
        <div class="col l3 m3">
            <select size="2" name="status" required>
                <option disabled>Выберите статус рейса</option>
                <option name="status" value="1">Выполнен</option>
                <option name="status" value="2">Не выполнен</option>
            </select>
        </div>
        <div class="col  s3 offset-s1">
            <input type="hidden" name="idUser" value="${currentUser.idUsers}">
            <input type="hidden" name="idTrip" value="${trips.idTrip}">
            <button  style="margin-top: 5px;" class="waves-effect waves-light btn blue lighten-2" type="submit" name="action">Обновить</button>
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
