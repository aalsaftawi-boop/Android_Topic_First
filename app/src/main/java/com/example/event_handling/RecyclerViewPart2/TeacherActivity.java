package com.example.event_handling.RecyclerViewPart2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityTeacher2Binding;
import com.example.event_handling.databinding.ActivityTeacherBinding;

import java.util.ArrayList;

public class TeacherActivity extends AppCompatActivity implements studentListener {

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getData() != null && result.getResultCode() == 101){
                        int index = result.getData().getIntExtra("position",-1);
                        String name = result.getData().getStringExtra("newTeacherName");
                        teachers.get(index).setName(name);
                        adapter.notifyDataSetChanged();
                    }
                }
            });
    ActivityTeacher2Binding binding;
    ArrayList<Teacher> teachers;
    TeacherAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTeacher2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        teachers = new ArrayList<>();
        teachers.add(new Teacher(120,"AHMED",85,"MOBILE"));
        teachers.add(new Teacher(121,"MOHAMMED",75,"WEB"));
        teachers.add(new Teacher(122,"AHMED",85,"MOBILE"));
        teachers.add(new Teacher(123,"AHMED",85,"WEB"));



        adapter = new TeacherAdapter(teachers,this,this);
        binding.teacherRecycler.setAdapter(adapter);
        binding.teacherRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));



        // عند الضغط على الزر(button) يعرضو في الrecyceler
        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teachers.add(new Teacher(122,binding.nameEt.getText().toString(),200,"MOBILE"));
                adapter.notifyItemChanged(teachers.size()-1);
            }
        });








    }

    @Override
    public void onDelete(int pos) {
        teachers.remove(pos);
        adapter.notifyItemRemoved(pos);
    }

    @Override
    public void onEdit(int pos) {
        Intent intent = new Intent(this,teacherEditActivity.class);
        intent.putExtra("teacherName",teachers.get(pos).getName());
        intent.putExtra("position",pos);
        launcher.launch(intent);
    }
}