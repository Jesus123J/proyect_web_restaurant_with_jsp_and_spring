<%-- 
    Document   : Employee
    Created on : 27 may. 2024, 8:19:37 p. m.
    Author     : Joshua Jose
--%>
<%@page import="com.utp.management_web_application.data.rest.LoginResponse"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<main>
    <%
        LoginResponse sessionAccount = (LoginResponse) request.getSession().getAttribute("sessionAccount");
    %>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
            <script src="ajax/ajax.js" type="text/javascript"></script>
            <meta name="viewport" content="width=device-width, initial-scale=1">
                <a><%=sessionAccount.getToken()%></a>
                <!-- Bootstrap CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
                      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                    <link rel="stylesheet" href=".css">
                        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
                            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-timepicker@0.5.2/css/bootstrap-timepicker.min.css">
                                    <!-- jQuery and Bootstrap JS -->
                                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
                                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
                                    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
                                    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.es.min.js"></script>

                                    <script>
                                        $(document).ready(function () {
                                            // Inicializar datepickers
                                            $('.datepicker').datepicker({
                                                format: 'yyyy-mm-dd',
                                                language: 'es',
                                                autoclose: true,
                                                todayHighlight: true
                                            });

                                            // Inicializar timepickers
                                            $('.timepicker').timepicker({
                                                minuteStep: 1,
                                                language: 'es',
                                                showMeridian: false,
                                                defaultTime: false,
                                                autoclose: true,
                                                todayHighlight: true
                                            });
                                        });

                                        function deleteRow(button) {
                                            var row = button.parentNode.parentNode;
                                            row.parentNode.removeChild(row);
                                        }

                                        function addRow(tableId) {
                                            var table = document.getElementById(tableId).getElementsByTagName('tbody')[0];
                                            var newRow = table.insertRow();

                                            switch (tableId) {
                                                case 'ingresoTable':
                                                    addEmptyRow(newRow, 2); // Dos celdas (Fecha y Hora de Ingreso)
                                                    break;
                                                case 'salidaTable':
                                                    addEmptyRow(newRow, 2); // Dos celdas (Fecha y Hora de Salida)
                                                    break;
                                                case 'faltasTable':
                                                    addFaltasRow(newRow, 2); // Dos celdas (Fecha y Motivo)
                                                    break;
                                                case 'descansosTable':
                                                    addDescansosRow(newRow, 5); // Cinco celdas (Apellidos, Nombres, Fecha, Hora de Inicio y Hora de Fin)
                                                    break;
                                                default:
                                                    break;
                                            }

                                            var actionCell = newRow.insertCell(-1);
                                            var deleteButton = document.createElement('button');
                                            deleteButton.className = 'btn btn-danger';
                                            deleteButton.textContent = 'Eliminar';
                                            deleteButton.onclick = function () {
                                                deleteRow(this);
                                            };
                                            actionCell.appendChild(deleteButton);

                                            var dialog = new bootstrap.Modal(document.getElementById('exampleModal'));
                                            dialog.show();

                                            // Reinicializar los datepickers para la nueva fila
                                            $('.datepicker').datepicker('update');
                                            // Reinicializar los timepickers para la nueva fila
                                            $('.timepicker').timepicker('update');
                                        }

                                        function addEmptyRow(row, numCells) {
                                            for (var i = 0; i < numCells; i++) {
                                                var newCell = row.insertCell(i);
                                                var input = document.createElement('input');
                                                input.type = 'text';
                                                input.className = 'form-control';

                                                if (i === 0) { // Asumiendo que la primera celda es para la fecha (datepicker)
                                                    input.className += ' datepicker';
                                                    input.placeholder = 'yyyy-mm-dd';
                                                } else if (i === 1) { // Asumiendo que la segunda celda es para la hora (timepicker)
                                                    input.className += ' timepicker';
                                                    input.placeholder = 'HH:mm';
                                                }

                                                newCell.appendChild(input);
                                            }
                                        }

                                        function addFaltasRow(row, numCells) {
                                            for (var i = 0; i < numCells; i++) {
                                                var newCell = row.insertCell(i);
                                                var input = document.createElement('input');
                                                input.type = 'text';
                                                input.className = 'form-control';

                                                if (i === 0) { // Asumiendo que la primera celda es para la fecha (datepicker)
                                                    input.className += ' datepicker';
                                                    input.placeholder = 'yyyy-mm-dd';
                                                } else if (i === 1) { // Asumiendo que la segunda celda es para el motivo (texto)
                                                    input.placeholder = "Motivo";
                                                }

                                                newCell.appendChild(input);
                                            }
                                        }

                                        function addDescansosRow(row, numCells) {
                                            for (var i = 0; i < numCells; i++) {
                                                var newCell = row.insertCell(i);
                                                var input = document.createElement('input');
                                                input.type = 'text';
                                                input.className = 'form-control';

                                                if (i === 0) { // Primera celda para Apellidos
                                                    input.placeholder = 'Apellidos';
                                                } else if (i === 1) { // Segunda celda para Nombres
                                                    input.placeholder = 'Nombres';
                                                } else if (i === 2) { // Tercera celda para la fecha (datepicker)
                                                    input.className += ' datepicker';
                                                    input.placeholder = 'yyyy-mm-dd';
                                                } else if (i === 3 || i === 4) { // Cuarta y Quinta celdas para la hora (timepicker)
                                                    input.className += ' timepicker';
                                                    input.placeholder = 'HH:mm';
                                                }

                                                newCell.appendChild(input);
                                            }
                                        }
                                        function guardarDatos() {
                                            var datos = {
                                                ingresos: [],
                                                salidas: [],
                                                faltas: [],
                                                descansos: []
                                            };

                                            // Capturar datos de ingresos desde el modal
                                            var ingresoFecha = $('#modalIngresoFecha').val();
                                            var ingresoHora = $('#modalIngresoHora').val();
                                            var ingresoObjeto = {
                                                fecha: ingresoFecha,
                                                hora: ingresoHora
                                            };
                                            datos.ingresos.push(ingresoObjeto);

                                            // Capturar datos de salidas desde el modal
                                            var salidaFecha = $('#modalSalidaFecha').val();
                                            var salidaHora = $('#modalSalidaHora').val();
                                            var salidaObjeto = {
                                                fecha: salidaFecha,
                                                hora: salidaHora
                                            };
                                            datos.salidas.push(salidaObjeto);

                                            // Capturar datos de faltas desde el modal
                                            var faltaFecha = $('#modalFaltaFecha').val();
                                            var faltaMotivo = $('#modalFaltaMotivo').val();
                                            var faltaObjeto = {
                                                fecha: faltaFecha,
                                                motivo: faltaMotivo
                                            };
                                            datos.faltas.push(faltaObjeto);

                                            // Capturar datos de descansos desde el modal
                                            var descansoApellidos = $('#modalDescansoApellidos').val();
                                            var descansoNombres = $('#modalDescansoNombres').val();
                                            var descansoFecha = $('#modalDescansoFecha').val();
                                            var descansoHoraInicio = $('#modalDescansoHoraInicio').val();
                                            var descansoHoraFin = $('#modalDescansoHoraFin').val();
                                            var descansoObjeto = {
                                                apellidos: descansoApellidos,
                                                nombres: descansoNombres,
                                                fecha: descansoFecha,
                                                horaInicio: descansoHoraInicio,
                                                horaFin: descansoHoraFin
                                            };
                                            datos.descansos.push(descansoObjeto);

                                            console.log(datos);

                                            // Aquí deberías hacer lo que necesites con los datos, por ejemplo, enviarlos al servidor
                                            // usando AJAX para almacenarlos en la base de datos, etc.

                                            // Cerrar el modal después de guardar
                                            var dialog = new bootstrap.Modal(document.getElementById('exampleModal'));
                                            dialog.hide();
                                        }


                                    </script>

                                    <style>
                                        body {
                                            background: rgb(131,58,180);
                                            background: linear-gradient(90deg, rgba(131,58,180,1) 0%, rgba(253,29,29,1) 50%, rgba(252,176,69,1) 100%);
                                        }
                                        .table {
                                            width: 100%;
                                            margin-bottom: 1rem;
                                            background-color: #dc3545;
                                            color: #dc3545;
                                            border-collapse: collapse;
                                            border-radius: 0.5rem;
                                            overflow: hidden;
                                            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
                                        }

                                        /* Estilo de cabecera de tabla */
                                        .table thead {
                                            background-color: #f8f9fa;
                                            color: #6c757d;
                                        }

                                        /* Estilo de las celdas del cuerpo de la tabla */
                                        .table tbody tr {
                                            transition: background-color 0.3s ease;
                                        }

                                        /* Estilo de las celdas del cuerpo al pasar el mouse */
                                        .table tbody tr:hover {
                                            background-color: rgba(0, 0, 0, 0.075);
                                        }

                                        /* Estilo para las acciones (botones) */
                                        .table.btn {
                                            padding: 0.375rem 0.75rem;
                                            font-size: 0.875rem;
                                            line-height: 1.5;
                                            border-radius: 0.25rem;
                                        }

                                        /* Estilo para las celdas de la primera columna con fecha */
                                        .table tbody td:first-child {
                                            min-width: 150px; /* Ajustar ancho mínimo para la columna de fecha */
                                        }

                                        /* Ajuste específico para los botones de eliminar */
                                        .table .btn-danger {
                                            background-color: #dc3545;
                                            border-color: #dc3545;
                                        }

                                        /* Ajuste para los botones de agregar */
                                        .btn-success {
                                            background-color: #198754;
                                            border-color: #198754;
                                        }

                                        /* Estilos para las tablas */
                                        .table {
                                            background-color: rgba(255, 193, 7, 0.2); /* Color amarillo translúcido */
                                            border-radius: 10px; /* Bordes redondeados */
                                            border: 1px solid rgba(255, 193, 7, 0.5); /* Borde amarillo más oscuro */
                                        }

                                        .table-striped tbody tr:nth-of-type(odd) {
                                            background-color: rgba(255, 193, 7, 0.1); /* Color de fondo para filas impares */
                                        }

                                        .sidebar {
                                            width: 200px;
                                            height: 100vh;
                                            position: fixed;
                                            top: 0;
                                            left: 0;
                                            background-color: #343a40;
                                            padding-top: 20px;
                                            z-index: 1000;
                                        }

                                        .sidebar a {
                                            padding: 10px 15px;
                                            text-decoration: none;
                                            font-size: 18px;
                                            color: white;
                                            display: block;
                                        }

                                        .sidebar a:hover {
                                            background-color: #575d63;
                                        }

                                        .icono-derecho {
                                            position: fixed; /* Fija el icono en la pantalla */
                                            right: 0.4%; /* Alinea el icono al lado derecho de la pantalla */
                                            top: 50%; /* Posiciona el icono a la mitad de la pantalla verticalmente */
                                            transform: translateY(-60%); /* Centra el icono verticalmente */
                                        }

                                        .icono-derecho img {
                                            display: block; /* Asegura que la imagen no tenga espacio adicional alrededor */
                                            width: 50px; /* Ancho del icono */
                                            height: auto; /* Altura automática para mantener la proporción */
                                        }
                                        .icono-derecho {
                                            position: fixed;
                                            right: 0.4%;
                                            top: 50%;
                                            transform: translateY(-50%);
                                        }

                                        .icono-derecho img {
                                            display: block;
                                            width: 50px; /* Ancho del icono */
                                            height: auto; /* Altura automática para mantener la proporción */
                                        }

                                        .icono-derecho::after {
                                            content: " RACOON      BROTHERS";
                                            display: block;
                                            position: absolute;
                                            top: 50%;
                                            left: 50%;
                                            transform: translate(-50%, -50%) rotate(90deg);
                                            font-style: normal;
                                            font-size: 1.5em;
                                            text-align: left;
                                            white-space: pre;
                                            letter-spacing: 5px;
                                            word-spacing: 10px;
                                        }

                                        .icono-derecho::after span {
                                            display: block;
                                        }

                                        .icono-derecho::after span:nth-child(2) {
                                            margin-top: 30px; /* Ajusta esta medida para bajar "BROTHERS" */
                                        }

                                        .offcanvas {
                                            background-color: #343a40; /* Cambia este color al que desees */
                                            color: white; /* Cambia el color del texto si es necesario */
                                            width: 200px; /* Ancho del offcanvas */
                                        }
                                        .content.bg-warning {
                                            background-color: #ffc107; /* Cambia el color de fondo a amarillo */
                                            padding: 20px; /* Añade un espacio de relleno para separar el contenido del borde */
                                            margin: 0; /* Elimina cualquier margen predeterminado */
                                            height: 90vh; /* Asegura que ocupe toda la altura del viewport */
                                        }

                                        body {
                                            background: rgb(131,58,180);
                                            background: linear-gradient(90deg, rgba(131,58,180,1) 0%, rgba(253,29,29,1) 50%, rgba(252,176,69,1) 100%);
                                        }
                                        .table {
                                            width: 100%;
                                            margin-bottom: 1rem;
                                            background-color: #dc3545;
                                            color: black;
                                            border-collapse: collapse;
                                            border-radius: 0.5rem;
                                            overflow: hidden;
                                            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
                                        }

                                        /* Estilo de cabecera de tabla */
                                        .table thead {
                                            background-color: #f8f9fa;
                                            color: #6c757d;
                                        }

                                        /* Estilo de las celdas del cuerpo de la tabla */
                                        .table tbody tr {
                                            transition: background-color 0.3s ease;
                                        }

                                        /* Estilo de las celdas del cuerpo al pasar el mouse */
                                        .table tbody tr:hover {
                                            background-color: rgba(0, 0, 0, 0.075);
                                        }

                                        /* Estilo para las acciones (botones) */
                                        .table.btn {
                                            padding: 0.375rem 0.75rem;
                                            font-size: 0.875rem;
                                            line-height: 1.5;
                                            border-radius: 0.25rem;
                                        }

                                        /* Estilo para las celdas de la primera columna con fecha */
                                        .table tbody td:first-child {
                                            min-width: 150px; /* Ajustar ancho mínimo para la columna de fecha */
                                        }

                                        /* Ajuste específico para los botones de eliminar */
                                        .table .btn-danger {
                                            background-color: #dc3545;
                                            border-color: #dc3545;
                                        }

                                        /* Ajuste para los botones de agregar */
                                        .btn-success {
                                            background-color: #198754;
                                            border-color: #198754;
                                        }

                                        /* Estilos para las tablas */
                                        .table {
                                            background-color: rgba(255, 193, 7, 0.2); /* Color amarillo translúcido */
                                            border-radius: 10px; /* Bordes redondeados */
                                            border: 1px solid rgba(255, 193, 7, 0.5); /* Borde amarillo más oscuro */
                                        }

                                        .table-striped tbody tr:nth-of-type(odd) {
                                            background-color: rgba(255, 193, 7, 0.1); /* Color de fondo para filas impares */
                                        }

                                        .sidebar {
                                            width: 200px;
                                            height: 100vh;
                                            position: fixed;
                                            top: 0;
                                            left: 0;
                                            background-color: #343a40;
                                            padding-top: 20px;
                                            z-index: 1000;
                                        }

                                        .sidebar a {
                                            padding: 10px 15px;
                                            text-decoration: none;
                                            font-size: 18px;
                                            color: white;
                                            display: block;
                                        }

                                        .sidebar a:hover {
                                            background-color: #575d63;
                                        }

                                        .icono-derecho {
                                            position: fixed; /* Fija el icono en la pantalla */
                                            right: 0.4%; /* Alinea el icono al lado derecho de la pantalla */
                                            top: 50%; /* Posiciona el icono a la mitad de la pantalla verticalmente */
                                            transform: translateY(-60%); /* Centra el icono verticalmente */
                                        }

                                        .icono-derecho img {
                                            display: block; /* Asegura que la imagen no tenga espacio adicional alrededor */
                                            width: 50px; /* Ancho del icono */
                                            height: auto; /* Altura automática para mantener la proporción */
                                        }
                                        .icono-derecho {
                                            position: fixed;
                                            right: 0.4%;
                                            top: 50%;
                                            transform: translateY(-50%);
                                        }

                                        .icono-derecho img {
                                            display: block;
                                            width: 50px; /* Ancho del icono */
                                            height: auto; /* Altura automática para mantener la proporción */
                                        }

                                        .icono-derecho::after {
                                            content: " RACOON      BROTHERS";
                                            display: block;
                                            position: absolute;
                                            top: 50%;
                                            left: 50%;
                                            transform: translate(-50%, -50%) rotate(90deg);
                                            font-style: normal;
                                            font-size: 1.5em;
                                            text-align: left;
                                            white-space: pre;
                                            letter-spacing: 5px;
                                            word-spacing: 10px;
                                        }

                                        .icono-derecho::after span {
                                            display: block;
                                        }

                                        .icono-derecho::after span:nth-child(2) {
                                            margin-top: 30px; /* Ajusta esta medida para bajar "BROTHERS" */
                                        }

                                        .offcanvas {
                                            background-color: #343a40; /* Cambia este color al que desees */
                                            color: white; /* Cambia el color del texto si es necesario */
                                            width: 200px; /* Ancho del offcanvas */
                                        }
                                        .content.bg-warning {
                                            background-color: #ffc107; /* Cambia el color de fondo a amarillo */
                                            padding: 20px; /* Añade un espacio de relleno para separar el contenido del borde */
                                            margin: 0; /* Elimina cualquier margen predeterminado */
                                            height: 90vh; /* Asegura que ocupe toda la altura del viewport */
                                        }


                                    </style>
                                    </head>
                                    <!-- Botón para abrir el sidebar -->

                                    <button class="btn btn-warning"  type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasSidebar" aria-controls="offcanvasSidebar">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 0-1h11a.5.5 0 0 1 0 1h-11zm0-5a.5.5 0 0 1 0-1h11a.5.5 0 0 1 0 1h-11zm0-5a.5.5 0 0 1 0-1h11a.5.5 0 0 1 0 1h-11z"/>
                                        </svg>
                                    </button>

                                    <body>
                                        <!-- Sidebar -->
                                        <div class="icono-derecho">
                                            <img src="https://cdn-icons-png.flaticon.com/512/5787/5787016.png" alt="Icono">
                                        </div>
                                        <div class= "offcanvas offcanvas-start  " tabindex="-1" id="offcanvasSidebar" aria-labelledby="offcanvasSidebarLabel ">

                                            <div class="offcanvas-header">

                                                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                                            </div>

                                            <div class="offcanvas-body sidebar">
                                                <a href="<%= request.getContextPath()%>/login"><svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-door-open-fill" viewBox="0 0 16 16">
                                                        <path d="M1.5 15a.5.5 0 0 0 0 1h13a.5.5 0 0 0 0-1H13V2.5A1.5 1.5 0 0 0 11.5 1H11V.5a.5.5 0 0 0-.57-.495l-7 1A.5.5 0 0 0 3 1.5V15zM11 2h.5a.5.5 0 0 1 .5.5V15h-1zm-2.5 8c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1"/>
                                                    </svg>Racoon Brothers</a>
                                                <a href="<%= request.getContextPath()%>/home"><svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
                                                        <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293z"/>
                                                        <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293z"/>
                                                    </svg> Inicio</a>

                                            </div>


                                        </div>
                                        <div class="container mt-5">
                                            <div class="row">
                                                <div class="col">
                                                    <h2>Registro de ingresos</h2>
                                                    <table id="ingresoTable" class="table table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th>Fecha</th>
                                                                <th>Hora de Ingreso</th>
                                                                <th>Acciones</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <!-- Aquí se insertan las filas dinámicamente -->
                                                        </tbody>
                                                    </table>
                                                    <script>
                                                        function ga(variable) {
                                                            console.log(variable);
                                                        }
                                                    </script>
                                                    <button class="btn btn-primary" onclick="addRow('ingresoTable')">Agregar</button>
                                                    <button class="btn btn-dark" onclick="componentContext('<%=sessionAccount.getToken()%>')" >Generar Reporte</button>
                                                    <button class="btn btn-danger" onclick="" >Generar PDF</button>
                                                    <button class="btn btn-success" onclick="" >Generar Excel</button>
                                                </div>
                                            </div>

                                            <div class="row mt-5">
                                                <div class="col">
                                                    <h2>Registro de salidas</h2>
                                                    <table id="salidaTable" class="table table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th>Fecha</th>
                                                                <th>Hora de Salida</th>
                                                                <th>Acciones</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <!-- Aquí se insertan las filas dinámicamente -->
                                                        </tbody>
                                                    </table>
                                                    <script>
                                                        function ga(variable) {
                                                            console.log(variable);
                                                        }
                                                    </script>
                                                    <button class="btn btn-primary" onclick="addRow('ingresoTable')">Agregar</button>
                                                    <button class="btn btn-dark" onclick="componentContext('<%=sessionAccount.getToken()%>')" >Generar Reporte</button>
                                                    <button class="btn btn-danger" onclick="" >Generar PDF</button>
                                                    <button class="btn btn-success" onclick="" >Generar Excel</button>
                                                </div>
                                            </div>

                                            <div class="row mt-5">
                                                <div class="col">
                                                    <h2>Registro de faltas</h2>
                                                    <table id="faltasTable" class="table table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th>Fecha</th>
                                                                <th>Motivo</th>
                                                                <th>Acciones</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <!-- Aquí se insertan las filas dinámicamente -->
                                                        </tbody>
                                                    </table>
                                                    <script>
                                                        function ga(variable) {
                                                            console.log(variable);
                                                        }
                                                    </script>
                                                    <button class="btn btn-primary" onclick="addRow('ingresoTable')">Agregar</button>
                                                    <button class="btn btn-dark" onclick="componentContext('<%=sessionAccount.getToken()%>')" >Generar Reporte</button>
                                                    <button class="btn btn-danger" onclick="" >Generar PDF</button>
                                                    <button class="btn btn-success" onclick="" >Generar Excel</button>
                                                </div>
                                            </div>

                                            <div class="row mt-5">
                                                <div class="col">
                                                    <h2>Registro de descansos</h2>
                                                    <table id="descansosTable" class="table table-bordered" >
                                                        <thead>
                                                            <tr>
                                                                <th>Hora de Inicio</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>

                                                        </tbody>
                                                    </table>
                                                    <script>
                                                        function ga(variable) {
                                                            console.log(variable);
                                                        }
                                                    </script>
                                                    <!-- addRow('ingresoTable') -->

                                                    <button class="btn btn-primary" onclick="componentContext('<%=sessionAccount.getToken()%>')">Agregar</button>
                                                    <button class="btn btn-dark" onclick="" >Generar Reporte</button>
                                                    <button class="btn btn-danger" onclick="" >Generar PDF</button>
                                                    <button class="btn btn-success" onclick="" >Generar Excel</button>
                                                </div>
                                            </div>

                                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel">Agregar nueva fila</h5>
                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>

                                                        <div class="modal-body">
                                                            <form id="yourTableForm">
                                                                <div class="mb-3">
                                                                    <label for="fechaSalida" class="form-label">Fecha</label>
                                                                    <input type="date" class="form-control datepicker" id="fechaSalida" placeholder="YYYY-MM-DD">
                                                                </div>
                                                                <div class="mb-3">
                                                                    <label for="horaSalida" class="form-label">Hora de Ingreso</label>
                                                                    <input type="time" class="form-control timepicker" id="horaSalida" placeholder="HH:MM">
                                                                </div>



                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                                                    <button type="submit" class="btn btn-primary">Guardar</button>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <p></p>

                                        </div>




                                    </body>

                                    </main>


                                    <script>
                                        document.addEventListener('DOMContentLoaded', () => {
                                            componentLoadingTable('<%=sessionAccount.getToken()%>');
                                        });
                                    </script>