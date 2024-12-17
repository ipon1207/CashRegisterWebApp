package com.example.auto_record.model;

public class SaleProductDTO {
    private final Integer saleId;
    private final String productName;
    private final Integer quantity;

    public SaleProductDTO(Integer saleId, String productName, Integer quantity) {
        this.saleId = saleId;
        this.productName = productName;
        this.quantity = quantity;
    }

    // Getters and setters
    public Integer getSaleId() {
        return saleId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }
}

