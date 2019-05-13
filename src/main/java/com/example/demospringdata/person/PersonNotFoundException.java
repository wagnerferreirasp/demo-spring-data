package com.example.demospringdata.person;

import lombok.Getter;

public class PersonNotFoundException extends RuntimeException {

    @Getter
    private Long id;

    public PersonNotFoundException(Long id) {
        this.id = id;
    }

}
