package com.krayzee.krenzeeproduct.adapter.gateway;

import com.krayzee.krenzeeproduct.adapter.dynamodb.repository.ProductSubCategoryRepository;
import com.krayzee.krenzeeproduct.adapter.mapper.ProductSubCategoryMapper;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductSubCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
@RequiredArgsConstructor
public class ProductSubCategoryGateway { 

    private final ProductSubCategoryRepository productSubCategoryRepository; 
    
    private final ProductSubCategoryMapper productSubCategoryMapper;

    public List<ProductSubCategoryDTO> getActiveSubCategories() {
        return productSubCategoryMapper.toDTOList(productSubCategoryRepository.getActiveSubCategories());
    }

}
