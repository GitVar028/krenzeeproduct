package com.krayzee.krenzeeproduct.adapter.gateway.request;

import lombok.Data;

import java.util.List;

@Data
public class ProductFilterRequest { 

    private String productCode; 
    
    private String lastSku; 
    
    private int pageLimit; 
    
    private List<String> themes;
    
    private List<String> productTypeTags; 

}
