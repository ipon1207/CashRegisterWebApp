package com.example.auto_record.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Integer saleId;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "received_price")
    private Integer receivedPrice;

    @Column(name = "change_price")
    private Integer changePrice;

    @Column(name = "sale_at", nullable = false)
    private LocalDateTime saleAt;

}
