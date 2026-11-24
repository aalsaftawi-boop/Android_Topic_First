package com.example.event_handling.RecyclerViewPart2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityTeacherEditBinding;

public class teacherEditActivity extends AppCompatActivity {
    ActivityTeacherEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTeacherEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.teacherNameEdit.setText(getIntent().getStringExtra("teacherName"));

        binding.teacherEditBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.teacherNameEdit.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("newTeacherName",name);
                intent.putExtra("position",getIntent().getIntExtra("position",-1));
                setResult(101,intent);
                finish();
            }
        });




















    }
}