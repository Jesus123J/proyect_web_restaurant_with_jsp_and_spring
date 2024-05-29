<%-- 
    Document   : Login
    Created on : 28 may 2024, 3:03:11 p.m.
    Author     : Axel Angulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Enlace a la hoja de estilos de FontAwesome para usar iconos -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

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

    <img src="views/auth/resource/racoon-removebg-preview (1).png" alt=""/>
    <button type="submit" class="btn btn-primary">Ingresando Mapache</button>
</form>
