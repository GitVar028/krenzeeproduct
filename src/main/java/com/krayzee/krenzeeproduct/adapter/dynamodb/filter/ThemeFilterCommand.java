package com.krayzee.krenzeeproduct.adapter.dynamodb.filter;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ThemeFilterCommand implements FilterCommand { 

    private final List<String> themes;

    public ThemeFilterCommand(List<String> themes) {
        this.themes = themes;
    }

    @Override
    public void execute(FilterContext context) {
        // Validation handled by the Invoker, but good for safety
        if (themes == null || themes.isEmpty()) return;

        StringBuilder sb = new StringBuilder();
        Map<String, AttributeValue> values = new HashMap<>();

        for (int i = 0; i < themes.size(); i++) {
            String key = ":theme" + i;
            if (i > 0) sb.append(" OR ");
            sb.append("contains(product_theme.themes, ").append(key).append(")");
            values.put(key, AttributeValue.builder().s(themes.get(i)).build());
        }

        Expression themesExpr = Expression.builder()
                .expression("(" + sb.toString() + ")")
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
