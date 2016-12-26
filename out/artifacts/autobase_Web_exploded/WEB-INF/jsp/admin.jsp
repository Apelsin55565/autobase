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
    <title>Панель администратора</title>
</head>
<body>
 <c:import url="/navbar"/>
 <div class="row">
     <div class="col s12 l9">
         <h4>Панель администратора</h4>
     </div>
 <div class="col s12 l2" style="margin-top: 30px;">
         <a class="waves-effect waves-light btn blue lighten-2" href="controller?command=DriversWithoutTrip">Добавить рейс</a>
     </div>
 </div>
<div class="row">
 <table class="ilike-blue-container responsive-table bordered striped col s12 m12">
     <caption><h5>Рейсы</h5></caption>
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
     <c:forEach var="trip" items="${trips}">
         <tr>
             <td>${trip.idTrip}</td>
             <td>${trip.date}</td>
             <td>${trip.idDriver_Users}</td>
             <td>${trip.quantity_trip}</td>
             <td>${trip.departure_from}</td>
             <td>${trip.destination_to}</td>
             <c:if test="${trip.idStatus == 1}">
                 <th>Выполнен</th>
             </c:if>

             <c:if test="${trip.idStatus > 1}">
                 <th>Не выполнен</th>
             </c:if>


             <td>
                 <form action="controller" method="post">
                     <input type="hidden" name="command" value="REMOVETRIP">
                     <input type="hidden" name="id" value="${trip.idTrip}">
                     <button class="btn waves-effect waves-light red lighten-3" type="submit" name="action">Удалить</button>
                 </form>
             </td>
         </tr>
         </c:forEach>
     </tbody>

 </table>
</div>

<%--<a  class="waves-effect waves-light btn blue lighten-2" href="controller?command=AllDrivers">Список водителей</a>
 <a  class="waves-effect waves-light btn blue lighten-2" href="controller?command=AllAuto">Список всех автомобилей</a>
 --%>
 <script type="text/javascript" src="../../js/jquery.js"></script>
 <script type="text/javascript" src="../../js/materialize.js"></script>

<jsp:include page="/footer"/>

</body>
</html>
