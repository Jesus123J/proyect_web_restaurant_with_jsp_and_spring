/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.management_web_application.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Jesus Gutierrez
 */
@WebServlet(name = "ControllerAdministrator", urlPatterns = {"/ControllerAdministrator", "/admin"})
public class ControllerAdministrator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("pages", "views/admin/Admin.jsp");
        request.setAttribute("path", request.getServletPath());
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String contentType = (String) request.getContentType();
        if (contentType != null && contentType.contains("application/json")) {

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
}
