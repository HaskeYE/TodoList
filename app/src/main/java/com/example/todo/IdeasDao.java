package com.example.todo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IdeasDao {
    @Query("SELECT * FROM Ideas")
    List<Ideas> getAll();

    @Query("SELECT * FROM Ideas WHERE id = :id")
    Ideas getById(long id);

    @Query("SELECT * FROM Ideas WHERE head = :head")
    List<Ideas> getByHead(String head);

    @Query("SELECT * FROM Ideas WHERE data = :data")
    List<Ideas> getByData(String data);

    @Query("SELECT * FROM Ideas WHERE data IS NULL AND time IS NULL")
    List<Ideas> getAllIdeas();

    @Query("DELETE FROM Ideas")
    void deletAll();

    @Query("DELETE FROM ideas WHERE head = :head")
    void deletByHead(String head);

    @Insert
    void insert(Ideas idea);

    @Update
    void update(Ideas idea);

    @Delete
    void delete(Ideas idea);
}
