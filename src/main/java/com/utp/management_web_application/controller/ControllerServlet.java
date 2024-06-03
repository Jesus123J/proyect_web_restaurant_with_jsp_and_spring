/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.management_web_application.controller;

import com.utp.management_web_application.data.api.Api;
import com.utp.management_web_application.data.dao.AuthDao;
import com.utp.management_web_application.data.rest.BoosRegisterEmployeeResponse;
import com.utp.management_web_application.data.rest.BossRegisterEmployeeRequest;
import com.utp.management_web_application.data.rest.LoginRequest;
import com.utp.management_web_application.data.rest.LoginResponse;
import com.utp.management_web_application.data.service.AuthService;
import com.utp.management_web_application.data.service.BossService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Jesus Gutierrez
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {

    AuthDao authDao = new AuthDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        request.setAttribute("pageDashboard", "views/auth/Auth.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String contentType = request.getContentType();
        String accion = request.getParameter("accion");
        if (accion != null && accion.equalsIgnoreCase("LoginService")) {

            request.getSession().setAttribute("dataLoginResponse", authDao.logIn(new LoginRequest(request.getParameter("username"), request.getParameter("password"))));
            response.sendRedirect(request.getContextPath() + "/admin");
        } 
        if (contentType
                != null && contentType.contains(
                        "application/json")) {

            StringBuilder sb = new StringBuilder();
            try (BufferedReader reader = request.getReader()) {
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            }

            JSONObject jsonObject = new JSONObject(sb.toString());
            String action = jsonObject.getString("action");

            if (null != action) {
                switch (action) {
                    case "createEmployee":
                        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/widget/FormRegisterEmployee.jsp");
                        dispatcher.forward(request, response);
                        break;
                    case "showEmployee":
                        RequestDispatcher dispatchersShowEmployee = request.getRequestDispatcher("views/admin/widget/FormShowEmployee.jsp");
                        dispatchersShowEmployee.forward(request, response);
                        break;
                    case "showOrder":
                        RequestDispatcher dispatchersShowOrder = request.getRequestDispatcher("views/admin/widget/FormShowOrder.jsp");
                        dispatchersShowOrder.forward(request, response);
                        break;
                    case "showStore":
                        RequestDispatcher dispatchersShowStore = request.getRequestDispatcher("views/admin/widget/FormShowStore.jsp");
                        dispatchersShowStore.forward(request, response);
                        break;
                }
            }

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
