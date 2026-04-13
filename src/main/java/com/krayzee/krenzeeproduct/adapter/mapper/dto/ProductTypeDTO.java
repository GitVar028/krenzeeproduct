package com.krayzee.krenzeeproduct.adapter.mapper.dto;

import java.util.Set;

public record ProductTypeDTO(String categoryTypeId,
                             String productTypeName,
                             Set<String> productTypeTags) {
}
