package com.org.model;

import com.org.entity.Seller;

import java.math.BigDecimal;

public class ProductDTO {


    private  long ProductId;

    private Long sellerId;

    private String  name;
    private String description;
    private BigDecimal price;

    private  Integer quantity;

    public long getProductId() {
        return ProductId;
    }

    public void setProductId(long productId) {
        ProductId = productId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
