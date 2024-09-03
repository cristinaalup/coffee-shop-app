package com.example.coffee_shop.service;

import com.example.coffee_shop.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAllProducts();
    Product createProduct(Product product);
}
