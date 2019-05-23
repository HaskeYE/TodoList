package com.example.todo;

public class Case extends Ideas {
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    Case(String headline, String text, String date) {
        super(headline, text);
        this.date = date;
    }
}
