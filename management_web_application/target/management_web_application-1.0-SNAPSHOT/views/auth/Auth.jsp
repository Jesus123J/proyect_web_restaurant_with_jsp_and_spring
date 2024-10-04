<%-- 
    Document   : Login
    Created on : 28 may 2024, 3:03:11 p.m.
    Author     : Axel Angulo
--%>


<%@page import="java.util.Set"%>
<%@page import="javax.validation.ConstraintViolation"%>
<%@page import="com.utp.management_web_application.data.dto.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Enlace a la hoja de estilos de FontAwesome para usar iconos -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<form action="<%= request.getContextPath() + "/login"%>" method="POST">
    <input type="hidden" name="action" value="loginService">
    <h1 class="title">Login</h1>
    <label> 
        <i class="fa-solid fa-user"></i>
        <input type="text" id="username" name="username">

    </label>
    <label> 
        <i class="fa-solid fa-lock"></i>
        <input type="password" id="contraseña" name="password">
    </label>
    <%
        try {
            Set<ConstraintViolation<Account>> errors = (Set<ConstraintViolation<Account>>) request.getAttribute("errors");

            if (errors != null) {
    %>
    <div>
        <% for (ConstraintViolation<Account> error : errors) {%>
        <p style="color: red;"><%= error.getMessage()%></p>
        <% } %>
    </div>
    <% }
    } catch (Exception e) {
        String errors = (String) request.getAttribute("errors");
        if (errors != null) {
    %>
    <p style="color: red;"><%= errors%></p>
    <%
            }
        }
    %>

    <a href="#" class="link">Olvidaste tu contraseña, causa?</a>

    <img src="views/auth/resource/racoon-removebg-preview (1).png" alt=""/>
    <button type="submit" class="btn btn-primary">Ingresando Mapache</button>
</form>
