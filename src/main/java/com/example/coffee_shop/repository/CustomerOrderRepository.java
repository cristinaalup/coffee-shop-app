package com.example.coffee_shop.repository;

import com.example.coffee_shop.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Integer> {
}
