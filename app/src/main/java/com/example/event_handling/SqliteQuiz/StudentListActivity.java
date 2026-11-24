package com.example.event_handling.SqliteQuiz;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityStudentListBinding;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity implements StudentListListener{


    ActivityStudentListBinding binding;
    ArrayList<Student> students;
    StudentQuizAdapter adapter;
    StudentDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        students = new ArrayList<>();

        dataBase = new StudentDataBase(this);

        dataBase.insertStudent(new Student(1,"ahmed",22,"mobile"));
        dataBase.insertStudent(new Student(2,"mohahmmed",22,"wep"));
        dataBase.insertStudent(new Student(3,"yazzen",22,"gis"));
        dataBase.insertStudent(new Student(4,"khaled",22,"ui"));
        dataBase.insertStudent(new Student(5,"khalil",22,"back_en"));

        students = dataBase.getAllStudents();

        adapter = new StudentQuizAdapter(students,this);


        binding.studentRv.setAdapter(adapter);

        binding.studentRv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));




    }


    @Override
    public void onDelete(int id) {
        // 1. البحث عن الترتيب الصحيح (Position) للطالب داخل المصفوفة باستخدام الـ id
        int position = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                position = i;
                break;
            }
        }

        // 2. إذا تم العثور على الطالب داخل المصفوفة، قم بعملية الحذف
        if (position != -1) {
            // إنشاء كائن قاعدة البيانات للحذف الفعلي منها
            StudentDataBase dataBase = new StudentDataBase(this);
            dataBase.deleteStudent(id);

            // الحذف من المصفوفة المحلية المؤقتة باستخدام الـ position وليس الـ id
            students.remove(position);

            // إشعار الـ Adapter بالـ position الصحيح ليختفي العنصر بتأثير بصري سلس
            adapter.notifyItemRemoved(position);
        }
    }


    @Override
    public void onEdit(int id) {
        Intent intent = new Intent(getBaseContext(), EditStudentListActivity.class);
        intent.putExtra("oldStudentdata",students.get(id));
        startActivity(intent);
    }

    @Override
    public void onItemClick(int id) {

    }

    public void datachange(){
        students = dataBase.getAllStudents();
        adapter = new StudentQuizAdapter(students,this);
        binding.studentRv.setAdapter(adapter);
    }

}