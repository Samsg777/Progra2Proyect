<%-- 
    Document   : insert_vehicle
    Created on : 04/05/2017, 10:53:04 AM
    Author     : Arturo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Insertar vehiculo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
    </head>
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
            background-color:#123;
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
    <div id="main">
        <br><br><h2>Datos del vehiculo</h2>
        <form action="CustomerInfoServlet" method="get">
            <table>
                <tr>
                    <td>Placa:</td>
                    <td><input type="text" name="plate"></td>
                </tr>
                <tr>
                    <td>Color:</td>
                    <td><input type="text" name="color"></td>
                </tr>
                <tr>
                    <td>Marca:</td>
                    <td><input type="text" name="brand"></td>
                </tr>
                <tr>
                    <td>Modelo:</td>
                    <td><input type="text" name="model"></td>
                </tr>
                <tr>
                    <td>Clientes:</td>
                    <td><a  href="insert_customer.jsp">
                            <input value="Insertar" type="text" style="color: blue"  name="customers">
                        </a>
                    </td>

                </tr>
                <tr>
                    <td>Tipo de vehiculo:</td>
                    <td><input type="text" name="vehicleType"></td>
                </tr>
            </table><br>
            <input type="submit" value="Guardar vehiculo"/>
        </form>



    </div>



</body>
</html>
