package com.example.creditcard.service.impl;

import com.example.creditcard.model.CardRequest;
import com.example.creditcard.repository.ICardRequestRepository;
import com.example.creditcard.service.ICardRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardRequestService implements ICardRequestService {
    @Autowired
    private ICardRequestRepository cardRequestRepository;

    @Override
    public List<CardRequest> all() {
        return cardRequestRepository.findAll();
    }

    @Override
    public CardRequest getById(Long id) {
        return cardRequestRepository.findById(id).get();
    }

    @Override
    public CardRequest add(CardRequest faculty) {
        return cardRequestRepository.save(faculty);
    }

    @Override
    public CardRequest update(CardRequest faculty) {
        return cardRequestRepository.save(faculty);
    }

    @Override
    public void delete(Long id) {
        cardRequestRepository.deleteById(id);
    }

    @Override
    public CardRequest getByUserEmailAndBankEmail(String userEmail, String bankEmail) {
        return cardRequestRepository.findByUserEmailAndBankEmail(userEmail, bankEmail);
    }
}
