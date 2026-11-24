package com.example.event_handling.intent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.event_handling.R;

public class FirstActivity extends AppCompatActivity {

    EditText nameEt ,ageEt;
    Button move_Bt;
    final String data = "lifecycle" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        nameEt = findViewById(R.id.nameEt);
        ageEt = findViewById(R.id.ageEt);
        move_Bt = findViewById(R.id.moveBt);

        move_Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString().trim();
                String ageStr = ageEt.getText().toString().trim();

                // التأكد أولاً أن المستخدم لم يترك الحقول فارغة لتجنب الكراش
                if (name.isEmpty() || ageStr.isEmpty()) {
                    Toast.makeText(FirstActivity.this, "الرجاء إدخال الاسم والعمر أولاً!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // إنشاء الـ Intent للانتقال
                Intent intent = new Intent(FirstActivity.this, Secondactivity.class);

                // تمرير البيانات (يفضل تمرير العمر كنص لتجنب مشاكل التحويل)
                intent.putExtra("name", name);
                intent.putExtra("age", ageStr);

                // السطر الأهم المفقود في كودك لتشغيل الواجهة الثانية:
                startActivity(intent);
            }
        });




        Log.d(data, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(data, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(data, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(data, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(data, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(data, "onDestory: ");
    }

}