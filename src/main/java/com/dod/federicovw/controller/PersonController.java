package com.dod.federicovw.controller;

import com.dod.federicovw.dtos.PersonDTO;
import com.dod.federicovw.model.Person;
import com.dod.federicovw.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Person person) {
        PersonDTO savedPersonDTO;
        try {
            savedPersonDTO = personService.create(person);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedPersonDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/persons/average-age", method = RequestMethod.GET)
    public Map<String, Integer> averageAge() {
        return personService.averageAge();
    }

    @RequestMapping(value = "/persons/date-of-death", method = RequestMethod.GET)
    public List<PersonDTO> dateOfDeath() {
        return personService.dateOfDeathList();
    }
}
