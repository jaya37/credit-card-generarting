package com.example.creditcard.repository;

import com.example.creditcard.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepository extends JpaRepository<Card,Long> {

    Card findByUserName(String userName);
}
