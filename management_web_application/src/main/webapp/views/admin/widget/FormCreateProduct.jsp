<%-- 
    Document   : FormCreateProduct
    Created on : 6 jun 2024, 23:19:13
    Author     : axele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h2>Crear Producto</h2>
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
