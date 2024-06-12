package com.proyect.racoonbrothers.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "otp")
public class OtpTb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "id_account")
    private Long idAccount;

    @Column(name = "otp")
    private String otp;

    @Column(name = "create_time",columnDefinition = "DATETIME(3)")
    private Date createTime;

    @Column(name = "expiration_time",columnDefinition = "DATETIME(3)")
    private Date expirationTime;

}
