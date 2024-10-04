<%-- 
    Document   : FormShowEmployee
    Created on : 24 may 2024, 2:59:04 p.m.
    Author     : Jesus Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="form-container right">
    <form class="report-form">
        <h2>Generar Reporte de Pedidos</h2>
        <label>
            Fecha de Entrada:
            <input type="date" name="fechaEntrada" required>
        </label>
        <label>
            Fecha de Salida:
            <input type="date" name="fechaSalida" required>
        </label>
        <button type="button" onclick="generateReport()">Generar Reporte de Pedidos</button>
    </form>
</div>

