package com.krayzee.krenzeeproduct.adapter.dynamodb.table;

import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class ProductDetailsRepository {
    
    private final DynamoDbTable<ProductDetails> productDetailsDynamoDbTable;
    
    public ProductDetailsRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.productDetailsDynamoDbTable = dynamoDbEnhancedClient.table("product_details",
                TableSchema.fromBean(ProductDetails.class));
    }
    
    public ProductDetails getProductDetailsBySKU(String sku) {
        Key key = Key.builder().partitionValue(sku).build();
        return productDetailsDynamoDbTable.getItem(key);
    }
    
    
}
