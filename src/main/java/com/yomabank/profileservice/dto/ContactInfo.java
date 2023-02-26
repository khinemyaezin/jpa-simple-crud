package com.yomabank.profileservice.dto;

import com.yomabank.profileservice.repository.model.ContactTypeEntity;
import com.yomabank.profileservice.repository.model.UserEntity;

import javax.persistence.*;

public class ContactInfo {

    private long id;

    private String contactValue;

    private UserEntity user;

    private ContactTypeEntity contactType;
}
