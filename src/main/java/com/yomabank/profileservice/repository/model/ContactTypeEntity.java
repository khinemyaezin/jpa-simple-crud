package com.yomabank.profileservice.repository.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="contact_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactTypeEntity {
    @Id
    @Column(name="id")
    private String id;

    @OneToMany(mappedBy ="contactType",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ContactInfoEntity> contactInfoList;

    public ContactTypeEntity(String id) {
        this.id = id;
    }
}
