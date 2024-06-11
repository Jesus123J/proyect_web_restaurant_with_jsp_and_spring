<%-- 
    Document   : Employee
    Created on : 27 may 2024, 10:50:29 a.m.
    Author     : Jesus Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<main>
    <div class="hamburger" onclick="toggleMenu()">
        <div></div>
        <div></div>
        <div></div>
    </div>
    <div id="container-main">
        <div id="container-left">
            <!-- Contenido de la izquierda -->
            Contenido del menú de la izquierda.
        </div>
        <div id="container-right">
            <!-- Contenido de la derecha -->
            Contenido principal de la derecha.
        </div>
    </div>
</main>
<script>
    function toggleMenu() {
        var containerLeft = document.getElementById('container-left');
        if (containerLeft.style.display === 'none' || containerLeft.style.display === '') {
            containerLeft.style.display = 'block';
        } else {
            containerLeft.style.display = 'none';
        }
    }
</script>