package com.example.auto_record.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_value")
    private Integer productValue;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false; // 論理削除フラグ

    @Column(name = "created_at")
    private String createdAt;
    
}