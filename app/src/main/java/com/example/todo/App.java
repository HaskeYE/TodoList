package com.example.todo;
///
import android.app.Application;

import androidx.room.*;

import java.util.List;

public class App extends Application {

    private static App instance;
    private DataHelper database;

    public static App getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(getApplicationContext(), DataHelper.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public DataHelper getDatabase() {
        return database;
    }
}
