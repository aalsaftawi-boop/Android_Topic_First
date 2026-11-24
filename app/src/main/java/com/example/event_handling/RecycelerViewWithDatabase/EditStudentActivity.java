package com.example.event_handling.RecycelerViewWithDatabase;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityEditStudentBinding;

public class EditStudentActivity extends AppCompatActivity {

    ActivityEditStudentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Student student = (Student) getIntent().getExtras().get("oldStudentData");
        Student student2 = (Student) getIntent().getExtras().get("oldStudentData");



// تأكد من تغيير أسماء الـ EditText حسب ما سميتها في ملف الـ XML لديك
        binding.nameEt.setText(student.getName());
        binding.GbaEt.setText(String.valueOf(student.getGba()));
        binding.fieldEt.setText(student.getField());



        binding.editBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. جلب البيانات المحدثة من الحقول
                String updatedName = binding.nameEt.getText().toString();
                double updatedGba = Double.parseDouble(binding.GbaEt.getText().toString());
                String updatedField = binding.fieldEt.getText().toString();

                // 2. تحديث بيانات كائن الطالب الحالي
                student.setName(updatedName);
                student.setGba(updatedGba);
                student.setField(updatedField);

                // 3. إنشاء كائن قاعدة البيانات واستدعاء دالة التعديل
                studentDatabase database = new studentDatabase(EditStudentActivity.this);
                database.ubdate(student); // سنكتب دالة update في الخطوة القادمة إذا لم تكن لديك

                // 4. إغلاق هذه الشاشة والعودة للشاشة السابقة المحدثة
                finish();
            }
        });

























        









    }
}