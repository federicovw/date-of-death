package com.dod.federicovw.service;

import com.dod.federicovw.dtos.PersonDTO;
import com.dod.federicovw.model.Person;

import java.util.List;

public interface PersonService {
    void create(Person person);

    int averageAge();

    List<PersonDTO> dateOfDeathList();
}
