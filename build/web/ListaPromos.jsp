<%-- 
    Document   : ListaPromos
    Created on : Apr 22, 2018, 9:53:16 PM
    Author     : juliamourac
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promoções</title>
    </head>
    <body>
        <h1 align="center">Lista de Promoções</h1>
        <c:if test="${empty requestScope.listapromos}">
            Não há promoções!
        </c:if>
        <c:if test="${!empty requestScope.listapromos}">
            <table>
                <tr>
                    <th>CNPJ</th>
                    <th>URL</th>
                    <th>Preço</th>
                    <th>Data de Início</th>
                    <th>Data Final</th>
                </tr>
                <c:forEach items="${requestScope.listapromos}" var="hotel">
                    <tr>
                        <td>${promo.cnpj}</td>
                        <td>${promo.url}</td>
                        <td>${promo.preco}</td>
                        <td>${promo.dataInicio}</td>
                        <td>${promo.dataFim}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
