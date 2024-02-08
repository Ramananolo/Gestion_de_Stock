package com.bonarson_dev.bonarson_spring_boot.service;

import com.bonarson_dev.bonarson_spring_boot.model.Employe;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeS {
    List<Employe> getAllEmploye();
    Employe getEmployeById(int id);

    void addEmploye(int id , Employe employe);
    void updateEmploy(int id,Employe employe);
    void deleteEmploye(int id);
}
