package com.yomabank.profileservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBody<T> {
    private T details;
}
