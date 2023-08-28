package com.example.creditcard.service;

import com.example.creditcard.model.CreditCardPartner;
import com.example.creditcard.model.User;

import java.util.List;

public interface ICreditCardPartnerService {
    List<CreditCardPartner> all();
    CreditCardPartner getById(Long id);
    CreditCardPartner add(CreditCardPartner faculty);
    CreditCardPartner update(CreditCardPartner faculty);
    void delete(Long id);
    CreditCardPartner getByEmail(String email);
    CreditCardPartner getByBankEmail(String email);
}
