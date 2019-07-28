package com.dod.federicovw.service;

import com.dod.federicovw.dtos.PersonDTO;
import com.dod.federicovw.model.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {
    void create(Person person);

    Map<String, Integer> averageAge();

    List<PersonDTO> dateOfDeathList();
}
