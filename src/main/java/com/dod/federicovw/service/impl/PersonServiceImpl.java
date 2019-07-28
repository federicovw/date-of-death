package com.dod.federicovw.service.impl;

import com.dod.federicovw.daos.PersonRepository;
import com.dod.federicovw.dtos.PersonDTO;
import com.dod.federicovw.model.Person;
import com.dod.federicovw.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void create(Person person) {
        validatePerson(person);
        personRepository.save(person);
    }

    private void validatePerson(Person person) {
        List<String> fields = new ArrayList<>();
        if (person.getFirstName() == null) {
            fields.add("First Name");
        }
        if (person.getLastName() == null) {
            fields.add("Last Name");
        }
        if (person.getAge() == 0) {
            fields.add("Age");
        }
        if (person.getDateOfBirth() == null) {
            fields.add("Date of Birth");
        }

        if (!fields.isEmpty()) {
            throw new IllegalArgumentException("The following fields are not populated or invalid: " + fields);
        }
    }

    @Override
    public Map<String, Integer> averageAge() {
        Map<String, Integer> map = new HashMap<>();
        map.put("averageAge", personRepository.getAverageAge());
        return map;
    }

    @Override
    public List<PersonDTO> dateOfDeathList() {
        List<PersonDTO> personDTOList = personRepository.findAll().stream()
                .map(Person::convertToDTO)
                .collect(Collectors.toList());
        personDTOList.forEach(personDTO -> personDTO.setDateOfDeath(calculateDateOfDeath(personDTO.getDateOfBirth())));
        return personDTOList;
    }

    /**
     * Calculates the date of death of a person, based on received parameters
     * Life Expectancy data obtained from
     * https://data.worldbank.org/indicator/SP.DYN.LE00.IN?end=2017&locations=ZJ&start=1960&view=map
     * for the assumed region Latin America & Caribbean
     *
     * @param dateOfBirth
     * @return dateOfDeathList
     */
    private LocalDate calculateDateOfDeath(LocalDate dateOfBirth) {
        return dateOfBirth.plusYears(77);
    }
}
