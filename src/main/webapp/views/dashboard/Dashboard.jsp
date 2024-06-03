<%-- 
    Document   : Dashboard
    Created on : 29 may 2024, 5:51:07 p.m.
    Author     : Jesus Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<main>
    <div align="center">
        <h1>Hola cliente</h1>
        <br>
        <form action="ControllerServlet" method="post">
              <input type="hidden" name="accion" value="dashboard">
                 <button type="submit" class="btn btn-primary">Loggin</button>
        </form>
    </div>
</main>
