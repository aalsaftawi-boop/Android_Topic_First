package com.example.event_handling.SqliteQuiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StudentDataBase extends SQLiteOpenHelper {
    public static final String Student_Table = "students";
    public static final String Id_column = "id";
    public static final String Name_Column = "name";
    public static final String Gba_Column = "gba";
    public static final String Field_Column = "field";

    public static final int version = 2;

    public StudentDataBase(@Nullable Context context) {
        super(context, "student_dp", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // تم تصحيح اسم الجدول وإضافة المسافات الضرورية لتفادي أخطاء الـ Syntax
        db.execSQL("Create Table " + Student_Table + " (" +
                Id_column + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Name_Column + " TEXT, " +
                Gba_Column + " REAL, " +
                Field_Column + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Student_Table);
        onCreate(db);
    }

    public long insertStudent(Student student){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Name_Column, student.getName());
        cv.put(Gba_Column, student.getGba());
        cv.put(Field_Column, student.getField());

        return database.insert(Student_Table, null, cv);
    }

    public long apdateStudent(Student student){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Name_Column, student.getName());
        cv.put(Gba_Column, student.getGba());
        cv.put(Field_Column, student.getField());

        // تم تصحيح الشرط هنا لمنع تكرار كلمة id
        return database.update(Student_Table, cv, Id_column + " = ?",
                new String[]{String.valueOf(student.getId())});
    }

    public long deleteStudent(int id){
        SQLiteDatabase database = getWritableDatabase();
        // تم تصحيح الشرط هنا أيضاً
        return database.delete(Student_Table, Id_column + " = ?", new String[]{String.valueOf(id)});
    }

    public ArrayList<Student> getAllStudents(){
        SQLiteDatabase database = getReadableDatabase();
        ArrayList<Student> students = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM " + Student_Table, null);

        while (cursor.moveToNext()){
            int index = cursor.getColumnIndexOrThrow(Id_column);
            int id = cursor.getInt(index);
            String name = cursor.getString(cursor.getColumnIndexOrThrow(Name_Column));
            double gba = cursor.getDouble(cursor.getColumnIndexOrThrow(Gba_Column));
            String field = cursor.getString(cursor.getColumnIndexOrThrow(Field_Column));

            students.add(new Student(id, name, gba, field));
        }
        cursor.close(); // من الممارسات الجيدة إغلاق الـ Cursor دائماً
        return students;
    }
}
