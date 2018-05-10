<%-- 
    Document   : index
    Author     : juliamourac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Painel do Hotel</title>
    </head>
    <body>
        <h1>Opções</h1>
        
        <div>
            <a href=""></a> <br/>
            <a href="PreCadastroPromo">Cadastrar Promoção</a> <br/>
            <a href="ListarPromosServlet">Listar Promoções</a> <br/>
            <a href="ListarHoteisServlet">Listar todos os hotéis</a><br/>
            <p>Listar Hotéis por cidade</p>
            <form action="ListarHoteisServlet" method="POST">
                <p><input type="text" name="cidade"/></p>
                <input type="submit" text="Buscar"/>             
            </form>        
            <!--<a href=""></a> <br/>
            <a href=""></a> <br/>
            <a href=""></a> <br/>-->
        </div>
    </body>
</html>
