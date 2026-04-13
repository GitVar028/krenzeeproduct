package com.krayzee.krenzeeproduct.adapter.gateway;

import com.krayzee.krenzeeproduct.adapter.dynamodb.repository.ProductPriceModelRepository;
import com.krayzee.krenzeeproduct.adapter.mapper.ProductPriceModelMapper;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductPriceModelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service 
@RequiredArgsConstructor
public class ProductPriceModelGateway { 

    private final ProductPriceModelRepository productPriceModelRepository; 
    
    private final ProductPriceModelMapper productPriceModelMapper;
    
    public ProductPriceModelDTO getProductPriceModelBySKU(String sku) {
        return productPriceModelMapper.toDTO(productPriceModelRepository.getProductPriceModelBySKU(sku));
    }

}
