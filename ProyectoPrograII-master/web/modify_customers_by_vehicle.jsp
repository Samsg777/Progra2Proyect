<%-- 
    Document   : modify_customers_by_vehicle
    Created on : 02/05/2017, 10:01:18 AM
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar personas registradas</title>
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
    <body>
        <h3>Seleccione el vehículo</h3>
        <!--TODO: mostrar tabla con lista de vehiculos y mostrar clientes según vehículo -->
        <form action="VehicleCustomerModifyServlet" method="get">
            <table border="1">
                <td>Selección</td>
                <td>Placa</td>
                <td>Marca</td>
                <td>Modelo</td>
                <td>Color</td>
                <c:forEach items="${vehicles}" var="currentVehicle">
                    <tr>
                        <td><input type="radio" name="plate" value="${currentVehicle.plate}"></td>
                        <td><c:out value="${currentVehicle.plate}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Modificar"/>
        </form>
    </body>
</html>
