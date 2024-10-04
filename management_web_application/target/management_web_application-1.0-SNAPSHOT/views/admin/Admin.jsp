<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="ajax/ajax.js" type="text/javascript"></script>
<body onload="cargarComponent()" >
    <div class="container">
        <div class="form-container left">
            <form id="leftForm">
                <button type="button" onclick="changeContainerRegisterEmployeeAdmin()" class="admin-button">Crear Empleados</button>
                <button type="button" onclick="changeContainerShowOrderAdmin()" class="admin-button">Ver pedidos</button>
                <button type="button" onclick="changeContainerShowEmployeeAdmin()" class="admin-button">Reportes</button>
                <button type="button" onclick="changeContainerShowStoreAdmin()" class="admin-button">Crear Producto</button>
            </form>
        </div>
        <div class="form-container right" id="rightForm">
            <!-- Aquí se cargarán los formularios dinámicamente -->
        </div>
    </div>   
</body>
