package com.bonarson_dev.bonarson_spring_boot.service;

import com.bonarson_dev.bonarson_spring_boot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final DataSource dataSource;

    @Autowired
    public PersonServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from person")) {   
            while (resultSet.next()){
                persons.add(new Person(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("first_name")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Person getPersonById(int id) {
       try(Connection connection= dataSource.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("select * from person where id=?")) {
           preparedStatement.setInt(1,id);
           ResultSet resultSet=preparedStatement.executeQuery();
           if(resultSet.next()){
               return  new Person(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("first_name"));
           }

       }catch (SQLException e){
           e.printStackTrace();
       }
       return null;
    }

    @Override
    public void addPerson(int id, Person person) {
     try(Connection connection =dataSource.getConnection();
     PreparedStatement preparedStatement= connection.prepareStatement("insert into person(id,name,first_name)values(?,?,?)")) {
         preparedStatement.setInt(1,person.getId());
         preparedStatement.setString(2, person.getName());
         preparedStatement.setString(3, person.getFirst_name());
         preparedStatement.executeQuery();

     }catch (SQLException e){
         e.printStackTrace();
     }
    }

    @Override
    public void updatePerson(int id, Person person) {

    }

    @Override
    public void deletePerson(int id) {

    }
}
