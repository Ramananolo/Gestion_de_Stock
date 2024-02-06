package com.bonarson_dev.bonarson_spring_boot.model;

public class Devise {
    private int IdDevise;
    private String NameDevise; //-------> //Euro
    private String code; //---------> //EUR

    public Devise(int idDevise, String nameDevise, String code) {
        IdDevise = idDevise;
        NameDevise = nameDevise;
        this.code = code;
    }

    public int getIdDevise() {
        return IdDevise;
    }

    public void setIdDevise(int idDevise) {
        IdDevise = idDevise;
    }

    public String getNameDevise() {
        return NameDevise;
    }

    public void setNameDevise(String nameDevise) {
        NameDevise = nameDevise;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Devise{" +
                "IdDevise=" + IdDevise +
                ", NameDevise='" + NameDevise + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
