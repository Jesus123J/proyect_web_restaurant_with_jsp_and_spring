
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String typeRole = (String) request.getSession().getAttribute("typeRole");
    String pathServlet = (String) request.getAttribute("path");
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="views/404/resources/raccoonb.png" type="image/x-icon">
    <title>Raccon Brothers</title>
    <% if (typeRole != null) {
            if (typeRole.equalsIgnoreCase("JEFE")) {
    %>
    
    <link href="views/admin/css/cssAdmin.css" rel="stylesheet" type="text/css"/>
    <script src="views/admin/js/jsAdmin.js" type="text/javascript"></script>
    <%  } else if (typeRole.equalsIgnoreCase("EMPLEADO")) {%>
    <link href="views/employee/css/cssEmployee.css" rel="stylesheet" type="text/css"/>
    <script src="views/employee/js/jsEmployee.js" type="text/javascript"></script>
    <%  } else if (typeRole.equalsIgnoreCase("GERENTE")) {%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="views/manager/css/cssManager.css" rel="stylesheet" type="text/css"/>
    <script src="views/manager/js/jsManager.js" type="text/javascript"></script>
    <%  }
    } else {
        if (pathServlet.equalsIgnoreCase("/home")) {
    %>
    <link href="views/dashboard/css/cssDashboard.css" rel="stylesheet" type="text/css"/>
    <script src="views/dashboard/js/jsDashboard.js" type="text/javascript"></script>
    <%  } else if (pathServlet.equalsIgnoreCase("/login")) {%>
    <link href="views/auth/css/cssAuth.css" rel="stylesheet" type="text/css"/>
    <script src="views/auth/js/jsAuth.js" type="text/javascript"></script>
    <%  } else if (pathServlet.equalsIgnoreCase("/404")) {%>
    <link href="views/404/css/404css.css" rel="stylesheet" type="text/css"/>
    <script src="views/404/js/404js.js" type="text/javascript"></script>
    <%  }  %>
    <%}%>
</head>

