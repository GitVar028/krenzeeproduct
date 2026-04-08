package com.krayzee.krenzeeproduct.adapter.controller;

import com.krayzee.krenzeeproduct.adapter.gateway.ProductGateway;
import com.krayzee.krenzeeproduct.adapter.gateway.request.ProductFilterRequest;
import com.krayzee.krenzeeproduct.adapter.gateway.response.GenericResponse;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductResponseContent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductGateway productGateway;
    
    @PostMapping("/products")
    public ResponseEntity<GenericResponse<ProductResponseContent>> getProducts(@RequestBody ProductFilterRequest productFilterRequest) {
        return ResponseEntity.ok(productGateway.getProducts(productFilterRequest));
        
    }
    
    
}
