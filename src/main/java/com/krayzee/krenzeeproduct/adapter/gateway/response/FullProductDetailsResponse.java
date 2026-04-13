package com.krayzee.krenzeeproduct.adapter.gateway.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductDetailsDTO;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductPriceModelDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Getter
public class FullProductDetailsResponse { 

    @JsonProperty("productDetails")
    private ProductDetailsDTO productDetailsDTO; 
    
    @JsonProperty("productPriceModel")
    private ProductPriceModelDTO productPriceModelDTO;

}
