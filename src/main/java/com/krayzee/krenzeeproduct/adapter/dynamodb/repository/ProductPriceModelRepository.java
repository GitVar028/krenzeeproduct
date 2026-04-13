package com.krayzee.krenzeeproduct.adapter.dynamodb.repository;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductPriceModel;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class ProductPriceModelRepository {
    
    private final DynamoDbTable<ProductPriceModel> productPriceModelDynamoDbTable;
    
    public ProductPriceModelRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.productPriceModelDynamoDbTable = dynamoDbEnhancedClient.table("product_price_model",
                TableSchema.fromBean(ProductPriceModel.class));
    }
    
    public ProductPriceModel getProductPriceModelBySKU(String sku) {
        Key key = Key.builder()
                .partitionValue(sku)
                .build();
        return productPriceModelDynamoDbTable.getItem(key);
    }
    
    
}
