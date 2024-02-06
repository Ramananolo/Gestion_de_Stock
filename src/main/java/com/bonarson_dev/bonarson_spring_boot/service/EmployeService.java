package com.bonarson_dev.bonarson_spring_boot.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service

public class EmployeService {

    public boolean authenticateEmploye(String email, String password, Connection connection) {
        String query = "SELECT * FROM employe WHERE email = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return password.equals(resultSet.getString("password"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gérer l'exception correctement en production
        }

        return false;
    }


    public boolean changePassword(String email, String currentPassword, String newPassword, Connection connection) {
        // Vérifier si le mot de passe actuel est correct
        if (authenticateEmploye(email, currentPassword, connection)) {
            // Mettre à jour le mot de passe dans la base de données
            String updateQuery = "UPDATE employe SET password = ? WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, newPassword);
                preparedStatement.setString(2, email);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace(); // Gérer l'exception correctement en production
                return false;
            }
        } else {
            return false; // Mot de passe actuel incorrect
        }
    }
}


