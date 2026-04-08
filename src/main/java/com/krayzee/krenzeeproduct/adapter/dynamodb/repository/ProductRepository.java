package com.krayzee.krenzeeproduct.adapter.dynamodb.repository;

import com.krayzee.krenzeeproduct.adapter.dynamodb.filter.FilterCommand;
import com.krayzee.krenzeeproduct.adapter.dynamodb.filter.FilterContext;
import com.krayzee.krenzeeproduct.adapter.dynamodb.filter.ProductTypeFilterCommand;
import com.krayzee.krenzeeproduct.adapter.dynamodb.filter.ThemeFilterCommand;
import com.krayzee.krenzeeproduct.adapter.dynamodb.table.Product;
import com.krayzee.krenzeeproduct.adapter.gateway.request.ProductFilterRequest;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    
    private final DynamoDbTable<Product> productDynamoDbTable;
    
    public ProductRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.productDynamoDbTable = dynamoDbEnhancedClient.table("product",
                TableSchema.fromBean(Product.class));
    }
    
    public PageIterable<Product> getProducts(ProductFilterRequest productFilterRequest) {
        
        
        Map<String, AttributeValue> startKey = null;
        String lastSku = productFilterRequest.getLastSku();
        if (lastSku != null && !lastSku.isEmpty()) {
            startKey = new HashMap<>();
            // For a composite key, DynamoDB requires both the PK and SK to resume a query
            startKey.put("product_code", AttributeValue.builder().s(productFilterRequest.getProductCode()).build());
            startKey.put("sku", AttributeValue.builder().s(lastSku).build());
        }
        
        Expression filterExpression = Expression.builder()
                .expression("product_status = :status")
                .putExpressionValue(":status", AttributeValue.builder().s("IN_STOCK").build())
                .build();
        
        FilterContext context = new FilterContext(filterExpression);
        List<FilterCommand> commands = new ArrayList<>();
        
        // Conditional logic: Only add the command if there's work to do
        if (productFilterRequest.getThemes() != null && !productFilterRequest.getThemes().isEmpty()) {
            commands.add(new ThemeFilterCommand(productFilterRequest.getThemes()));
        }
        
        if(productFilterRequest.getProductTypeTags() != null && !productFilterRequest.getProductTypeTags().isEmpty()) {
            commands.add(new ProductTypeFilterCommand(productFilterRequest.getProductTypeTags()));
        }
        
        commands.forEach(command -> command.execute(context));
        
        QueryEnhancedRequest request = QueryEnhancedRequest.builder()
                .queryConditional(QueryConditional.keyEqualTo(
                        Key.builder().partitionValue(productFilterRequest.getProductCode()).build()
                ))
                .exclusiveStartKey(startKey)
                .filterExpression(context.getFilterExpression())
                .attributesToProject("product_code", "sku",
                        "product_name", "product_image_url",
                        "purchase_model", "product_status",
                        "product_price_model")
                .limit(productFilterRequest.getPageLimit())
                .build();
        return productDynamoDbTable.query(request);
        
    }
    
}
