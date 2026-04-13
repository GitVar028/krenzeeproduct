package com.krayzee.krenzeeproduct.adapter.mapper.dto;

import java.util.Map;
import java.util.Set;

public record ProductDetailsDTO(String sku,
                                String description,
                                Set<String>productImageUrls,
                                Map<String, String>specifications) {
}
