package com.proyect.racoonbrothers.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "RECORD_NOTICES")
public class RecordNoticeTb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_account")
    private Long idAccount;

    @Column(name = "id_person")
    private Long idPerson;

    @Column(name = "description")
    private String description;

    @Column(name = "read_boss")
    private Integer readBoss;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}
