package com.krayzee.krenzeeproduct.adapter.mapper;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductCategory;
import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductSubCategory;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductCategoryDTO;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductSubCategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductSubCategoryMapper { 

    @Mapping(target = "subCategoryCode", source = "subCategoryCode")
    @Mapping(target = "subCategoryName", source = "subCategoryName")
    @Mapping(target = "subCategoryImage", source = "subCategoryImage")
    @Mapping(target = "subCategoryStatus", source = "subCategoryStatus")
    ProductSubCategoryDTO toDTO(ProductSubCategory entity);
    
    List<ProductSubCategoryDTO> toDTOList(List<ProductSubCategory> entities);

    // Note: When mapping BACK to an entity from a Record, MapStruct will use 
    // the Record's accessor methods (e.g., dto.code() instead of dto.getCode())
    @Mapping(target = "subCategoryCode", source = "subCategoryCode")
    @Mapping(target = "subCategoryName", source = "subCategoryName")
    @Mapping(target = "subCategoryImage", source = "subCategoryImage")
    @Mapping(target = "subCategoryStatus", source = "subCategoryStatus")
    ProductSubCategory toEntity(ProductSubCategoryDTO dto);
    
    List<ProductSubCategory> toEntityList(List<ProductSubCategoryDTO> dtos);

}
