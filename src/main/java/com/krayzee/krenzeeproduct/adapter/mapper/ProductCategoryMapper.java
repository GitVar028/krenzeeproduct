package com.krayzee.krenzeeproduct.adapter.mapper;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductCategory;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductCategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductCategoryMapper {

    @Mapping(target = "categoryCode", source = "categoryCode")
    @Mapping(target = "categoryName", source = "categoryName")
    @Mapping(target = "categoryImageUrl", source = "categoryImageUrl")
    @Mapping(target = "categoryStatus", source = "categoryStatus")
    ProductCategoryDTO toDTO(ProductCategory entity);
    
    List<ProductCategoryDTO> toDTOList(List<ProductCategory> entities);

    List<ProductCategory> toEntityList(List<ProductCategoryDTO> dtos);
}
