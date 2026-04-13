package com.krayzee.krenzeeproduct.adapter.gateway;

import com.krayzee.krenzeeproduct.adapter.dynamodb.repository.ProductTypeRepository;
import com.krayzee.krenzeeproduct.adapter.mapper.ProductTypeMapper;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductTypeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
@RequiredArgsConstructor
public class ProductTypeGateway { 
    
    private final ProductTypeRepository productTypeRepository; 
    
    private final ProductTypeMapper productTypeMapper; 
    
    public List<ProductTypeDTO> getProductTypesByCategoryCode(String categoryCode) {
        return productTypeMapper.toDTOs(productTypeRepository.getProductTypesByCategoryCode(categoryCode));
    }

}
