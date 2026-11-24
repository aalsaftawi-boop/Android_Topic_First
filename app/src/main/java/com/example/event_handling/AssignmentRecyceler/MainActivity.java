package com.example.event_handling.AssignmentRecyceler;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityMain2Binding;
import com.example.event_handling.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Car> cars;
    CarAdapter carAdapter;
    ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        /*
        / Assignment :1- عند الضغط على ال (floatin action button) سوف يضيف item في ال recycerview
        2- عند ال ضغط على ال item ضغطة طويلة سوف يحذفو من ال recyceler
        3- عند الضغط على ال item ضغطة عادية سوف ينقلني على واجهة بحيث تكون الصورة معروضة بكل كامل اعلى الواجة التي انتقلت اليها بعد الضغط على ال item
         */

        cars = new ArrayList<>();
        cars.add(new Car("ahmed","BMW","Black",R.drawable.image_car));
        cars.add(new Car("mohammed","BMW","Black",R.drawable.image_car));
        cars.add(new Car("yazzen","BMW","Black",R.drawable.image_car));
        cars.add(new Car("mahmoud","BMW","Black",R.drawable.image_car));

        carAdapter = new CarAdapter(this,cars);

        binding.recycelerView.setAdapter(carAdapter);

        binding.recycelerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false));

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cars.add(new Car("ahmed","BMW","Black",R.drawable.image_car));
                carAdapter.notifyDataSetChanged();
            }
        });





















    }
}