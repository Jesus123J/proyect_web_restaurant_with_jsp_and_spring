<%-- 
    Document   : employee
    Created on : 17 jun 2024, 3:08:07 a.m.
    Author     : Jesus Gutierrez
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Empleados</h2>
<button type="button" id="btnDownloadPDF" onclick="downloadPDF()" class="btn btn-primary">Generar PDF</button>
 <button type="button" id="btnDownloadExcel" onclick="downloadExcel()" class="btn btn-success">Generar Excel</button>
<input class="buscador" type="search" placeholder="Buscar">
<table class="table table-success table-striped">
    <thead>
        <tr class="table-info">
            <th>Nombre Completo</th>
            <th>E-mail</th>
            <th>Celular</th>
            <th>DNI</th>
            <th>Rol</th>
        </tr>
    </thead>
    <tbody id="employeeTableBody">
        <!-- Los empleados se llenarán dinámicamente aquí -->
    </tbody>

</table> 
