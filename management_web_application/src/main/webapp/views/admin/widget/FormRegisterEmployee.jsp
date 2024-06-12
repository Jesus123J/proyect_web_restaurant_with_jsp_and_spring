<%-- 
    Document   : FormRegisterEmployee
    Created on : 24 may 2024, 2:58:30 p.m.
    Author     : Jesus Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h2>Crear Empleados</h2>
<label>
    Nombre:
    <input type="text" name="nombre" required>
</label>
<label>
    Apellido Paterno:
    <input type="text" name="apellidoPaterno" required>
</label>
<label>
    Apellido Materno:
    <input type="text" name="apellidoMaterno" required>
</label>
<label>
    Email:
    <input type="email" name="email" required>
</label>
<label>
    Celular:
    <input type="text" name="celular" required>
</label>
<label>
    DNI:
    <input type="text" name="dni" required>
</label>
<label>
    Rol:
    <input type="text" name="rol" required>
</label>
<div class="button-group">
    <button type="button" onclick="addEmployee()">Agregar</button>
    <button type="button" onclick="updateEmployee()">Modificar</button>
    <button type="button" onclick="saveEmployee()">Actualizar</button>
    <button type="button" onclick="deleteEmployee()">Eliminar</button>
</div>
