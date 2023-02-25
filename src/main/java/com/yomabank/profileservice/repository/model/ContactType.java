package com.yomabank.profileservice.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="contact_type")
@Getter
@Setter
public class ContactType {

    @Id
    @Column(name="id")
    private String id;

    @OneToMany(mappedBy ="contactType",fetch = FetchType.EAGER)
    private List<ContactInfo> contactInfoList;
}
