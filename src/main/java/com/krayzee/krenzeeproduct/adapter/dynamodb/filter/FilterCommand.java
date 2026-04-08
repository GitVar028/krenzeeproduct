package com.krayzee.krenzeeproduct.adapter.dynamodb.filter;

public interface FilterCommand {
    void execute(FilterContext context);
}
