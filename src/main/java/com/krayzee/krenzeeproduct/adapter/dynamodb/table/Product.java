package com.krayzee.krenzeeproduct.adapter.dynamodb.table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Product {
    
    private String categoryTypeId;
    
    private String sku;
    
    private String productName;
    
    private String productImageUrl;
    
    private String purchaseModel;
    
    private String productStatus;
    
    private ProductPriceModel productPriceModel;
    
    private ProductCategoryTheme productTheme;
    
    private ProductType productType;
    
    
    @DynamoDbPartitionKey
    @DynamoDbAttribute("category_type_id")
    public String getCategoryTypeId() {
        return categoryTypeId;
    }
    
    @DynamoDbSortKey
    @DynamoDbAttribute("sku")
    public String getSku() {
        return sku;
    }
    
    @DynamoDbAttribute("product_name")
    public String getProductName() {
        return productName;
    }
    
    @DynamoDbAttribute("product_image_url")
    public String getProductImageUrl() {
        return productImageUrl;
    }
    
    @DynamoDbAttribute("purchase_model")
    public String getPurchaseModel() {
        return purchaseModel;
    }
    
    @DynamoDbAttribute("product_status")
    public String getProductStatus() {
        return productStatus;
    }
    
    @DynamoDbAttribute("product_price_model")
    public ProductPriceModel getProductPriceModel() {
        return productPriceModel;
    }
    
    @DynamoDbAttribute("product_theme")
    public ProductCategoryTheme getProductTheme() {
        return productTheme;
    }
    
    @DynamoDbAttribute("product_type")
    public ProductType getProductType() {
        return productType;
    }
}
