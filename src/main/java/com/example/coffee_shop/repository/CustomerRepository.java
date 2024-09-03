package com.example.coffee_shop.repository;

import com.example.coffee_shop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
