package com.example.demospringdata.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    public List<PersonDTO> findAll() {
        return PersonMapper.mapEntitiesIntoDTOs(repository.findAll());
    }

    public PersonDTO findById(Long id) {
        Optional<Person> optionalPerson = repository.findById(id);
        if (optionalPerson.isPresent()) {
            return PersonMapper.mapEntityIntoDTO(optionalPerson.get());
        }
        throw new PersonNotFoundException(id);
    }

    public PersonDTO create(PersonDTO personDTO) {
        Person newPerson = new Person();
        newPerson.setName(personDTO.getName());
        newPerson.setSocialSecurityNumber(personDTO.getSocialSecurityNumber());

        return PersonMapper.mapEntityIntoDTO(repository.save(newPerson));
    }
}
