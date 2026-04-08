package com.krayzee.krenzeeproduct.adapter.gateway;

import com.krayzee.krenzeeproduct.adapter.dynamodb.repository.ProductRepository;
import com.krayzee.krenzeeproduct.adapter.dynamodb.table.Product;
import com.krayzee.krenzeeproduct.adapter.gateway.request.ProductFilterRequest;
import com.krayzee.krenzeeproduct.adapter.mapper.ProductMapper;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductDTO;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductResponseContent;
import com.krayzee.krenzeeproduct.adapter.gateway.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductGateway {
    
    private final ProductRepository productRepository;
    
    private final ProductMapper productMapper;
    
    public GenericResponse<ProductResponseContent> getProducts(ProductFilterRequest productFilterRequest) {
        
        PageIterable<Product> productPageIterable = productRepository.getProducts(productFilterRequest);
        return productMapper.toGenericResponse(productPageIterable);
    }
    
}
