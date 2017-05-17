<%-- 
    Document   : show_all_customers
    Created on : 27/04/2017, 05:19:35 PM
    Author     : Equipo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de clientes</title>
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
       
        <table border="1">
            <td><b>Identificación<b></b></td>
            <td><b>Nombre<b></b></td>
            <td><b>Nombre de usuario</b></td>
            <td><b>Discapacidad presente<b></td>
                        <c:forEach items="${customers}" var="currentCustomer">
                            <tr>
                                <td><c:out value="${currentCustomer.identification}"/></td>
                                <td><c:out value="${currentCustomer.name}"/></td>
                                <td><c:out value="${currentCustomer.username}"/></td>
                                <td><c:out value="${currentCustomer.disabilityPresented}"/></td>

                            </tr>
                        </c:forEach>
                        </table>
                        </body>
                        </html>
