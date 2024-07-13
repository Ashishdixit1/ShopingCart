package com.org.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product ;

    @ManyToOne
    @JoinColumn(name = "buyer_id",nullable = false)
    private Buyer buyer ;

   private Integer quantity;
   private BigDecimal price;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
