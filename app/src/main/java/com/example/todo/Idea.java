package com.example.todo;

public class Idea {
    private int id;
    private String head;
    private String data;
    private String time;

    Idea() {}

    Idea(String h, String d, String t) {
        setHead(h);
        setData(d);
        setTime(t);
    }

    Idea(int id, String h, String d, String t) {
        setID(id);
        setHead(h);
        setData(d);
        setTime(t);
    }

    public int getID() {
        return this.id;
    }

    public String getHead() {
        return this.head;
    }

    public String getData() {
        return this.data;
    }

    public String getTime() {
        return this.time;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setID(int id) {
        this.id = id;
    }
}
