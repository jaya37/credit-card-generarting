package com.example.creditcard.service;

import com.example.creditcard.model.CardRequest;
import com.example.creditcard.model.User;

import java.util.List;

public interface ICardRequestService {

    List<CardRequest> all();
    CardRequest getById(Long id);
    CardRequest add(CardRequest faculty);
    CardRequest update(CardRequest faculty);
    void delete(Long id);
    CardRequest getByUserEmailAndBankEmail(String userEmail,String bankEmail);
}
