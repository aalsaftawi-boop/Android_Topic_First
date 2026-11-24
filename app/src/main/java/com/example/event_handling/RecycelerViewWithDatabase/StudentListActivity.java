package com.example.event_handling.RecycelerViewWithDatabase;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.event_handling.databinding.ActivityStudentListBinding;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity implements StudentListener {

    ActivityStudentListBinding binding;
    ArrayList<Student> students;
    StudentAdapter adapter;
    studentDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.deleteDatabase("students_dp");


        database = new studentDatabase(this);


        database.insert(new Student(1,"ahmed",27,"mobile"));
        database.insert(new Student(2,"mohammed",27,"wep"));
        database.insert(new Student(3,"yazzen",22,"mobile"));
        database.insert(new Student(4,"mahmoud",27,"play"));




        students = database.getAllStudents();

        adapter = new StudentAdapter(students,this);

        adapter.notifyDataSetChanged();




        binding.studentRv.setAdapter(adapter);

        binding.studentRv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onDelete(int id, int index) {
        database.delete(id);
        students = database.getAllStudents();
        adapter = new StudentAdapter(students,StudentListActivity.this);
        binding.studentRv.setAdapter(adapter);
    }

    @Override
    public void onEdit(int id, int index) {
        Intent intent = new Intent(getApplicationContext(),StudentListActivity.class);
        intent.putExtra("oldStudentData",students.get(index));
        startActivity(intent);
    }

    @Override
    public void onItemClick(int index) {

    }


    public void notifyChanges(){
        students = database.getAllStudents();
        adapter = new StudentAdapter(students,StudentListActivity.this);
        binding.studentRv.setAdapter(adapter);
    }



}