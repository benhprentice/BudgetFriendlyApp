package com.example.budgetfriendlyapp;

public class Data {

    private String note;
    private float amount = 0,
            budget = 0;

    public Data() {
    }

    public String getNote() {
        return note;
    }

    public void setNote(String item) {
        this.note = note;
    }

    public float getAmount() {
        return amount;
    }

    public void addAmount(float amount) {
        this.amount += amount;
    }

    public void subAmount(float amount) {
        this.amount -= amount;
        this.budget -= amount;
    }

    public void setBudget(float budget) {
        this.budget = budget;
        if ( this.budget > amount ) this.budget = amount; }

    public float getBudget() {
        return budget; }
}


