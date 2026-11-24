package com.example.event_handling.sqliteDatabasePart3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.event_handling.databinding.ActivityShowContentBinding;

import java.util.ArrayList;

public class showContentActivity extends AppCompatActivity {
    ActivityShowContentBinding binding;
    myDataBaseContent dataBaseContent;
    ArrayList<Content> contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowContentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        dataBaseContent = new myDataBaseContent(this);
        contents = dataBaseContent.getAllContent();

        contentAdapter adapter1 = new contentAdapter(contents);

        binding.showRv.setAdapter(adapter1);

        binding.showRv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
                false));





















    }
}