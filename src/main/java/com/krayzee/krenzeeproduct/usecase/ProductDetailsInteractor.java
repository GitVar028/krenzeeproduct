package com.krayzee.krenzeeproduct.usecase;

import com.krayzee.krenzeeproduct.adapter.gateway.ProductDetailsGateway;
import com.krayzee.krenzeeproduct.adapter.gateway.ProductPriceModelGateway;
import com.krayzee.krenzeeproduct.adapter.gateway.response.FullProductDetailsResponse;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductDetailsDTO;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductPriceModelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service 
@RequiredArgsConstructor
public class ProductDetailsInteractor { 

    private final ProductDetailsGateway productDetailsGateway; 
    
    private final ProductPriceModelGateway productPriceModelGateway;
    
    public FullProductDetailsResponse getFullProductDetails(String sku) {
        
        Objects.requireNonNull(sku);
        ProductDetailsDTO productDetailsDTO = productDetailsGateway.getProductDetailsBySKU(sku);
        ProductPriceModelDTO priceModelDTO = productPriceModelGateway.getProductPriceModelBySKU(sku);
        return new FullProductDetailsResponse(productDetailsDTO, priceModelDTO);
    }

}
