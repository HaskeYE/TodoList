package com.example.todo;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@androidx.room.Database(entities = {Ideas.class}, version = 1)
public abstract class DataHelper extends RoomDatabase {
    public abstract IdeasDao ideasDao();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return App.getInstance().getDatabase().getOpenHelper();
    }
}