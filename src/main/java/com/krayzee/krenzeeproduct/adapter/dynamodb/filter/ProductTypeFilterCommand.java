package com.krayzee.krenzeeproduct.adapter.dynamodb.filter;

import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductTypeFilterCommand implements FilterCommand {
    
    private final List<String> tags;
    
    public ProductTypeFilterCommand(List<String> tags) {
        this.tags = tags;
    }
    
    @Override
    public void execute(FilterContext context) {
        if (tags == null || tags.isEmpty()) return;

        StringBuilder sb = new StringBuilder();
        Map<String, AttributeValue> values = new HashMap<>();

        for (int i = 0; i < tags.size(); i++) {
            String key = ":tag" + i;
            if (i > 0) sb.append(" OR ");
            sb.append("contains(product_type.product_type_tags, ").append(key).append(")");
            values.put(key, AttributeValue.builder().s(tags.get(i)).build());
        }

        Expression themesExpr = Expression.builder()
                .expression("(" + sb + ")")
                .expressionValues(values)
                .build();

        // Update the context with the merged expression
        Expression current = context.getFilterExpression();
        context.setFilterExpression(Expression.builder()
                .expression(current.expression() + " AND " + themesExpr.expression())
                .expressionValues(Stream.concat(
                        current.expressionValues().entrySet().stream(),
                        themesExpr.expressionValues().entrySet().stream()
                ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1)))
                .build());
    }
}
