package com.adboardz.adboardz_userservice.controllers;

import com.adboardz.adboardz_userservice.dtos.SignupDto;
import com.adboardz.adboardz_userservice.services.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Getter
@Setter
@RestController
@RequestMapping("/auth")
public class UserController {
    UserService userService;

    UserController(UserService u)
    {
        this.userService=u;
    }


    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignupDto signupDto)
    {
        String name=signupDto.getName();
        String companyName=signupDto.getCompanyName();
        String phoneNo=signupDto.getPhoneNumber();
        String email=signupDto.getEmail();
        String password=signupDto.getPassword();
        String website=signupDto.getWebsite();
        String city=signupDto.getCity();
        userService.signUp(name,companyName,phoneNo,email,password,website,city);
        return ResponseEntity.ok("User signed up successfully");
    }

  @PostMapping("/login")
    public void login() {

    }

    @PostMapping("/logout")
    public void logout() {

    }

}
