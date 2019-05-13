package com.example.demospringdata.person;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PersonDTO> findAll() {
        return repository.findAll()
            .stream()
            .map(it -> modelMapper.map(it, PersonDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public PersonDTO findById(Long id) {
        Person person = repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        return modelMapper.map(person, PersonDTO.class);
    }

    @Override
    public PersonDTO create(PersonDTO personDTO) {
        return this.update(personDTO);
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        Person newPerson = modelMapper.map(personDTO, Person.class);
        return modelMapper.map(repository.save(newPerson), PersonDTO.class);

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
