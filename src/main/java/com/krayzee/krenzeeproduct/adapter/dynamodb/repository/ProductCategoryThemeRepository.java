package com.krayzee.krenzeeproduct.adapter.dynamodb.repository;

import com.krayzee.krenzeeproduct.adapter.dynamodb.table.ProductCategoryTheme;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class ProductCategoryThemeRepository { 

    private final DynamoDbTable<ProductCategoryTheme> productCategoryThemeDynamoDbTable;
    
    public ProductCategoryThemeRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.productCategoryThemeDynamoDbTable = dynamoDbEnhancedClient.table("product_category_theme",
                TableSchema.fromBean(ProductCategoryTheme.class)); 
    } 
    
    public ProductCategoryTheme getThemesByCategoryCode(String categoryCode) {
    
        Key key = Key.builder().partitionValue(categoryCode).build();
        return productCategoryThemeDynamoDbTable.getItem(key);
    }
    

}
