package com.example.todo;
///
import android.app.Application;

import androidx.room.*;

import java.util.List;

public class App extends Application {


    @androidx.room.Database(entities = {Ideas.class}, version = 1)
    public abstract class DataHelper extends RoomDatabase {
        public abstract IdeasDao ideasDao();
    }

    private static App instance;
    private DataHelper database;



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
        database = Room.databaseBuilder(getApplicationContext(), DataHelper.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public DataHelper getDatabase() {
        return database;
    }
}
