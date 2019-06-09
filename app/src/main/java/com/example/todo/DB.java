package com.example.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor; //тут чевото
import android.database.sqlite.*;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper implements BaseColumns {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "IdeasManager";
    private static final String TABLE_IDEAS = "ideas";
    private static final String KEY_ID = "id";
    private static final String KEY_HEAD = "head";
    private static final String KEY_DATA = "data";
    private static final String KEY_TIME = "time";

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY, "
                + USERNAME + " TEXT NOT NULL, " + PASSWORD
                + " TEXT NOT NULL, "
                + EMAIL
                + " TEXT NOT NULL UNIQUE)";
        db.execSQL(CREATE_IDEAS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IDEAS);

        onCreate(db);
    }

    public void addIdea(Idea idea) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_HEAD, idea.getHead());
        values.put(KEY_DATA, idea.getData());
        values.put(KEY_TIME, idea.getTime());

        db.insert(TABLE_IDEAS, null, values);
        db.close();
    }

    /**
     @Override
     public Idea getIdea(int id) {
     SQLiteDatabase db = this.getReadableDatabase();
     Cursor cursor = db.query(TABLE_IDEAS, new String[] { KEY_ID,
     KEY_HEAD, KEY_DATA, KEY_TIME }, KEY_ID + "=?",
     new String[] { String.valueOf(id) }, null, null, null, null);
     if (cursor != null){
     cursor.moveToFirst();
     }
     Idea idea = new Idea(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
     return idea;
     }
     @Override
     public List<Idea> getAllContacts() {
     List<Idea> contactList = new ArrayList<Idea>();
     String selectQuery = "SELECT  * FROM " + TABLE_IDEAS;
     SQLiteDatabase db = this.getWritableDatabase();
     Cursor cursor = db.rawQuery(selectQuery, null);
     if (cursor.moveToFirst()) {
     do {
     Idea idea = new Idea();
     idea.setID(Integer.parseInt(cursor.getString(0)));
     idea.setHead(cursor.getString(1));
     idea.setPhoneNumber(cursor.getString(2));
     contactList.add(idea);
     } while (cursor.moveToNext());
     }
     return contactList;
     }
     **/

    public int updateIdea(Idea idea) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_HEAD, idea.getHead());
        values.put(KEY_DATA, idea.getData());
        values.put(KEY_TIME, idea.getTime());

        return db.update(TABLE_IDEAS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(idea.getID()) });
    }

    public void deleteIdea(Idea idea) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_IDEAS, KEY_ID + " = ?", new String[] { String.valueOf(idea.getID()) });
        db.close();
    }


    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_IDEAS, null, null);
        db.close();
    }
}