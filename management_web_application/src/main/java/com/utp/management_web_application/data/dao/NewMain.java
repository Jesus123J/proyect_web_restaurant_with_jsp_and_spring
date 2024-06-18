/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.utp.management_web_application.data.dao;

import com.utp.management_web_application.data.rest.ManagerEmployeeListResponse;

/**
 *
 * @author Jesus Gutierrez
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ManagerDao managerDao = new ManagerDao();
        
        ManagerEmployeeListResponse listEm = managerDao.listManagerEmployee("eyJpZEFjY291bnQiOjYsImlkUGVyc29uIjo2LCJzdGF0dXMiOjEsInVzZXJuYW1lIjoicGFibG9AZ21haWwuY29tIiwibmFtZSI6IlBBQkxPIiwibGFzdG5hbWUiOiJQRVJFWiIsIm1vdGhlckxhc3RuYW1lIjoiUE9OVEUiLCJpZFJvbGUiOjMsInJvbGVUeXBlIjoiR0VSRU5URSJ9");
        
        listEm.getManagerEmployees().forEach((e) -> System.out.println(e.getFullName()) );
    }
    
}
