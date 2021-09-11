<%-- 
    Document   : reportes
    Created on : 5 jul. 2021, 11:36:45
    Author     : dreyna
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../WEB-INF/templates/headerMain.jspf"%>
    </head>
    <body>
        <%@include file="../WEB-INF/templates/headerMainBody.jspf"%>
	<h1>Reportes!</h1>
	<hr>
	<div class="row">
		<div class="col col-lg-2">
			<div class="form-group">
				<label>Fecha 1:</label> <input type="date" id="fecha1" class="form-control">
			</div>
		</div>
		<div class="col col-lg-2">
			<div class="form-group">
				<label>Fecha 2:</label> <input type="date" id="fecha2" class="form-control">
			</div>
		</div>
		<div class="col col-lg-2">
			<div class="form-group">
			<br />
				<button class="btn btn-primary">Buscar</button>
			</div>
		</div>
	</div>
	<%@include file="../WEB-INF/templates/footerMain.jspf"%>
    </body>
</html>
