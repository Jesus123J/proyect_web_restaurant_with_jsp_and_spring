/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.management_web_application.controller;

import com.utp.management_web_application.data.dao.AuthDao;
import com.utp.management_web_application.data.dto.Account;
import com.utp.management_web_application.data.rest.LoginRequest;
import com.utp.management_web_application.data.rest.LoginResponse;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;

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

            Account account = new Account();
            account.setUsername(request.getParameter("username"));
            account.setPassword(request.getParameter("password"));

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Account>> violations = validator.validate(account);

            if (!violations.isEmpty()) {
                request.setAttribute("pages", "views/auth/Auth.jsp");
                request.setAttribute("path", request.getServletPath());
                request.setAttribute("errors", violations);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                LoginResponse sessionAccount = authDao.logIn(new LoginRequest(request.getParameter("username"), request.getParameter("password")));
                if (sessionAccount != null) {
                    request.getSession().setAttribute("sessionAccount", sessionAccount);
                    request.getSession().setAttribute("typeRole", sessionAccount.getRoleType());
                    request.setAttribute("pages", "views/auth/Auth.jsp");
                    request.setAttribute("path", request.getServletPath());
                    if (sessionAccount.getStatus() == 401) {
                         request.setAttribute("errors", sessionAccount.getMessage());
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        if (sessionAccount.getRoleType().equalsIgnoreCase("JEFE")) {
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
}
