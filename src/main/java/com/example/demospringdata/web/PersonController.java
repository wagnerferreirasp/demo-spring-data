package com.example.demospringdata.web;

import com.example.demospringdata.person.PersonDTO;
import com.example.demospringdata.person.PersonNotFoundException;
import com.example.demospringdata.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return service.create(personDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO update(@RequestBody PersonDTO personDTO) {
        return service.update(personDTO);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response handleNotFound(PersonNotFoundException e) {
        return new Response(null, "Person with id " + e.getId() + " not found!");

    }

}
