<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: timme
  Date: 13.12.2016
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
    <link rel="stylesheet" type="text/css" href="../../css/materialize.css">

</head>
<body>
<c:import url="/navbar"/>
Request from ${pageContext.errorData.requestURI} is failed <br/>
Servlet name or type : ${pageContext.errorData.servletName} <br>
Status code: ${pageContext.errorData.statusCode} <br/>
Exception^ ${pageContext.errorData.throwable}
<a class="waves-effect waves-light btn blue lighten-3" href="/index">На главную</a>
</body>
</html>
