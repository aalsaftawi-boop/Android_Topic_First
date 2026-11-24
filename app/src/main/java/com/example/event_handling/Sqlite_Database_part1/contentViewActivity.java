package com.example.event_handling.Sqlite_Database_part1;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityContentViewBinding;

public class contentViewActivity extends AppCompatActivity {

ActivityContentViewBinding binding;
sqliteDatabase database;
    Content content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContentViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = new sqliteDatabase(this);


        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.nameEt.getText().toString();
                String email = binding.emailEt.getText().toString();
                String phone = binding.phoneEt.getText().toString();
                int year = Integer.parseInt(binding.yearEt.getText().toString());
                content = new Content(name,email,phone,year);
                database.insert(content);
            }
        });










    }
}