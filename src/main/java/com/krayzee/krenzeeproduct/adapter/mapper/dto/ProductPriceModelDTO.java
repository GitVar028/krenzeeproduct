package com.krayzee.krenzeeproduct.adapter.mapper.dto;

import java.util.Map;

public record ProductPriceModelDTO(
    String sku,
    Map<String, String> prices
) {}