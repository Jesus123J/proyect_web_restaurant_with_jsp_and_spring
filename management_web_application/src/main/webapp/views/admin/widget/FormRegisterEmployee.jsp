<%-- 
    Document   : FormRegisterEmployee
    Created on : 24 may 2024, 2:58:30 p.m.
    Author     : Jesus Gutierrez
--%>

<%@page import="com.utp.management_web_application.data.rest.LoginResponse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    LoginResponse sessionAccount = (LoginResponse) request.getSession().getAttribute("sessionAccount");
%>
<!DOCTYPE html>

<form>
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
        <select name="rol" id="rolSelect" required>
            <option value="" disabled selected>Seleccione un rol</option>
            <option value="2">Jefe</option>
            <option value="3">Gerente</option>
            <option value="4">Empleado</option>
        </select>
    </label>

    <div class="button-group">
        <button type="button" onclick="addEmployee('<%=sessionAccount.getToken()%>')">Agregar</button>
    </div>
</form>
<h2>Lista de Empleados</h2>
<div class="table-container">
    <table id="employeeTable">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Apellido Paterno</th>
                <th>Apellido Materno</th>
                <th>Email</th>
                <th>Celular</th>
                <th>DNI</th>
                <th>Rol</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody id="employeeTableBody">
            <!-- Aquí se agregarán las filas de empleados dinámicamente -->
        </tbody>
    </table>
</div>



