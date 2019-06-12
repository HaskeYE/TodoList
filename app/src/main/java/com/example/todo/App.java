package com.example.todo;
///
import android.app.Application;

import androidx.room.*;

import java.util.List;

public class App extends Application {

    private static App instance;
    private DataHelper database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, DataHelper.class, "dadatabase")
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public DataHelper getDatabase() {
        return database;
    }
}
