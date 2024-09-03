package com.example.coffee_shop.model;

import jakarta.persistence.*;

@Entity
@Table(name="OrderProduct")
public class OrderProduct {
    @EmbeddedId
    private OrderProductId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "OrderId")
    private CustomerOrder customerOrder;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "ProductId")
    private Product product;

    @Column(name = "Quantity")
    private Integer quantity;

    public OrderProduct() {
    }

    public OrderProduct(OrderProductId id, CustomerOrder customerOrder, Product product, Integer quantity) {
        this.id = id;
        this.customerOrder = customerOrder;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderProductId getId() {
        return id;
    }

    public void setId(OrderProductId id) {
        this.id = id;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
