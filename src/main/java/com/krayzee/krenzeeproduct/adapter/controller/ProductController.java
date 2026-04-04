package com.krayzee.krenzeeproduct.adapter.controller;

import com.krayzee.krenzeeproduct.adapter.gateway.ProductGateway;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductCategoryDTO;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductDTO;
import com.krayzee.krenzeeproduct.adapter.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductGateway productGateway;
    
    @GetMapping("/products")
    public ResponseEntity<GenericResponse> getProductCategories(@RequestParam("category") String category,
                                                                @RequestParam("subCategory") String subCategory, 
                                                                @RequestParam("baseProductCode") String baseProductCode) {
        List<ProductDTO> productCategories = productGateway.getProductByCategoryAndSubCategoryAndBaseProductCode(category, subCategory, baseProductCode);
        return ResponseEntity.ok(
                new GenericResponse("200", "Success", productCategories)
        );
    }
    
    
}
