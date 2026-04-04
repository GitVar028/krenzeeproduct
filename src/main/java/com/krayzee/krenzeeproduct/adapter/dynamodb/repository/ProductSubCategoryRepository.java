package com.krayzee.krenzeeproduct.adapter.dynamodb.repository;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductSubCategory;
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
public class ProductSubCategoryRepository { 

    private final DynamoDbTable<ProductSubCategory> productSubCategoryDynamoDbTable;
    
    public ProductSubCategoryRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.productSubCategoryDynamoDbTable = dynamoDbEnhancedClient.table("ProductSubCategory",
                TableSchema.fromBean(ProductSubCategory.class));
    }
    
    public List<ProductSubCategory> getActiveSubCategories() {
        Map<String, AttributeValue> expressionValues = Map.of(
            ":statusVal", AttributeValue.builder().s("ACTIVE").build()
            );
        
            Expression filterExpression = Expression.builder()
                    .expression("sub_category_status = :statusVal")
                    .expressionValues(expressionValues)
                    .build();
        
            ScanEnhancedRequest scanRequest = ScanEnhancedRequest.builder()
                    .filterExpression(filterExpression)
                    .build();
   
        return productSubCategoryDynamoDbTable.scan(scanRequest)
                .items()
                .stream()
                .toList();
    }

}
