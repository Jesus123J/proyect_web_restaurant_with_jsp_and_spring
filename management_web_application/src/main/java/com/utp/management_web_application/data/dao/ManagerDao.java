/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.dao;

import com.utp.management_web_application.data.api.Api;
import com.utp.management_web_application.data.dto.AccountDto;
import com.utp.management_web_application.data.rest.ManagerEmployeeListResponse;
import com.utp.management_web_application.data.service.ManagerService;
import java.io.IOException;
/**
 *
 * @author Jesus Gutierrez
 */
public class ManagerDao extends  Api<ManagerService>{
    
    public ManagerDao() {
        super(ManagerService.class);
    }
    
    public AccountDto dataCompletManager(String token){
        try {
           return service.dataCompletMamager(token).execute().body();
        } catch (IOException ex) {
           return null;
        }
    } 
    public ManagerEmployeeListResponse listManagerEmployee(String token){
           try {
           return service.listManagerEmployee(token).execute().body();
        } catch (IOException ex) {
           return null;
        }
    }
    
}
