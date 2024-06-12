<%-- 
    Document   : Employee
    Created on : 27 may. 2024, 8:19:37 p. m.
    Author     : Joshua Jose
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <main>

  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="css/mainEmployee.css" rel="stylesheet" type="text/css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
        <title>Empleados</title>
  </head>
  <body  class="fondo">
     
         
    <!--ENCABEZADO-->
    <!-- ===================================== -->
  <header>
    <h1 class="container-fluid bg-warning d-flex  fw-bold">
           <nav class="navbar navbar-expand-lg bg-body-tertiary">
               
               <a> <span class="nav-link active text-dark fs-5 fw-bold"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-door-open-fill" viewBox="0 0 16 16">
  <path d="M1.5 15a.5.5 0 0 0 0 1h13a.5.5 0 0 0 0-1H13V2.5A1.5 1.5 0 0 0 11.5 1H11V.5a.5.5 0 0 0-.57-.495l-7 1A.5.5 0 0 0 3 1.5V15zM11 2h.5a.5.5 0 0 1 .5.5V15h-1zm-2.5 8c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1"/>
                       </svg>Racoon Brothers</span></a>                   
               
  
  <div class="container-fluid">
    <a class="navbar-brand" href="../admin/Admin.jsp">
        <span class="text-dark fs-10 fw-bold" ><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person-vcard-fill" viewBox="0 0 16 16">
  <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm9 1.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 0-1h-4a.5.5 0 0 0-.5.5M9 8a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 0-1h-4A.5.5 0 0 0 9 8m1 2.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 0-1h-3a.5.5 0 0 0-.5.5m-1 2C9 10.567 7.21 9 5 9c-2.086 0-3.8 1.398-3.984 3.181A1 1 0 0 0 2 13h6.96q.04-.245.04-.5M7 6a2 2 0 1 0-4 0 2 2 0 0 0 4 0"/>
</svg>Admin</span> 
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active text-dark fs-5 fw-bold" aria-current="page" href="../../index.jsp"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="30" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
  <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5"/>
  
</svg>Inicio</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active text-dark fs-5 fw-bold" href="../employee/Employee.jsp"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
  <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
</svg>Empleados</a> 
        </li>
           <li class="nav-item">
          <a class="nav-link active text-dark fs-5 fw-bold" href="#"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person-badge-fill" viewBox="0 0 16 16">
  <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2zm4.5 0a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1zM8 11a3 3 0 1 0 0-6 3 3 0 0 0 0 6m5 2.755C12.146 12.825 10.623 12 8 12s-4.146.826-5 1.755V14a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1z"/>
</svg>Gerente</a>
        </li>
     </ul>
         </div>
  </div>
</nav>
      </div>
      </h1
      
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
   
    
    <div class="container">
  
  <table class="table table-bordered table-striped table-warning table-hover caption-top">
      <caption class="text-white fs-5 fw-bold bg-warning">Horarios de Ingreso</caption>
      <thead>
    <tr>
      <th scope="col" >Tabla de Ingresos de Empleados </th> 
      <th scope="col">Apellidos</th>
      <th scope="col">Nombres</th>
      <th scope="col">Fecha</th> 
      <th></th>
      
    </tr>
          
  </thead>
  <tbody>
    <tr>
      <th scope="row">1 </th> 
      <td>hola</td>
      <td>hola</td>
      <td> <div class="row form-group"
                <label for="date" class="col-sm-1 col-form-label"></label>
                <div class="col-sm-4">
                    <div class="input-group date" id="datepicker">
                        <input type="text" class="form-control">
                        <span class="input-group-append">
                            <span class="input-group-text bg-white">
                                <i class="fa fa-calendar"></i>
                                <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
        });
    </script>
                         </td>
      <td><button type="button" class="btn btn-primary">Agregar</button>
            </div>
            
        </div>
        
        
    </div>
   


     <div class="container">
         <p></p></td>
      
    </tr>
      
      <tr>
     <th scope="row">2</th>
      <td></td>
      <td></td>
      <td><div class="row form-group"
                <label for="date" class="col-sm-1 col-form-label"></label>
                <div class="col-sm-4">
                    <div class="input-group date" id="datepicker">
                        <input type="text" class="form-control">
                        <span class="input-group-append">
                            <span class="input-group-text bg-white">
                                <i class="fa fa-calendar"></i>
                                <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
        });
    </script></td>
     
      <td></td>
      
      
      <tr>
      
          
          
          
          
          
          
   <tr>
      <th scope="row">3</th>
      <td></td>
      <td></td>
       <td><div class="row form-group"
                <label for="date" class="col-sm-1 col-form-label"></label>
                <div class="col-sm-4">
                    <div class="input-group date" id="datepicker">
                        <input type="text" class="form-control">
                        <span class="input-group-append">
                            <span class="input-group-text bg-white">
                                <i class="fa fa-calendar"></i>
                                <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
        });
    </script></td>
      <td></td>
          </tr>
  </tbody>
      
