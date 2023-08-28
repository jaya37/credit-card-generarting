package com.example.creditcard.repository;

import com.example.creditcard.model.CardRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRequestRepository extends JpaRepository<CardRequest,Long> {
    CardRequest findByUserEmailAndBankEmail(String userEmail,String bankEmail);
}
