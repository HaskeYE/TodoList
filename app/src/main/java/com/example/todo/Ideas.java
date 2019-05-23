package com.example.todo;

/**
 * Класс идей, от него наследуются дела и события
 * поля - заголовок, текст и тэг
 */
public class Ideas {
    private String headline;
    private String text;
    private String tag;

    Ideas(String headline, String text) {
        this.headline = headline;
        this.text = text;
    }

    Ideas(String headline, String text, String tag) {
        this.headline = headline;
        this.text = text;
        this.tag = tag;
    }

    //--getters
    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    //--setters
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    //--methods
    private boolean dateParser(String date) {
        return true;
    }
}
