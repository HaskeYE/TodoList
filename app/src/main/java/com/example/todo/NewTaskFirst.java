package com.example.todo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.room.*;
import java.util.List;

public class NewTaskFirst extends AppCompatActivity {
    @Database(entities = {Ideas.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract IdeasDao ideasDao();
    }

    @Entity
    public class Ideas {
        @PrimaryKey
        public long id;

        public String head;

        public String data;

        public String time;
    }

    @Dao
    public interface IdeasDao {
        @Query("SELECT * FROM Ideas")
        List<Ideas> getAll();

        @Query("SELECT * FROM Ideas WHERE id = :id")
        Ideas getById(long id);

        @Insert
        void insert(Ideas idea);

        @Update
        void update(Ideas idea);

        @Delete
        void delete(Ideas idea);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    AppDatabase db = App.getInstance().getDatabase();
    IdeasDao ideaDao = db.ideasDao();

}
