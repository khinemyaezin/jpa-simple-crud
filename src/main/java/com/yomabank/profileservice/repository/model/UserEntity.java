package com.yomabank.profileservice.repository.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="user")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="nrc")
    private String nrc;

    @OneToMany(mappedBy ="user",fetch = FetchType.LAZY)
    private List<ContactInfoEntity> contactInfoList;

    @OneToMany(mappedBy ="user",fetch = FetchType.LAZY)
    private List<AddressEntity> address;
}
