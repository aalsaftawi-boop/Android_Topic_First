package com.example.activity_result_launcher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class teacherActivity extends AppCompatActivity {
EditText nameEt,idEt;
Button teachertBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        nameEt = findViewById(R.id.nameEt);
        idEt = findViewById(R.id.idEt);
        teachertBt = findViewById(R.id.teachertBt);

        teachertBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =  nameEt.getText().toString();
                String id = idEt.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("name",name);
                intent.putExtra("id",id);

                setResult(102,intent);

                finish();


            }
        });




    }
}