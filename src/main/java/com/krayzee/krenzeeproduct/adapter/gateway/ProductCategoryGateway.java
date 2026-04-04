package com.krayzee.krenzeeproduct.adapter.gateway;

import com.krayzee.krenzeeproduct.adapter.dynamodb.repository.ProductCategoryRepository;
import com.krayzee.krenzeeproduct.adapter.mapper.ProductCategoryMapper;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
@RequiredArgsConstructor
public class ProductCategoryGateway { 

    private final ProductCategoryRepository productCategoryRepository;
    
    private final ProductCategoryMapper productCategoryMapper;

    public List<ProductCategoryDTO> getAllActiveProductCategory() {
        return productCategoryMapper.toDTOList(productCategoryRepository.getAllActiveProductCategory());
    }
    
}
