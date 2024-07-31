package com.adboardz.adboardz_userservice.services;

public interface UserServiceInterface {
    public void signUp(String name,String companyName,String phoneNo,String email,String password,String website,String city);
    public void login();
    public void logout();
}
