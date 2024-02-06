package com.bonarson_dev.bonarson_spring_boot.model;

public class Person {
    private int id;
    private String name;
    private  String first_name;

    public Person(int id, String name, String first_name) {
        this.id = id;
        this.name = name;
        this.first_name = first_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
