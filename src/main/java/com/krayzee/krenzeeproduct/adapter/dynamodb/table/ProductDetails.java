package com.krayzee.krenzeeproduct.adapter.dynamodb.table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.Map;
import java.util.Set;

@DynamoDbBean
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProductDetails {
    
    private String sku;
    
    private String description;
    
    private Set<String> productImageUrls;
    
    private Map<String, String> specifications;
    
    @DynamoDbPartitionKey
    @DynamoDbAttribute("sku")
    public String getSku() {
        return sku;
    }
    
    @DynamoDbAttribute("sku")
    public String getDescription() {
        return description;
    }
    
    @DynamoDbAttribute("product_image_urls")
    public Set<String> getProductImageUrls() {
        return productImageUrls;
    }
    
    @DynamoDbAttribute("specifications")
    public Map<String, String> getSpecifications() {
        return specifications;
    }
}
