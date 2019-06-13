package com.example.todo;

import android.app.Application;
import androidx.room.*;

import java.util.List;

public class App extends Application {

    private static App instance;
    private DataHelper db;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        db = Room.databaseBuilder(getApplicationContext(), DataHelper.class, "db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public DataHelper getDatabase() {
        return db;
    }
}
