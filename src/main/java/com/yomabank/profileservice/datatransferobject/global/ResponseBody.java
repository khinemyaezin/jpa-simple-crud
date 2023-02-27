package com.yomabank.profileservice.datatransferobject.global;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBody<T> {
    private T details;
}
