package com.krayzee.krenzeeproduct.adapter.dynamodb.repository;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.Product;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    
    private final DynamoDbTable<Product> productDynamoDbTable;
    
    public ProductRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.productDynamoDbTable = dynamoDbEnhancedClient.table("Product",
                TableSchema.fromBean(Product.class));
    }
    
    public List<Product> getProductByCategoryAndSubCategoryAndBaseProductCode(String categoryCode,
                                                                              String subCategoryCode,
                                                                              String baseProductCode) {
        
        Map<String, AttributeValue> expressionValues = new HashMap<>();
        
        List<String> conditions = new ArrayList<>();
        
        expressionValues.put(":categoryCode", AttributeValue.builder().s(categoryCode).build());
        conditions.add("category_code = :categoryCode");
        
        expressionValues.put(":subCategoryCode", AttributeValue.builder().s(subCategoryCode).build());
        conditions.add("sub_category_code = :subCategoryCode");
        
        if (baseProductCode != null && !baseProductCode.isBlank()) {
            expressionValues.put(":baseProductCode", AttributeValue.builder().s(baseProductCode).build());
            conditions.add("base_product_code = :baseProductCode");
        }
        
        String expressionString = String.join(" AND ", conditions);
        
        Expression filterExpression = Expression.builder()
                .expression(expressionString)
                .expressionValues(expressionValues)
                .build();
        
        ScanEnhancedRequest scanRequest = ScanEnhancedRequest.builder()
                .filterExpression(filterExpression)
                .build();
        
        return productDynamoDbTable.scan(scanRequest)
                .items()
                .stream()
                .toList();
    }
    
}
