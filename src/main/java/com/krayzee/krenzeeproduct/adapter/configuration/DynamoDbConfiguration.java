package com.krayzee.krenzeeproduct.adapter.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Configuration
public class DynamoDbConfiguration {
    
    @Value("${aws.dynamodb.endpoint:}")
    private String dynamoDbEndpoint;
    
    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                .region(Region.AP_SOUTHEAST_1)
                .endpointOverride(URI.create(dynamoDbEndpoint))
                // this will take the AWS_ACCESS_KEY configured using aws configure
                .credentialsProvider(DefaultCredentialsProvider.create()) 
                .build();
    }
    
    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }
    
    
}
