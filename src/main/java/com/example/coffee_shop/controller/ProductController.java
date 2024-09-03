package com.example.coffee_shop.controller;

import com.example.coffee_shop.model.Product;
import com.example.coffee_shop.service.IProductService;
import com.example.coffee_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/admin")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newProduct = productService.createProduct(product);
        return ResponseEntity.ok(newProduct);
    }
}
