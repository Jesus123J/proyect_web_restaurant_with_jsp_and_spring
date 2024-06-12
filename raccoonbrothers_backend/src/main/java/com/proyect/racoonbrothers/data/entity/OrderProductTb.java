package com.proyect.racoonbrothers.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "order_products")
public class OrderProductTb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_record_orders")
    private Long idRecordOrders;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "amount_product")
    private Integer amountProduct;

    @Column(name = "price_products")
    private Double priceProducts;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}
