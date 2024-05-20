<%-- 
    Document   : Gerente
    Created on : 19 may 2024, 19:22:14
    Author     : axele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin</title>
        <!-- Enlace a la hoja de estilos de FontAwesome para usar iconos -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
              integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Enlace a tu hoja de estilos CSS -->
        <link href="EstiloAdmin.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>

        <div class="container">
            <div class="form-container left">
                <form id="leftForm">
                    <img id="mapacheAdmin", src="imagenes/843c0430e1c72c93e41fdd5e3962c330.jpg" alt=""/>
                    <button type="button" onclick="changeRightForm('form1')">Crear Empleados</button>
                    <button type="button" onclick="changeRightForm('form2')">Inventario</button>
                    <button type="button" onclick="changeRightForm('form3')">Ver pedidos</button>
                    <button type="button" onclick="changeRightForm('form4')">Ver empleados</button>
                </form>
            </div>
            <div class="form-container right">
                <form id="rightForm">
                    <!-- Aquí se cargarán los formularios dinámicamente -->
                </form>
            </div>
        </div>

    </body>

</html>