package com.example.creditcard.repository;

import com.example.creditcard.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends JpaRepository<Account,Long> {

    List<Account> findByEmail(String email);
}
