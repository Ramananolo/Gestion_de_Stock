package com.bonarson_dev.bonarson_spring_boot.model;

public class Transaction {
    private int TransactionId;
    private String label; // exemple:pret bancaire
    private double montant;
    private String type;
    private String date_heure;


    public Transaction(int transactionId, String label, double montant, String type, String date_heure) {
        TransactionId = transactionId;
        this.label = label;
        this.montant = montant;
        this.type = type;
        this.date_heure = date_heure;
    }

    public int getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(int transactionId) {
        TransactionId = transactionId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getMontant() {
        return montant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDate_heure() {
        return date_heure;
    }

    public void setDate_heure(String date_heure) {
        this.date_heure = date_heure;
    }

    public void Credit(double credit_amount, Account C2, Devise devise) {
        if (devise.getNameDevise().equals("ariary")) {
            //double a = C1.getSolde();
            double b = C2.getSolde();
            // C1.setSolde(a - credit_amount);
            C2.setSolde(b + credit_amount);


        } else if (devise.getNameDevise().equals("euro")) {

            //  double a = C1.getSolde();
            double b = C2.getSolde();
            //  C1.setSolde(a - credit_amount);
            C2.setSolde(b + credit_amount * 5030);
        }


    }

    public void Debit(double debit_amount, Account C2, Devise devise) {
        if (devise.getNameDevise().equals("Ariary")) {
            double b = C2.getSolde();
            C2.setSolde(b - debit_amount);

        } else if (devise.getNameDevise().equals("Euro")) {
            double b = C2.getSolde();
            C2.setSolde(b - debit_amount * 5030);
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "TransactionId=" + TransactionId +
                ", label='" + label + '\'' +
                ", montant=" + montant +
                ", date_heure=" + date_heure +
                '}';
    }
}
