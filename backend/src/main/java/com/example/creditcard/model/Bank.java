package com.example.creditcard.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data @Builder @ToString
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String name;
    private String email;
    private String password;
    private String address;
    private String ifscCode;
    private String cifCode;
    private String branch;
    private Long phoneNumber;
    private  String status ="created";
    @OneToMany(cascade = CascadeType.ALL)
    Set<User> users=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL)
    Set<AccountRequest> accountRequests=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL)
    Set<CardRequest> requests=new HashSet<>();
}
