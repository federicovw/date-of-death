package com.dod.federicovw.dtos;

import com.dod.federicovw.model.Person;

import java.time.LocalDate;

public class PersonDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;

    public PersonDTO(Long id, String firstName, String lastName, int age, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public PersonDTO() {
    }

    public PersonDTO(Person person) {
        id = person.getId();
        firstName = person.getFirstName();
        lastName = person.getLastName();
        age = person.getAge();
        dateOfBirth = person.getDateOfBirth();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
}
