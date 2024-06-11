
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String typeRole = (String) request.getSession().getAttribute("typeRole");
    String pathServlet = (String) request.getAttribute("path");
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Raccon Brothers</title>
    <% if (typeRole != null) {
            if (typeRole.equalsIgnoreCase("ADMINISTRADOR")) {
    %>
    <link href="views/admin/css/cssAdmin.css" rel="stylesheet" type="text/css"/>
    <script src="views/admin/js/jsAdmin.js" type="text/javascript"></script>
    <%  } else if (typeRole.equalsIgnoreCase("EMPELADO")) {%>
    <link href="views/employee/css/cssEmployee.css" rel="stylesheet" type="text/css"/>
    <script src="views/employee/js/jsEmployee.js" type="text/javascript"></script>
    <%  } else if (typeRole.equalsIgnoreCase("GERENTE")) {%>
    <link href="views/manager/css/cssManager.css" rel="stylesheet" type="text/css"/>
    <script src="views/manager/js/jsManager.js" type="text/javascript"></script>
    <%  }
    } else {
        if (pathServlet.equalsIgnoreCase("/home")) {
    %>
    <link href="views/dashboard/css/cssDashboard.css" rel="stylesheet" type="text/css"/>
    <script src="views/dashboard/js/jsDashboard.js" type="text/javascript"></script>
    <%  } else {%>
    <link href="views/auth/css/cssAuth.css" rel="stylesheet" type="text/css"/>
    <script src="views/auth/js/jsAuth.js" type="text/javascript"></script>
    <%  }%>
    <%}%>
</head>

