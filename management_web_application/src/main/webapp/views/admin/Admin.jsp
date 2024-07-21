<%@page import="com.utp.management_web_application.data.rest.LoginResponse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="ajax/ajax.js" type="text/javascript"></script>
<%
    LoginResponse sessionAccount = (LoginResponse) request.getSession().getAttribute("sessionAccount");
%>
<body onload="cargarComponent()" >
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <div class="container">
        <div class="form-container left">
            <form id="leftForm">
                <button type="button" onclick="changeContainerRegisterEmployeeAdmin('<%=sessionAccount.getToken()%>')" class="admin-button">Crear Empleados</button>
                <button type="button" onclick="changeContainerShowOrderAdmin('<%=sessionAccount.getToken()%>')" class="admin-button">Ver pedidos</button>
                <button type="button" onclick="changeContainerShowStoreAdmin('<%=sessionAccount.getToken()%>')" class="admin-button">Crear Producto</button>
                <button type="button" onclick="window.location.href='<%= request.getContextPath() %>/home'" class="admin-button">Salir</button>
            </form>
        </div>
        <div class="form-container right" id="rightForm">
            <!-- Aquí se cargarán los formularios dinámicamente -->
        </div>
    </div>   

    <div class="modal fade" id="editEmployeeModalAccount" tabindex="-1" role="dialog" aria-labelledby="editEmployeeModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editEmployeeModalLabel">Editar Cuenta Empleado</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>    
                </div>
                <div class="modal-body">
                    <form id="editEmployeeFormAccount">
                        <input type="hidden" id="editEmployeeIdAccount">
                        <input type="hidden" id="editEmployeeAccountIdAccount">
                        <div class="form-group">
                            <label for="editEmployeeName">Editar Contraseña</label>
                            <input type="password" class="form-control" id="editEmployeePassword" required>
                        </div>
                        <button type="button" class="btn btn-primary" onclick="saveEditedAccountEmployee('<%=sessionAccount.getToken()%>')">Guardar Cambios</button>
                    </form>
                </div>
            </div>
        </div>
    </div>          

    <!-- Modal -->
    <div class="modal fade" id="editEmployeeModal" tabindex="-1" role="dialog" aria-labelledby="editEmployeeModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editEmployeeModalLabel">Editar Empleado</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="editEmployeeForm">
                        <input type="hidden" id="editEmployeeId">
                        <input type="hidden" id="editEmployeeAccountId">
                        <div class="form-group">
                            <label for="editEmployeeName">Nombre</label>
                            <input type="text" class="form-control" id="editEmployeeName" required>
                        </div>
                        <div class="form-group">
                            <label for="editEmployeeLastName">Apellido Paterno</label>
                            <input type="text" class="form-control" id="editEmployeeLastName" required>
                        </div>
                        <div class="form-group">
                            <label for="editEmployeeMotherLastName">Apellido Materno</label>
                            <input type="text" class="form-control" id="editEmployeeMotherLastName" required>
                        </div>
                        <div class="form-group">
                            <label for="editEmployeeEmail">Email</label>
                            <input type="email" class="form-control" id="editEmployeeEmail" required>
                        </div>
                        <div class="form-group">
                            <label for="editEmployeeCellphone">Celular</label>
                            <input type="text" class="form-control" id="editEmployeeCellphone" required>
                        </div>
                        <div class="form-group">
                            <label for="editEmployeeDni">DNI</label>
                            <input type="text" class="form-control" id="editEmployeeDni" required>
                        </div>
                        <div class="form-group">
                            <label>
                                Rol:
                                <select name="rol" id="rolSelect" required>
                                    <option value="" disabled selected>Seleccione un rol</option>
                                    <option value="2">Jefe</option>
                                    <option value="3">Gerente</option>
                                    <option value="4">Empleado</option>
                                </select>
                            </label>
                        </div>

                        <button type="button" class="btn btn-primary" onclick="saveEditedEmployee('<%=sessionAccount.getToken()%>')">Guardar Cambios</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
