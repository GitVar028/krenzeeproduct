package com.krayzee.krenzeeproduct.adapter.dynamodb.table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.Map;

@DynamoDbBean
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProductPriceModel {
    
    private String sku;
    
    private Map<String, String> prices;
    
    @DynamoDbPartitionKey
    @DynamoDbAttribute("sku")
    public String getSku() {
        return sku;
    }
    
    @DynamoDbAttribute("prices")
    public Map<String, String> getPrices() {
        return prices;
    }
}
