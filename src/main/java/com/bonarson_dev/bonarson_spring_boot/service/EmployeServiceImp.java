package com.bonarson_dev.bonarson_spring_boot.service;

import com.bonarson_dev.bonarson_spring_boot.model.Employe;
import com.bonarson_dev.bonarson_spring_boot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Service

public class EmployeServiceImp implements EmployeS {
    private final DataSource dataSource;
    @Autowired

    public EmployeServiceImp(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Employe> getAllEmploye() {
        List<Employe> employes = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from employe ;")) {
            while (resultSet.next()){
                employes.add(new Employe(resultSet.getInt("id"),resultSet.getString("email"),resultSet.getString("password")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employes;


    }

    @Override
    public Employe getEmployeById(int id) {
        return null;
    }

    @Override
    public void addEmploye(int id,Employe employe) {
        try(Connection connection =dataSource.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("insert into employe (email,password)values(?,?);")) {
            preparedStatement.setString(1, employe.getEmail());
            preparedStatement.setString(2, employe.getPassword());
            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateEmploy(int id, Employe employe) {

    }

    @Override
    public void deleteEmploye(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employe WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
