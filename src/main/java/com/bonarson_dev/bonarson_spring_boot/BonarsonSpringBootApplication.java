package com.bonarson_dev.bonarson_spring_boot;

import com.bonarson_dev.bonarson_spring_boot.model.Account;
import com.bonarson_dev.bonarson_spring_boot.model.Devise;
import com.bonarson_dev.bonarson_spring_boot.model.Transaction;
import com.bonarson_dev.bonarson_spring_boot.service.TransactionServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.Scanner;


@SpringBootApplication

public class BonarsonSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BonarsonSpringBootApplication.class, args);

    }
}
