package com.yomabank.profileservice.repository.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="address")
@Getter
@Setter
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;

    @Column(name="address")
    private String address;

    @Column(name="township_or_city")
    private String townshipOrCity;

    @Column(name="district")
    private String district;

    @Column(name="state")
    private String state;

    @Column(name="postal_code")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

}
