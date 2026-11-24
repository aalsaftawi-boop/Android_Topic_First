package com.example.event_handling.AssignmentRecyceler;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityDetielsBinding;

public class DetielsActivity extends AppCompatActivity {

    ActivityDetielsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetielsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Car car = (Car) getIntent().getSerializableExtra("image");

        binding.carImageView.setImageResource(car.getImage());



        // 3. عرض باقي النصوص في الـ TextViews الخاصة بك داخل واجهة التفاصيل
        // (تأكد من كتابة أسماء الـ TextViews وأسماء دوال الـ get تماماً كما هي في مشروعك)
        binding.tvDetailsName.setText(car.getName());   // يعرض الاسم (مثلاً: ahmed)
        binding.tvDetailsBrand.setText(car.getColor()); // يعرض الماركة (مثلاً: BMW)
        binding.tvDetailsColor.setText(car.getColor());





















    }
}