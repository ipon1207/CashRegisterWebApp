package com.example.auto_record.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sales_details")
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_details_id")
    private Integer saleDetailId;

    @Column(name = "sale_id")
    private Integer saleId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "quantity")
    private Integer quantity;

}
