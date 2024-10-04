<%-- 
    Document   : index.jsp
    Created on : Apr 18, 2024, 5:57:50 PM
    Author     : Jesus Gutierrez
--%>
<%@page import="com.utp.management_web_application.config.PathPermitidos"%>
<%@page import="com.utp.management_web_application.data.rest.LoginResponse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String pages = (String) request.getAttribute("pages");
    String pathServlet = (String) request.getAttribute("path");

    if (pages == null) {
        response.sendRedirect(request.getContextPath() + "/home");
        return;
    }
    
    if (request.getSession().getAttribute("sessionAccount") != null) {
        if(PathPermitidos.verificar(pathServlet) == false){ 
            session.invalidate();
        } 
    }
%>
<html>
    <jsp:include page="views/inic/Head.jsp" />
    <body>  
        <jsp:include page = "<%=pages%>" />  
    </body>
</html>
