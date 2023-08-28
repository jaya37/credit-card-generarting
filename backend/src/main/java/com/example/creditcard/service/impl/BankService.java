package com.example.creditcard.service.impl;

import com.example.creditcard.model.Bank;
import com.example.creditcard.repository.IBankRepository;
import com.example.creditcard.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService implements IBankService {

    @Autowired
    private IBankRepository bankRepository;
    @Override
    public List<Bank> all() {
        return bankRepository.findAll();
    }

    @Override
    public Bank getById(Long id) {
        return bankRepository.findById(id).get();
    }

    @Override
    public Bank add(Bank faculty) {
        return bankRepository.save(faculty);
    }

    @Override
    public Bank update(Bank faculty) {
        return bankRepository.save(faculty);
    }

    @Override
    public void delete(Long id) {
        bankRepository.deleteById(id);
    }

    @Override
    public Bank getByEmail(String email) {
        return bankRepository.findByEmail(email);
    }

}
