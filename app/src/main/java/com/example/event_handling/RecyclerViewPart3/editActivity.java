package com.example.event_handling.RecyclerViewPart3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityEditBinding;

public class editActivity extends AppCompatActivity {
    ActivityEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        binding.nameEt.setText(getIntent().getStringExtra("marketName"));

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.nameEt.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("newName",name);
                intent.putExtra("position",getIntent().getIntExtra("position",-1));
                setResult(101,intent);
                finish();
            }
        });





    }
}