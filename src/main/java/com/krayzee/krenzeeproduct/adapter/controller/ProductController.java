package com.krayzee.krenzeeproduct.adapter.controller;

import com.krayzee.krenzeeproduct.adapter.gateway.ProductCategoryGateway;
import com.krayzee.krenzeeproduct.adapter.gateway.ProductCategoryThemeGateway;
import com.krayzee.krenzeeproduct.adapter.gateway.ProductGateway;
import com.krayzee.krenzeeproduct.adapter.gateway.ProductTypeGateway;
import com.krayzee.krenzeeproduct.adapter.gateway.request.ProductFilterRequest;
import com.krayzee.krenzeeproduct.adapter.gateway.response.FullProductDetailsResponse;
import com.krayzee.krenzeeproduct.adapter.gateway.response.GenericResponse;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductCategoryDTO;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductCategoryThemeDTO;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductResponseContent;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductTypeDTO;
import com.krayzee.krenzeeproduct.usecase.ProductDetailsInteractor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductGateway productGateway;
    
    private final ProductCategoryThemeGateway productCategoryThemeGateway;
    
    private final ProductCategoryGateway productCategoryGateway; 
    
    private final ProductTypeGateway productTypeGateway;
    
    private final ProductDetailsInteractor productDetailsInteractor;
    
    @GetMapping("/product-categories")
    public ResponseEntity<GenericResponse<List<ProductCategoryDTO>>> getProductCategories() {
        return ResponseEntity.ok(productCategoryGateway.getAllActiveProductCategory());
    }
    
    @GetMapping("/product-category-themes")
    public ResponseEntity<GenericResponse<ProductCategoryThemeDTO>> getThemesByCategoryCode(@RequestParam(name = "categoryTypeId") String categoryTypeId) {
        return ResponseEntity.ok(productCategoryThemeGateway.getThemesByCategoryCode(categoryTypeId));
    }
    
    @GetMapping("/product-types")
    public ResponseEntity<GenericResponse<List<ProductTypeDTO>>> getProductTypesByCategoryCode(@RequestParam(name = "categoryTypeId") String categoryTypeId) {
        return ResponseEntity.ok(new GenericResponse<>("200", "Success", productTypeGateway.getProductTypesByCategoryCode(categoryTypeId)));
    }
    
    @PostMapping("/products")
    public ResponseEntity<GenericResponse<ProductResponseContent>> getProducts(@RequestBody ProductFilterRequest productFilterRequest) {
        return ResponseEntity.ok(productGateway.getProducts(productFilterRequest));
        
    }
    
    @GetMapping("/product-details")
    public ResponseEntity<GenericResponse<FullProductDetailsResponse>> getProductDetailsBySKU(@RequestParam("sku") String sku) {
        return ResponseEntity.ok(
            new GenericResponse<>("200", "Success", productDetailsInteractor.getFullProductDetails(sku))
        );
    }
    
    
}
