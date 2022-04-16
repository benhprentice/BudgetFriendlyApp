package com.example.budgetfriendlyapp;

public class Data {

    private String note, date;
    private float amount, budget;

    public Data() {
    }

    public Data( String date, String note, float amount, float budget ) {
        this.note = note;
        this.date = date;
        this.amount = amount;
        this.budget = budget;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String item) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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


