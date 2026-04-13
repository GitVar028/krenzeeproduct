package com.krayzee.krenzeeproduct.adapter.mapper;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductDetails;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductDetailsMapper { 

    ProductDetailsDTO toDTO(ProductDetails productDetails);
    

}
