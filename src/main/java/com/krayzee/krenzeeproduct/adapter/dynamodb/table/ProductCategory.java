package com.krayzee.krenzeeproduct.adapter.dynamodb.table;

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
    
    private String categoryTypeId;
    
    private String categoryName;
    
    private String categoryImageUrl;
    
    private String categoryStatus;
    
    @DynamoDbPartitionKey
    @DynamoDbAttribute("category_type_id")
    public String getCategoryTypeId() {
        return categoryTypeId;
    }
    
    @DynamoDbAttribute("category_name")
    public String getCategoryName() {
        return categoryName;
    }
    
    @DynamoDbAttribute("category_image_url")
    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }
    
    @DynamoDbAttribute("category_status")
    public String getCategoryStatus() {
        return categoryStatus;
    }
}
