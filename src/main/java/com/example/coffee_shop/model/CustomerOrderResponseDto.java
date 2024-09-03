package com.example.coffee_shop.model;

import java.time.LocalDate;

public class CustomerOrderResponseDto {
    private Integer orderId;
    private Integer customerId;
    private Double totalPrice;
    private LocalDate orderDate;

    public CustomerOrderResponseDto(Integer orderId, Integer customerId, Double totalPrice, LocalDate orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    // Getters and setters

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
