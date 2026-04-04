package com.krayzee.krenzeeproduct.adapter.gateway;

import com.krayzee.krenzeeproduct.adapter.dynamodb.repository.ProductRepository;
import com.krayzee.krenzeeproduct.adapter.dynamodb.table.Product;
import com.krayzee.krenzeeproduct.adapter.mapper.ProductMapper;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductGateway {
    
    private final ProductRepository productRepository; 
    
    private final ProductMapper productMapper;
    
    public List<ProductDTO> getProductByCategoryAndSubCategoryAndBaseProductCode(String categoryCode,
                                                                              String subCategoryCode,
                                                                              String baseProductCode) {
        List<Product> products = productRepository.getProductByCategoryAndSubCategoryAndBaseProductCode(categoryCode, subCategoryCode, baseProductCode);
        return productMapper.toDTOList(products);
    }
    
}
