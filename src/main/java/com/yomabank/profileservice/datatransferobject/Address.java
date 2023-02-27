package com.yomabank.profileservice.datatransferobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private long id;
    private String address;
    private String townshipOrCity;
    private String district;
    private String state;
    private String postalCode;

}
