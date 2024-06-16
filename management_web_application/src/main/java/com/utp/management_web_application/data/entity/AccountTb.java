
package com.utp.management_web_application.data.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter

public class AccountTb {

   
    private Long id;

    
    private String code;

   
    private String username;

  
    private String password;

 
    private Integer idRole;


    private boolean enable;


    private Integer status;

  
    private Date createTime;

   
    private Date updateTime;


}