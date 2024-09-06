package com.example.coffee_shop.service;

import com.example.coffee_shop.model.*;
import com.example.coffee_shop.repository.CustomerOrderRepository;
import com.example.coffee_shop.repository.CustomerRepository;
import com.example.coffee_shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService{

    private  CustomerRepository customerRepository;

    private  ProductRepository productRepository;

    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    public OrderService(CustomerRepository customerRepository, ProductRepository productRepository,
                        CustomerOrderRepository customerOrderRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.customerOrderRepository = customerOrderRepository;
    }

    @Override
    public CustomerOrderResponseDto placeOrder(Integer customerId, List<OrderProductRequestDto> products) {
        Customer customer=customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found."));

        double totalPrice = 0.0;
        CustomerOrder order = new CustomerOrder();
        order.setCustomer(customer);
        order.setOrderDate(LocalDate.now());
        List<OrderProduct> orderProductList = new ArrayList<>();
        for (OrderProductRequestDto productDto : products){
            Product product = productRepository.findById(productDto.getProductId()).orElseThrow(() -> new RuntimeException("Product not found."));

            totalPrice += product.getPrice() * productDto.getQuantity();

            OrderProductId orderProductId = new OrderProductId(order.getOrderId(), product.getProductId());
            OrderProduct orderProduct = new OrderProduct(orderProductId, order, product, productDto.getQuantity());
            orderProductList.add(orderProduct);
        }
        order.setTotalPrice(totalPrice);
        order.setOrderProducts(orderProductList);

        CustomerOrder savedOrder = customerOrderRepository.save(order);

        return new CustomerOrderResponseDto(savedOrder.getOrderId(), customer.getCustomerId(), savedOrder.getTotalPrice(), savedOrder.getOrderDate());
    }

    @Override
    public List<CustomerOrderResponseDto> getAllOrders() {
        return customerOrderRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
    private CustomerOrderResponseDto mapToDto(CustomerOrder order) {
        return new CustomerOrderResponseDto(
                order.getOrderId(),
                order.getCustomer().getCustomerId(),
                order.getTotalPrice(),
                order.getOrderDate()
        );
    }
}
