package com.example.creditcard.service;

import com.example.creditcard.model.Account;
import com.example.creditcard.model.AccountRequest;
import com.example.creditcard.model.User;

import java.util.List;

public interface IAccountService {

    List<Account> all();
    Account getById(Long id);
    Account add(Account faculty);
    Account update(Account faculty);
    void delete(Long id);
    List<Account> getByEmail(String email);
    List<AccountRequest> allRequests();
    AccountRequest getRequest(Long id);
    AccountRequest addRequest(AccountRequest faculty);
    AccountRequest updateRequest(AccountRequest faculty);
    void deleteRequest(Long id);

}
