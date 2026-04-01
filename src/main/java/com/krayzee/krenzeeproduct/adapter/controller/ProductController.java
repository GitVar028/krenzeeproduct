package com.krayzee.krenzeeproduct.adapter.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController 
@RequestMapping("/api")
public class ProductController { 

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(
                List.of(
                    new Product("54321", "Wedding Invitation"), 
                    new Product("12345", "Key Chains") 
                )
        );
    }
    
    @AllArgsConstructor 
    @Getter
    public static final class Product {
        private String productCode; 
        private String productName;
    }
    

}
