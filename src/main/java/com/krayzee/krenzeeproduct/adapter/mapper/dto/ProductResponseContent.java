package com.krayzee.krenzeeproduct.adapter.mapper.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductResponseContent { 

    private List<ProductDTO> products;
    
    private String nextSkuToken;
    
    private Integer numberOfItems;
    
}