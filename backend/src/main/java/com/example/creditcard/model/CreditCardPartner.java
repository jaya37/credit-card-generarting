package com.example.creditcard.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor @Data @Builder
@ToString
public class CreditCardPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String name;
    private String email;
    private String password;
    private String bankEmail;
    private String address;
    private Long phoneNumber;
}
