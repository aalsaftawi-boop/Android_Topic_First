package com.example.event_handling.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityStudentViewBinding;

import java.util.ArrayList;

public class StudentViewActivity extends AppCompatActivity {

    ActivityStudentViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(120,"AHMED",55,"MOBILE"));
        students.add(new Student(121,"MOHAMMED",55,"WEB"));
        students.add(new Student(122,"YAZZEN",54,"MOBILE"));
        students.add(new Student(120,"AHMED",55,"MOBILE"));
        students.add(new Student(121,"MOHAMMED",55,"WEB"));
        students.add(new Student(122,"YAZZEN",54,"MOBILE"));
        students.add(new Student(120,"AHMED",55,"MOBILE"));
        students.add(new Student(121,"MOHAMMED",55,"WEB"));
        students.add(new Student(122,"YAZZEN",54,"MOBILE"));






        StudentAdapter adapter = new StudentAdapter(students);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(manager);

















    }
}