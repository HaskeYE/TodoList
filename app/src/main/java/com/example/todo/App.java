package com.example.todo;
///
import android.app.Application;

import androidx.room.*;

import java.util.List;

public class App extends Application {
    private static App instance;
    private AppDatabase database;

    @androidx.room.Database(entities = {Ideas.class}, version = 1)
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

        @Query("SELECT * FROM Ideas WHERE head = :head")
        List<Ideas> getByHead(String head);

        @Query("SELECT * FROM Ideas WHERE data = :data")
        List<Ideas> getByData(String data);

        @Insert
        void insert(Ideas idea);

        @Update
        void update(Ideas idea);

        @Delete
        void delete(Ideas idea);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
