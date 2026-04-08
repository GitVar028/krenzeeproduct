package com.krayzee.krenzeeproduct.adapter.dynamodb.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.Expression;

@Data
@AllArgsConstructor
public class FilterContext {
    private Expression filterExpression;
}
