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
@Entity(name = "record_orders")
public class RecordOrderTb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "id_account")
    private Long idAccount;

    @Column(name = "order_price")
    private Double orderPrice;

    @Column(name = "create_time")
    private Date createTime;

}
