
package com.utp.management_web_application.data.entity;

import lombok.*;
import java.util.Date;

@Getter
@Setter

public class HistoryAttendanceTb {

    private Long id;

  
    private Long idAccount;

   
    private Date entryTime;


    private Date departureTime;

}

