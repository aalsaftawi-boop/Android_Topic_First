package com.example.event_handling.Sqlite_Database_part1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class sqliteDatabase extends SQLiteOpenHelper {
    public static final String CONTACTS_TABLE = "Contacts";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String EMAIL_COLUMN = "email";
    public static final String PHONE_COLUMN = "phone";
    public static final String YEAR_COLUMN = "yearOfBirth";
    public sqliteDatabase(@Nullable Context context) {
        super(context, CONTACTS_TABLE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+CONTACTS_TABLE+"("+ID_COLUMN+" Integer primary key autoincrement, "+NAME_COLUMN+" text,"
                +EMAIL_COLUMN+" text, "+PHONE_COLUMN+" text , "+YEAR_COLUMN+" text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+CONTACTS_TABLE);
        onCreate(db);
    }

    public long insert(Content content){
        SQLiteDatabase database =  getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME_COLUMN,content.getName());
        cv.put(EMAIL_COLUMN,content.getEmail());
        cv.put(PHONE_COLUMN,content.getPhone());
        cv.put(YEAR_COLUMN,content.getYearOfBirth());
        long result = database.insert(CONTACTS_TABLE,null,cv);
        return result;
    }





}
