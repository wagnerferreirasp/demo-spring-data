package com.example.demospringdata.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PersonRepository extends JpaRepository<Person, Long> {

}
