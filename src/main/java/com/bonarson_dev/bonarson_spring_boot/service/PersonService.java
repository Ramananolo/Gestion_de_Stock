package com.bonarson_dev.bonarson_spring_boot.service;
import com.bonarson_dev.bonarson_spring_boot.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public interface PersonService {
    List<Person> getAllPersons();
    Person getPersonById(int id);

    void addPerson(int id, Person person);
    void updatePerson(int id,Person person);
    void deletePerson(int id);


}
