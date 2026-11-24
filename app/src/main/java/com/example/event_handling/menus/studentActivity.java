package com.example.event_handling.menus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.event_handling.databinding.ActivityStudentBinding;

public class studentActivity extends AppCompatActivity {

    ActivityStudentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.nameEt.getText().toString();
                String id = binding.idEt.getText().toString();


                Intent intent = getIntent();
                intent.putExtra("name",name);
                intent.putExtra("id",id);
                setResult(101,intent);
                finish();
            }
        });





    }
}