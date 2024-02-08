package com.bonarson_dev.bonarson_spring_boot.model;

public class Employe {
    private int id;
    private String email;
    private String password;

    public Employe(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
