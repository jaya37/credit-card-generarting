package com.example.creditcard.repository;

import com.example.creditcard.model.AccountRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRequestRepository extends JpaRepository<AccountRequest,Long> {
}
