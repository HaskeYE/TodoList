package com.example.todo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ideas {
    @PrimaryKey
    private long id;
    private String head;
    private String data;
    private String time;

    Ideas() {}

    Ideas(String h) {
        setHead(h);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHead() {
        return this.head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
