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

public class studentActivity extends AppCompatActivity {

    EditText nameEt,idEt;
    Button studentBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);


        nameEt = findViewById(R.id.nameEt);
        idEt = findViewById(R.id.idEt);
        studentBt = findViewById(R.id.studentBt);


        studentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String name =  nameEt.getText().toString();
               String id = idEt.getText().toString();


                Intent intent = new Intent();
                intent.putExtra("name",name);
                intent.putExtra("id",id);

                setResult(101,intent);

                finish();
            }
        });



    }
}