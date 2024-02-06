package com.bonarson_dev.bonarson_spring_boot.model;

public class Account {
   private int IdAccount;

   //caracteriser par le montant et la date de dernier maj
   private  String AccountName ;
   Transaction TransactionsListe;
   private double solde ;
   Devise devise;
   private String Type;

    public Account(int idAccount, String accountName, Transaction transactionsListe, double solde, Devise devise, String type) {
        IdAccount = idAccount;
        AccountName = accountName;
        TransactionsListe = transactionsListe;
        this.solde = solde;
        this.devise = devise;
        Type = type;
    }

    public double getSolde() {
        return solde;
    }

    public double setSolde(double solde) {
        this.solde = solde;
        return solde;
    }

    public int getIdAccount() {
        return IdAccount;
    }

    public void setIdAccount(int idAccount) {
        IdAccount = idAccount;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public Transaction getTransactionsListe() {
        return TransactionsListe;
    }

    public void setTransactionsListe(Transaction transactionsListe) {
        TransactionsListe = transactionsListe;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "IdAccount=" + IdAccount +
                ", AccountName='" + AccountName + '\'' +
                ", TransactionsListe=" + TransactionsListe +
                ", solde=" + solde +
                ", devise=" + devise +
                ", Type='" + Type + '\'' +
                '}';
    }
}
