package com.bonarson_dev.bonarson_spring_boot.controller;

import com.bonarson_dev.bonarson_spring_boot.model.ChangePasswordForm;
import com.bonarson_dev.bonarson_spring_boot.model.LoginForm;
import com.bonarson_dev.bonarson_spring_boot.service.EmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class AuthController {

    private final EmployeService employeService;
    private final DataSource dataSource;

    public AuthController(EmployeService employeService, DataSource dataSource) {
        this.employeService = employeService;
        this.dataSource = dataSource;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();

        try (Connection connection = dataSource.getConnection()) {
            if (employeService.authenticateEmploye(email, password, connection)) {
                return ResponseEntity.ok("Information correct");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Information incorrecte");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gérer l'exception correctement en production
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur de base de données");
        }
    }


    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordForm changePasswordForm) {
        String email = changePasswordForm.getEmail();
        String currentPassword = changePasswordForm.getCurrentPassword();
        String newPassword = changePasswordForm.getNewPassword();

        try (Connection connection = dataSource.getConnection()) {
            if (employeService.changePassword(email, currentPassword, newPassword, connection)) {
                return ResponseEntity.ok("Mot de passe modifié avec succès");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe actuel incorrect");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gérer l'exception correctement en production
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur de base de données");
        }
    }

}
