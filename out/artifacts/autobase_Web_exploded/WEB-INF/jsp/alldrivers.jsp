<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: timme
  Date: 15.12.2016
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Все пользователи</title>
    <link rel="stylesheet" type="text/css" href="../../css/materialize.css">

</head>
<body>

<c:import url="/navbar"/>


<table class="ilike-blue-container responsive-table bordered striped  col s12 m12">
    <caption><h5>Все пользователи</h5></caption>
    <thead>
    <tr>
        <th data-field="id">ID</th>
        <th data-field="login">Логин</th>
        <th data-field="password">Пароль</th>
        <th data-field="name">Имя</th>
        <th data-field="surname">Фамилия</th>
    </tr>
    </thead>
<c:forEach var="user" items="${users}">
    <tr>
        <td>${user.idUsers}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.name}</td>
        <td>${user.surname}</td>

        <td>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="REMOVEUSER">
                <input type="hidden" name="id" value="${user.idUsers}">
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
