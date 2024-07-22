/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.controller;

/**
 *
 * @author Jesus Gutierrez
 */
import java.io.File;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

@WebServlet(name = "PdfGeneratorServlet", urlPatterns = {"/PdfGeneratorServlet , /generatePdf"})
public class PdfGeneratorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener la ruta del archivo JRXML desde la carpeta de recursos
            String jrxmlPath = getServletContext().getRealPath("Flower.jrxml");
            System.out.println("JRXML Path: " + jrxmlPath);

            // Verificar si el archivo existe
            File jrxmlFile = new File(jrxmlPath);
            if (!jrxmlFile.exists()) {
                throw new ServletException("El archivo JRXML no se encuentra en: " + jrxmlPath);
            }

            // Compilar el reporte
            JasperReport jasperReport;
            try {
                jasperReport = JasperCompileManager.compileReport(jrxmlPath);
            } catch (JRException e) {
                throw new ServletException("Error al compilar el reporte", e);
            }

            // Configurar los parámetros y datos
            Map<String, Object> parameters = new HashMap<>();
            // JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(getData());

            // Llenar el reporte
            JasperPrint jasperPrint;
            try {
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            } catch (JRException e) {
                throw new ServletException("Error al llenar el reporte", e);
            }

            // Configurar la respuesta
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=report.pdf");

            // Exportar el reporte a PDF
            try (OutputStream outputStream = response.getOutputStream()) {
                JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            }

        } catch (Exception e) {
            e.printStackTrace(); // Esto imprimirá el error en el log del servidor
            throw new ServletException("Error al generar el PDF", e);
        }

    }

    // Método de ejemplo para obtener datos
    private Collection<?> getData() {
        // Implementa tu lógica para obtener los datos
        return new ArrayList<>();
    }
}
