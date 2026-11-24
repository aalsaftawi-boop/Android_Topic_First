package com.example.event_handling.RecycelerViewWithDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class studentDatabase extends SQLiteOpenHelper {
    public static final String Student_Table = "student";
    public static final String Column_Id = "id";
    public static final String Column_Name = "name";
    public static final String Column_Gba = "gba";
    public static final String Column_Field= "field";
    public studentDatabase(@Nullable Context context) {
        super(context, "students_dp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+Student_Table+"("+Column_Id+" Integer primary key autoincrement, "+Column_Name+" text,"
                +Column_Gba+" real, "+Column_Field+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+Student_Table);
        onCreate(db);
    }


    public long insert(Student student){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Column_Name,student.getName());
        cv.put(Column_Field,student.getField());
        cv.put(Column_Gba,student.getGba());


        return database.insert(Student_Table,null,cv);
    }


    public int ubdate(Student student){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Column_Name,student.getName());
        cv.put(Column_Field,student.getField());
        cv.put(Column_Gba,student.getGba());


        return database.update(Student_Table,cv,Column_Id+"where id = ?",
                new String[]{String.valueOf(student.getId())});

    }


    public int delete(int id){
        SQLiteDatabase database = getWritableDatabase();
        return database.delete(Student_Table, Column_Id + " = ?",
                new String[]{String.valueOf(id)});

    }


    public ArrayList<Student> getAllStudents(){
        SQLiteDatabase database = getReadableDatabase();
        ArrayList<Student> students = new ArrayList<>();
        Cursor cursor = database.rawQuery("select * from "+Student_Table,null);

        while (cursor.moveToNext()){
            int index = cursor.getColumnIndexOrThrow(Column_Id);
            int id = cursor.getInt(index);
            String name = cursor.getString(cursor.getColumnIndexOrThrow(Column_Name));
            Double Gba = cursor.getDouble(cursor.getColumnIndexOrThrow(Column_Gba));
            String field = cursor.getString(cursor.getColumnIndexOrThrow(Column_Field));


            students.add(new Student(id,name,Gba,field));

        }
        cursor.close();
        return students;




    }

}
