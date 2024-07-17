<%-- 
    Document   : order
    Created on : 17 jun 2024, 3:07:43 a.m.
    Author     : Jesus Gutierrez
--%>

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

<div class="content-pedido">
    <h2>Pedidos</h2>
    <label class="l-pedido">Insertar nombre del cliente</label>
    <input class="nombre" type="text" placeholder="Nombre">
    <button type="button" class="btn btn-primary b-pedido" onclick="openModal()">Ver productos</button>
    <label class="l-pedido">Precio total: <p align="center">12,20</p></label>
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

<script>
    async function listaProductos(token) {
        try {
            const response = await fetch('http://localhost:9091/employee/manager/product/list', {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': token
                }
            });

            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }

            const data = await response.json();
            console.log(data);

            // Crear la tabla y añadir los datos de los productos
            let tableHtml = '<table class="table">';
            tableHtml += '<thead><tr><th>ID</th><th>Código</th><th>Nombre</th><th>Precio</th></tr></thead>';
            tableHtml += '<tbody>';

            data.managerProducts.forEach(product => {
                tableHtml += `<tr>
                                <td>${product.id}</td>
                                <td>${product.code}</td>
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                              </tr>`;
            });

            tableHtml += '</tbody></table>';

            // Insertar la tabla en el modal
            document.querySelector('#exampleModalCenter .modal-body').innerHTML = tableHtml;

        } catch (error) {
            console.error('There was a problem with the fetch operation:', error);
        }
    }

    function openModal() {
        document.getElementById('exampleModalCenter').style.display = 'flex';
        listaProductos('your-auth-token-here'); // Reemplaza con el token real
    }

    function closeModal() {
        document.getElementById('exampleModalCenter').style.display = 'none';
    }
</script>