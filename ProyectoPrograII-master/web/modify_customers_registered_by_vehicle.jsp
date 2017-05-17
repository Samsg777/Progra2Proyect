<%-- 
    Document   : modify_customers_registered_by_vehicle
    Created on : 02/05/2017, 11:11:05 AM
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente(s) por vehículo</title>
    </head>
    <body>
          <table border="1">
            <td><b>Identificación<b></b></td>
            <td><b>Nombre<b></b></td>
            <td><b>Nombre de usuario</b></td>
            <td><b>Discapacidad presente<b></td>
            <td><b>Modificar<b></td>
            <c:forEach items="${customers}" var="currentCustomer">
                <tr>
                    <td><c:out value="${currentCustomer.identification}"/></td>
                    <td><c:out value="${currentCustomer.name}"/></td>
                    <td><c:out value="${currentCustomer.username}"/></td>
                    <td><c:out value="${currentCustomer.disabilityPresented}"/></td>
                    <td><input type="radio" name="identification" value="${currentCustomer.identification}"></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
