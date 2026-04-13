package com.krayzee.krenzeeproduct.adapter.dynamodb.table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.Set;

@DynamoDbBean
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProductType { 

    private String categoryTypeId; 
    
    private String productTypeName; 
    
    private Set<String> productTypeTags;
    
    @DynamoDbPartitionKey
    @DynamoDbAttribute("category_type_id")
    public String getCategoryTypeId() {
        return categoryTypeId;
    }
    
    @DynamoDbAttribute("product_type_name")
    public String getProductTypeName() {
        return productTypeName;
    }
    
    @DynamoDbAttribute("product_type_tags")
    public Set<String> getProductTypeTags() {
        return productTypeTags;
    }
}
