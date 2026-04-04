package com.krayzee.krenzeeproduct.adapter.mapper;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductCategory;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductCategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductCategoryMapper {

    @Mapping(target = "categoryCode", source = "productCategoryCode")
    @Mapping(target = "categoryName", source = "productCategoryName")
    @Mapping(target = "imageUrl", source = "productCategoryImage")
    @Mapping(target = "status", source = "status")
    ProductCategoryDTO toDTO(ProductCategory entity);
    
    List<ProductCategoryDTO> toDTOList(List<ProductCategory> entities);

    // Note: When mapping BACK to an entity from a Record, MapStruct will use 
    // the Record's accessor methods (e.g., dto.code() instead of dto.getCode())
    @Mapping(target = "productCategoryCode", source = "categoryCode")
    @Mapping(target = "productCategoryName", source = "categoryName")
    @Mapping(target = "productCategoryImage", source = "imageUrl")
    @Mapping(target = "status", source = "status")
    ProductCategory toEntity(ProductCategoryDTO dto);
    
    List<ProductCategory> toEntityList(List<ProductCategoryDTO> dtos);
}
