<%-- 
    Document   : home
    Created on : 5 jul. 2021, 11:15:49
    Author     : dreyna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LP1</title>
        <link rel="shortcut icon" type="image/x-icon" href="recursos/img/logo.ico">
        <%@include file="WEB-INF/templates/header.jspf" %>
        <script>
            function deshabilitaRetroceso() {
                window.location.hash = "no-back-button";
                window.location.hash = "Again-No-back-button"; //chrome
                window.onhashchange = function () {
                    window.location.hash = "no-back-button";
                };
            }
        </script>
    </head>
    <body onload="deshabilitaRetroceso() ">
                <div class="container">

    <!-- Static navbar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><img src="recursos/img/ep.png" alt="" width="24" height="24"></a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li class="dropdown-header">Nav header</li>
                            <li><a href="#">Separated link</a></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <!--  <li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li> -->
                    <li><a href="#">Static top</a></li>
                    <li><a href="#" style="color: #33ccff;" id="login"><i class="fas fa-users-cog fa-lg"></i></a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>

    <!-- Main component for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div>
            <img src="recursos/img/car.jpg" class="img-responsive" alt="#">
        </div>                
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <img src="recursos/img/user2.png" style="border-radius: 50%;border: 1px solid #cccccc; padding: 5px;">
                </div>
                <form method="post" action="home">
                    <div class="modal-body">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Ingresar Usuario" name="user">
                            <input type="hidden" value="1" name="op">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Ingresar Password" name="pass">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-primary" value="Enviar">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!--Login-->
<%@include file="WEB-INF/templates/fo2.jspf" %>
</body>
</html>
