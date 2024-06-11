<%-- 
    Document   : Employee
    Created on : 27 may. 2024, 8:19:37 p. m.
    Author     : Joshua Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <link href="views/employee/css/cssEmployee.css" rel="stylesheet" type="text/css"/>
    <script src="views/employee/js/jsEmployee.js" type="text/javascript"></script>
 
<main>
    <link href="views/employee/css/cssEmployee.css" rel="stylesheet" type="text/css"/>
    <script src="views/employee/js/jsEmployee.js" type="text/javascript"></script>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administración de Horarios - Raccoon Brothers</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
    
</head>
<body>

<div class="container">
    <h1 align="center">Administración de Horarios</h1>
    
    <div class="row">
        <div class="col-md-6">
            
                <h2>Registro de Entrada</h2>
  <table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nombre </th>
      <th scope="col" >Dia </<th>
      <th scope="col">Fecha</th>
      <th scope="col">Hora</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td> </td>
      <td>  </td>
     
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td></td>
    </tr>
  </tbody>
</table>

            <button id="agregarEntrada" class="btn btn-primary">Agregar <i class="fas fa-plus"></i></button>
            <button id="editarEntrada" class="btn btn-warning">Editar <i class="fas fa-edit"></i></button>
            <button id="borrarEntrada" class="btn btn-danger">Borrar <i class="fas fa-trash-alt"></i></button>
        </div>
        <div class="col-md-6">
            <h2>Registro de Salida</h2>
            <table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nombre</th>
      <th scope="col">Hora</th>
      <th scope="col">Fecha</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>toronto</td>
    </tr>
  </tbody>
</table>
</table> 
                
            </table>
            <button id="agregarSalida" class="btn btn-primary">Agregar <i class="fas fa-plus"></i></button>
            <button id="editarSalida" class="btn btn-warning">Editar <i class="fas fa-edit"></i></button>
            <button id="borrarSalida" class="btn btn-danger">Borrar <i class="fas fa-trash-alt"></i></button>
        </div>
    </div>
    
        </div>
  
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- FullCalendar JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/5.9.0/main.min.js"></script>
<!-- Custom JS -->


</main>
</html>