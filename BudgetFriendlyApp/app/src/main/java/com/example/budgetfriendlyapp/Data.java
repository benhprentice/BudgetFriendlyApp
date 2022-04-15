package com.example.budgetfriendlyapp;

public class Data {

    private String note, date, id, notes;
    private int amount;

    public Data() {
    }

    public Data(String item, String date, String id, String notes, int amount) {
        this.note = note;
        this.date = date;
        this.id = id;
        this.notes = notes;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