</table>
        <button type="button" class="btn btn-success">Generar Reporte</button>
            </div>
            
        </div>
        
        
    </div>
   


     <div class="container">
         <p></p>
 
  <table class="table table-bordered table-striped table-warning table-hover caption-top">
      <caption class="text-white fs-5 fw-bold bg-warning">Horarios de Salida</caption>
      <thead>
    <tr>
      <th scope="col" >Tabla de Salida de Empleados</th>
      <th scope="col">Apellidos</th>
      <th scope="col">Nombres</th>
      <th scope="col">Fecha</th>
      <th scope="col">Estado</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Empleado1</td>
      <td>Apellido1</td>
       <td><div class="row form-group"
                <label for="date" class="col-sm-1 col-form-label"></label>
                <div class="col-sm-4">
                    <div class="input-group date" id="datepicker">
                        <input type="text" class="form-control">
                        <span class="input-group-append">
                            <span class="input-group-text bg-white">
                                <i class="fa fa-calendar"></i>
                                <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
        });
    </script></td>
    <td><td><button type="button" class="btn btn-primary">Agregar</button>
            </div>
            
        </div>
        
        
    </div>
   


     <div class="container">
         <p></p></td>
      
    </tr></td>
    </tr>
    
    <tr>
      <th scope="row">2</th>
      <td>Empleado1</td>
      <td>Apellido1</td>
       <td><div class="row form-group"
                <label for="date" class="col-sm-1 col-form-label"></label>
                <div class="col-sm-4">
                    <div class="input-group date" id="datepicker">
                        <input type="text" class="form-control">
                        <span class="input-group-append">
                            <span class="input-group-text bg-white">
                                <i class="fa fa-calendar"></i>
                                <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
        });
    </script></td>
      <td></td>
      <td></td>
    </tr > 
    <tr>
      <th scope="row">3</th>
      <td></td>
      <td></td>
       <td><div class="row form-group"
                <label for="date" class="col-sm-1 col-form-label"></label>
                <div class="col-sm-4">
                    <div class="input-group date" id="datepicker">
                        <input type="text" class="form-control">
                        <span class="input-group-append">
                            <span class="input-group-text bg-white">
                                <i class="fa fa-calendar"></i>
                                <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
        });
    </script></td>
      <td></td>
      <td></td>
          </tr>
  </tbody>
      
