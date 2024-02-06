package com.bonarson_dev.bonarson_spring_boot.controller;

import com.bonarson_dev.bonarson_spring_boot.model.Person;
import com.bonarson_dev.bonarson_spring_boot.service.PersonService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")

public class PersonController {
    private final PersonService personService;

    @Autowired

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person>getAllPersons(){
        return personService.getAllPersons();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person>getPersonById(@PathVariable int id){
        Person person = personService.getPersonById(id);
        return person !=null ? new ResponseEntity<>(person, HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public  ResponseEntity<Void>addPerson(@RequestBody Person person){
        personService.addPerson(1,person);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
