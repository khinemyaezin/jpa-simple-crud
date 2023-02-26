package com.yomabank.profileservice.repository.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(mappedBy ="user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ContactInfoEntity> contactInfoList = new ArrayList<>();

    @OneToMany(mappedBy ="user",fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private List<AddressEntity> addressList= new ArrayList<>();

    public void setContactInfo(ContactInfoEntity contact) {
        if(contact != null) {
            contact.setUser(this);
            this.contactInfoList.add(contact);
        }
    }

    public void setAddress(AddressEntity address) {
        if(address != null) {
            address.setUser(this);
            this.addressList.add(address);
        }
    }
}
