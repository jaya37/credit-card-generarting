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
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String email;
    private String bankName;
    private String bankEmail;
    private String ifscCode;
    private String cifCode;
    private String branch;
    private String address;
    private String isCardGenerated="false";
    private String loan="false";
}
