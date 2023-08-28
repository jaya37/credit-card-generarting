package com.example.creditcard.service.impl;

import com.example.creditcard.model.Account;
import com.example.creditcard.model.AccountRequest;
import com.example.creditcard.repository.IAccountRepository;
import com.example.creditcard.repository.IAccountRequestRepository;
import com.example.creditcard.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IAccountRequestRepository requestRepository;
    @Override
    public List<Account> all() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Account add(Account faculty) {
        return accountRepository.save(faculty);
    }

    @Override
    public Account update(Account faculty) {
        return accountRepository.save(faculty);
    }

    @Override
    public void delete(Long id) {
            accountRepository.deleteById(id);
    }

    @Override
    public List<Account> getByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public List<AccountRequest> allRequests() {
        return requestRepository.findAll();
    }

    @Override
    public AccountRequest getRequest(Long id) {
        return requestRepository.findById(id).get();
    }

    @Override
    public AccountRequest addRequest(AccountRequest faculty) {
        return requestRepository.save(faculty);
    }

    @Override
    public AccountRequest updateRequest(AccountRequest faculty) {
        return requestRepository.save(faculty);
    }

    @Override
    public void deleteRequest(Long id) {
            requestRepository.deleteById(id);
    }
}
