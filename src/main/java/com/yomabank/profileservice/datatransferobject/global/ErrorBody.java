package com.yomabank.profileservice.datatransferobject.global;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorBody {
    private String message;
    private HttpStatus httpStatus ;
}
