package com.krayzee.krenzeeproduct.adapter.dynamodb;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProductCategory {
    
    private String productCategoryCode;
    
    private String productCategoryName;
    
    private String productCategoryImage;
    
    private String status;
    
    @DynamoDbPartitionKey
    @DynamoDbAttribute("category_code")
    public String getProductCategoryCode() {
        return productCategoryCode;
    }
    
    @DynamoDbAttribute("category_name")
    public String getProductCategoryName() {
        return productCategoryName;
    }
    
    @DynamoDbAttribute("category_image")
    public String getProductCategoryImage() {
        return productCategoryImage;
    }
    
    @DynamoDbAttribute("category_status")
    public String getStatus() {
        return status;
    }
}
