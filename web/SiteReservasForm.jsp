<%-- 
    Document   : cadastroSiteReservas
    Created on : 16/04/2018, 14:33:33
    Author     : 619655
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de sites de reservas</title>
    </head>
    <body>
        <h1>Novo site de reservas</h1>
        <c:if test="${!empty requestScope.messages}">
            <hr>
            <ul class="erro">
                <c:forEach items="${requestScope.messages}" var="message">
                    <li>${message}</li>
                    </c:forEach>
            </ul>
            <hr>
        </c:if>
        <form action="NovoSiteReservaServlet" method="POST">
            Endereço/URL: <input name="url" type="url" required/><br/>
            Nome do site: <input name="nome" type="text" required/><br/>
            Telefone: <input name="telefone" type="tel" required/><br/>
            Senha: <input  name="senha" type="password" required/><br/>            
            <input type="submit" text="Enviar"/>
            </form>
    </body>
</html>
