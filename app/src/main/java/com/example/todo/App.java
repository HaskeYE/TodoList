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
        private long id;
        private String head;
        private String data;
        private String time;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
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
