<%-- 
    Document   : FormCreateProduct
    Created on : 6 jun 2024, 23:19:13
    Author     : axele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    /* Reset y estilos base */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: sans-serif;
}

/* Estilo del cuerpo */
body {
    display: flex;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    background: linear-gradient(to right, #e32929, #f9b438);
}

/* Contenedor del formulario de productos */
.product-form {
    width: 90%;
    max-width: 1400px;
    background-color: #fff;
    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    padding: 40px;
    margin: 20px;
    overflow: hidden;
}

.product-form h2 {
    color: #333;
    margin-bottom: 20px;
}

.product-form label {
    display: flex;
    flex-direction: column;
    margin-bottom: 15px;
    font-size: 16px;
}

.product-form label input {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    margin-top: 5px;
}

.button-group {
    display: flex;
    justify-content: space-between;
    margin-top: 20px;
}

.button-group button {
    flex: 1;
    margin: 5px;
    padding: 15px;
    border: none;
    background: linear-gradient(to right, #e32929, #f9b438);
    color: white;
    font-size: 16px;
    cursor: pointer;
    border-radius: 4px;
    transition: background 0.3s ease;
}

.button-group button:hover {
    background: linear-gradient(to right, #d92626, #e69929);
}

/* Estilos para la tabla */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

table, th, td {
    border: 1px solid #ccc;
}

th, td {
    padding: 10px;
    text-align: left;
}

th {
    background-color: #f3f3f3;
    font-size: 16px;
}

tbody tr:nth-child(even) {
    background-color: #f9f9f9;
}

</style>

<html>
<head>
    
</head>
<body>
    <div class="product-form">
        <h2>Crear Producto</h2>
        <form id="createProductForm">
            <label>
                ID:
                <input type="text" name="id" required>
            </label>
            <label>
                ID Producto:
                <input type="text" name="idProducto" required>
            </label>
            <label>
                Código del Producto:
                <input type="text" name="codigoProducto" required>
            </label>
            <label>
                Nombre del Producto:
                <input type="text" name="nombreProducto" required>
            </label>
            <label>
                Precio Unitario:
                <input type="number" name="precioUnitario" step="0.01" required>
            </label>
            <label>
                Cantidad:
                <input type="number" name="cantidad" required>
            </label>
            <label>
                Precio del Producto:
                <input type="number" name="precioProducto" step="0.01" required>
            </label>
            <div class="button-group">
                <button type="button" onclick="addProduct()">Agregar</button>
                <button type="button" onclick="modifyProduct()">Modificar</button>
                <button type="button" onclick="updateProduct()">Actualizar</button>
                <button type="button" onclick="deleteProduct()">Eliminar</button>
            </div>
        </form>
        <h2>Lista de Productos</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ID Producto</th>
                    <th>Código del Producto</th>
                    <th>Nombre del Producto</th>
                    <th>Precio Unitario</th>
                    <th>Cantidad</th>
                    <th>Precio del Producto</th>
                </tr>
            </thead>
            <tbody>
                <!-- Aquí se agregarán las filas de productos dinámicamente -->
            </tbody>
        </table>
    </div>
</body>
</html>

