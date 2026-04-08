package com.krayzee.krenzeeproduct.adapter.controller;

import com.krayzee.krenzeeproduct.adapter.gateway.ProductCategoryGateway;
import com.krayzee.krenzeeproduct.adapter.gateway.response.GenericResponse;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductCategoryController {
    
    private final ProductCategoryGateway productCategoryGateway; 
    
    @GetMapping("/product-categories")
    public ResponseEntity<GenericResponse<List<ProductCategoryDTO>>> getProductCategories() {
        return ResponseEntity.ok(productCategoryGateway.getAllActiveProductCategory());
    }
    
    
    
}
