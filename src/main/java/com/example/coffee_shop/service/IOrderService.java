package com.example.coffee_shop.service;

import com.example.coffee_shop.model.CustomerOrderResponseDto;
import com.example.coffee_shop.model.OrderProductRequestDto;

import java.util.List;

public interface IOrderService {
    CustomerOrderResponseDto placeOrder(Integer customerId, List<OrderProductRequestDto> products);
    List<CustomerOrderResponseDto> getAllOrders();
}
