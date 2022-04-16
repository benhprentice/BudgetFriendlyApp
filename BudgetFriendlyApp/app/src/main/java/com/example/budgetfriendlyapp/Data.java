package com.example.budgetfriendlyapp;

public class Data {

    private String note;
    private float amount, budget;

    public Data() {
    }

    public Data( String note, float amount, float budget ) {
        this.note = note;
        this.amount = amount;
        this.budget = budget;
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

    public void setBudget(float budget) { this.budget = budget; }

    public float getBudget() {
        return budget; }
}


