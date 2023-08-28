package com.example.creditcard.service;

import com.example.creditcard.model.User;

import java.util.List;

public interface IUserService {
    List<User> all();
    User getById(Long id);
    User add(User faculty);
    User update(User faculty);
    void delete(Long id);
    User getByEmail(String email);
    public  void sendEmail(String toEmail,String subject,String body);

}
