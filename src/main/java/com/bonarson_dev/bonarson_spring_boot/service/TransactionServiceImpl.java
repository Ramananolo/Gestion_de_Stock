package com.bonarson_dev.bonarson_spring_boot.service;

import com.bonarson_dev.bonarson_spring_boot.model.Person;
import com.bonarson_dev.bonarson_spring_boot.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;

public class TransactionServiceImpl {
    public  Connection connect_to_db(String dbname, String user , String password){
        Connection conn=null;
        try {
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,password);
            if (conn !=null){
                System.out.println("connection estblished");
            }else {
                System.out.println("connection error ");
            }
           }catch (Exception e){
            System.out.println(e);
        }
        return  conn;
    }
    public void insert_tran(Connection conn, String table_name,int transactionId, String label, double montant, String type, String date_heure) {
        Statement statement;
        try {
            String query = String.format("insert into %s(transactionId,label,montant,type,date_heure) values('%s','%s','%s','%s','%s');", table_name, transactionId, label, montant, type, date_heure);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("transaction ok ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
