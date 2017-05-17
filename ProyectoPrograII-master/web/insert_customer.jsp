<%-- 
    Document   : insert_customer
    Created on : Apr 20, 2017, 5:50:57 PM
    Author     : Esteban
--%>

<%@page import="Domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar cliente</title>
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
        <i>
            <font size=6 COLOR=009900>
            <marquee>
                SISTEMA DE INGRESO DE CLIENTES
            </marquee>
            </font>
        </i>

        <form action="CustomerInfoServlet" method="get">
            <table>
                <tr>
                    <td>Identificación:</td>
                    <td><input type="text" name="identification"></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Nombre de usuario</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td>Presenta discapacidad</td>
                    <td>
                        <input type="radio" name="isDisabilityPresented" value="true">Sí
                        <input type="radio" name="isDisabilityPresented" value="false">No<br>
                    </td>
                </tr>
            </table>
          
            
            <input type="submit" value="Registrar otro(s)"/>
            <input type="submit" value="Guardar cliente(s)"/>
            
        </form>
    </body>
</html>
