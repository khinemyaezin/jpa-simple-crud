package com.yomabank.profileservice.repository.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="contact_type")
@Getter
@Setter
public class ContactTypeEntity {

    @Id
    @Column(name="id")
    private String id;

    @OneToMany(mappedBy ="contactType",fetch = FetchType.EAGER)
    private List<ContactInfoEntity> contactInfoList;
}
