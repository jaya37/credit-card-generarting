package com.example.creditcard.repository;

import com.example.creditcard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
