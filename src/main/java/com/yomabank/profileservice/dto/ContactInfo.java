package com.yomabank.profileservice.dto;

import com.yomabank.profileservice.repository.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfo {
    private long id;
    private String contactValue;
    private ContactType contactType;
}
