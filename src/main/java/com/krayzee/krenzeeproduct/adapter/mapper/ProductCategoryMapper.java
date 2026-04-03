package com.krayzee.krenzeeproduct.adapter.mapper;

import com.krayzee.krenzeeproduct.adapter.dynamodb.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductCategoryMapper {

    @Mapping(source = "productCategoryCode", target = "categoryCode")
    @Mapping(source = "productCategoryName", target = "categoryName")
    @Mapping(source = "productCategoryImage", target = "imageUrl")
    @Mapping(source = "status", target = "status")
    ProductCategoryDTO toDTO(ProductCategory entity);
    
    List<ProductCategoryDTO> toDTOList(List<ProductCategory> entities);

    // Note: When mapping BACK to an entity from a Record, MapStruct will use 
    // the Record's accessor methods (e.g., dto.code() instead of dto.getCode())
    @Mapping(source = "categoryCode", target = "productCategoryCode")
    @Mapping(source = "categoryName", target = "productCategoryName")
    @Mapping(source = "imageUrl", target = "productCategoryImage")
    @Mapping(source = "status", target = "status")
    ProductCategory toEntity(ProductCategoryDTO dto);
    
    List<ProductCategory> toEntityList(List<ProductCategoryDTO> dtos);
}
