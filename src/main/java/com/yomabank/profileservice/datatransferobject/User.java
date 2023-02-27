package com.yomabank.profileservice.datatransferobject;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String nrc;
    @NotNull
    private List<ContactInfo> contactInfoList;
    @NotNull
    private List<Address> addressList;
}
