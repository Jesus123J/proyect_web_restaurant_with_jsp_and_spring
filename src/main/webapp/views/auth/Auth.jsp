<%-- 
    Document   : Login
    Created on : 24 may 2024, 3:03:11 p.m.
    Author     : Jesus Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="ControllerServlet" method="POST">
    <input type="hidden" name="accion" value="loginService">
    <h1 class="title">Login</h1>
    <label> 
        <i class="fa-solid fa-user"></i>
        <input type="text" id="username" name="username">
    </label>
    <label> 
        <i class="fa-solid fa-lock"></i>
        <input type="password" id="contraseña" name="password">
    </label>
    <a href="#" class="link">Olvidaste tu contraseña, causa?</a>
    <!--  <img src="imagenes/racoon-removebg-preview (1).png" alt=""/>  -->   
    <button type="submit" class="btn btn-primary">Ingresando Mapache</button>
</form>
