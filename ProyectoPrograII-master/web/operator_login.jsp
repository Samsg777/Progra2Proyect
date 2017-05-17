<%--
    Document   : customer_login
    Created on : 01/05/2017, 12:54:41 PM
    Author     : Samuel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            div.container {
                width: 100%;
                border: 3px solid gray;
            }
                
            header, footer {
                padding: 1em;
                color: white;
                background-color: black;
                clear: left;
                text-align: center;
            }
                
            nav {
                float: left;
                max-width: 160px;
                margin: 0;
                padding: 1em;
            }
                
            nav ul {
                list-style-type: none;
                padding: 0;
            }
                
            nav ul a {
                text-decoration: none;
            }
                
            article {
                margin-left: 170px;
                border-left: 1px solid gray;
                padding: 1em;
                overflow: hidden;
            }
        </style>
    </head>
    <body>
        
        <div class="container">
            
            <header>
                <h1>Login Operador </h1>
            </header>
             
            <nav>
                <ul>
                   <li><a href="customer_login.jsp">Cliente</a></li>
                   <li><a href="operator_login.jsp">Operador</a></li>
                   <li><a href="administrator_login.jsp">Administrador</a></li> 
                </ul>
            </nav>
            
            <article>
                <img src="oso.gif-c200" alt="HTML Icon" style="width:100px;height:100px;">             
             </article>
                       
            <article>
                <form action="OperatorLoginServlet" method="get">
                    <table>
                        <tr>
                            <td>
                                Nombre de usuario: 
                            </td>
                            <td>
                                <input type="text" name="username">
                            </td>
                        </tr>
                            
                        <tr>                    
                            <td>
                                Contraseña:
                            </td>
                            <td>
                                <input type="password" name="password">
                            </td>
                        </tr>
                            
                        <tr>
                            <td>
                                <input type="submit" value="Ingresar" />
                            </td>
                            <td>
                                <input type="reset" value="Cancelar" />
                            </td>
                        </tr>                
                    </table>
                </form>
            </article>
                
            <footer>Proyecto de programación 2</footer>
                
        </div>
            
    </body>
</html>