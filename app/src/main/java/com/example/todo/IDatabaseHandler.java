package com.example.todo;

import java.util.List;

public interface IDatabaseHandler {
    public void addIdea(Idea idea);
    //public Idea getIdea(int id);
    //public List<Idea> getAllContacts();
    //public int getIdeasCount();
    public int updateIdea(Idea idea);
    public void deleteIdea(Idea idea);
    public void deleteAll();
}
