package com.krayzee.krenzeeproduct.adapter.mapper;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.Product;
import com.krayzee.krenzeeproduct.adapter.mapper.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    /**
     * Complete mapping from Entity to Record DTO.
     * Note: MapStruct uses the Record's canonical constructor here.
     */
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "productCode", target = "productCode")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "productImageUrl", target = "imageUrl")
    @Mapping(source = "productImageUrls", target = "imagePaths")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "categoryCode", target = "categoryCode")
    @Mapping(source = "subCategoryCode", target = "subCategoryCode")
    @Mapping(source = "baseProductCode", target = "baseProductCode")
    @Mapping(source = "description", target = "description")
    ProductDTO toDTO(Product entity);

    /**
     * Automatically maps a List of Entities to a List of Record DTOs.
     */
    List<ProductDTO> toDTOList(List<Product> entities);

    /**
     * Complete reverse mapping from Record DTO back to Entity.
     * Note: MapStruct calls the Record's accessor methods (e.g., dto.code()).
     */
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "productCode", target = "productCode")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "imageUrl", target = "productImageUrl")
    @Mapping(source = "imagePaths", target = "productImageUrls")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "categoryCode", target = "categoryCode")
    @Mapping(source = "subCategoryCode", target = "subCategoryCode")
    @Mapping(source = "baseProductCode", target = "baseProductCode")
    @Mapping(source = "description", target = "description")
    Product toEntity(ProductDTO dto);

    /**
     * Maps a List of Record DTOs back to a List of Entities.
     */
    List<Product> toEntityList(List<ProductDTO> dtos);
}