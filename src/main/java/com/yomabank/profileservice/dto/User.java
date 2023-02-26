package com.yomabank.profileservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yomabank.profileservice.repository.model.AddressEntity;
import com.yomabank.profileservice.repository.model.ContactInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String nrc;
    private List<ContactInfoEntity> contactInfoList;
    private List<AddressEntity> address;
}
