package com.krayzee.krenzeeproduct.adapter.dynamodb.repository;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductCategory;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.List;
import java.util.Map;

@Repository
public class ProductCategoryRepository {
    
    private final DynamoDbTable<ProductCategory> productCategoryDynamoDbTable;
    
    public ProductCategoryRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.productCategoryDynamoDbTable = dynamoDbEnhancedClient.table("product_category",
                TableSchema.fromBean(ProductCategory.class));
    }
    
    
    public List<ProductCategory> getAllActiveProductCategory() {
        
        Map<String, AttributeValue> expressionValues = Map.of(
                ":statusVal", AttributeValue.builder().s("ACTIVE").build()
        );
        
        Expression filterExpression = Expression.builder()
                .expression("category_status = :statusVal")
                .expressionValues(expressionValues)
                .build();
        
        ScanEnhancedRequest scanRequest = ScanEnhancedRequest.builder()
                .filterExpression(filterExpression)
                .build();
        
        return productCategoryDynamoDbTable.scan(scanRequest)
                .items()
                .stream()
                .toList();
    }
    
}
