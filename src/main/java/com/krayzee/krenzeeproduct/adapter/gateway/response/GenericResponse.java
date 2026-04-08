package com.krayzee.krenzeeproduct.adapter.gateway.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor 
@Getter
public class GenericResponse<O> { 

    private String code; 
    
    private String message; 
    
    private O response;

}
