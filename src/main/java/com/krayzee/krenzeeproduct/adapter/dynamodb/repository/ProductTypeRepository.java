package com.krayzee.krenzeeproduct.adapter.dynamodb.repository;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductType;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;

@Repository
public class ProductTypeRepository {
    
    private final DynamoDbTable<ProductType> productTypeDynamoDbTable;
    
    public ProductTypeRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.productTypeDynamoDbTable = dynamoDbEnhancedClient.table("product_type",
                TableSchema.fromBean(ProductType.class));
    }
    
    public List<ProductType> getProductTypesByCategoryCode(String categoryTypeId) {
        
        Key key = Key.builder()
                .partitionValue(categoryTypeId)
                .build();
        
        QueryEnhancedRequest request = QueryEnhancedRequest.builder()
                .queryConditional(QueryConditional.keyEqualTo(key))
                .build();
        return productTypeDynamoDbTable.query(request)
                .items()
                .stream()
                .toList();
    }
    
}
