package com.krayzee.krenzeeproduct.adapter.dynamodb.table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.util.Set;

@DynamoDbBean
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Product {
    
    private Integer productId;
    
    private String productCode;
    
    private String productName;
    
    private String productImageUrl;
    
    private Set<String> productImageUrls;
    
    private String price;
    
    private String categoryCode;
    
    private String subCategoryCode;
    
    private String baseProductCode;
    
    private String description;
    
    @DynamoDbPartitionKey
    @DynamoDbAttribute("product_id")
    public Integer getProductId() {
        return productId;
    }
    
    @DynamoDbSortKey
    @DynamoDbAttribute("product_code")
    public String getProductCode() {
        return productCode;
    }
    
    @DynamoDbAttribute("product_name")
    public String getProductName() {
        return productName;
    }
    
    @DynamoDbAttribute("product_image_url")
    public String getProductImageUrl() {
        return productImageUrl;
    }
    
    @DynamoDbAttribute("product_image_urls")
    public Set<String> getProductImageUrls() {
        return productImageUrls;
    }
    
    @DynamoDbAttribute("price")
    public String getPrice() {
        return price;
    }
    
    @DynamoDbAttribute("category_code")
    public String getCategoryCode() {
        return categoryCode;
    }
    
    @DynamoDbAttribute("sub_category_code")
    public String getSubCategoryCode() {
        return subCategoryCode;
    }
    
    @DynamoDbAttribute("base_product_code")
    public String getBaseProductCode() {
        return baseProductCode;
    }
    
    @DynamoDbAttribute("description")
    public String getDescription() {
        return description;
    }
}
