package com.example.event_handling.list_view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityProductDetialesBinding;

public class ProductDetiales extends AppCompatActivity {

    ActivityProductDetialesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetialesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        String data = getIntent().getStringExtra("product");
        binding.proparatiesTv.setText(data);

//        binding.proparatiesTv.setText(getIntent().getStringExtra("product"));


    }
}