package com.example.demospringdata.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Setter
    @Column(name = "name")
    private String nome;

    @Setter
    @Column(name = "social_security_number")
    private String socialSecurityNumber;

}
