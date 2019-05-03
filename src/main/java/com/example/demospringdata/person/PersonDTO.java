package com.example.demospringdata.person;

import lombok.Getter;
import lombok.Setter;

@Getter
public class PersonDTO {
    @Setter private Long id;
    @Setter private String name;
    @Setter private String socialSecurityNumber;
}
