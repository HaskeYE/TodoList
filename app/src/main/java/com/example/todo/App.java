package com.example.todo;
///
import android.app.Application;

import androidx.room.*;

import java.util.List;

public class App extends Application {

    public static App instance;
    public DataHelper db;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        db = Room.databaseBuilder(getApplicationContext(), DataHelper.class, "dadatabase")
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public DataHelper getDatabase() {
        return db;
    }
}
