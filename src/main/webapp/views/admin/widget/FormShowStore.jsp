<%-- 
    Document   : FormShowStore
    Created on : 24 may 2024, 2:57:19 p.m.
    Author     : Jesus Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Inventario</h2>
<label for="nombre">Nombre:</label>
<input type="text" id="nombre" name="nombre" required>
<label for="tipo">Tipo:</label>
<input type="text" id="tipo" name="tipo" required>
<label for="cantidad">Cantidad:</label>
<input type="number" id="cantidad" name="cantidad" required>
<button type="submit">Actualizar Datos</button>
<h2>Lista de Inventario</h2>
<table>
    <thead>
        <tr>
            <th>Nombre</th>
            <th>Tipo</th>
            <th>Cantidad</th>
        </tr>
    </thead>
    <tbody>
        <!-- Aquí se agregarán las filas del inventario dinámicamente -->
    </tbody>
</table>
