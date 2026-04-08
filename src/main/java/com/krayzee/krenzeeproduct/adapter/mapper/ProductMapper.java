package com.krayzee.krenzeeproduct.adapter.mapper;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.Product;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductDTO;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductResponseContent;
import com.krayzee.krenzeeproduct.adapter.gateway.response.GenericResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                ProductPriceModelMapper.class,
                ProductTypeMapper.class
        })
public interface ProductMapper {
    
    
    @Mapping(target = "productCode", source = "productCode")
    @Mapping(target = "sku", source = "sku")
    @Mapping(target = "productName", source = "productName")
    @Mapping(target = "productImageUrl", source = "productImageUrl")
    @Mapping(target = "purchaseModel", source = "purchaseModel")
    @Mapping(target = "productStatus", source = "productStatus")
    @Mapping(target = "productPriceModel", source = "productPriceModel")
    ProductDTO toDTO(Product entity);
    
    @Mapping(target = "code", constant = "200")
    @Mapping(target = "message", constant = "Success")
    @Mapping(source = "productPageIterable", target = "response", qualifiedByName = "convertToProductResponseContent")
    GenericResponse<ProductResponseContent> toGenericResponse(PageIterable<Product> productPageIterable);
    
    
    @Named("convertToProductResponseContent")
    default ProductResponseContent convertToProductResponseContent(PageIterable<Product> productPageIterable) {
        if ( productPageIterable == null ) {
            return null;
        }
        Page<Product> page = productPageIterable.iterator().next();
        
        List<ProductDTO> list = new ArrayList<>(page.items().size() );
        for ( Product product : page.items() ) {
            list.add( toDTO( product ) );
        }
        long totalNumberOfItems = productPageIterable.items().stream().count();
        
        ProductResponseContent productResponseContent = new ProductResponseContent();
        productResponseContent.setProducts(list);
        productResponseContent.setNumberOfItems((int) totalNumberOfItems);
        String nextSku = null;
        if (page.lastEvaluatedKey() != null && !page.lastEvaluatedKey().isEmpty()) {
            nextSku = page.lastEvaluatedKey().get("sku").s();
        }
        productResponseContent.setNextSkuToken(nextSku);
        return productResponseContent;
    }
    
    /**
     * Automatically maps a List of Entities to a List of Record DTOs.
     */
    List<ProductDTO> toDTOList(List<Product> entities);
    
}