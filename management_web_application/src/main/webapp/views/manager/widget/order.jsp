<%-- 
    Document   : order
    Created on : 17 jun 2024, 3:07:43 a.m.
    Author     : Jesus Gutierrez
--%>

<%@page import="com.utp.management_web_application.data.rest.LoginResponse"%>
<%@page import="com.utp.management_web_application.data.dao.ManagerDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    /* Estilos básicos para el modal */
    .modal {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5);
        display: flex;
        justify-content: center;
        align-items: center;
        display: none; /* Oculto por defecto */
    }
    .modal-dialog {
        background-color: white;
        padding: 20px;
        border-radius: 5px;
        width: 80%;
        max-width: 600px;
    }
    .modal-header, .modal-footer {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    .close {
        background: none;
        border: none;
        font-size: 1.5rem;
        cursor: pointer;
    }
</style>

<%
    String token = ((LoginResponse) request.getSession().getAttribute("sessionAccount")).getToken();

%>
<div class="content-pedido">
    <h2>Pedidos</h2>
    <label class="l-pedido">Insertar nombre del cliente</label>
    <input class="nombre" type="text" placeholder="Nombre">
    <button type="button" class="btn btn-primary b-pedido" onclick="openModal()">Ver productos</button>
    <label class="l-pedido">Precio total: <p align="center">12.20</p></label>
    <button type="button" class="btn btn-primary b-pedido" onclick="openModal()">Registrar pedido</button>
</div>

<div class="modal" id="exampleModalCenter">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="close" onclick="closeModal()">&times;</button>
            </div>
            <div class="modal-body">
                <!-- La tabla se insertará aquí -->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick="closeModal()">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
