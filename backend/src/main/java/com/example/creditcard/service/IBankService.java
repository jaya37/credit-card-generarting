package com.example.creditcard.service;

import com.example.creditcard.model.Bank;
import com.example.creditcard.model.User;

import java.util.List;

public interface IBankService {

    List<Bank> all();
    Bank getById(Long id);
    Bank add(Bank faculty);
    Bank update(Bank faculty);
    void delete(Long id);
    Bank getByEmail(String email);
}
