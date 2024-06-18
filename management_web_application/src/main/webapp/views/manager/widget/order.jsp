<%-- 
    Document   : order
    Created on : 17 jun 2024, 3:07:43 a.m.
    Author     : Jesus Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="content-pedido">
    <h2>Pedidos</h2>
    <label class="l-pedido">Insentar nombre del cliente  </label>
    <input class="nombre" type="text" placeholder="Nombre">
    <button  type="button" class="btn btn-primary b-pedido" data-toggle="modal" data-target="#exampleModalCenter"> Ver productos</button>
    <label class="l-pedido"> Precio total: <p align="center">12,20</p> </label>
    <button type="button" class="btn btn-primary b-pedido" data-toggle="modal" data-target="#exampleModalCenter">Registrar pedido</button>
    
</div>

<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>