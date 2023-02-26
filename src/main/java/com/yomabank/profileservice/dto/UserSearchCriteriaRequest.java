package com.yomabank.profileservice.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchCriteriaRequest {
    private List<UserFilter> criteriaList;
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserFilter {
        private String field;
        private String operator;
        private String value;
        private List<String> values;//Used in case of IN operator
    }
}
