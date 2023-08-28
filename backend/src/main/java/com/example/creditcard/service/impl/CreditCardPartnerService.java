package com.example.creditcard.service.impl;

import com.example.creditcard.model.CreditCardPartner;
import com.example.creditcard.repository.ICreditCardPartnerRepository;
import com.example.creditcard.service.ICreditCardPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardPartnerService implements ICreditCardPartnerService
{
    @Autowired
    private ICreditCardPartnerRepository cardPartnerRepository;
    @Override
    public List<CreditCardPartner> all() {
        return cardPartnerRepository.findAll();
    }

    @Override
    public CreditCardPartner getById(Long id) {
        return cardPartnerRepository.findById(id).get();
    }

    @Override
    public CreditCardPartner add(CreditCardPartner faculty) {
        return cardPartnerRepository.save(faculty);
    }

    @Override
    public CreditCardPartner update(CreditCardPartner faculty) {
        return cardPartnerRepository.save(faculty);
    }

    @Override
    public void delete(Long id) {
            cardPartnerRepository.deleteById(id);
    }

    @Override
    public CreditCardPartner getByEmail(String email) {
        return cardPartnerRepository.findByEmail(email);
    }

    @Override
    public CreditCardPartner getByBankEmail(String email) {
        return cardPartnerRepository.findByBankEmail(email);
    }
}
