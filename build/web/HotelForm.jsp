<%-- 
    Document   : CadastroHotelForm
    Created on : Apr 22, 2018, 9:51:32 PM
    Author     : juliamourac
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Hotéis</title>
    </head>
    <body>
        <h1>Cadastro de hotel</h1>
        <p>Insira os dados:</p>
        <form action="NovoHotelServlet" method="POST">
            CNPJ: <input type="text" name="CNPJ" maxlength="14"/><br/>
            Nome: <input type="text" name="nome"/><br/>
            Cidade: <input type="text" name="cidade"/><br/>
            Senha: <input type="password" name="senha"/><br/>
            <input type="submit" text="Enviar"/>
        </form>
    </body>
</html>
