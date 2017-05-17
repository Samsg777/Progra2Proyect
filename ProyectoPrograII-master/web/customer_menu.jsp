<%-- 
    Document   : customer_menu
    Created on : 30/04/2017, 12:27:31 PM
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>customer menu</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
        <link rel="stylesheet" href="https://cr.staticontent.com/sbox/static/1.77.5-ab/boxes.module/css/main.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <style>
            body,h1 {font-family: "Raleway", sans-serif}
            body, html {height: 100%}
            .bgimg {
                background-image: url('/w3images/forestbridge.jpg');
                min-height: 100%;
                background-position: center;
                background-size: cover;
            }
        </style>
        <style type="text/css">

            * {
                margin:0px;
                padding:0px;
            }

            #header {
                margin:auto;
                width:500px;
                font-family:Arial, Helvetica, sans-serif;
            }

            ul, ol {
                list-style:none;
            }

            .nav > li {
                float:left;
            }

            .nav li a {
                background-color:#000;
                color:#fff;
                text-decoration:none;
                padding:10px 12px;
                display:block;
            }

            .nav li a:hover {
                background-color:#434343;
            }

            .nav li ul {
                display:none;
                position:absolute;
                min-width:140px;
            }

            .nav li:hover > ul {
                display:block;
            }

            .nav li ul li {
                position:relative;
            }

            .nav li ul li ul {
                right:-140px;
                top:0px;
            }

        </style>
    </head>
    <body>
        <div id="header">
            <ul class="nav">
                <li><a href="">Inicio</a></li>
                <li><a href="">Clientes</a>
                    <ul>
                        <li><a href="./insert_customer.jsp">Insertar persona(s) autorizada(s) por vehiculo</a></li>
                        <li><a href="VehicleRetrievalServlet"> Consultar persona(s) autorizada(s) por vehiculo</a></li>
                        <li><a href="VehicleCustomerRetrievalServlet">Modificar persona(s) autorizada(s) por vehiculo</a></li>
                        <li><a href="CustomerRetrievalServlet">Retirar persona(s) autorizada(s) por vehiculo</a></li>
                    </ul>
                </li>
                  <li><a href="">Vehiculos</a>
                    <ul>
                        <li><a href="insert_vehicle.jsp">Insertar</a></li>
                        <li><a href="">Submenu2</a></li>
                        <li><a href="">Submenu3</a></li>
                        <li><a href="">Submenu4</a></li>
                    </ul>
                </li>
                <li><a href="">Contacto</a></li>
            </ul>
        </div>
        
    </body>
</html>
