<%-- 
    Document   : main
    Created on : 5 jul. 2021, 11:15:33
    Author     : dreyna
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistemas de Ventas</title>
        <link rel="shortcut icon" type="image/x-icon" href="recursos/img/logo.ico">
        <%@include file="WEB-INF/templates/headerMain.jspf" %>
    </head>
    <body onload="deshabilitaRetroceso() >
          <%@include file="WEB-INF/templates/headerMainBody.jspf" %>
            < div class ="container" id="contenido">
        <h1>Bienvenido al Sistema de Ventas...!</h1>
    </div>
    <%@include file="WEB-INF/templates/footerMain.jspf" %>
</body>
</html>
