package com.example.creditcard.repository;

import com.example.creditcard.model.CreditCardPartner;
import com.example.creditcard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditCardPartnerRepository extends JpaRepository<CreditCardPartner,Long> {
    CreditCardPartner findByEmail(String email);
    CreditCardPartner findByBankEmail(String email);
}