</table>
        <button type="button" class="btn btn-success">Generar Reporte</button>
           </div>
            
        </div>
        
        
    </div>
           </div>
                </div>
   


     <div class="container">
         <p></p>
  <table class="table table-bordered table-striped table-warning table-hover caption-top">
      <caption class="text-white fs-5 fw-bold bg-warning bg-warning">Lista de Faltas</caption>
      <thead>
    <tr>
      <th scope="col" >Tabla de Faltas</th>
       <th scope="col">Fecha</th>
       <th scope="col">Falta</th>
       <th scope="col">Dia</th>
      <th scope="col">Apellidos</th>
      <th scope="col">Nombres</th>
      <th scope="col">Faltas Totales</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td><div class="row form-group"
                <label for="date" class="col-sm-1 col-form-label"></label>
                <div class="col-sm-4">
                    <div class="input-group date" id="datepicker">
                        <input type="text" class="form-control">
                        <span class="input-group-append">
                            <span class="input-group-text bg-white">
                                <i class="fa fa-calendar"></i>
                                <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
        });
    </script></td>
      <td>Empleado1</td>
      <td>Apellido1</td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td><td><button type="button" class="btn btn-primary">Agregar</button>
            </div>
            
        </div>
        
        
    </div>
   


     <div class="container">
         <p></p></td>
      
    </tr></td>
      
      
      
    </tr > 
    <tr>
      <th scope="row">2</th>
      <td><div class="row form-group"
                <label for="date" class="col-sm-1 col-form-label"></label>
                <div class="col-sm-4">
                    <div class="input-group date" id="datepicker">
                        <input type="text" class="form-control">
                        <span class="input-group-append">
                            <span class="input-group-text bg-white">
                                <i class="fa fa-calendar"></i>
                                <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
        });
    </script></td>
      <td>Empleado2</td>
      <td>Apellido2</td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
        </tr>
    <tr>
      <th scope="row">3</th>
      <td><div class="row form-group"
                <label for="date" class="col-sm-1 col-form-label"></label>
                <div class="col-sm-4">
                    <div class="input-group date" id="datepicker">
                        <input type="text" class="form-control">
                        <span class="input-group-append">
                            <span class="input-group-text bg-white">
                                <i class="fa fa-calendar"></i>
                                <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
        });
    </script></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td><td>
            
        </div>
        
        
    </div>
   
          </tr>
    
  </tbody>
      
</table>
    <button type="button" class="btn btn-success">Generar Reporte</button>
            </div>
            
        </div>
        
        
    </div>
    <div class="container">
         <p></p>
  <table class="table table-bordered table-striped table-warning table-hover caption-top">
      <caption class="text-white fs-5 fw-bold bg-warning bg-warning">Lista de Descanso</caption>
      <thead>
    <tr>
      <th scope="col" >Tabla de Descanso</th>
      <th scope="col">Descanso</th>
       <th scope="col">Duracion</th>
       <th scope="col">Motivo</th>
       <th scope="col">Fecha Ini</th>
       <th scope="col">Fecha Termino</th>
      <th scope="col">Apellidos</th>
      <th scope="col">Nombres</th>
      <th></th>
      <th></th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td><div class="row form-group"
                <label for="date" class="col-sm-1 col-form-label"></label>
                <div class="col-sm-4">
                    <div class="input-group date" id="datepicker">
                        <input type="text" class="form-control">
                        <span class="input-group-append">
                            <span class="input-group-text bg-white">
                                <i class="fa fa-calendar"></i>
                                <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
        });
    </script></td>
      <td>Empleado1</td>
      <td>Apellido1</td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
       <td></td>
      <td><button type="button" class="btn btn-primary">Agregar</button>
            </div>
            
        </div>
        
        
    </div>
   


     <div class="container">
         <p></p></td>
      
    </tr></td>
      
      
      
      
    </tr > 
    <tr>
      <th scope="row">2</th>
      <td><div class="row form-group"
                <label for="date" class="col-sm-1 col-form-label"></label>
                <div class="col-sm-4">
                    <div class="input-group date" id="datepicker">
                        <input type="text" class="form-control">
                        <span class="input-group-append">
                            <span class="input-group-text bg-white">
                                <i class="fa fa-calendar"></i>
                                <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
        });
    </script></td>
      <td>Empleado2</td>
      <td>Apellido2</td>
      <td>asd</td>
      <td>dasd</td>
      <td></td>
       <td></td>
       <td></td>
       <td></td>
       
      
        </tr>
    <tr>
      <th scope="row">3</th>
      <td><div class="row form-group"
                <label for="date" class="col-sm-1 col-form-label"></label>
                <div class="col-sm-4">
                    <div class="input-group date" id="datepicker">
                        <input type="text" class="form-control">
                        <span class="input-group-append">
                            <span class="input-group-text bg-white">
                                <i class="fa fa-calendar"></i>
                                <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
        });
    </script></td>
     <td>Empleado2</td>
      <td>Apellido2</td>
      <td>asd</td>
      <td>dasd</td>
      <td></td>
       <td></td>
       <td></td>
       <td></td>
      
          </tr>
  </tbody>
      
</table>
    <button type="button" class="btn btn-success">Generar Reporte</button>
            </div>
            
        </div>
        
        
    </div>
    
  </body>
      
</main>