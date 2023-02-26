package com.yomabank.profileservice.dto;

import com.yomabank.profileservice.constant.QueryOperator;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Filter {
        private String field;
        private QueryOperator operator;
        private String value;
        private List<String> values;//Used in case of IN operator

}
