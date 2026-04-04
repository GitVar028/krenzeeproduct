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
public class ProductSubCategory {
    
    private String subCategoryCode;
    
    private String subCategoryName;
    
    private String subCategoryImage;
    
    private String subCategoryStatus;
    
    @DynamoDbPartitionKey
    @DynamoDbAttribute("sub_category_code")
    public String getSubCategoryCode() {
        return subCategoryCode;
    }
    
    @DynamoDbAttribute("sub_category_name")
    public String getSubCategoryName() {
        return subCategoryName;
    }
    
    @DynamoDbAttribute("sub_category_image")
    public String getSubCategoryImage() {
        return subCategoryImage;
    }
    
    @DynamoDbAttribute("sub_category_status")
    public String getSubCategoryStatus() {
        return subCategoryStatus;
    }
}
