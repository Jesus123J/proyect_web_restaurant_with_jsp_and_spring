<%-- 
    Document   : index.jsp
    Created on : Apr 18, 2024, 5:57:50 PM
    Author     : Jesus Gutierrez
--%>

<%@page import="com.utp.management_web_application.data.rest.LoginResponse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    LoginResponse dataLoginResponse = (LoginResponse) session.getAttribute("dataLoginResponse");
%>
<html>
    <head>
        <jsp:include page="views/inic/Head.jsp" />
        <title>Raccon Brothers</title>
    </head>
    <body>
        <%
            if (dataLoginResponse != null) {
            if (dataLoginResponse.getRoleType().equals("ADMINISTRADOR")) {
        %>
        <jsp:include page="views/admin/Admin.jsp" />
        <%  }
        %>
        <%
            if (dataLoginResponse.getRoleType().equals("GERENTE")) {
        %>
        <jsp:include page="views/manager/Manager.jsp" />
        <%
            }
        %>
        <%
            if (dataLoginResponse.getRoleType().equals("EMPLEADO")) {
        %>
        <jsp:include page="views/employee/Employee.jsp" />
        <%
            }
        } else {
        %>
         <jsp:include page="views/auth/Auth.jsp" />
        <%
            }
        %>
    </body>
</html>
