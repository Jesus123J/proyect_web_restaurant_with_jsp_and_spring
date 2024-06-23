/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.management_web_application.controller;

import com.google.gson.Gson;
import com.utp.management_web_application.data.dao.ManagerDao;
import com.utp.management_web_application.data.dto.AccountDto;
import com.utp.management_web_application.data.dto.ManagerEmployeeDto;
import com.utp.management_web_application.data.rest.LoginResponse;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.json.JSONObject;

/**
 *
 * @author Jesus Gutierrez
 */
@WebServlet(name = "ControllerManager", urlPatterns = {"/ControllerManager , /manager"})
public class ControllerManager extends HttpServlet {

    ManagerDao managerDao = new ManagerDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String downloadPDF = request.getParameter("downloadPDF");
        String downloadExcel = request.getParameter("downloadExcel");

        if (downloadPDF != null && downloadPDF.equals("true")) {
            try {
                // Conexión a la base de datos (simulado aquí)
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/racoon_brothers", "root", "");

                // Ruta al archivo .jasper compilado
                String jasperPath = getServletContext().getRealPath("Blank_A4.jasper");

                // Parámetros del reporte (si es necesario)
                Map<String, Object> params = new HashMap<>();

                // Cargar el reporte Jasper
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, params, conn);

                // Generar el PDF en bytes
                byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

                // Configurar la respuesta para enviar el PDF
                response.setContentType("application/pdf");
                response.setContentLength(pdfBytes.length);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", "nombre_del_archivo.pdf");
                response.setHeader(headerKey, headerValue);

                OutputStream outputStream = response.getOutputStream();
                outputStream.write(pdfBytes);
                outputStream.close();
                return;

            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException("Error al generar el PDF", e);
            }
        } else if (downloadExcel != null && downloadExcel.equals("true")) {
            try {
                // Conexión a la base de datos (simulado aquí)
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/racoon_brothers", "root", "");

                // Ruta al archivo .jasper compilado
                String jasperPath = getServletContext().getRealPath("Blank_A4.jasper");

                // Parámetros del reporte (si es necesario)
                Map<String, Object> params = new HashMap<>();

                // Cargar el reporte Jasper
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, params, conn);

                // Configurar el exportador para Excel
                JRXlsxExporter exporter = new JRXlsxExporter();
           
                // Configurar el output stream
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));

                SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
                configuration.setOnePagePerSheet(true);
                configuration.setRemoveEmptySpaceBetweenRows(true);
                configuration.setDetectCellType(true);
                configuration.setWhitePageBackground(false);
                exporter.setConfiguration(configuration);

                // Exportar el reporte a Excel
                exporter.exportReport();

                // Obtener los bytes del archivo Excel
                byte[] excelBytes = byteArrayOutputStream.toByteArray();

                // Configurar la respuesta para enviar el archivo Excel
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                response.setContentLength(excelBytes.length);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", "nombre_del_archivo.xlsx");
                response.setHeader(headerKey, headerValue);

                OutputStream outputStream = response.getOutputStream();
                outputStream.write(excelBytes);
                outputStream.close();
                return;

            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException("Error al generar el archivo Excel", e);
            }
        }

        request.setAttribute("path", request.getServletPath());
        request.setAttribute("pages", "views/manager/Manager.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String contentType = request.getContentType();
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
            boolean jsonVeri = (boolean) jsonObject.getBoolean("veri");

            if (action != null) {
                switch (action) {
                    case "showOrderManager":
                        RequestDispatcher dispatcher = request.getRequestDispatcher("views/manager/widget/order.jsp");
                        dispatcher.forward(request, response);
                        break;
                    case "showEmployeeManager":
                        if (jsonVeri) {
                            String token = ((LoginResponse) request.getSession().getAttribute("sessionAccount")).getToken();
                            List<ManagerEmployeeDto> employees = managerDao.listManagerEmployee(token).getManagerEmployees();

                            response.setContentType("application/json");
                            response.setCharacterEncoding("UTF-8");
                            PrintWriter out = response.getWriter();
                            out.print(new Gson().toJson(employees));
                            out.flush();
                        } else {
                            RequestDispatcher dispatchersShowStore = request.getRequestDispatcher("views/manager/widget/employee.jsp");
                            dispatchersShowStore.forward(request, response);
                        }
                        break;

                    case "showStoreManager":
                        RequestDispatcher dispatchersShowStore = request.getRequestDispatcher("views/manager/widget/store.jsp");
                        dispatchersShowStore.forward(request, response);
                        break;
                }
            }

        } else {
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Content-Type not supported");
        }
    }

}
