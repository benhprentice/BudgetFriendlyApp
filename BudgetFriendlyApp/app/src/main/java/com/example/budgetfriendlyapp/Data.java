package com.example.budgetfriendlyapp;

import java.text.DecimalFormat;

public class Data {

    private String note;
    private double amount = 0,
            budget = 0;

    public Data() {
    }

    public String getNote() {
        return note;
    }

    public void setNote(String item) {
        this.note = note;
    }

    public double getAmount() { return amount;
    }

    public void addAmount(double amount) {
        this.amount += amount;
    }

    public void subAmount(double amount) {
        this.amount -= amount;
        this.budget -= amount;
    }

    public void setBudget(double budget) {
        this.budget = budget;
        if ( this.budget > amount ) this.budget = amount; }

    public double getBudget() {
        return budget; }
}


