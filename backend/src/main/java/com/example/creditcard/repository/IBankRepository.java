package com.example.creditcard.repository;

import com.example.creditcard.model.Bank;
import com.example.creditcard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankRepository extends JpaRepository<Bank,Long> {

    Bank findByEmail(String email);
}
