package com.adboardz.adboardz_userservice.services;

import com.adboardz.adboardz_userservice.models.User;
import com.adboardz.adboardz_userservice.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface{
    @Autowired
    UserRepo userRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    UserService(UserRepo u,BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepo=u;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }
    @Override
    public void signUp(String name,String companyName,String phoneNo,String email,String password,String website,String city) {
           User user=User.builder()
                   .setName(name)
                   .setEmail(email)
                   .setPassword(bCryptPasswordEncoder.encode(password))
                   .setCompanyName(companyName)
                   .setPhoneNumber(phoneNo)
                   .setWebsite(website)
                   .setCity(city)
                   .build();
        Optional<User> savedUser=userRepo.findByEmail(user.getEmail());
        if(savedUser.isEmpty())
        {
            userRepo.save(user);
        }else
        {
            throw new RuntimeException("User Already exist");
        }

    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }
}
