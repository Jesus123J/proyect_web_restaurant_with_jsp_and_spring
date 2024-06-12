<%-- 
    Document   : FormShowEmployee
    Created on : 24 may 2024, 2:59:04 p.m.
    Author     : Jesus Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h2>Mostrar Empleados</h2>
<label>
    Nombre:
    <input type="text" name="nombre" required>
</label>
<label>
    Fecha de Inicio:
    <input type="date" name="fechaInicio" required>
</label>
<label>
    Fecha de Salida:
    <input type="date" name="fechaSalida" required>
</label>
<div class="button-group">
    <button type="button" onclick="showEmployee()">Mostrar</button>
</div>
</form>
<h2>Lista de Empleados</h2>
<table>
    <thead>
        <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Hora de Entrada</th>
            <th>Hora de Salida</th>
            <th>Fecha</th>
        </tr>
    </thead>
    <tbody>
        <!-- Aquí se agregarán las filas de empleados dinámicamente -->
    </tbody>
</table>

