<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <title>Добавление рейса</title>
        <link rel="stylesheet" type="text/css" href="../../css/materialize.css">
 </head>
 <body>
 <c:import url="/navbar"/>
 <div class="row">
     <form name="CreateNewTripForm" style="margin-top: 30px;" action="controller" method="POST" class=" ">
         <div style="margin-top: 30px;" class="row center">
             <div class="col s12 offset-l4 l4 ">
                 <div class="card blue-grey">
                     <div class="card-content black-text blue-grey lighten-5">
                         <input name="command" type="hidden"  value="CREATENEWTRIP">
                         <label>Дата</label>
                         <input name="date" type="date" required value="">
                         <label>Количество пассажиров</label>
                         <input name="quantity" type="text" required value="">
                         <label>Откуда</label>
                         <input name="from" type="text" required class="validate">
                         <label>Куда</label>
                         <input  name="to" type="text" required class="validate">

                         <select required size="1" name="driver_id">
                             <option selected="selected">Выберите свободного водителя</option>
                             <c:forEach var="user" items="${users}">
                                 <option name="driver_id" value="${user.idUsers}"> ${user.username}</option>
                             </c:forEach>
                         </select>

                         <div class="col s4"><p>${errorTripIsNotCreated}</p></div>
                     </div>
                     <div class="card-action">
                         <button class="waves-effect waves-light btn blue lighten-2" type="submit" name="action">Добавить</button>
                     </div>
                 </div>
             </div>
         </div>
    </form>
</div>
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
