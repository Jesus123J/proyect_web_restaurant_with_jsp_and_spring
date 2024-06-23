/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.rest;

import com.utp.management_web_application.data.dto.ManagerEmployeeDto;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Jesus Gutierrez
 */
public class ShowContainerEmployee {
    
     List<ManagerEmployeeDto>  managerEmployeeDtosList ;
     String urlJsp ;

    public ShowContainerEmployee(List<ManagerEmployeeDto> managerEmployeeDtosList, String urlJsp) {
        this.managerEmployeeDtosList = managerEmployeeDtosList;
        this.urlJsp = urlJsp;
    }
     
     
}
