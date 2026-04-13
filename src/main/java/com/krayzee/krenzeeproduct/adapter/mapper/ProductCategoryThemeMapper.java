package com.krayzee.krenzeeproduct.adapter.mapper;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductCategoryTheme;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductCategoryThemeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductCategoryThemeMapper { 

    ProductCategoryThemeDTO toDTO(ProductCategoryTheme productCategoryTheme);
    
    List<ProductCategoryThemeDTO> toDTOs(List<ProductCategoryTheme> productCategoryThemes);

}
