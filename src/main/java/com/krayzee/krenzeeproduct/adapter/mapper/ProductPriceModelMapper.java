package com.krayzee.krenzeeproduct.adapter.mapper;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductPriceModel;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductPriceModelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductPriceModelMapper { 

    @Mapping(target = "prices", source = "prices")
    ProductPriceModelDTO toDTO(ProductPriceModel productPriceModel);

}
