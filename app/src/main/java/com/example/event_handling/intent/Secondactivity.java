package com.example.event_handling.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.event_handling.R;

public class Secondactivity extends AppCompatActivity {

    TextView nameTv , ageTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        // 2. ربط العناصر بملف الـ XML (تأكد من مطابقة الـ id للـ ageTv)
        nameTv = findViewById(R.id.nameTv);
        ageTv = findViewById(R.id.ageTv); // هذا السطر كان ينقصك!

        // 3. جلب النصوص المرسلة
        String userName = getIntent().getStringExtra("name");
        String userAge = getIntent().getStringExtra("age");

        // 4. عرض البيانات داخل الـ TextViews
        nameTv.setText(userName);
        ageTv.setText(userAge);





    }
}