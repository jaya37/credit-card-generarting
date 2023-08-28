package com.example.creditcard.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data @Builder @ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;
    private Long phoneNumber;
    @OneToMany(cascade = CascadeType.ALL)
    Set<Bank> banks=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL)
    Set<Card> cards=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL)
    Set<CardRequest> requests= new HashSet<>();
    @OneToMany(cascade =  CascadeType.ALL)
    Set<Question> questions= new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;


}
