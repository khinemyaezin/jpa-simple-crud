package com.yomabank.profileservice.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="contact_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="contact_value")
    private String contactValue;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="contact_type_id")
    private ContactTypeEntity contactType;

    public ContactInfoEntity(String contactValue, UserEntity user, ContactTypeEntity contactType) {
        this.contactValue = contactValue;
        this.user = user;
        this.contactType = contactType;
    }
}
