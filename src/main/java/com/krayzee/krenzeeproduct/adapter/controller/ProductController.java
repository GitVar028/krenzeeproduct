package com.krayzee.krenzeeproduct.adapter.controller;

import com.krayzee.krenzeeproduct.adapter.gateway.ProductCategoryGateway;
import com.krayzee.krenzeeproduct.adapter.mapper.ProductCategoryDTO;
import com.krayzee.krenzeeproduct.adapter.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductCategoryGateway productCategoryGateway;
    
    @GetMapping("/product-categories")
    public ResponseEntity<GenericResponse> getProducts() {
        List<ProductCategoryDTO> productCategories = productCategoryGateway.getAllActiveProductCategory();
        return ResponseEntity.ok(
            new GenericResponse("200", "Success", productCategories)
        );
    }
    
}
