package com.example.demospringdata.person;

import java.util.List;

import static java.util.stream.Collectors.toList;

final class PersonMapper {

    static List<PersonDTO> mapEntitiesIntoDTOs(List<Person> entities) {
        return entities.stream()
                .map(PersonMapper::mapEntityIntoDTO)
                .collect(toList());
    }

    static PersonDTO mapEntityIntoDTO(Person entity) {
        PersonDTO personDTO = new PersonDTO();

        personDTO.setId(entity.getId());
        personDTO.setName(entity.getName());
        personDTO.setSocialSecurityNumber(entity.getSocialSecurityNumber());

        return personDTO;
    }
}
