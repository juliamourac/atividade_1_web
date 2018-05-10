<%-- 
    Document   : index
    Author     : juliamourac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem-Vindo!</title>
    </head>
    <body>
        <h1>Logar</h1>
        <form action="LogarServlet" method="POST">
            <input type="text" name="username"/>
            <input type="password" name="senha"/>
            <input type="submit" text="Enviar"/>
        </form>
        
        <h1>Menu</h1>
        <a href="ListarHoteisServlet">Listar todos os hotéis</a><br/>
        <p>Listar Hotéis por cidade</p>
            <form action="ListarHoteisServlet" method="POST">
                <p><input type="text" name="cidade"/></p>
                <input type="submit" text="Buscar"/>             
            </form>        
    </body>
</html>
