<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="ajax/ajax.js" type="text/javascript"></script>

<div class="container">
    <div class="form-container left">
        <form id="leftForm">
            <button type="button" onclick="changeContainerRegisterEmployeeAdmin()">Crear Empleados</button>
            <button type="button" onclick="changeContainerShowStoreAdmin()">Inventario</button>
            <button type="button" onclick="changeContainerShowOrderAdmin()">Ver pedidos</button>
            <button type="button" onclick="changeContainerShowEmployeeAdmin()">Ver empleados</button>
        </form>
    </div>
    <div class="form-container right" id ="rightForm">

    </div>
</div>

