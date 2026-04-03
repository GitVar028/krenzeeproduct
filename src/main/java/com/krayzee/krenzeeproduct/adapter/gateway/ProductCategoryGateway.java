package com.krayzee.krenzeeproduct.adapter.gateway;

import com.krayzee.krenzeeproduct.adapter.dynamodb.ProductCategoryRepository;
import com.krayzee.krenzeeproduct.adapter.mapper.ProductCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
@RequiredArgsConstructor
public class ProductCategoryGateway { 

    private final ProductCategoryRepository productCategoryRepository;
    
    public List<ProductCategoryDTO> getAllActiveProductCategory() {
        return productCategoryRepository.getAllActiveProductCategory();
    }
    
}
