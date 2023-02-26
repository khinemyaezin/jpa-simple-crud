package com.yomabank.profileservice.constant;

import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;

@AllArgsConstructor
public enum QueryOperator {
    GREATER_THAN("GREATER_THAN"),
    LESS_THAN("LESS_THAN"),
    EQUALS("EQUALS"),
    LIKE("LIKE"),
    NOT_EQ("NOT_EQ"),
    IN("IN");
    private static final QueryOperator[] VALUES = values();
    public String value;

    @Nullable
    public static QueryOperator resolve(String value){
        QueryOperator[] var1 = VALUES;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            QueryOperator status = var1[var3];
            if (status.value.equals(value)) {
                return status;
            }
        }
        return null;
    }
}
