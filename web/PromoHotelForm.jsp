    <%-- 
    Document   : PromoHotelForm
    Author     : juliamourac
--%>
<%@page import="dc.ufscar.web.beans.SiteReservas"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar promoção</title>
    </head>
    <body>
        <h1>Criar promoção</h1>
        <hr>
        <c:if test="${!empty requestScope.mensagens}">
            <ul class="erro">
                <c:forEach items="${requestScope.mensagens}" var="mensagem">
                    <li>${mensagem}</li>
                    </c:forEach>
            </ul>
            <hr>
        </c:if>
        <br/>
        <form action="NovaPromoServlet" method="POST">
            <p>Endereço/URL: <select name="url">
                    <option disabled selected hidden>Selecione uma opção</option>
                    <c:forEach items="${requestScope.listaurl}" var="url">
                        <option value="${url}">${url}</option>
                    </c:forEach>
                </select></p>
            <p>CNPJ: <input type="text" name="cnpj" maxlength="14" value="${sessionScope.username}"/></p>
            <p>Preço: <input type="text" name="preco"/></p>
            <p>Data de início: <input type="date" name="dataInicio"/></p>
            <p>Data de término: <input type="date" name="dataFim"/></p>
            <input type="submit" text="Enviar"/>
        </form>
    </body>
</html>
