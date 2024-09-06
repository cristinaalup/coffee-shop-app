package com.example.coffee_shop.controller;

import com.example.coffee_shop.model.CustomerOrderResponseDto;
import com.example.coffee_shop.model.OrderProductRequestDto;
import com.example.coffee_shop.service.IOrderService;
import com.example.coffee_shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private IOrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<?> placeOrder(@RequestParam Integer customerId, @RequestBody List<OrderProductRequestDto> products){
        try{
            CustomerOrderResponseDto order = orderService.placeOrder(customerId,products);
            return ResponseEntity.ok(order);
        }catch(RuntimeException e){
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders(){
        try{
            List<CustomerOrderResponseDto> orders = orderService.getAllOrders();
            return ResponseEntity.ok(orders);
        }catch(RuntimeException e){
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
