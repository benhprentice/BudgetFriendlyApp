package com.example.budgetfriendlyapp;

public class Data {

    private String note, date;
    private float amount;

    public Data() {
    }

    public Data( String date, String note, float amount) {
        this.note = note;
        this.date = date;
        this.amount = amount;
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

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
