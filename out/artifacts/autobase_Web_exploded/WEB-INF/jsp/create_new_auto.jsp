<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: timme
  Date: 16.12.2016
  Time: 14:43
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
    <form name="CreateNewTripForm" action="controller" style="margin-top: 30px;" method="POST" class="">
        <div style="margin-top: 30px;" class="row center">
            <div class="col s12 offset-l4 l4 ">
                <div class="card blue-grey">
                    <div class="card-content black-text blue-grey lighten-5">
                        <input name="command" type="hidden" value="CREATENEWAUTO">
                        <label>Марка</label>
                        <input name="mark" type="text" value="" required>
                        <label>Модель</label>
                        <input name="model" type="text" value="" required>

                        <label>Вместимость (человек)</label>
                        <input name="quantity" type="text" required>

                        <label>Выберите водителя</label>
                        <select size="1" name="driver_id" required >
                            <option disabled selected>Водители без автомобиля</option>
                            <c:forEach var="user" items="${users}">
                                <option name="driver_id" value="${user.idUsers}"> ${user.username}</option>
                            </c:forEach>
                        </select>

                        <div class="col s4"><p>${errorInPass}</p></div>
                        <div class="col s4"><p>${errorSIGNIN}</p></div>
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
