package com.krayzee.krenzeeproduct.adapter.mapper.dto;

public record ProductDTO(
    String productCode,
    String sku,
    String productName,
    String productImageUrl,
    String purchaseModel,
    String productStatus,
    ProductPriceModelDTO productPriceModel
) {}