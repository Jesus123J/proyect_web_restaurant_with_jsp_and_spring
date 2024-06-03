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
    String url = (String) session.getAttribute("pageDashboard");
%>
<html>

    <head>
        <jsp:include page="views/inic/Head.jsp" />
        <title>Raccon Brothers</title>
    </head>
    <body>
        <script>
            console.log("<%= request.getContextPath() %>");
             console.log("<%= request.getServletPath() %>");
               console.log("<%= request.getPathInfo() %>");
               console.log("<%= request.getPathTranslated()%>");
            console.log("<%=url%>");
        </script>
    
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
        <jsp:include page="views/dashboard/Dashboard.jsp" />
        <%
            }
        %>
    </body>
</html>
