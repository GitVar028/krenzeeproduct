package com.krayzee.krenzeeproduct.adapter.controller;

import com.krayzee.krenzeeproduct.adapter.gateway.ProductCategoryGateway;
import com.krayzee.krenzeeproduct.adapter.gateway.ProductSubCategoryGateway;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductCategoryDTO;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductSubCategoryDTO;
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
public class ProductCategoryController {
    
    private final ProductCategoryGateway productCategoryGateway; 
    
    private final ProductSubCategoryGateway productSubCategoryGateway;
    
    @GetMapping("/product-categories")
    public ResponseEntity<GenericResponse> getProductCategories() {
        List<ProductCategoryDTO> productCategories = productCategoryGateway.getAllActiveProductCategory();
        return ResponseEntity.ok(
            new GenericResponse("200", "Success", productCategories)
        );
    }
    
    @GetMapping("/product-sub-categories")
    public ResponseEntity<GenericResponse> getProductSubCategories() {
        List<ProductSubCategoryDTO> activeSubCategories = productSubCategoryGateway.getActiveSubCategories();
        return ResponseEntity.ok(
            new GenericResponse("200", "Success", activeSubCategories)
        );
    }
    
}
