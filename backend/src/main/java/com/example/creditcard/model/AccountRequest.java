package com.example.creditcard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor @Data @Builder
@ToString
public class AccountRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String bankEmail;
    private String password;
    private String address;
    private Long phoneNumber;
    private String loan="false";
    private String status="requested";
}
