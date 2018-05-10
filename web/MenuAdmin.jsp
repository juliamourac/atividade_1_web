<%-- 
    Document   : MenuAdmin
    Author     : juliamourac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
    </head>
    <body>
        <h1>Opções de administrador:</h1>
        <a href="SiteReservasForm.jsp">Cadastrar site de reservas</a> <br/>
        <a href="HotelForm.jsp">Cadastrar Hotel</a><br/>
        <a href="ListarHoteisServlet">Listar todos os hotéis</a><br/>
        <p>Listar Hotéis por cidade</p>
            <form action="ListarHoteisServlet" method="POST">
                <p><input type="text" name="cidade"/></p>
                <input type="submit" text="Buscar"/>             
            </form>        
    </body>
</html>
