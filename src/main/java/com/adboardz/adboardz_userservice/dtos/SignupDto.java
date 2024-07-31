package com.adboardz.adboardz_userservice.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SignupDto {
    private String name;
    private String companyName;
    private String email;
    private String Password;
    private String phoneNumber;
    private String website;
    private String city;
}
