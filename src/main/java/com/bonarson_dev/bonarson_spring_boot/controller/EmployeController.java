package com.bonarson_dev.bonarson_spring_boot.controller;

import com.bonarson_dev.bonarson_spring_boot.model.Employe;
import com.bonarson_dev.bonarson_spring_boot.model.Person;
import com.bonarson_dev.bonarson_spring_boot.service.EmployeS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employe")

public class EmployeController {
    private final EmployeS employeS;
    @Autowired

    public EmployeController(EmployeS employeS) {
        this.employeS = employeS;
    }

    @GetMapping
    public List<Employe> getAllEmployes(){
        return employeS.getAllEmploye();
    }

    @PostMapping
    public ResponseEntity<Void>addEmploye(@RequestBody Employe employe){
        employeS.addEmploye(1,employe);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable int id) {
        employeS.deleteEmploye(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
