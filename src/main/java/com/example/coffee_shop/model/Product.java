package com.example.coffee_shop.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ProductId", nullable = false)
    private Integer productId;
    @Column(name="Type", nullable = false)
    private String type;
    @Column(name="Description", nullable = false)
    private String description;
    @Column(name="Price", nullable = false)
    private double price;

    public Product() {
    }

    public Product(String type, String description, double price) {
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
