<%-- 
    Document   : ventas
    Created on : 5 jul. 2021, 11:27:59
    Author     : dreyna
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="shortcut icon" type="image/x-icon" href="../recursos/img/logo.ico">
        <%@include file="../WEB-INF/templates/headerMain.jspf" %>
        <style type="text/css">
            #custom-search-input{
                border: solid 1px #E4E4E4;
                border-radius: 6px;
                background-color: #fff;
            }

            #custom-search-input input{
                border: 0;
                box-shadow: none;
            }

            #custom-search-input button{
                margin: 2px 0 0 0;
                background: none;
                box-shadow: none;
                border: 0;
                color: #666666;
                padding: 0 8px 0 10px;
                border-left: solid 1px #ccc;
            }

            #custom-search-input button:hover{
                border: 0;
                box-shadow: none;
                border-left: solid 1px #ccc;
            }

            #custom-search-input .glyphicon-search{
                font-size: 23px;
            }

        </style>

    </head>
    <body>
        <%
            Date myDate = new Date();
        %>
        <%@include file="../WEB-INF/templates/headerMainBody.jspf" %>
        <header>
            <div class="row">
                <div class="col-xs-12 col-md-8">
                    <h3>Ventas</h3>
                </div>
                <div class="col-xs-6 col-md-4">
                    <a href="#" onclick="imprimir()"><img src="recursos/img/Printer.png" alt="" width="64" height="64"></a>
                </div>
            </div>

            <hr>
        </header>
        <div class="row">
            <div class="col-xs-12 col-md-8">
                <div id="custom-search-input" style="margin-top: 5px;">
                    <div class="input-group col-md-12">
                        <input type="text" class="form-control input-lg" placeholder="Ingresar Código de Producto..." id="prod"/>
                        <span class="input-group-btn">
                            <button class="btn btn-info btn-lg" type="button"> <!-- id="searchproducto" -->
                                <i class="fas fa-search-plus" style="color: #0d7cf2;"></i>
                            </button>
                        </span>
                    </div>
                </div>
                <div id="visualizarProducto" style="border: 1px solid #eae8e8; border-radius: 5px; margin: 10px 0px 5px 0px; padding: 10pX 10Px 0px 10px;display: none;">
                    <table class="table" id="tablaVentas">
                        <thead>
                            <tr>
                                <th scope="col">CANTIDAD</th>
                                <th scope="col">ID</th>
                                <th scope="col">CODIGO</th>
                                <th scope="col">PRODUCTO</th>
                                <th scope="col">PRECIO</th>
                                <th scope="col">STOCK</th>
                            </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
                <hr>
                <table class="table" id="tablitaDetalle">
                    <thead>
                        <tr>
                            <th scope="col">#</th>   
                            <th scope="col">CODIGO</th>
                            <th scope="col">PRODUCTO</th>
                            <th scope="col">PRECIO</th>
                            <th scope="col">CANTIDAD</th>
                            <th scope="col">ACCION</th>
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
                <div class="form-group">
                    <button class="btn btn-success" id="registrarVenta"><i class="fas fa-cart-plus" style="margin-right: 5px;"></i>Guardar Compra</button>
                    <button class="btn btn-danger"><i class="fas fa-shopping-cart" style="margin-right: 5px;"></i>Vaciar Carrito</button>
                </div>
            </div>
            <div class="col-xs-6 col-md-4">
                <div class="page-header" style="background: #cc0000;margin: 0;border: 1px solid #cc0000;">
                    <h3 style="margin: 20px; text-align: center; color: white;" id="totalcito">
                        S/.0.0
                    </h3>
                </div>
                <hr>
                <div class="form-group">
                    <label>Fecha:</label>
                    <% out.println(new SimpleDateFormat("dd-MM-yyyy").format(myDate));%>                    
                </div>
                <div class="form-group">
                    <label>Vendedor:</label>
                    ${sessionScope.nombres}                      
                </div>
                <hr>
                <div class="form-group">
                    <label>Cliente:</label>
                    <input type="text" class="form-control" placeholder="Ingresar DNI del Cliente" id="cliente">  
                    <input type="hidden" id="idcliente"> 
                </div>
                <hr>
                <div class="row" style="border:1px solid #e3e2e2;padding: 5px;">
                    <div class="col-md-5">SUB TOTAL</div>
                    <div class="col-md-5" id="st"></div>
                </div>
                <div class="row" style="border:1px solid #e3e2e2;padding: 5px;">
                    <div class="col-md-5">IGV(18%)</div>
                    <div class="col-md-5" id="igv"></div>
                </div>
                <div class="row" style="border:1px solid #e3e2e2;padding: 5px;">
                    <div class="col-md-5">TOTAL</div>
                    <div class="col-md-5" id="total"></div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../WEB-INF/templates/footerMain.jspf" %>
    <script src="recursos/js/ventas.js" type="text/javascript"></script>
</body>
</html>
