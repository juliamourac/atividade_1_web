<%-- 
    Document   : ListaHoteis
    Created on : Apr 22, 2018, 9:52:07 PM
    Author     : juliamourac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotéis Cadastrados</title>
    </head>
    <body>
        <h1 align="center">Lista de Hotéis</h1>
        <hr>
        <c:if test="${empty requestScope.listaHoteis}">
            Não há hotéis!
        </c:if>
        <c:if test="${!empty requestScope.listaHoteis}">
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Cidade</th>
                </tr>
                <c:forEach items="${requestScope.listaHoteis}" var="hotel">
                    <tr>
                        <td>${hotel.nome}</td>
                        <td>${hotel.cidade}</td>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
