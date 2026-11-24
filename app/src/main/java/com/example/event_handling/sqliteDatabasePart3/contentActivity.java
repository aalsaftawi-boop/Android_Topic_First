package com.example.event_handling.sqliteDatabasePart3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.event_handling.databinding.ActivityContentBinding;

import java.util.ArrayList;

public class contentActivity extends AppCompatActivity {
    ActivityContentBinding binding;
    myDataBaseContent dataBaseContent;
    ArrayList<Content> contents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        dataBaseContent = new myDataBaseContent(this);


        contents = dataBaseContent.getAllContent();


        Log.d("getDataTesting","onCreate"+contents);

        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.nameEt.getText().toString();
                String email = binding.emailEt.getText().toString();
                String phone = binding.phoneEt.getText().toString();
                int year = Integer.parseInt(binding.yearEt.getText().toString());
                Content content = new Content(name,email,phone,year);

                dataBaseContent.insertDatabase(content);

            }
        });





        binding.apdateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.nameEt.getText().toString();
                String email = binding.emailEt.getText().toString();
                String phone = binding.phoneEt.getText().toString();
                int year = Integer.parseInt(binding.yearEt.getText().toString());
                int id = Integer.parseInt(binding.idEt.getText().toString());
                Content content = new Content(name,email,phone,year);
                content.setId(id);

                int res = dataBaseContent.update(content);

                if (res > 0) {
                    Toast.makeText(contentActivity.this, "update succesfuly", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(contentActivity.this, "update failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // عتد الضغط على زر ال delete سوف يحذف الrow بناء على ال id
        binding.deleteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int input = Integer.parseInt(binding.idEt.getText().toString());
                int res = dataBaseContent.delete(input);

                if (res > 0) {
                    Toast.makeText(contentActivity.this, "delete succesfuly", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(contentActivity.this, "delete failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // عند الضغط سوف ينقلني على الواجهة الاخرى ويعرض البيانات في ال recuceler view 
        binding.showBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), showContentActivity.class));
            }
        });
    }
}