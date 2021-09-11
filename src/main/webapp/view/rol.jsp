<%-- 
    Document   : rol
    Created on : 5 jul. 2021, 11:38:25
    Author     : dreyna
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../WEB-INF/templates/headerMain.jspf" %>
    </head>
    <body>
        <%@include file="../WEB-INF/templates/headerMainBody.jspf" %>
        <h3>REGISTRO DE ROLES</h3>
        <hr>
        <button class="btn btn-success" id="crearRol"><i class="fas fa-plus"></i></button>
        <hr>
        <table class="table" id="tablita">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">ROL</th>
                    <th scope="col">ACCION</th>
                </tr>
            </thead>
            <tbody>                    
            </tbody>
        </table>
    </div>
    <!-- Modal PARA REGISTRAR-->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">REGISTRAR ROL</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Rol:</label>
                        <input type="text" id="nomrol" class="form-control">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="saverol">Save Rol</button>
                </div>
            </div>
        </div>
    </div>
    <!--MODAL PARA EDITAR-->
    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Rol:</label>
                        <input type="text" id="edit_nomrol" class="form-control">
                        <input type="hidden" id="edit_idrol" class="form-control">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="editrol">Modificar Rol</button>
                </div>
            </div>
        </div>

        <%@include file="../WEB-INF/templates/footerMain.jspf" %>
        <script src="recursos/js/rol.js"></script>
</body>
</html>
