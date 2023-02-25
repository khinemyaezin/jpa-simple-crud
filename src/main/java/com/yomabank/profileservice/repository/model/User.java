package com.yomabank.profileservice.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="nrc")
    private String nrc;

    @OneToMany(mappedBy ="user",fetch = FetchType.LAZY)
    private List<ContactInfo> contactInfoList;

    @OneToMany(mappedBy ="address",fetch = FetchType.LAZY)
    private List<Address> address;
}
