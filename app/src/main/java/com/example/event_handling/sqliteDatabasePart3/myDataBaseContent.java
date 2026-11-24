package com.example.event_handling.sqliteDatabasePart3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class myDataBaseContent extends SQLiteOpenHelper {
    public static final String table = "Content";
    public static final String column_id = "id";
    public static final String column_name = "name";
    public static final String column_email = "email";
    public static final String column_phone = "phone";
    public static final String column_yearOfBirth = "year";




    public myDataBaseContent(@Nullable Context context) {
        super(context, table, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+table+"("+column_id+" Integer primary key autoincrement, "+column_name+" text,"
                +column_email+" text, "+column_phone+" text , "+column_yearOfBirth+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+table);
        onCreate(db);
    }


    public long insertDatabase(Content content){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(column_name,content.getName());
        cv.put(column_email,content.getEmail());
        cv.put(column_phone,content.getPhone());
        cv.put(column_yearOfBirth,content.getYearOfBirth());

        return database.insert(table,null,cv);

    }

    
    
    public int delete(int id){
        SQLiteDatabase database = getWritableDatabase();
//         التعديل هنا: حذف كلمة where وإضافة علامة =
        return database.delete(table,"id = ?",new String[]{String.valueOf(id)});
    }
    
    
    public int update(Content content){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(column_name,content.getName());
        cv.put(column_email,content.getEmail());
        cv.put(column_phone,content.getPhone());
        cv.put(column_yearOfBirth,content.getYearOfBirth());
        
        return database.update(table,cv,"id = ?",new String[]{String.valueOf(content.getId())});
    }
    
    
    
    
    public ArrayList<Content> getAllContent(){
        ArrayList<Content> contents = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        
        Cursor cursor = database.rawQuery("select * from "+table,null);
        
        
        int id_index = cursor.getColumnIndexOrThrow(column_id);
        int name_index = cursor.getColumnIndexOrThrow(column_name);
        int email_index = cursor.getColumnIndexOrThrow(column_email);
        int phone_index = cursor.getColumnIndexOrThrow(column_phone);
        int year_index = cursor.getColumnIndexOrThrow(column_yearOfBirth);
        
        while (cursor.moveToNext()){
            int id = cursor.getInt(id_index);
            String name = cursor.getString(name_index);
            String email = cursor.getString(email_index);
            String phone = cursor.getString(phone_index);
            int year = cursor.getInt(year_index);
            
            
            Content content1 = new Content(name,email,phone,year);
            content1.setId(id);
            contents.add(content1);
        }
        cursor.close();
        return contents;
        
        
    }



















}
