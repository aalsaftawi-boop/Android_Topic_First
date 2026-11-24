package com.example.activity_result_launcher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 1. تسجيل "العقد" وتجهيز مركز استقبال البيانات القادمة من الواجهات الأخرى
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), // تحديد نوع العقد: الانتقال لشاشة وانتظار نتيجة
            new ActivityResultCallback<ActivityResult>() {

                @Override
                public void onActivityResult(ActivityResult result) {
                    // 2. التأكد أولاً من أن الشاشة التي أُغلقت أرسلت بيانات معها ولم تكن فارغة
                    if (result.getData() != null) {

                        // 3. التحقق: هل البيانات قادمة من شاشة الطالب؟ (رمز النتيجة 101)
                        if (result.getResultCode() == 101) {
                            Intent intent = result.getData(); // استخراج الحقيبة (Intent) التي تحتوي على البيانات
                            String name = intent.getStringExtra("name"); // سحب اسم الطالب
                            String id = intent.getStringExtra("id");     // سحب رقم الطالب

                            // طباعة بيانات الطالب داخل أداة عرض النصوص (TextView)
                            dataTv.append("STUDENT :" + "\t" + name + "\t" + id + "\n");
                        }

                        // 4. التحقق: هل البيانات قادمة من شاشة المعلم؟ (رمز النتيجة 102)
                        else if (result.getResultCode() == 102) {
                            Intent intent = result.getData(); // استخراج الحقيبة (Intent) التي تحتوي على البيانات
                            String name = intent.getStringExtra("name"); // سحب اسم المعلم
                            String id = intent.getStringExtra("id");     // سحب رقم المعلم

                            // طباعة بيانات المعلم داخل أداة عرض النصوص (TextView)
                            dataTv.append("TEACHER :" + "\t" + name + "\t" + id + "\n");
                        }
                    }
                }
            });

    Button moveStudentBt ,moveTeacherBt;
    TextView dataTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveStudentBt = findViewById(R.id.movestudentBt);
        moveTeacherBt = findViewById(R.id.moveTeacherBt);
        dataTv = findViewById(R.id.dataTv);

        moveStudentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), studentActivity.class);
                launcher.launch(intent);
            }
        });

        moveTeacherBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), teacherActivity.class);
                launcher.launch(intent);
            }
        });






    }
}