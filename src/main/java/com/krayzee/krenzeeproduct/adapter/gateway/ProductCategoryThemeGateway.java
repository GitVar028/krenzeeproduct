package com.krayzee.krenzeeproduct.adapter.gateway;

import com.krayzee.krenzeeproduct.adapter.dynamodb.repository.ProductCategoryThemeRepository;
import com.krayzee.krenzeeproduct.adapter.gateway.response.GenericResponse;
import com.krayzee.krenzeeproduct.adapter.mapper.ProductCategoryThemeMapper;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductCategoryThemeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryThemeGateway {
    
    private final ProductCategoryThemeRepository productCategoryRepository;
    
    private final ProductCategoryThemeMapper productCategoryThemeMapper;
    
    public GenericResponse<ProductCategoryThemeDTO> getThemesByCategoryCode(String categoryCode) {
        return new GenericResponse<>("200",
                "Success",
                productCategoryThemeMapper.toDTO(productCategoryRepository.getThemesByCategoryCode(categoryCode)));
    }
    
}
