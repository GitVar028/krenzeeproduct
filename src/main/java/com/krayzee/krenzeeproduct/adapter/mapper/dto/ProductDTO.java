package com.krayzee.krenzeeproduct.adapter.mapper.dto;

import java.util.Set;

public record ProductDTO(
    Integer productId,
    String productCode,
    String productName,
    String imageUrl,
    Set<String> imagePaths,
    String price,
    String categoryCode,
    String subCategoryCode,
    String baseProductCode,
    String description
) {}