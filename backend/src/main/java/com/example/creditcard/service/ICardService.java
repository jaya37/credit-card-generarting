package com.example.creditcard.service;

import com.example.creditcard.model.Bank;
import com.example.creditcard.model.Card;

import java.util.List;

public interface ICardService {
    List<Card> all();
    Card getById(Long id);
    Card add(Card faculty);
    Card update(Card faculty);
    void delete(Long id);
    Card getByUserName(String userName);
}
