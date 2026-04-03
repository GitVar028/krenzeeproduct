package com.krayzee.krenzeeproduct.adapter.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor 
@Getter
public class GenericResponse { 

    private String code; 
    
    private String message; 
    
    private Object response;

}
