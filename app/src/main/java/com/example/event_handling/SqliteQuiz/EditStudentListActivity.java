package com.example.event_handling.SqliteQuiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityEditStudentListBinding;

public class EditStudentListActivity extends AppCompatActivity {

    ActivityEditStudentListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditStudentListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Student student = (Student) getIntent().getExtras().get("oldStudentdata");
        Student s1 = (Student) getIntent().getSerializableExtra("oldStudentdata");



        binding.editBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. جلب البيانات الجديدة التي عدلها المستخدم من الواجهة
                String updatedName = binding.nameEt.getText().toString(); // استبدل nameEd بالـ id الخاص بك لاسم الطالب
                double updatedGba = Double.parseDouble(binding.GbaEt.getText().toString()); // استبدل gbaEd بالـ id للمعدل
                String updatedField = binding.fieldEt.getText().toString(); // استبدل fieldEd بالـ id للتخصص

               // 2. تحديث بيانات الكائن المستلم بالقيم الجديدة
                student.setName(updatedName);
                student.setGba(updatedGba);
                student.setField(updatedField);

                // 3. تحديث البيانات في قاعدة البيانات الفعالة
                StudentDataBase dataBase = new StudentDataBase(EditStudentListActivity.this);
                dataBase.apdateStudent(student);

                // 4. إغلاق هذه الشاشة تلقائياً والرجوع للشاشة الرئيسية
                finish();
            }
        });












    }
}