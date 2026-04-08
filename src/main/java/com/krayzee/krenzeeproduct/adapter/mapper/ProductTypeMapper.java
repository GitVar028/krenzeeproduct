package com.krayzee.krenzeeproduct.adapter.mapper;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductType;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductTypeMapper { 

    ProductTypeDTO toDTO(ProductType productType);
    
}
