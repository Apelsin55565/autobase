<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: timme
  Date: 15.12.2016
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../css/materialize.css">
    <c:import url="/navbar"/>
</head>
<body>
<div class="row">
    <div class="col l9">
        <h4>Список всех автомобилей</h4>
    </div>
    <div class="col l3" style="margin-top: 30px;">
        <a class="waves-effect waves-light btn blue lighten-2" href="controller?command=DriversWithoutAuto">Добавить автомобиль</a>
    </div>
</div>
<table class="ilike-blue-container responsive-table bordered striped  col s12 m12">
    <caption><h5>Автомобили</h5></caption>
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
    <c:forEach var="auto" items="${autos}">
        <tr>
            <td>${auto.idAuto}</td>
            <td>${auto.mark}</td>
            <td>${auto.model}</td>

            <c:if test="${auto.isOk == true}">
                <th>Исправен</th>
            </c:if>

            <c:if test="${auto.isOk != true}">
                <th>Неисправен</th>
            </c:if>

            <td>${auto.quantity_auto}</td>
            <td>${auto.idUsers}</td>

            <td>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="REMOVEAUTO">
                    <input type="hidden" name="id" value="${auto.idAuto}">
                    <button class="btn waves-effect waves-light red lighten-3" type="submit" name="action">Удалить</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/materialize.js"></script>
<jsp:include page="/footer"/>

</body>
</html>
