package com.org.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long ProductId;

    @ManyToOne
    @JoinColumn(name = "seller_id",nullable = false)
    private Seller seller;

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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
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
