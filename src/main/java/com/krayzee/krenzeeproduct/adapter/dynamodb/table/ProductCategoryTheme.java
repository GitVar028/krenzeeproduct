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
public class ProductCategoryTheme {
    
    
    private String categoryTypeId;
    
    private Set<String> themes;
    
    @DynamoDbPartitionKey
    @DynamoDbAttribute("category_type_id")
    public String getCategoryTypeId() {
        return categoryTypeId;
    }
    
    @DynamoDbAttribute("themes")
    public Set<String> getThemes() {
        return themes;
    }
}
