package com.adboardz.adboardz_userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "users")
public class User extends BaseModel{
    private String name;
    private String companyName;
    private String email;
    private String password;
    private String phoneNumber;
    private String website;
    private String city;
    @ManyToMany
    private List<Roles> roles=new ArrayList<>();
    public User()
    {

    }
    private User (UserBuilder userBuilder)
    {
        this.name=userBuilder.name;
        this.email=userBuilder.email;
        this.companyName=userBuilder.companyName;
        this.password=userBuilder.password;
        this.phoneNumber=userBuilder.phoneNumber;
        this.website=userBuilder.website;
        this.city=userBuilder.city;
    }

    public static UserBuilder builder()
    {
        return new UserBuilder();
    }
    public static class UserBuilder
    {
        public  String name;
        public String companyName;
        private String email;
        private String password;
        private String phoneNumber;
        private String website;
        private String city;


        public UserBuilder setName(String name)
        {
            this.name=name;
            return this;
        }
        public UserBuilder setCompanyName(String companyName)
        {
            this.companyName=companyName;
            return this;
        }
        public UserBuilder setEmail(String email)
        {
            this.email=email;
            return this;
        }
        public UserBuilder setPassword(String password)
        {
            this.password=password;
            return this;
        }
        public UserBuilder setPhoneNumber(String phoneNumber)
        {
            this.phoneNumber=phoneNumber;
            return this;
        }
        public UserBuilder setWebsite(String website)
        {
            this.website=website;
            return this;
        }
        public UserBuilder setCity(String city)
        {
            this.city=city;
            return this;
        }
        public User build()
        {
            return new User(this);
        }

    }
}
