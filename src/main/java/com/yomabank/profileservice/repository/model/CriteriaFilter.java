package com.yomabank.profileservice.repository.model;

import com.yomabank.profileservice.constant.QueryOperator;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CriteriaFilter {
        private String field;
        private QueryOperator operator;
        private String value;
        private List<String> values;//Used in case of IN operator

}
