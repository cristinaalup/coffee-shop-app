package com.example.coffee_shop.controller;

import com.example.coffee_shop.model.Product;
import com.example.coffee_shop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        try{
            List<Product> products = productService.getAllProducts();
            return ResponseEntity.ok(products);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/admin")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        try{
            Product newProduct = productService.createProduct(product);
            return ResponseEntity.ok(newProduct);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
