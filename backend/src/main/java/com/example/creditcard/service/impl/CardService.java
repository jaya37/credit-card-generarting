package com.example.creditcard.service.impl;

import com.example.creditcard.model.Card;
import com.example.creditcard.repository.ICardRepository;
import com.example.creditcard.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService implements ICardService {
    @Autowired
    private ICardRepository cardRepository;
    @Override
    public List<Card> all() {
        return cardRepository.findAll();
    }

    @Override
    public Card getById(Long id) {
        return cardRepository.findById(id).get();
    }

    @Override
    public Card add(Card faculty) {
        return cardRepository.save(faculty);
    }

    @Override
    public Card update(Card faculty) {
        return cardRepository.save(faculty);
    }

    @Override
    public void delete(Long id) {
            cardRepository.deleteById(id);
    }

    @Override
    public Card getByUserName(String userName) {
        return cardRepository.findByUserName(userName);
    }
}
