package com.dod.federicovw.daos;

import com.dod.federicovw.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT AVG(age) FROM Person p")
    int getAverageAge();

}
