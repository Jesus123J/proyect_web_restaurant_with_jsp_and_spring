
<%@page import="com.utp.management_web_application.data.rest.LoginResponse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    LoginResponse dataLoginResponse = (LoginResponse) session.getAttribute("dataLoginResponse");
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%
        if (dataLoginResponse != null) {
    %>
    <%
        if (dataLoginResponse.getRoleType().equals("ADMINISTRADOR")) {
    %>
    <script src="views/admin/js/jsAdmin.js" type="text/javascript"></script>
    <link href="views/admin/css/cssAdmin.css" rel="stylesheet" type="text/css"/>
    <%
    } else if (dataLoginResponse.getRoleType().equals("GERENTE")) {
    %>
    <link href="views/manager/css/cssManager.css" rel="stylesheet" type="text/css"/>
    <script src="views/manager/js/jsManager.js" type="text/javascript"></script>
    <%
    } else if (dataLoginResponse.getRoleType().equals("EMPLEADO")) {
    %>
    <link href="views/employee/css/cssEmployee.css" rel="stylesheet" type="text/css"/>
    <script src="views/employee/js/jsEmployee.js" type="text/javascript"></script>
    <%
        }
    %>
    <%
    } else {
    %>
  
    <link href="views/auth/css/cssAuth.css" rel="stylesheet" type="text/css"/>
    <script src="views/auth/js/jsAuth.js" type="text/javascript"></script>
    <% }%>
</head>

