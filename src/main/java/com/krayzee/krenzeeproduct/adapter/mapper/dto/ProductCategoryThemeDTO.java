package com.krayzee.krenzeeproduct.adapter.mapper.dto;

import java.util.Set;

public record ProductCategoryThemeDTO(String categoryCode,
                                      Set<String> themes) {
}
