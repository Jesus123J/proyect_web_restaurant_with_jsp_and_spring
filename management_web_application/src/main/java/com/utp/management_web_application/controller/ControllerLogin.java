/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.management_web_application.controller;

import com.utp.management_web_application.data.dao.AuthDao;
import com.utp.management_web_application.data.rest.LoginRequest;
import com.utp.management_web_application.data.rest.LoginResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesus Gutierrez
 */
@WebServlet(name = "ControllerLogin", urlPatterns = {"/login"})
public class ControllerLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("path", request.getServletPath());
        request.setAttribute("pages", "views/auth/Auth.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AuthDao authDao = new AuthDao();
        String formComponent = (String) request.getParameter("action");

        if (formComponent.equalsIgnoreCase("loginService")) {
            LoginResponse sessionAccount = authDao.logIn(new LoginRequest(request.getParameter("username"), request.getParameter("password")));
            if (sessionAccount != null) {
                request.getSession().setAttribute("sessionAccount", sessionAccount);
                request.getSession().setAttribute("typeRole", sessionAccount.getRoleType());
                request.setAttribute("path", request.getServletPath());
                if (sessionAccount.getStatus() == 401) {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    if (sessionAccount.getRoleType().equalsIgnoreCase("ADMINISTRADOR")) {
                        response.sendRedirect(request.getContextPath() + "/admin");
                    } else if (sessionAccount.getRoleType().equalsIgnoreCase("GERENTE")) {
                        response.sendRedirect(request.getContextPath() + "/manager");
                    } else if (sessionAccount.getRoleType().equalsIgnoreCase("EMPLEADO")) {
                        response.sendRedirect(request.getContextPath() + "/employee");
                    }
                }
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }
}
