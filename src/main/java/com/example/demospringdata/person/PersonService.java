package com.example.demospringdata.person;

import java.util.List;

public interface PersonService {

    List<PersonDTO> findAll();

    PersonDTO findById(Long id);

    PersonDTO create(PersonDTO personDTO);

    PersonDTO update(PersonDTO personDTO);

    void delete(Long id);

}
