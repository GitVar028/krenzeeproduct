package com.krayzee.krenzeeproduct.adapter.gateway;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductDetailsRepository;
import com.krayzee.krenzeeproduct.adapter.gateway.response.GenericResponse;
import com.krayzee.krenzeeproduct.adapter.mapper.ProductDetailsMapper;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductDetailsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDetailsGateway {
    
    private final ProductDetailsRepository productDetailsRepository;
    
    private final ProductDetailsMapper productDetailsMapper;
    
    public ProductDetailsDTO getProductDetailsBySKU(String sku) {
        return productDetailsMapper.toDTO(productDetailsRepository.getProductDetailsBySKU(sku));
    }
    
}
