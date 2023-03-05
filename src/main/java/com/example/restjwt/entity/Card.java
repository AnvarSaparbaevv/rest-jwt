package com.example.restjwt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false,unique = true)
    private String cardNumber;

    @Column(nullable = false)
    private double balance;

    @Column(nullable = false)
    private String expired_date;

    @Column
    private boolean active;
}
