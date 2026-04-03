package com.krayzee.krenzeeproduct.adapter.dynamodb;

import com.krayzee.krenzeeproduct.adapter.mapper.ProductCategoryDTO;
import com.krayzee.krenzeeproduct.adapter.mapper.ProductCategoryMapper;
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
    
    private final ProductCategoryMapper productCategoryMapper;
    
    public ProductCategoryRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient, ProductCategoryMapper productCategoryMapper) {
        this.productCategoryDynamoDbTable = dynamoDbEnhancedClient.table("ProductCategory",
                TableSchema.fromBean(ProductCategory.class));
        this.productCategoryMapper = productCategoryMapper;
    }
    

   public List<ProductCategoryDTO> getAllActiveProductCategory() {
   
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
   
        List<ProductCategory> productCategories = productCategoryDynamoDbTable.scan(scanRequest)
                .items()
                .stream()
                .toList();
        return productCategoryMapper.toDTOList(productCategories);
   }

}
