package com.proyect.racoonbrothers.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "history_stock")
@ToString
public class HistoryStockTb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_stock", nullable = false)
    private Integer idStock;

    @Column(name = "name")
    private String name;

    @Column(name = "unit")
    private String unit;

    @Column(name = "price_unit")
    private Double priceUnit;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "create_time")
    private Date createTime;

}
